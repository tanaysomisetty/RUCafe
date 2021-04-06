package cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 *The "control" class that implements functionalities for the main menu GUI.
 * @author Sailokesh Mondi, Tanay Somisetty
 */

public class MainMenuController {

    @FXML
    private GridPane mainMenuGrid;

    private static Order currOrder = new Order();

    private static StoreOrders storeOrder = new StoreOrders();

    /**
     * Accessory method to get the current order
     * @return currOrder Object
     */
    public static Order getOrder() {
        return currOrder;
    }

    /**
     * Accessory method to set the current order
     * @param order Object
     */
    public static void setOrder(Order order) {
        currOrder = order;
    }

    /**
     * Accessory method to get the total store orders.
     * @return store order Object
     */
    public static StoreOrders getStoreOrders() {
        return storeOrder;
    }

    /**
     * Method to go to the ordering donuts GUI from the main menu GUI
     */
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

    /**
     * Method to go to the ordering coffee GUI from the main menu GUI
     */
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

    /**
     * Method to go to the current order GUI from the main menu GUI
     */
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

    /**
     * Method to go to the store orders GUI from the main menu GUI
     */
    public void goToStoreOrders() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            mainMenuGrid.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }
}
