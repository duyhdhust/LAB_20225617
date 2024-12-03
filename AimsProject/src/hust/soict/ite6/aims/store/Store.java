package hust.soict.ite6.aims.store;
import java.util.ArrayList;

import hust.soict.ite6.aims.media.Media;
public class Store {
	private ArrayList<Media> itemInStore = new ArrayList<Media>();
	public Media findMedia(String title) {
	        for (Media item : itemInStore) {
	            if (item.getTitle().equals(title)) {
	                return item;
	            }
	        }
	        return null;
	    }
    public ArrayList<Media> getItemsInStore() { return itemInStore; }
    public void addMedia(Media item) {
    	if(itemInStore.contains(item)) {
    		System.out.println(item.getClass().getSimpleName() + ' ' + item.getTitle() + " is already in store!");
    	} else {
    		itemInStore.add(item);
    		System.out.println(item.getClass().getSimpleName() + ' ' + item.getTitle() + " was successfully added to store!");
    	}
    }

    public void removeMedia(Media item) {
    	if(itemInStore.contains(item)) {
    		itemInStore.remove(item);
    		System.out.println(item.getClass().getSimpleName() + ' ' + item.getTitle() + " was successfully removed from store!");
    	} else {
    		System.out.println(item.getClass().getSimpleName() + ' ' + item.getTitle() + " is not in store!");
    	}
    }
}
