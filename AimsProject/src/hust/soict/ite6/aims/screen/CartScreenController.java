package hust.soict.ite6.aims.screen;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;


public class CartScreenController {
    private Cart cart;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media,Float> colMediaCost;
    @FXML
    private Label totalPrice;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Thiết lập các cột trong TableView
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(FXCollections.observableList(this.cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart")); // Hiển thị khi không có item

        // Ẩn các nút ban đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Sự kiện Remove
        btnRemove.setOnAction(event -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media != null) {
                cart.removeMedia(media);
                totalPrice.setText(Float.toString(cart.totalCost()) + "$");
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            }
        });

        // Lắng nghe sự thay đổi trong ô tìm kiếm
        tfFilter.textProperty().addListener((observableValue, oldValue, newValue) -> showFilterMedia(newValue));

        // Lắng nghe sự thay đổi trong selection của TableView
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observableValue, oldItem, newItem) -> updateButtonBar(newItem));

        // Cập nhật tổng tiền ban đầu
        totalPrice.setText(Float.toString(cart.totalCost()) + "$");

        // Xử lý sự kiện khi nhấn nút Play
        btnPlay.setOnAction(event -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media != null) {
                JDialog playDialog = MediaStore.createPlayDialog(media);
                playDialog.setVisible(true);
                playDialog.setSize(300, 200);
                playDialog.pack();
            }
        });

        // Xử lý sự kiện khi nhấn nút Place Order
        btnPlaceOrder.setOnAction(event -> {
            createPopUp();
            cart.getItemsOrdered().clear();
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            totalPrice.setText(Float.toString(cart.totalCost()) + "$");
        });
    }

    @FXML
    void showFilterMedia(String t1) {
        ArrayList<Media> filteredList = new ArrayList<>();
        if (filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
            for (Media item : cart.getItemsOrdered()) {
                if (item.getTitle().toLowerCase().contains(t1.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        } else if (filterCategory.getSelectedToggle() == radioBtnFilterId) {
            try {
                int id = Integer.parseInt(t1);
                for (Media item : cart.getItemsOrdered()) {
                    if (item.getId() == id) {
                        filteredList.add(item);
                    }
                }
            } catch (NumberFormatException e) {
                // Nếu nhập không phải là số, có thể thông báo lỗi hoặc không làm gì
            }
        }
        tblMedia.setItems(FXCollections.observableList(filteredList));
    }
    @FXML
    void createPopUp() {
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Place order");

        Label label1 = new Label("You have placed your order!");
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label label2 = new Label("Your bill total is " + Float.toString(cart.totalCost()) + "$");
        Button button1 = new Button("OK!");
        label2.setTextFill(Color.RED);

        button1.setOnAction(e -> popupwindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, label2, button1);
        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 300, 200);
        popupwindow.setScene(scene1);
        popupwindow.show();
    }
    @FXML
    void updateButtonBar(Media media) {
        // Kiểm tra nếu có media được chọn
        if (media != null) {
            btnRemove.setVisible(true); // Hiển thị nút Remove khi có media
            if (media instanceof Playable) {
                btnPlay.setVisible(true); // Hiển thị nút Play nếu media có thể phát
            } else {
                btnPlay.setVisible(false); // Ẩn nút Play nếu media không thể phát
            }
        } else {
            // Nếu không có media được chọn, ẩn cả hai nút
            btnRemove.setVisible(false);
            btnPlay.setVisible(false);
        }
    }

}