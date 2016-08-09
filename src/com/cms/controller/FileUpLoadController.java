	package com.cms.controller;

	import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
	 

	import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	 

	import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	@RequestMapping("/fileupload")

	public class FileUpLoadController {
	 
	    private static final ObjectMapper objectMapper = new ObjectMapper();

	    private PrintWriter writer = null;
	 
		@RequestMapping(value="/fileupload",method=RequestMethod.GET)
		public String manager() {
			return "/fileupload/fileupload";
		}
	    
	    
	    
	    @SuppressWarnings("rawtypes")
	    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	    public String fileUpload()
	            throws ServletException, IOException, FileUploadException {
	        HttpServletRequest request = null;
			ServletContext application = request.getSession().getServletContext();
	        //文件保存路径
	        String savePath = application.getRealPath("/") + "upload/";
	        // 文件保存目录URL
	        String saveUrl = request.getContextPath() + "/upload/";
	 
	        // 定义允许上传的文件扩展名
	        HashMap<String, String> extMap = new HashMap<String, String>();
	        extMap.put("image", "gif,jpg,jpeg,png,bmp");
	        //extMap.put("flash", "swf,flv");
	        //extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,mp4,webm");
	        //extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	 
	        // 最大文件大小
	        long maxSize = 32505856;
	 
	        ServletResponse response = null;
			response.reset();
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html");
	        writer = response.getWriter();
	        // writer.println(json); //想办法把map转成json
	 
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            writer.println(objectMapper.writeValueAsString(getError("请选择文件。")));
	            return null;
	 
	        }
	        // 检查目录
	        File uploadDir = new File(savePath);
	        if (!uploadDir.isDirectory()) {
	            writer.println(objectMapper.writeValueAsString(getError("上传目录不存在。")));
	            return null;
	        }
	        // 检查目录写权限
	        if (!uploadDir.canWrite()) {
	            writer.println(objectMapper.writeValueAsString(getError("上传目录没有写权限。")));
	            return null;
	        }
	 
	        String dirName = request.getParameter("dir");
	        if (dirName == null) {
	            dirName = "image";
	        }
	        if (!extMap.containsKey(dirName)) {
	            writer.println(objectMapper.writeValueAsString(getError("目录名不正确。")));
	            return null;
	        }
	        // 创建文件夹
	        savePath += dirName + "/";
	        saveUrl += dirName + "/";
	        File saveDirFile = new File(savePath);
	        if (!saveDirFile.exists()) {
	            saveDirFile.mkdirs();
	        }
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        String ymd = sdf.format(new Date());
	        savePath += ymd + "/";
	        saveUrl += ymd + "/";
	        File dirFile = new File(savePath);
	        if (!dirFile.exists()) {
	            dirFile.mkdirs();
	        }
	 
	        FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setHeaderEncoding("UTF-8");
	        List items = upload.parseRequest(request);
	        Iterator itr = items.iterator();
	        while (itr.hasNext()) {
	            FileItem item = (FileItem) itr.next();
	            String fileName = item.getName();
	            if (!item.isFormField()) {
	                // 检查文件大小
	                if (item.getSize() > maxSize) {
	                    writer.println(objectMapper.writeValueAsString(getError("上传文件大小超过限制。")));
	                    return null;
	                }
	                // 检查扩展名
	                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	                if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
	                    writer.println(objectMapper.writeValueAsString(getError("上传文件扩展名是不允许的扩展名。\n只允许"
	                            + extMap.get(dirName) + "格式。")));
	                    return null;
	                }
	 
	                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	                String newFileName =
	                        df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
	                try {
	                    File uploadedFile = new File(savePath, newFileName);
	                    item.write(uploadedFile);
	                } catch (Exception e) {
	                    writer.println(objectMapper.writeValueAsString(getError("上传文件失败。")));
	                }
	 
	                Map<String, Object> msg = new HashMap<String, Object>();
	                msg.put("error", 0);
	                msg.put("url", saveUrl + newFileName);
	                writer.println(objectMapper.writeValueAsString(msg));
	                return null;
	            }
	        }
	        return null;
	    }
	 
	    private Map<String, Object> getError(String message) {
	        Map<String, Object> msg = new HashMap<String, Object>();
	        msg.put("error", 1);
	        msg.put("message", message);
	        return msg;
	    }
	 

	 
	 
	 

	}
	
	
	
	
	


