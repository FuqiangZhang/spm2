<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page import="DB.UserBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
    This is my JSP page. <br>
       <form action = "./user/Register.jsp" method = "post">
    	<input type = "submit" value = "注册"></form>
    <form action = "./course/choiceone.jsp" method = "post">
    	<input type = "submit" value = "选课"></form>
    <%	String name;
    	boolean admin;
    	String duty;
    	if(session.getAttribute("user")!=null){
  			 UserBean user = (UserBean)session.getAttribute("user");  
  			 name = user.getName();
  			 admin = user.getAdmin();
  			 duty = user.getDuty();
    %>
   		<%= name %>	 
   		is admin:<%= admin %>
   		duty:<%=duty %>
   		<form method = "post" action = "loginservlet">
   			<input type = "hidden" name="action" value = "logout" >
   			<input type = "submit" value = "注销">
   			</form>
    <%
      }else{%>
	     <%!String username=null; %>
	     <%!String pwd = null; %>
	     
	     <%username = request.getParameter("username");
	     	pwd = request.getParameter("pwd"); %>
	     	<%=pwd+username %>
	    <form method = "post" action = "loginservlet">
	    	<input type = "hidden" name ="action" value = "login"/>
	    	<input type = "text" name = "username" value =<%=username %> />
	    	<input type = "text" name ="pwd" value=<%=pwd %> />
	    	<input type = "submit" value="提交"/>
	    	<select name="duty">
				<option value="teacher">teacher</option>
				<option value="student">student</option>
				<option value="assistant">assistant</option>
				
			</select>
	    </form>
	    <%}
     %>
  </body>
</html>
