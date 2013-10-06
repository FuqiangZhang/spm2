package GradeManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.UserBean;

public class GradeServlet extends HttpServlet {



	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GradeImpl gradeimpl = new GradeImpl();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String getwhat = request.getParameter("getwhat");
		if(action!=null&&action.equalsIgnoreCase("confirm")){
			ConfirmChoice(request, response);
		}
		
		System.out.println(getwhat);
		if(getwhat!=null&&getwhat.equalsIgnoreCase("allgrade")){
			ArrayList gradelist = (ArrayList) gradeimpl.getAllGrade();
			System.out.println(gradelist);
			session.setAttribute("gradelist", gradelist);
			response.sendRedirect("./course/allgrade.jsp");
			
		}
		
		
		
	//	System.out.println(user.getDuty());

	}
	/**
	 * 确认选课(user:students|assistant)
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void ConfirmChoice(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		GradeImpl gradeimpl = new GradeImpl();
		UserBean user = (UserBean) session.getAttribute("user");
		
		if(user.getDuty() == null){
			session.setAttribute("message", "请完善您的信息");
			response.sendRedirect("./course/choiceone.jsp");
		}else{
			if(user.getDuty().equalsIgnoreCase("student")){
				int flag = gradeimpl.oneChoice(user);
			//	System.out.println(flag);
				switch(flag){
				case 0:	session.setAttribute("message", "请完善您的信息:sid 未绑定");
						response.sendRedirect("./course/choiceone.jsp");
						break;
				case 1: session.setAttribute("message","更新失败请重试");
						response.sendRedirect("./course/choiceone.jsp");
						break;
				case 2: session.setAttribute("message","选课成功");
						response.sendRedirect("./course/choiceone.jsp");
				}
			}else if(user.getDuty().equalsIgnoreCase("assistant")){
				int flag = gradeimpl.oneChoice(user);
		//		System.out.println(flag);
				switch(flag){
				case 0:	session.setAttribute("message", "请完善您的信息:sid 未绑定");
						response.sendRedirect("./course/choiceone.jsp");
						break;
				case 1: session.setAttribute("message","更新失败请重试");
						response.sendRedirect("./course/choiceone.jsp");
						break;
				case 2: session.setAttribute("message","选课成功");
						response.sendRedirect("./course/choiceone.jsp");
				}
				
			}
		}
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
