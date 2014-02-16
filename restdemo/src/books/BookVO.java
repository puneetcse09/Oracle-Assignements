package books;

import javax.xml.bind.annotation.XmlRootElement;

import category.CategoryVO;
import authors.AuthorVO;

@XmlRootElement
public class BookVO {

	private int id;
	private String title;
//	private AuthorVO author = new AuthorVO();
//	private CategoryVO category = new CategoryVO();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
