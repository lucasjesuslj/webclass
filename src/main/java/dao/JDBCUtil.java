package dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCUtil {
	private static final String SERVER = "localhost";
	private static final String DATABASE = "webclass";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String TIMEZONE = "UTC";
	private static final String ENCODGIN = "UTF-8";
	private static MysqlDataSource ds = null;

	public static Connection getConnection() throws SQLException {
		if (ds == null) {
			try {
				ds = new MysqlDataSource();
				ds.setServerName(SERVER);
				ds.setDatabaseName(DATABASE);
				ds.setServerTimezone(TIMEZONE);
				ds.setCharacterEncoding(ENCODGIN);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ds.getConnection(USER, PASSWORD);
	}

	public static void close(Connection con) {
		
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
