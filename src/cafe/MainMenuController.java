package cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class MainMenuController {

    @FXML
    private GridPane mainMenuGrid;


    public void goToOrderingDonuts() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderingDonuts.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ordering Donuts");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            mainMenuGrid.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }

    public void goToOrderingCoffee() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderingCoffee.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ordering Coffee");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            mainMenuGrid.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }

    public void goToCurrentOrder() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrder.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            mainMenuGrid.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }

    public void goToStoreOrders() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Order");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            mainMenuGrid.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }
}
