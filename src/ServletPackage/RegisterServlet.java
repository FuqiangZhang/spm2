package ServletPackage;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import DB.DbImpl;
import DB.UserBean;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String pwd2 =request.getParameter("pwd2");
		UserBean userbean = new UserBean();
		DbImpl impl = new DbImpl();
		
		LogServlet.logOut(request);//���ע��ǰ��¼�� �����˳���¼��session

			if(pwd.equals(pwd2)){
				
				userbean.setAdmin(false);
				userbean.setName(username);
				userbean.setPwd(pwd);
				
				if(impl.Resiger(userbean)){
					session.setAttribute("user", userbean);
					session.setAttribute("username", userbean.getName());
					response.sendRedirect("index.jsp");
				}else{
					session.setAttribute("message", "�û����Ѵ���");
					response.sendRedirect("./user/Register.jsp");
				}
					
			}else{
				session.setAttribute("message","�������벻һ��");
				response.sendRedirect("./user/Register.jsp");
			}
		}
	
}
