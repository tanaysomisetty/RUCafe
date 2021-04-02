package cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


public class OrderingDonutsController {

    private Donut donutOrder;

    @FXML
    private ListView donutTypeList;

    @FXML
    private ComboBox flavorsComboBox;

    @FXML
    private GridPane donutGridPane;

    @FXML
    public void initialize() {
        donutTypeList.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");

        String[] flavors = Donut.getDonutFlavors();
        int PLAIN_FLAVOR_INDEX = 0;
        int CHOCOLATE_FLAVOR_INDEX = 1;
        int STRAWBERRY_FLAVOR_INDEX = 2;
        flavorsComboBox.getItems().addAll(flavors[PLAIN_FLAVOR_INDEX],
                flavors[CHOCOLATE_FLAVOR_INDEX], flavors[STRAWBERRY_FLAVOR_INDEX]);

        donutOrder = new Donut();
    }

    public void goToMainMenu() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("RU Cafe");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            donutGridPane.getScene().getWindow().hide();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
