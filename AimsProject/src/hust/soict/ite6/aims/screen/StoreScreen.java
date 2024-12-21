package hust.soict.ite6.aims.screen;

import javax.swing.*;
import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.*;
import hust.soict.ite6.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StoreScreen extends JFrame {
 private Store store;
 private Container cp;
 private Cart cart;
 JPanel createNorth() {
     JPanel north = new JPanel();
     north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
     north.add(createMenuBar());
     north.add(createHeader());
     return north;
 }

 JMenuBar createMenuBar() {
     JMenu menu = new JMenu("Options");
     JMenu smUpdateStore = new JMenu("Update Store");

     JMenuItem addBook = new JMenuItem("Add Book");
     smUpdateStore.add(addBook);
     addBook.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             AddBookStoreScreen popUp = new AddBookStoreScreen(store);
         }
     });

     JMenuItem addCD = new JMenuItem("Add CD");
     smUpdateStore.add(addCD);
     addCD.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             AddCDStoreScreen popUp = new AddCDStoreScreen(store);
         }
     });

     JMenuItem addDVD = new JMenuItem("Add DVD");
     smUpdateStore.add(addDVD);
     addDVD.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             AddDVDStoreScreen popUp = new AddDVDStoreScreen(store);
         }
     });
     
     menu.add(smUpdateStore);
     menu.add(new JMenuItem("View store"));
     menu.add(new JMenuItem("View cart"));

     JMenuBar menuBar = new JMenuBar();
     menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
     menuBar.add(menu);
     return menuBar;
 }

 JPanel createHeader() {
     JPanel header = new JPanel();
     header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

     JLabel title = new JLabel("AIMS");
     title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
     title.setForeground(Color.CYAN);

     JButton cart1 = new JButton("View cart");
     cart1.setPreferredSize(new Dimension(100,50));
     cart1.setMaximumSize(new Dimension(100,50));
     cart1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             Container cp = getContentPane();
             cp.add(new CartScreen(cart));
         }
     });
     header.add(Box.createRigidArea(new Dimension(10,10)));
     header.add(title);
     header.add(Box.createHorizontalGlue());
     header.add(cart1);
     header.add(Box.createRigidArea(new Dimension(10,10)));
     return header;
 }

 JPanel createCenter() {
     JPanel center = new JPanel();
     center.setLayout(new GridLayout(3,3,2,2));
     ArrayList<Media> mediaStore = store.getItemsInStore();
     for(Media media : mediaStore) {
         MediaStore cell = new MediaStore(media,cart);
         center.add(cell);
     }
     return center;
 }

 public StoreScreen(Store store, Cart myCart) {
     this.store  = store;
     this.cart = myCart;
     cp = getContentPane();
     cp.setLayout(new BorderLayout());
     cp.add(createNorth(),BorderLayout.NORTH);
     cp.add(createCenter(),BorderLayout.CENTER);
     setVisible(true);
     setTitle("Store");
     setSize(1024,768);
 }

 public static void main(String[] args) {
     DigitalVideoDisc dvd = new DigitalVideoDisc("Avatar", "Science fiction",
             13.5f, 197, "James Cameron");
     DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "Animation",
             23.5f, 117, "Jon Favreau , Jeff Nathanson");

     ArrayList<Track> tracks = new ArrayList<Track>();
     tracks.add(new Track("Eternal Sunshine",3));
     tracks.add(new Track("End of the world",4));
     CompactDisc cd = new CompactDisc("Eternal Sunshine", "Pop", 20.5f, "Ariana Grande", tracks);

     ArrayList<Track> tracks2 = new ArrayList<Track>();
     tracks2.add(new Track("SOS", 3));
     tracks2.add(new Track("Kill Bill", 4));
     tracks2.add(new Track("Special", 2));
     tracks2.add(new Track("Good days", 4));
     tracks2.add(new Track("Low", 3));
     tracks2.add(new Track("F2F", 4));
     tracks2.add(new Track("Love Language", 4));
     tracks2.add(new Track("Snooze",4));
     tracks2.add(new Track("Gone Girl",4));
     tracks2.add(new Track("Far", 3));
     tracks2.add(new Track("Shirt", 5));
     CompactDisc cd2 = new CompactDisc("SOS", "RnB", 37.25f, "Sza", tracks2);

     List<String> authors = new ArrayList<String>();
     authors.add("Dale Carnegie");
     Book book1   = new Book("Dac nhan tam", "Self-help", 25.2f, authors);
     List<String> authors2 = new ArrayList<String>();
     authors2.add("Victor Hugo");
     Book book2   = new Book("Nhung nguoi khon kho", "Tieu thuyet", 27.45f, authors2);
     Store store = new Store();

     store.addMedia(cd);
     store.addMedia(cd2);
     store.addMedia(dvd);
     store.addMedia(dvd2);
     store.addMedia(book1);
     store.addMedia(book2);

     Book[] books = new Book[15];
     Cart myCart = new Cart();
     new StoreScreen(store, myCart);
 }

 private class AddDVDStoreScreen extends JFrame {
     public AddDVDStoreScreen(Store store) {
         this.setLayout(new GridLayout(6, 2, 5, 5));
         this.add(new JLabel("Enter title: "));
         TextField title = new TextField(10);
         this.add(title);
         this.add(new JLabel("Enter category: "));
         TextField category = new TextField(10);
         this.add(category);
         this.add(new JLabel("Enter cost: "));
         TextField cost = new TextField(10);
         this.add(cost);
         this.add(new JLabel("Enter length: "));
         TextField length = new TextField(10);
         this.add(length);
         this.add(new JLabel("Enter director: "));
         TextField director = new TextField(10);
         this.add(director);

         this.setTitle("Add DVD");
         this.setSize(300, 100);
         JButton turnInBtn = new JButton("Add");
         this.add(turnInBtn);
         turnInBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), Float.parseFloat(cost.getText()), Integer.parseInt(length.getText()), director.getText() );
                 store.addMedia(dvd);
                 updateCenter();
                 title.setText("");
                 category.setText("");
                 cost.setText("");
                 length.setText("");
                 director.setText("");
             }
         });
         this.setVisible(true);
     }
 }

 private class AddCDStoreScreen extends JFrame {
     private ArrayList<Track> tracks = new ArrayList<>(); 

     public AddCDStoreScreen(Store store) {
         this.setLayout(new GridLayout(0, 2, 5, 5)); // Sử dụng GridLayout linh hoạt

         this.add(new JLabel("Enter title: "));
         TextField title = new TextField(10);
         this.add(title);
         this.add(new JLabel("Enter category: "));
         TextField category = new TextField(10);
         this.add(category);
         this.add(new JLabel("Enter cost: "));
         TextField cost = new TextField(10);
         this.add(cost);
         this.add(new JLabel("Enter artist: "));
         TextField artist = new TextField(10);
         this.add(artist);

         JLabel trackTitleLabel = new JLabel("Enter track title: ");
         this.add(trackTitleLabel);
         TextField trackTitle = new TextField(10);
         this.add(trackTitle);

         JLabel trackLengthLabel = new JLabel("Enter track length (minutes): ");
         this.add(trackLengthLabel);
         TextField trackLength = new TextField(10);
         this.add(trackLength);

         JButton addTrackButton = new JButton("Add Track");
         this.add(addTrackButton);
         JLabel trackStatus = new JLabel("No track added yet.");
         this.add(trackStatus);

         // Nút thêm track
         addTrackButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     String tTitle = trackTitle.getText();
                     int tLength = Integer.parseInt(trackLength.getText());
                     if (!tTitle.isEmpty() && tLength > 0) {
                         tracks.add(new Track(tTitle, tLength));
                         trackStatus.setText("Track added: " + tTitle + " (" + tLength + " mins)");
                         trackTitle.setText("");
                         trackLength.setText("");
                     } else {
                         JOptionPane.showMessageDialog(null, "Invalid track details. Try again.");
                     }
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(null, "Track length must be a number.");
                 }
             }
         });

         // Nút xác nhận thêm CD
         JButton turnInBtn = new JButton("Add CD");
         this.add(turnInBtn);
         turnInBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     String cdTitle = title.getText();
                     String cdCategory = category.getText();
                     float cdCost = Float.parseFloat(cost.getText());
                     String cdArtist = artist.getText();

                     // Kiểm tra điều kiện đầu vào
                     if (cdTitle.isEmpty() || cdCategory.isEmpty() || cdArtist.isEmpty() || tracks.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "All fields and at least one track are required.");
                         return;
                     }

                     CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdCost, cdArtist, tracks);
                     store.addMedia(cd);
                     updateCenter(); 
                     title.setText("");
                     category.setText("");
                     cost.setText("");
                     artist.setText("");
                     tracks.clear();
                     trackStatus.setText("No track added yet.");
                     JOptionPane.showMessageDialog(null, "CD added successfully!");
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(null, "Invalid cost input. Please enter a valid number.");
                 }
             }
         });

         this.setTitle("Add CD");
         this.setSize(400, 300);
         this.setVisible(true);
     }
 }

 private class AddBookStoreScreen extends JFrame {
     public AddBookStoreScreen(Store store) {
         this.setLayout(new GridLayout(5, 2, 5, 5));

         // Title
         this.add(new JLabel("Enter title: "));
         TextField title = new TextField(10);
         this.add(title);

         // Category
         this.add(new JLabel("Enter category: "));
         TextField category = new TextField(10);
         this.add(category);

         // Cost
         this.add(new JLabel("Enter cost: "));
         TextField cost = new TextField(10);
         this.add(cost);

         // Authors (comma-separated)
         this.add(new JLabel("Enter authors (comma-separated): "));
         TextField authorsField = new TextField(20);
         this.add(authorsField);

         // Button "Add"
         JButton addButton = new JButton("Add");
         this.add(addButton);
         this.setTitle("Add Book");
         this.pack();
         this.setVisible(true);

         addButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     // Parse authors
                     String[] authorsArray = authorsField.getText().split(",");
                     List<String> authors = new ArrayList<>();
                     for (String author : authorsArray) {
                         authors.add(author.trim());
                     }

                     // Create and add book
                     Book book = new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText()), authors);
                     store.addMedia(book);

                     // Update center panel
                     updateCenter();

                     // Clear input fields
                     title.setText("");
                     category.setText("");
                     cost.setText("");
                     authorsField.setText("");

                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(null, "Invalid input for cost. Please enter a number.");
                 }
             }
         });

     }
 }
 public void updateCenter() {
     cp.remove(1); // Xóa panel cũ ở vị trí CENTER (index 1)
     cp.add(createCenter(), BorderLayout.CENTER); // Thêm panel mới
     cp.revalidate(); // Cập nhật lại layout
     cp.repaint(); // Vẽ lại giao diện
 }

}
