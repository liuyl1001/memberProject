package cn.mldn.util.dbc;

import java.sql.Connection;
import java.sql.DriverManager;




public class DatabaseConnection {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
	private static  ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	//取得数据库连接
	public static Connection getConnection() {
		Connection conn=  threadLocal.get();
		if (conn == null ) {
			conn=rebuilConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	//关闭数据连接
	public static void  close() {
		Connection conn=threadLocal.get();
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
	//当数据库连接为空时，创建。
	private static Connection rebuilConnection() {
		try {
			Class.forName(DRIVER);		
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception  e) {
			e.printStackTrace();
		return null;
		}
	}
}
