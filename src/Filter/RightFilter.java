package Filter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import DB.UserBean;

public class RightFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest request	, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession session = hrequest.getSession();
		UserBean userbean = null;
//		session.getAttributeNames();
		userbean = (UserBean) session.getAttribute("user");
	//	boolean isAdmin = false;
	//	isAdmin = userbean.getAdmin();
		if(userbean==null){
			hresponse.sendRedirect("index.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
