package hust.soict.ite6.aims.screen;
import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.*;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
 private Cart cart;

 public CartScreen(Cart cart) {
     super();
     this.cart = cart;
     JFXPanel fxPanel = new JFXPanel();
     this.add(fxPanel);
     this.setTitle("Cart");
     this.setVisible(true);
     setSize(1100,768);
     Platform.runLater(new Runnable() {
         @Override
         public void run() {
             try {
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/ite6/aims/screen/cart.fxml"));
                 CartScreenController controller = new CartScreenController(cart);
                 loader.setController(controller);
                 Parent root = loader.load();
                 fxPanel.setScene(new Scene(root));
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     });
 }

}