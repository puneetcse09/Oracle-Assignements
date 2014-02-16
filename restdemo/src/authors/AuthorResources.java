package authors;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sun.jersey.spi.resource.Singleton;


@Produces({ "application/xml", "application/json" })
@Path("author")
@Singleton
public class AuthorResources {

	private TreeMap<Integer, AuthorVO> AuthorMap = new TreeMap<Integer, AuthorVO>();

	public AuthorResources() throws Exception{
		AuthorDAO authDao = new AuthorDAO();
		System.out.println(authDao.getAuthorResults().toString());
	}

	@GET
	public List<AuthorVO> getCategories() throws Exception {
		AuthorDAO authDao = new AuthorDAO();
		List<AuthorVO> Author = new ArrayList<AuthorVO>(authDao.getAuthorResults().values());
		return Author;
	}

	@GET
	@Path("{id}")
	public AuthorVO getAuthor(@PathParam("id") int cId) throws Exception {
		AuthorDAO authDao = new AuthorDAO();
//		return authDao.getAuthorResults().get(cId);
		return authDao.getAuthorResults(cId);
	}

	@POST
	@Path("add")
	@Produces("text/plain")
	@Consumes({ "application/xml", "application/json" })
	public String addAuthor(AuthorVO Author) {
		int id = AuthorMap.size();
		Author.setId(id);
		AuthorMap.put(id, Author);
		return "Author " + Author.getName() + " added with Id " + Author.getId();
	}
}