package MessageServlet;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class MsgServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		MsgeImpl msgsimpl = new MsgeImpl();
		MsgFolder folder = new MsgFolder();
		folder.setTitle("教学信息");
		System.out.println(msgsimpl.getAllCount());
		System.out.println(msgsimpl.getAllCount(folder));
	}
}
