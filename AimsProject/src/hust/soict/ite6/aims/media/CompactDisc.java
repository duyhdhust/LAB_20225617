package hust.soict.ite6.aims.media;


import java.util.ArrayList;

import hust.soict.ite6.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable
{
	private String artist;
	private ArrayList<Track> tracks;
	public String getArtist() {
		return artist;
	}
	
    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
        this.setLength(getLength());
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    // Method addTrack HoangAnh_226076
    public void addTrack(Track song) {
        if(tracks.contains(song)) {
            System.out.println(song.getTitle() + " is already in the CD");
        } else {
            tracks.add(song);
        }
    }
    // Method removeTrack HoangAnh_226076
    public void removeTrack(Track song) {
        if(tracks.contains(song)) {
            tracks.remove(song);
        } else {
            System.out.println(song.getTitle() + " is not in the CD");
        }
    }
    // Method getLength HoangAnh_226076
    @Override
    public int getLength() {
    	int totalLength = 0;
    	for(Track song : tracks) {
    		totalLength += song.getLength();
    	}
    	return totalLength;
    }
    //Method play HoangAnh_226076
    public void play() throws PlayerException {
        if(this.getLength() < 0) {
            throw new PlayerException("ERROR: DVD-length is non-positive!");
        } else {
            System.out.println("\ntitle: " + getTitle() + '\n' + "artist: " + getArtist() + "\n\n" + "Tracks:");
            for (Track song : tracks) {
                song.play();
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("CD: " +
                " [id = "  + getId() +
                ", artist: " + artist +
                ", title = " + getTitle() +
                ", category = " + getCategory() +
                ", length: " + getLength() + " min" +
                ", cost = " + getCost() + "$]" + '\n' + "Tracks: \n"
                + "===================" + '\n');
        for (Track track : tracks) {
            print.append(track.getTitle());
            print.append('\t');
            print.append(track.getLength());
            print.append(" min");
            print.append('\n');
        }
        return print.toString();
    }

	public ArrayList<Track> getTracks() {
		return tracks;
	}

}
