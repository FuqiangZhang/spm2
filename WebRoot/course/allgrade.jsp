<%@ page language="java" import="java.util.*,GradeManage.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allgrade.jsp' starting page</title>
    
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
  <table border="1">
		<tr>
			<th>编号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>班级</th>
			<th>平时成绩</th>
			<th>期中成绩</th>
			<th>期末成绩</th>
			<th>实验成绩</th>
			<th>总成绩</th>
		</tr>
   <%request.setAttribute("getwhat", "allgrade"); %>
  
   <%	GradeImpl gradeimpl = new GradeImpl();
   		ArrayList gradelist = (ArrayList) gradeimpl.getAllGrade();

   		GradeBean gradebean = null;
   		out.print("");
   		for(int i =0;i<gradelist.size();i++){
   			gradebean = (GradeBean) gradelist.get(i);
   			
   			String sid = gradebean.getSid();
   			String sname = gradebean.getSname();
   			String sclass = gradebean.getSclass();
   			
   			int peacetime = gradebean.getPeacetime();
   			int midgrade = gradebean.getMidgrade();
   			int finnal = gradebean.getFinnal();
   			long all = gradebean.getAll();
   			int practic = gradebean.getPractic();
   			
   				out.print("<tr>");
				out.print("<td>");
				out.print(i);
				out.print("</td>");
				
				out.print("<td>");
				out.print(sid);
				out.print("</td>");
				
				out.print("<td>");
				out.print(sname);
				out.print("</td>");
				
				out.print("<td>");
				out.print(sclass);
				out.print("</td>");
				
				out.print("<td>");
				out.print(peacetime);
				out.print("</td>");
				
				out.print("<td>");
				out.print(midgrade);
				out.print("</td>");
				
				out.print("<td>");
				out.print(finnal);
				out.print("</td>");
				
				out.print("<td>");
				out.print(practic);
				out.print("</td>");
				
				out.print("<td>");
				out.print(all);
				out.print("</td>");
   		
   
   		} %>
  </body>
</html>
