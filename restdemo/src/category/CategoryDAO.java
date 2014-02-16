package category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBConfig.BaseJDBC;

public class CategoryDAO {

	static Connection con;
	ResultSet rs = null;
	Statement stmt = null;
	String testSql = null;

	public Map<String, CategoryVO> getCategoryResults()throws Exception{

		Map<String, CategoryVO> rows = new HashMap<String, CategoryVO>();

		String query = "SELECT * FROM category";
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("SQl Executed inside getCategoryResults. . .");

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("NAME"));
				CategoryVO category = new CategoryVO();
				category.setId(Integer.parseInt(rs.getString("ID")));
				category.setName(rs.getString("NAME"));
				rows.put(rs.getString("ID"), category);
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
	
	public CategoryVO getCategoryResults(int param)throws Exception{

		String query = "SELECT * FROM category where id = :param";
		CategoryVO category = new CategoryVO();
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, param);

			rs = ps.executeQuery();
			System.out.println("SQl Executed inside getCategoryResults with param . . ."+param);

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("NAME"));
			
				category.setId(Integer.parseInt(rs.getString("ID")));
				category.setName(rs.getString("NAME"));
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

		return category;
	}

}
