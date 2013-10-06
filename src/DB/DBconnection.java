package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Administrator
 * DBconnection类
 * 方法：
 * 1、getConneciton(String SqlUrl,String DbDriver,
 * 						String SqlUser,String SqlPwd)
 * 		return Connection
 * 2、closeConnection(ResultSet rs,Statement stmt,Connection conn)
 * 
 * 3、executeQuary(Connection conn,String sql)
 * 		return ResultSet 
 * 
 * 4、executeUpdate(Connection conn,String sql)
 */

public class DBconnection {
	
/*	private static String SqlUrl;
	private static String DbDriver;
	private static String SqlUser;
	private static String SqlPwd;
	
	public DBconnection(String SqlUrl,String DbDriver,String SqlUser,String SqlPwd){
		this.SqlUrl = SqlUrl;
		this.SqlUser = SqlUser;
		this.DbDriver = DbDriver;
		this.SqlPwd = SqlPwd;
	}*/
	
	
	/**
	 * 打开数据库链接
	 * @param SqlUrl
	 * @param DbDriver
	 * @param SqlUser
	 * @param SqlPwd
	 * @return Connection
	 */
	public static Connection getConneciton(String SqlUrl,String DbDriver,String SqlUser,String SqlPwd){
		Connection conn = null;
		try{
			Class.forName(DbDriver);
		}catch(ClassNotFoundException e){
			System.out.println("驱动加载失败");
		}
		try{
			conn = DriverManager.getConnection(SqlUrl, SqlUser, SqlPwd);
		}catch(SQLException e){
			System.out.println("链接数据库失败");
		}
		return conn;
	}
	
	
	
	/**
	 * 关闭数据库链接
	 * @param Statement
	 * @param ResultSet
	 * @param Connection
	 */
	public static void closeConnection(Connection conn){
		if(conn !=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(Statement stmt){
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(ResultSet rs,Statement stmt,Connection conn){
		closeConnection(rs);
		closeConnection(stmt,conn);
	}
	public static void closeConnection(Statement stmt,Connection conn){
		closeConnection(stmt);
		closeConnection(conn);
	}
	

	/**
	 * 数据库操作
	 * @param conn
	 * @param sql
	 * @return ResultSet
	 */
	public static ResultSet executeQuary(Connection conn,String sql){
		Statement stmt=null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void executeUpdate(Connection conn,String sql){
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection(stmt,conn);
		}
	}
	

}
