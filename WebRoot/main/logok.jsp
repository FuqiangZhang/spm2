<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType = "text/html;charset = utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome!!!</title>
    
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
    Welcome!<%= session.getAttribute("username") %>
    <form method = "post" action = "loginservlet"/>
    	<input type = "submit" value = "注销"/>
    	<input type = "hidden" name = "action" value = "logout"/>
    </form>
  </body>
</html>
