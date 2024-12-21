package hust.soict.ite6.painter;
import java.util.Iterator;


public class PainterController {
	@FXML
    private RadioButton penRadioButton;
    @FXML
    private RadioButton eraserButton;
    @FXML
    private VBox drawingAreaPane;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawAreaMouseDragged(MouseEvent event) {
        if (penRadioButton.isSelected()) {
            Circle circle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(circle);
        } else if (eraserButton.isSelected()) {
            Iterator<Node> iter = drawingAreaPane.getChildren().iterator();
            while (iter.hasNext()) {
                Node c = iter.next();
                if (c instanceof Circle circle) {
                    if (circle.getCenterX() <= event.getX() + 4 && circle.getCenterX() >= event.getX() - 4) {
                        if (circle.getCenterY() <= event.getY() + 4 && circle.getCenterY() >= event.getY() - 4) iter.remove();
                    }
                }
            }
        }
    }
}