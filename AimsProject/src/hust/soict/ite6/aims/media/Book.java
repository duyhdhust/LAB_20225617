package hust.soict.ite6.aims.media;
import java.util.List;
import java.util.ArrayList;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println(authorName + "is already in the list of authors!");
		}
		else {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println(authorName + "is not in the list of authors!");
		}
	}
}