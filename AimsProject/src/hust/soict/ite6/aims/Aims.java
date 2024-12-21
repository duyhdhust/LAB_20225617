package hust.soict.ite6.aims;
import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.store.Store;
import hust.soict.ite6.aims.media.*;
import hust.soict.ite6.aims.exception.*;
import java.util.*;
public class Aims {
    public static void main(String[] args) throws PlayerException{
    	// Khoi tao cac item HoangAnh_226076
    	Media dvd = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
    		 
    	List<String> authors = new ArrayList<String>();
    	authors.add("To Hoai");
    	authors.add("Nguyen Huy Tuong");
    	Media book = new Book("Tuoi tre du doi", "Ki su", 6.5f, authors);
    	     
    	ArrayList<Track> tracks = new ArrayList<Track>();
    	tracks.add(new Track("End of the world",3));
    	tracks.add(new Track("Eternal sunshine",4));
    	Media cd = new CompactDisc("Eternal sunshine", "Pop" , 5.5f, "Ariana Grande", tracks);
    	Store store = new Store();
    	store.addMedia(cd);
    	store.addMedia(dvd);
    	store.addMedia(book);
    	Cart cart = new Cart();
    	Scanner scanner = new Scanner(System.in);
        showMenu(scanner, store, cart);
    }

public static void showMenu(Scanner scanner, Store store, Cart cart) {
    while (true) {
    	System.out.println( 
    	        "--------------------------------\n" +
    	        "1. View store\n" +
    	        "2. Update store\n" +
    	        "3. See current cart\n" +
    	        "0. Exit\n" +
    	        "--------------------------------\n" +
    	        "Please choose a number: 0-1-2-3");
        int option = scanner.nextInt();
        switch (option) {
        case 0:
            scanner.close();
            System.exit(0);
            break;

        case 1:
            storeMenu(scanner, store, cart);
            break;

        case 2:
            updateStoreMenu(scanner, store);
            break;

        case 3:
            cart.print();
            cartMenu(scanner, cart);
            break;

        default:
            System.out.println("Invalid option. Please try again.");
            break;
    }

    }
}

public static void updateStoreMenu(Scanner scanner, Store store) {
	System.out.println(
		    "==========================\n" +
		    "1. add Media\n" +
		    "2. delete Media\n" +
		    "3. update Media in Store\n" +
		    "0. Back\n" +
		    "==========================\n" +
		    "Option: ");

    int option = scanner.nextInt();
    switch (option) {
    case 1:
        System.out.println(
            "1. DigitalVideoDisc\n" +
            "2. CompactDisc\n" +
            "3. Book\n" +
            "-------\n" +
            "-> Your type:");
        int option2 = scanner.nextInt();
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        
        switch (option2) {
            case 1:
                System.out.print("Enter director's name: ");
                String director = scanner.nextLine();
                System.out.print("Enter dvd's length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
                break;

            case 3:
                System.out.print("Enter author's name (Enter nothing to skip): ");
                StringBuilder author = new StringBuilder(scanner.nextLine());
                ArrayList<String> authors = new ArrayList<>();
                while (!author.toString().isEmpty()) {
                    authors.add(author.toString());
                    System.out.print("Enter author's name (Enter nothing to skip): ");
                    author.replace(0, author.length(), scanner.nextLine());
                }
                store.addMedia(new Book(id, title, category, cost, authors));
                break;

            case 2:
                System.out.print("Enter artist's name: ");
                StringBuffer artist = new StringBuffer(scanner.nextLine());
                System.out.print("Enter number of tracks: ");
                int nbTrack = scanner.nextInt();
                scanner.nextLine();
                ArrayList<Track> tracks = new ArrayList<>();
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < nbTrack; i++) {
                    System.out.print("Enter Track[" + i + "]'s name: ");
                    name.replace(0, name.length(), scanner.nextLine());
                    System.out.print("Enter Track[" + i + "]'s length: ");
                    int trackLength = scanner.nextInt();
                    tracks.add(new Track(name.toString(), trackLength));
                    scanner.nextLine();
                }
                store.addMedia(new CompactDisc(id, title, category, cost, artist.toString(), tracks));
                break;

            default:
                System.out.println("Invalid type. Please try again.");
                break;
        }
        break;

    case 2:
        System.out.println("Enter item's title: ");
        scanner.nextLine();
        String delTitle = scanner.nextLine();
        Iterator<Media> iter = store.getItemsInStore().iterator();
        while (iter.hasNext()) {
            Media item = iter.next();
            if (item.getTitle().equals(delTitle)) {
                iter.remove();
                System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + " has been deleted from the store!");
            }
        }
        break;

    case 3:
        System.out.println("Enter item's id: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter category: ");
        String newCategory = scanner.nextLine();
        System.out.print("Enter cost: ");
        float newCost = scanner.nextFloat();
        store.getItemsInStore().get(updateId).setCost(newCost);
        store.getItemsInStore().get(updateId).setTitle(newTitle);
        store.getItemsInStore().get(updateId).setCategory(newCategory);
        System.out.println(store);
        break;

    default:
        System.out.println("Invalid option. Please try again.");
        break;
}

}

public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
    System.out.print("Enter media's title: ");
    String title = scanner.nextLine();
    Media item = store.findMedia(title);
    if(item == null) {
        System.out.println("There is no such media !");
        return;
    }
    System.out.println(item);
    while (true) {
    	System.out.println(
    		    "Options:\n" +
    		    "--------------------------------\n" +
    		    "1. Add to cart\n" +
    		    "2. Play\n" +
    		    "0. Back\n" +
    		    "--------------------------------\n" +
    		    "Please choose a number: 0-1-2");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
        case 1:
            cart.addMedia(item);
            break;

        case 2:
            if (item.getClass().getSimpleName().equals("Book")) {
                System.out.println("This media is unplayable");
            } else {
                if (item instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) item;
                    dvd.play();
                }
                if (item instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) item;
                    cd.play();
                }
            }
            break;

        case 0:
            return;

        default:
            System.out.println("Invalid option. Please try again.");
            break;
    }

    }
}
public static void storeMenu(Scanner scanner, Store store, Cart cart) {
    System.out.println(store);
    while (true) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
        case 1:
            mediaDetailsMenu(scanner, store, cart);
            break;

        case 0:
            return;

        case 2:
            System.out.print("Enter media's title: ");
            String titleAdd = scanner.nextLine();
            Media itemAdd = store.findMedia(titleAdd);
            if (itemAdd == null) {
                System.out.println("There is no such media!");
            } else {
                cart.addMedia(itemAdd);
            }
            break;

        case 3:
            System.out.print("Enter media's title: ");
            String titlePlay = scanner.nextLine();
            Media itemPlay = store.findMedia(titlePlay);
            if (itemPlay == null) {
                System.out.println("There is no such media!");
            } else {
                if (itemPlay.getClass().getSimpleName().equals("Book")) {
                    System.out.println("This media is unplayable");
                } else {
                    if (itemPlay instanceof DigitalVideoDisc) {
                        DigitalVideoDisc dvd = (DigitalVideoDisc) itemPlay;
                        dvd.play();
                    }
                    if (itemPlay instanceof CompactDisc) {
                        CompactDisc cd = (CompactDisc) itemPlay;
                        cd.play();
                    }
                }
            }
            break;

        case 4:
            cart.print();
            cartMenu(scanner, cart);
            break;

        default:
            System.out.println("Invalid option. Please try again.");
            break;
    }

    }
}

public static void cartMenu(Scanner scanner,Cart cart) {
    while (true) {
    	System.out.println(
    		    "Options:\n" +
    		    "--------------------------------\n" +
    		    "1. Filter medias in cart\n" +
    		    "2. Sort medias in cart\n" +
    		    "3. Remove media from cart\n" +
    		    "4. Play a media\n" +
    		    "5. Place order\n" +
    		    "0. Back\n" +
    		    "--------------------------------\n" +
    		    "Please choose a number: 0-1-2-3-4-5");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
        case 0:
            return;

        case 1:
            System.out.println(
                "1. Filter by id\n" +
                "2. Filter by title\n" +
                "----------------\n" +
                "your option:");
            int option2 = scanner.nextInt();
            scanner.nextLine();
            if (option2 == 1) {
                int id = scanner.nextInt();
                cart.searchById(id);
            } else {
                String title = scanner.nextLine();
                cart.searchByTitle(title);
            }
            break;

        case 2:
            System.out.println(
                "1. sort by title cost\n" +
                "2. sort by cost title\n" +
                "----------------\n" +
                "your option:");
            int option2Sort = scanner.nextInt();
            scanner.nextLine();
            if (option2Sort == 1) {
                cart.sortByTitleCost();
                cart.print();
            } else {
                cart.sortByCostTitle();
                cart.print();
            }
            break;

        case 3:
            System.out.print("Enter media's title: ");
            String titleRemove = scanner.nextLine();
            Media itemRemove = cart.findMedia(titleRemove);
            if (itemRemove == null) {
                System.out.println("There is no such media!");
            } else {
                cart.removeMedia(itemRemove);
            }
            break;

        case 4:
            System.out.print("Enter media's title: ");
            String titlePlay = scanner.nextLine();
            Media itemPlay = cart.findMedia(titlePlay);
            if (itemPlay == null) {
                System.out.println("There is no such media!");
            } else {
                if (itemPlay.getClass().getSimpleName().equals("Book")) {
                    System.out.println("This media is unplayable");
                } else {
                    if (itemPlay instanceof DigitalVideoDisc) {
                        DigitalVideoDisc dvd = (DigitalVideoDisc) itemPlay;
                        dvd.play();
                    }
                    if (itemPlay instanceof CompactDisc) {
                        CompactDisc cd = (CompactDisc) itemPlay;
                        cd.play();
                    }
                }
            }
            break;

        case 5:
            System.out.println("Your cart has been paid\nThanks for using our service");
            cart.emptyCart();
            break;

        default:
            System.out.println("Invalid option. Please try again.");
            break;
    }

    }
    }
}
