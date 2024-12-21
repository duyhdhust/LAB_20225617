package hust.soict.ite6.aims.media;
import hust.soict.ite6.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable
{


	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);

	}
	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}
	public void play() throws PlayerException {
      if (this.getLength() < 0){
          throw new PlayerException("ERROR: DVD-length is non-positive!");
      } else {
          System.out.println("Playing DVD: " + this.getTitle());
          System.out.println("DVD length: " + this.getLength());
      }
  }
}
