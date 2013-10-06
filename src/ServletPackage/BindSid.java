package ServletPackage;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import DB.DbImpl;
import DB.UserBean;

public class BindSid extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException{
		DbImpl dbimpl = new DbImpl();
		boolean flag = false;
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sclass = request.getParameter("sclass");
		user.setSid(sid);
		user.setSname(sname);
		user.setSclass(sclass);
		flag = dbimpl.BindSid(user);
		if(flag){
			session.setAttribute("message", "³É¹¦");
		}else{
			session.setAttribute("message", "°ó¶¨Ê§°Ü");
		}
		try {
			response.sendRedirect("./user/bindsid.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
