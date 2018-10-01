package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBConnection {

	private static Connection conn;
	/**
	 * Returns a Singleton database connection
	 * @return
	 */
	public static Connection getConnection() {
	
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Properties props = new Properties();
				FileInputStream in = new FileInputStream("src/main/resources/connections.properties");
				props.load(in);
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				conn = DriverManager.getConnection(url, username, password);
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return conn;
	}
}
