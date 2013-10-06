package GradeManage;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
public class CourseChangeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException{
		HttpSession session = request.getSession();
		GradeImpl gradeimpl = new GradeImpl();
		ArrayList list = (ArrayList) gradeimpl.getAllist();
		int Ncoursebean = Integer.valueOf(request.getParameter("Ncoursebean"));
	//	System.out.println(Ncoursebean);
		if(gradeimpl.changeOnecourse((CourseBean)list.get(Ncoursebean))){
			try {
				response.sendRedirect("./choiceone.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
