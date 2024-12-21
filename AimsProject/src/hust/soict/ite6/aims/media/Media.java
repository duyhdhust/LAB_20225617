package hust.soict.ite6.aims.media;

import java.util.Comparator;
public abstract class Media implements Comparable<Media>{
	@Override
	public int compareTo(Media otherMedia) {
		// So sanh theo tieu de truoc
		int titleComparison = this.title.compareTo(otherMedia.getTitle());
		// Neu cac title bang nhau so sanh theo gia
		return (titleComparison == 0) ? Float.compare(this.cost, otherMedia.getCost()) : titleComparison;
	}
	private static int nextId = 1;
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media(String title, String category, float cost) {
		this.id = nextId++;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true; // Cùng tham chiếu
	    if (o == null || getClass() != o.getClass()) return false; // Null hoặc khác lớp

	    Media media = (Media) o; // Ép kiểu sang Media
	    return title != null && title.equalsIgnoreCase(media.title); // So sánh title 
	}

	 @Override
	    public String toString() {
	        return this.getClass().getSimpleName() +
	                " [id = " + id +
	                ", title = " + title +
	                ", category = " + category +
	                ", cost = " + cost + "$]";
	    }

}
