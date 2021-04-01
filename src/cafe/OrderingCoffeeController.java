package cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class OrderingCoffeeController {

    private Coffee coffeeOrder;

    @FXML
    private GridPane coffeeGridPane;

    @FXML
    private ComboBox sizesComboBox;

    @FXML
    private CheckBox cream;

    @FXML
    private CheckBox syrup;

    @FXML
    private CheckBox milk;

    @FXML
    private CheckBox caramel;

    @FXML
    private CheckBox whippedCream;

    @FXML
    private TextField subtotalText;

    @FXML
    public void initialize() {
        sizesComboBox.getItems().addAll("Short", "Tall", "Grande", "Venti");
        coffeeOrder = new Coffee();
        subtotalText.setText(Double.toString(coffeeOrder.getPrice()));
    }

    public void goToMainMenu() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("RU Cafe");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            coffeeGridPane.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }
}
