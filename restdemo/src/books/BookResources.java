package books;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sun.jersey.spi.resource.Singleton;

@Produces({ "application/xml", "application/json" })
@Path("book")
@Singleton
public class BookResources {

	private TreeMap<Integer, BookVO> BookMap = new TreeMap<Integer, BookVO>();

	public BookResources() throws Exception{
		BookDAO bookDao = new BookDAO();
		System.out.println(bookDao.getBookResults().toString());
	}

	@GET
	public List<BookVO> getBooks() throws Exception {
		BookDAO bookDao = new BookDAO();
		List<BookVO> book = new ArrayList<BookVO>(bookDao.getBookResults().values());
		return book;
	}

	@GET
	@Path("{id}")
	public BookVO getBook(@PathParam("id") int cId) throws Exception {
		BookDAO bookDao = new BookDAO();
		return bookDao.getBookResults(cId);
	}

	@POST
	@Path("add")
	@Produces("text/plain")
	@Consumes({ "application/xml", "application/json" })
	public String addBook(BookVO book) {
		int id = BookMap.size();
		book.setId(id);
		BookMap.put(id, book);
		return "Book " + book.getTitle() + " added with Id " + book.getId();
	}
	
	@DELETE
	@Path("{id}")
	public void deleteBook(@PathParam("id") int cId) throws Exception {
		BookDAO bookDao = new BookDAO();
		bookDao.getDeleteBook(cId);
	   
	  }
	
	@PUT
	@Path("{id}, {title}")
	public void updateBook(@PathParam("id") int cId, @PathParam("title") String cTitle) {
		BookDAO bookDao = new BookDAO();
		updateBook(cId, cTitle);
	   
	  }
	
	
}