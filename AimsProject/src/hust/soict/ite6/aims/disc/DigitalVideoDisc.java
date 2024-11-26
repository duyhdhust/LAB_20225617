package hust.soict.ite6.aims.disc;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
	private int id;
	private static int nbDigitalVideoDiscs = 0;
    // Constructor đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    }

	public DigitalVideoDisc(String title, String category, Float cost) {
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
    
	public DigitalVideoDisc(String title) {
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
	public int getId() {
		return id;
	}
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDiscs;
	}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DigitalVideoDisc that = (DigitalVideoDisc) obj;
        return title != null && title.equals(that.title);
    }
    
	@Override
	public String toString() {
	    return "DVD - " + title + " - " + category + " - " + director + " - " + length + " mins: " + cost + " $";
	}
    
	public boolean isMatch(String title) {
	    return this.title.equalsIgnoreCase(title);
	}
    
	public void setTitle(String title){ this.title = title; }
	public void setCategory(String category){ this.category = category; }
	public void setDirector(String director){ this.director = director; }
	public void setLength(int length){ this.length = length; }
	public void setCost(float cost){ this.cost = cost; }
}
