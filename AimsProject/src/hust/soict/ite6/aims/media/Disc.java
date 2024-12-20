package hust.soict.ite6.aims.media;

public class Disc extends Media
{
	private int length;
	private String director;
	public Disc(String title, String category, float cost, int length, String director) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
		}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String toString() {
	       return "DVD: " +
	                " [id = "  + getId() +
	                ", title = " + getTitle() +
	                ", category = " + getCategory() +
	                ", director: " + getDirector() +
	                ", length = " + getLength() + " min" + ", cost= " + getCost() + "$]";
	    }
}
