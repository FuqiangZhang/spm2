package UPload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import GradeManage.GradeBean;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import jxl.*;
public class UploadServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		PageContext pageContext = JspFactory.getDefaultFactory()
			     .getPageContext(this, request, response, null,
			       true, 8192, true);// ��ȡpagecontext()
		SmartUpload su = new SmartUpload();
		long file_size_max=4000000;
		String fileName2="",ext="xls",testvar="";
		String url="upload/"; //Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ��ڣ�Ҳ����˵��Ҫ�Լ�������Ӧ���ļ��У�
		//��ʼ��
		try {
			su.initialize(pageContext);
			su.setAllowedFilesList("xls");//ֻ�����ϴ������ļ�
			su.upload();
			File myFile = su.getFiles().getFile(0);
			String saveurl="";
			Calendar calendar = Calendar.getInstance();

			String filename = String.valueOf(calendar.getTimeInMillis());
			ServletContext application=this.getServletContext();  
			saveurl=application.getRealPath("/")+url;
			saveurl+=filename+"."+ext; //����·��

			myFile.saveAs(saveurl,SmartUpload.SAVE_PHYSICAL);
			request.getSession().setAttribute("message", "success");
			response.sendRedirect("./upload.jsp");
			
			Exc2Db exc2db = new Exc2Db();
			ArrayList list = (ArrayList) exc2db.ReadExcel(saveurl);
			GradeBean grade;
			for(int i =0;i<list.size();i++){
			//	grade = new GradeBean();
		//		System.out.println(((GradeBean)list.get(i)).getSid());
				System.out.println(((GradeBean)list.get(i)).getAll());
			}
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
