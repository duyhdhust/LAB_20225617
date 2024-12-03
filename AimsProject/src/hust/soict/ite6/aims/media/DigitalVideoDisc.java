package hust.soict.ite6.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {


	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		//nbDigitalVideoDiscs++;
		//this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		//nbDigitalVideoDiscs++;
		//this.id = nbDigitalVideoDiscs;
	}
//    public static int getNbDigitalVideoDisc() {
//		return nbDigitalVideoDiscs;
//	}
	public void play() {
	     System.out.println("Playing DVD: " + this.getTitle());
	     System.out.println("DVD length: " + this.getLength());
	}

}