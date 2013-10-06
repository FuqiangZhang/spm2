package Filter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
public class EncodeFilter implements Filter{
	private String ccode;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding(ccode);
		chain.doFilter(req, rep);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ccode = config.getInitParameter("ccode");
		
	}
	
}
