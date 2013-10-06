package MessageServlet;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import DB.DBconnection;

public class MsgeImpl implements MsgeInterFace{
	private final  String SQLURL = "jdbc:mysql://localhost:3306/test";
	private final  String DBDRIVER = "com.mysql.jdbc.Driver";
	private final  String SQLUSER = "";
	private final  String SQLPWD = "";
	
	
	@Override
	public int getAllCount() {
		int count = 0;
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(id) FROM message";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBconnection.closeConnection(rs, pstmt, conn);
		}
		return count;
	}
	public int getAllCount(MsgFolder folder) {
		int count = 0;
		Connection conn = DBconnection.getConneciton(SQLURL, DBDRIVER, SQLUSER, SQLPWD);
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT COUNT(id) FROM message WHERE folder = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, folder.getTitle());
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBconnection.closeConnection(rs, pstmt, conn);
		}
		return count;
	}

	@Override
	public MessageBean getOneMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getAllMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	public HashMap getAllMessage(MsgFolder folder) {
		// TODO Auto-generated method stub
		return null;
	}

}
