package category;

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
@Path("category")
@Singleton
public class CategoryResources {
	
	private TreeMap<Integer, CategoryVO> categoryMap = new TreeMap<Integer, CategoryVO>();
	
	public CategoryResources() throws Exception{
		CategoryDAO catDao = new CategoryDAO();
		System.out.println(catDao.getCategoryResults().toString());
	}
	
	@GET
	public List<CategoryVO> getCategories() throws Exception {
		System.out.println("Inside getCategories : ");
		CategoryDAO catDao = new CategoryDAO();
		List<CategoryVO> category = new ArrayList<CategoryVO>(catDao.getCategoryResults().values());
		return category;
	}

	@GET
	@Path("{id}")
	public CategoryVO getCategory(@PathParam("id") int cId) throws Exception {
		System.out.println("Inside Category getCategory : "+cId);
		CategoryDAO catDao = new CategoryDAO();
		return catDao.getCategoryResults(cId);
    }
		
	@POST
	@Path("add")
	@Produces("text/plain")
	@Consumes({ "application/xml", "application/json" })
	public String addCategory(CategoryVO category) {
		System.out.println("Inside addCategory : ");
		int id = categoryMap.size();
		category.setId(id);
		categoryMap.put(id, category);
		return "Category " + category.getName() + " added with Id " + category.getId();
	}
}