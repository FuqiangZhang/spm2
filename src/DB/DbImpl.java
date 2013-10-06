package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbImpl implements DbInterface {
	
	private final  String SQLURL = "jdbc:mysql://localhost:3306/test";
	private final  String DBDRIVER = "com.mysql.jdbc.Driver";
	private final  String SQLUSER = "";
	private final  String SQLPWD = "";
	
	//ÓÃ»§µÇÂ¼
	public int LogIn(UserBean userbean){
		
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String selectuser = "SELECT uid,pwd,admin,teacher FROM USERS WHERE uid = ? AND pwd = ?";
		String getsid = "SELECT sid ,class,name FROM students WHERE uid = ?";
		String username = userbean.getName();
		String pwd = userbean.getPwd();
		
		String sid = null;
		String sclass = null;
		String name = null;
		
		boolean admin = userbean.getAdmin();
		String duty = userbean.getDuty();
		int flag = 0;
		
		
		
		try {
			
			pstmt = conn.prepareStatement(selectuser);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("success");
				admin = rs.getBoolean("admin");
				if(duty.equalsIgnoreCase(rs.getString("teacher"))){
					userbean.setAdmin(admin);
					userbean.setDuty(duty);
					flag = 1;//success
				}else{
					flag = 2;//dutyÑ¡Ôñ´íÎó
				}
			}
			if(flag == 1){
				try {
					pstmt = conn.prepareStatement(getsid);
					pstmt.setString(1, username);
								
					rs = pstmt.executeQuery();
					while(rs.next()){
						sid = rs.getString("sid");
						sclass = rs.getString("class");
						name = rs.getString("name");
						userbean.setSid(sid);
						userbean.setSclass(sclass);
						userbean.setSname(name);
						System.out.println(name);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			flag = 0;//µÇÂ½Ê§°Ü
		}finally{
			DBconnection.closeConnection(rs, pstmt, conn);
		}
		
		
		
		
		return flag;
	}

	@Override
	public boolean Resiger(UserBean userbean) {
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sqlifexist = "SELECT uid FROM users WHERE uid = ?";
		String sqlinsertuser = "INSERT INTO users (uid,pwd,admin) VALUES (?, ?,?)"; 
		
		String username = userbean.getName();
		String pwd = userbean.getPwd();
		boolean admin = userbean.getAdmin();
		
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sqlifexist);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			conn.commit();
			if(rs.next()){
				return false;
			}else{
				pstmt = conn.prepareStatement(sqlinsertuser);
				pstmt.setString(1, username);
				pstmt.setString(2, pwd);
				pstmt.setBoolean(3, admin);
				pstmt.executeUpdate();
				conn.commit();
			}
		}catch(SQLException e){
			System.out.println("SQL WRONG");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBconnection.closeConnection(rs, pstmt, conn);
		}
		return true;
	}

	@Override
	public boolean BindSid(UserBean userbean) {
		boolean flag = false;
		
		String sid = userbean.getSid();
		String sname = userbean.getSname();
		String sclass = userbean.getSclass();
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		PreparedStatement pstmt = null;
	//	String sql = "UPDATE students SET sid = ? name = ? WHERE uid = ?";
		String sql = "INSERT INTO students (uid, name, sid, class,state) VALUES (?, ?, ?, ?,0)";
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, sclass);
			pstmt.setString(3, sid);
			pstmt.setString(2, sname);
			pstmt.setString(1,userbean.getName());
			pstmt.executeUpdate();
			conn.commit();
			flag = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("°ó¶¨sidÊ§°Ü");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBconnection.closeConnection(pstmt, conn);
		}
		return flag;
	}

	
}
