package authors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import category.CategoryVO;
import DBConfig.BaseJDBC;

public class AuthorDAO {
	static Connection con;
	ResultSet rs = null;
	Statement stmt = null;
	String testSql = null;

	public Map<String, AuthorVO> getAuthorResults()throws Exception{

		Map<String, AuthorVO> rows = new HashMap<String, AuthorVO>();

		String query = "SELECT * FROM author";
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("SQl Executed inside getAuthorResults. . .");

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("NAME"));
				AuthorVO author = new AuthorVO();
				author.setId(Integer.parseInt(rs.getString("ID")));
				author.setName(rs.getString("NAME"));
				author.setName(rs.getString("LAST_NAME"));
				author.setName(rs.getString("DATE_OF_BIRTH"));
				rows.put(rs.getString("ID"), author);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
			}
			catch (Exception e) {
			}
		}

		return rows;
	}

	
	public AuthorVO getAuthorResults(int param)throws Exception{

		String query = "SELECT * FROM author where id = :param";
		AuthorVO author = new AuthorVO();
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, param);

			rs = ps.executeQuery();
			System.out.println("SQl Executed inside getAuthorResults with param . . ."+param);

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("NAME"));
			
				author.setId(Integer.parseInt(rs.getString("ID")));
				author.setName(rs.getString("NAME"));
				author.setLastName(rs.getString("LAST_NAME"));
				author.setDOB(rs.getString("DATE_OF_BIRTH"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) con.close();
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
			}
			catch (Exception e) {
			}
		}

		return author;
	}
}
