<%@ page language="java" import="java.util.*,DB.UserBean" pageEncoding="utf-8"%>
<%@ page contentType = "text/html;charset = utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'choiceone.jsp' starting page</title>
    
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
  <% UserBean user = (UserBean) session.getAttribute("user");
  	
  	%>
<%= user.getDuty() %>
<%= user.getSclass() %>
<%= user.getSid() %>
<%= user.getSname() %>
<%if(!user.getDuty().equalsIgnoreCase("teacher")){ %>
    <form method = "post" action = "choicecourse">
   		<input type = "hidden" name = "action" value = "confirm"/>
    	<input type = "submit" value = "选课"></form>
    		<jsp:include page="/main/errors.jsp"></jsp:include>
    		<%String message = "";
    		message=(String) session.getAttribute("message");
    		if(message!=null){
    			if(message.equalsIgnoreCase("请完善您的信息:sid 未绑定")) {%>
    				<form action = "./user/bindsid.jsp" method = "post">
    					<input type = "submit" value = "去绑定">
    				</form>
    				<%		}
    					}
    				}%>
    				
   <jsp:include page="/course/allselect.jsp"></jsp:include>
  </body>
</html>
