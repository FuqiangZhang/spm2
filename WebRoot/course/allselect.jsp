<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "GradeManage.*,DB.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!所有学生的选课信息>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allselect.jsp' starting page</title>
    
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
			<th>状态</th>
			<th>备注</th>
		</tr>
		
		<%!ArrayList list = new ArrayList(); %>
		<% GradeImpl gradeimpl = new GradeImpl();
			UserBean user = (UserBean)session.getAttribute("user");
			String duty = user.getDuty();
			list = (ArrayList)gradeimpl.getAllist();
			for(int i = 0;i<list.size();i++){
				CourseBean coursebean = null;
				String sid;//学号
				String sname;//姓名
				String sclass;
				boolean state;
				coursebean =(CourseBean) list.get(i) ;;
				sid = coursebean.getSid();
				sname = coursebean.getSname();
				sclass = coursebean.getSclass();
				state = coursebean.getState();
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
				out.print(state);
				out.print("</td>");
				if(!duty.equalsIgnoreCase("student")){
					out.print("<td>");
			//		session.setAttribute("Ncoursebean", i);
					out.print("<a href=\"./course/change?Ncoursebean="+i+"\">改</a>");
					out.print("</td>");
				}
				out.print("</tr>");
				}
			%>
	
	</table>
  </body>
</html>
