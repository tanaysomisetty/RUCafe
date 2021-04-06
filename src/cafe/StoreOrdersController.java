package cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 * The "control" class that implements functionalities for the store order GUI,
 * such as displaying the details of each order and the total amount of each
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class StoreOrdersController {

    @FXML
    private GridPane storeOrdersPane;


    /*

     - Comment blocks for each method and at the top of each file
     - Java doc

       StoreOrder.fxml:
     - Checkboxes in the select column and when you click "Cancel Order" button, you call remove method from
       StoreOrders.java
     - Order ID and Total Amount Column
     - When you click a button in view details column, call the toString method from Order.java and set the text
       of the TextArea to that string

     - Make sure to delete all unused methods, instance variables, and import statements
     - Test a view times to see if its working.
     - Make sure all numbers are two decimals places
     */


    /**
     * Method to go to the main menu GUI from the store orders GUI
     * @return 'none'
     */
    public void goToMainMenu() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("RU Cafe");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            storeOrdersPane.getScene().getWindow().hide();
        }
        catch (Exception e) {
        }
    }

    public void export() {
        MainMenuController.getStoreOrders().exportOrders();
    }
}
