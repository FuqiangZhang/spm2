package ServletPackage;
import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.xml.ws.Dispatch;

import DB.DbImpl;
import DB.UserBean;
import Listener.loginListener;

public class LogServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
	
		HttpSession session = request.getSession();
		DbImpl impl = new DbImpl();
		UserBean user = new UserBean();
		if((request.getParameter("action")).equals("login")){
			
			user.setName(request.getParameter("username"));
			user.setPwd(request.getParameter("pwd"));
			user.setDuty(request.getParameter("duty"));
			
			switch(impl.LogIn(user)){
			case 1:	getRepeat(request,response);//1 success
					session.setAttribute("user", user);
					session.setAttribute("username",user.getName());
					response.sendRedirect("index.jsp");	
					break;
			case 2:	session.setAttribute("message","你不是学生/老师");
					response.sendRedirect("./main/errors.jsp");
					break;
			case 0:	session.setAttribute("message","用户名/密码错误！");
					response.sendRedirect("./main/errors.jsp");
			}
				
					
				
			
		}else{
			if((request.getParameter("action")).equals("logout")){
				
				logOut(request);
				response.sendRedirect("index.jsp");	
				}
		}
	}
	
	
	public static synchronized boolean getRepeat(HttpServletRequest request,HttpServletResponse response){
		
		boolean flag = false;
		List list = loginListener.list;
		System.out.println(list);
		HttpSession session=null;
		for(int i = 0 ;i<list.size();i++){
			session = (HttpSession)list.get(i);
			if(!(((UserBean)session.getAttribute("user"))==null)){
				UserBean user = (UserBean) (session.getAttribute("user"));
				if((request.getParameter("username")).equals(user.getName())){
					flag = true;
					session.removeAttribute("user");
					loginListener.listRemove(i);
					System.out.println("之前session 已remove");
				}
			}
		}
		
		return flag;
		
	}
	public static synchronized void logOut(HttpServletRequest request){
		HttpSession session2,session1 = null;
		session1 = request.getSession();
		UserBean user1 = (UserBean)session1.getAttribute("user");
		Vector<HttpSession> list = loginListener.list;
		UserBean user2 = null;
		if(user1!=null){
			for(int i =0;i<list.size();i++){
				session2 = (HttpSession)list.get(i);
				user2 = (UserBean)session2.getAttribute("user");
				if(user2!=null){
					if(user2.getName().equals(user1.getName())){
						
						loginListener.listRemove(i);
						
						session1.removeAttribute("user");
						session1.removeAttribute("username");
						session1.removeAttribute("message");
						return;
					}
				}
			}
			
		}
		
		
	}
	
	public static synchronized void logOut(HttpSession session){
		HttpSession session2 = null;
		UserBean user1 = (UserBean)session.getAttribute("user");
		Vector<HttpSession> list = loginListener.list;
		UserBean user2 = null;
		if(user1!=null){
			System.out.println("注册之前有人登录 则退出登录");
			for(int i =0;i<list.size();i++){
				session2 = (HttpSession)list.get(i);
				user2 = (UserBean)session2.getAttribute("user");
				if(user2!=null){
					if(user2.getName().equals(user1.getName())){
						
						loginListener.listRemove(i);
						
						session.removeAttribute("user");
						session.removeAttribute("username");
						return;
					}
				}
			}
			
		}
		
		
	}
}
