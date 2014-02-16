package DBConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryResult {
	static Connection con;
	ResultSet rs = null;
	Statement stmt = null;
	String testSql = null;

	public void getcategoryResults()throws Exception{
		try
		{
			con = (Connection) BaseJDBC.getConnPool();
			
			testSql = "select * from category";

			System.out.println("SQl "+testSql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(testSql);
			System.out.println("SQl Executed . . .");

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("SYSDATE"));
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (con != null) con.close();
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
			}
			catch (Exception e) {
			}
		}
		
	}

}
