package GradeManage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBconnection;
import DB.UserBean;
public class GradeImpl implements GradeInterface{
	private final  String SQLURL = "jdbc:mysql://localhost:3306/test";
	private final  String DBDRIVER = "com.mysql.jdbc.Driver";
	private final  String SQLUSER = "";
	private final  String SQLPWD = "";
	/**
	 * 确认选课(user: students|assistant)
	 */
	@Override
	public int oneChoice(UserBean userbean) {
		String uid = userbean.getName();
		String sid = null;
		String sclass = null;
		int flag = 0;
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		PreparedStatement pstmt = null;
		String setstate = "UPDATE students SET state = ? WHERE uid = ? ";//UPDATE `test`.`students` SET `state` = '1' WHERE `sid` = '111111111'; 
		String getsid = "SELECT sid ,class FROM students WHERE uid = ?";
		ResultSet rs = null;
		
		try{
			conn.setAutoCommit(true);
			pstmt = conn.prepareStatement(getsid);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sid = rs.getString("sid");
				sclass = rs.getString("class");
				userbean.setSid(sid);
				userbean.setSclass(sclass);
			}
			if(sid == null){
				flag = 0;//返回0 为 sid未绑定
				DBconnection.closeConnection(rs, pstmt, conn);
				return flag;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(setstate);
			pstmt.setString(2, uid);
			pstmt.setBoolean(1, true);
			pstmt.executeUpdate();
			conn.commit();
			flag = 2;//返回2 为选课成功
			
		} catch (SQLException e) {
			flag = 1;//返回1 为选课失败
		}finally{
			try {
				conn.setAutoCommit(true);
				DBconnection.closeConnection(pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * 获取选课表
	 */
	@Override
	//synchronized??
	public  List<CourseBean> getAllist() {
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		PreparedStatement pstmt = null;
		String sql = "SELECT sid,name,class,state FROM students";
		ResultSet rs = null;
		String sid,name,sclass;
		boolean state ;
		
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CourseBean user=new CourseBean();
				sid = rs.getString("sid");
				name = rs.getString("name");
				sclass = rs.getString("class");
				state = rs.getBoolean("state");
				
				user.setSname(name);
				user.setSclass(sclass);
				user.setSid(sid);
				user.setState(state);
				
				list.add(user);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBconnection.closeConnection(rs, pstmt, conn);
		}
		
		return list;
	}
	/**
	 * 选课修改（user: teacher|assistant）
	 */
	@Override
	public boolean changeOnecourse(CourseBean coursebean) {
		boolean flag = false;
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "UPDATE students SET state = ? WHERE sid = ?";
		String getstate = "SELECT state FROM students WHERE sid = ?";
		
		String sid = coursebean.getSid();
//		System.out.println(sid);
		boolean state1 = false;
		try{
			conn.setAutoCommit(true);
			pstmt = conn.prepareStatement(getstate);
			pstmt.setString(1,sid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				state1 = rs.getBoolean("state");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, !state1);
			pstmt.setString(2, sid);
			pstmt.executeUpdate();
			conn.commit();
			flag = true;
		}catch(SQLException e){
			flag = false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally{
			DBconnection.closeConnection(rs,pstmt, conn);
		}
		return flag;
	}
	/**
	 * 
	 */
	public int inputGrade(){
		
		return 0;
		}
	
	/**
	 * 获得所有成绩
	 */
	@Override
	public List<GradeBean> getAllGrade() {
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "SELECT * FROM grade";
		String getname = "SELECT name,class FROM students WHERE sid = ?";
		GradeBean grades = null;
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GradeBean grade = new GradeBean();
				grade.setSid(rs.getString("sid"));
				grade.setAll(rs.getLong("all"));
				grade.setFinnal(rs.getInt("finnal"));
				grade.setMidgrade(rs.getInt("midgrade"));
				grade.setPeacetime(rs.getInt("peacetime"));
				grade.setPractic(rs.getInt("practic"));
				
				list.add(grade);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			pstmt = conn.prepareStatement(getname);
			for(int i =0;i<list.size();i++){
				String name,sclass,sid;
				grades= (GradeBean)list.get(i);

				sid = grades.getSid();
				pstmt.setString(1, sid);
				rs = pstmt.executeQuery();
				while(rs.next()){
					name = rs.getString("name");
					sclass = rs.getString("class");
					grades.setSclass(sclass);
					grades.setSname(name);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBconnection.closeConnection(rs, pstmt, conn);
		}
		
		return list;
	}
	
}
