<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="net.coobird.thumbnailator.Thumbnails" %>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.json.simple.*" %>
<%

/**
 * KindEditor JSP
 * 
 * 本JSP程序是演示程序，建议不要直接在实际项目中使用。
 * 如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
 * 
 */
try{
//文件保存目录路径

//String savePath = pageContext.getServletContext().getRealPath("/") + "attached/";

//文件保存目录路径
//$save_path = $_SERVER['DOCUMENT_ROOT'].'\\uploadfiles\\';

//文件保存目录URL
//String saveUrl  = request.getContextPath() + "/attached/";

String savePath = pageContext.getServletContext().getRealPath("/") + "upload/kindeditor/attached/";


//文件保存目录URL

//$save_url = '/uploadfiles/';

String saveUrl  = request.getContextPath() + "/upload/kindeditor/attached/";


//定义允许上传的文件扩展名
HashMap<String, String> extMap = new HashMap<String, String>();
extMap.put("image", "gif,jpg,jpeg,png,bmp");
extMap.put("file", "doc,docx,xls,xlsx,ppt,pdf,txt");

//最大文件大小
long maxSize = 30*1024*1024;

response.setContentType("text/html; charset=UTF-8");

if(!ServletFileUpload.isMultipartContent(request)){
	out.println(getError("请选择文件。"));
	return;
}
//检查目录
System.out.println("savePath===="+savePath);
File uploadDir = new File(savePath);
if(!uploadDir.isDirectory()){
	//System.out.println("上传目录不存在。");
	out.println(getError("上传目录不存在。"));
	return;
}
//检查目录写权限
if(!uploadDir.canWrite()){
	//System.out.println("上传目录没有写权限。");
	out.println(getError("上传目录没有写权限。"));
	return;
}

String dirName = request.getParameter("dir");
if (dirName == null) {
	dirName = "image";
}
if(!extMap.containsKey(dirName)){
	//System.out.println("目录名不正确。");
	out.println(getError("目录名不正确。"));
	return;
}
//创建文件夹
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
	long fileSize = item.getSize();
	if (!item.isFormField()) {
		//检查文件大小
		if(item.getSize() > maxSize){
			//System.out.println("上传文件大小超过限制。");
			out.println(getError("上传文件大小超过限制。"));
			return;
		}
		//检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
			//System.out.println("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
			out.println("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
			return;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		String thumbnail = "thum_"+newFileName;
		try{
			File uploadedFile = new File(savePath, newFileName);
			item.write(uploadedFile);
			System.out.println("dirName===="+dirName);
			if("image".equalsIgnoreCase(dirName) && Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
				FileInputStream fis = new FileInputStream(uploadedFile);
                BufferedImage bi = ImageIO.read(fis);
                int width = bi.getWidth();
                int height = bi.getHeight();
                System.out.println("width:"+width+",height:"+height);
                int tWidth = width>270?270:width;
                int tHeight = width>270?height*270/width:height;
                System.out.println("tWidth:"+tWidth+",tHeight:"+tHeight);
                
	            // 生成缩略图
	            System.out.println(saveUrl +","+ newFileName);
	            Thumbnails.of(new File(dirFile.getAbsoluteFile()+"/" +newFileName)).size(tWidth, tHeight).toFile(new File(dirFile.getAbsoluteFile()+"/", thumbnail));
                
			}
		}catch(Exception e){
			out.println(getError("上传文件失败。"));
			return;
		}
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		if("image".equalsIgnoreCase(dirName) && Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
			obj.put("url", saveUrl + thumbnail);
		}else{
			obj.put("url", saveUrl + newFileName);
		}
		out.println(obj.toJSONString());
		
	}
}
}catch(Exception ex){
	System.out.println("发生异常了。。。。。。。。。。。");
	System.out.println("Exception::"+ex.getMessage());
}
%>
<%!
private String getError(String message) {
	JSONObject obj = new JSONObject();
	obj.put("error", 1);
	obj.put("message", message);
	return obj.toJSONString();
}
%>