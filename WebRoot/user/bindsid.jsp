<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bindsid.jsp' starting page</title>
    
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
  <%String message = (String)session.getAttribute("message"); 
  	out.println(message);
  			if((message == null)||(!message.equalsIgnoreCase("成功"))){%>
    <form action = "bindsid" method = "post">
	   	sid:<input type = "text" name = "sid"><br>
	   	name:<input type = "text" name ="sname"><br>
	   	class<input type = "text" name ="sclass"><br>
	   	<input type = "submit" value = "绑定">
	   </form>
	   <%}else{ %>
	<jsp:include page="/main/errors.jsp"></jsp:include>
	<%} %>
  </body>
</html>
