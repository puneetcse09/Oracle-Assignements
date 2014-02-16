package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import DBConfig.BaseJDBC;

public class BookDAO {
	static Connection con;
	ResultSet rs = null;
	Statement stmt = null;
	String testSql = null;

	public Map<String, BookVO> getBookResults()throws Exception{

		Map<String, BookVO> rows = new HashMap<String, BookVO>();

		String query = "SELECT * FROM book";
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("SQl Executed inside getBookResults. . .");

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("TITLE"));
				BookVO book = new BookVO();
				book.setId(Integer.parseInt(rs.getString("ID")));
				book.setTitle(rs.getString("TITLE"));
				rows.put(rs.getString("ID"), book);
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

	
	public BookVO getBookResults(int param)throws Exception{

//		String query = "SELECT * FROM book where id = :param";
		String query = "select * from book, author, category where book.id = :param and book.id = author.id and book.id = category.id";
		BookVO book = new BookVO();
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, param);

			rs = ps.executeQuery();
			System.out.println("SQl Executed inside getBookResults with param . . ."+param);

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("TITLE"));
			
				book.setId(Integer.parseInt(rs.getString("ID")));
				book.setTitle(rs.getString("TITLE"));
				
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

		return book;
	}
	
	public BookVO getDeleteBook(int param)throws Exception{

		String query = "delete from book where id = :param";
		BookVO book = new BookVO();
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, param);

			rs = ps.executeQuery();
			System.out.println("SQl Executed inside getBookResults with param . . ."+param);

			System.out.println("Record is deleted from BOOK table !");

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

		return book;
	}
	
	public BookVO updateBook(int bookId, String bookTitle)throws Exception{

//		String query = "SELECT * FROM book where id = :param";
		String query = "update book set title  = :bookTitle where book_id  = :bookId";
		BookVO book = new BookVO();
		try {
			con = (Connection) BaseJDBC.getConnPool();

			System.out.println("SQl "+query);
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bookId);
            ps.setString(2, bookTitle);

			rs = ps.executeQuery();
			System.out.println("SQl Executed inside getBookResults with param . . ."+bookId);

			while (rs.next()){
				System.out.println("Result Set : "+rs.getString("TITLE"));
			
				book.setId(Integer.parseInt(rs.getString("ID")));
				book.setTitle(rs.getString("TITLE"));
				
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

		return book;
	}
}
