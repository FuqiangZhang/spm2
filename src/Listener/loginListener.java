package Listener;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
public class loginListener implements HttpSessionAttributeListener,
		ServletContextListener,HttpSessionListener{
	
	//public static List list = new ArrayList();
	public static Vector<HttpSession> list = new Vector<HttpSession>();
	
	public static synchronized void listRemove(int i){
		
		list.remove(i);
		System.out.println("注销后"+list.size());
		
		
		
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		if(arg0.getName().equals("user")){

			list.add(arg0.getSession());
			System.out.println("新登录后"+list.size());

		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
			
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
