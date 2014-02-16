package DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseJDBC {

	public static Connection getConnPool() throws Exception{

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@indlin241:1521:eacdw";
		String username = "ea_dev";
		String password = "ea_dev";

		Class.forName(driver); // load Oracle driver
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Got Connection.");
		return conn;	 
	}

	public static Connection openConnection(String url,String username, String password) throws ClassNotFoundException{

		String driver = "oracle.jdbc.OracleDriver";
		Class.forName(driver); // load Oracle driver
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got Connection.");
		return connect;

	}
}

