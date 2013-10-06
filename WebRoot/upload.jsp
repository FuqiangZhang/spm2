<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   upload <br>
  </body>
  
  
  
<FORM METHOD="POST" ACTION="uploadservlet"
ENCTYPE="multipart/form-data">
<input type="hidden" name="TEST" value="good">
  <table width="75%" border="1" align="center">
    <tr> 
      <td><div align="center">1、 
          <input type="FILE" name="FILE1" size="30">
        </div></td>
    </tr>

    <tr> 
      <td><div align="center">
          <input type="submit" name="Submit" value="上传它！">
        </div></td>
    </tr>
  </table>
</FORM>
<jsp:include page="/main/errors.jsp"></jsp:include>
</html>



 


