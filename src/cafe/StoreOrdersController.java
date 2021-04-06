package cafe;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;


/**
 * The "control" class that implements functionalities for the store order GUI,
 * such as displaying the details of each order and the total amount of each
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class StoreOrdersController {

    @FXML
    private GridPane storeOrdersPane;


    @FXML
    private TableColumn select;

    @FXML
    private TableColumn orderID;

    @FXML
    private TableColumn totalAmount;

    @FXML
    private TableColumn viewDetails;

    @FXML
    private TableView tableView;

    @FXML
    private TextArea textArea;



    /**
     *Method to initialize all the table columns and create objects pertaining to
     * menuItemID, itemDetails and price
     * @return 'none'
     */
    @FXML
    public void initialize() {

        orderID.setCellValueFactory(
                new PropertyValueFactory<Order, String>("orderID"));

        totalAmount.setCellValueFactory(
                new PropertyValueFactory<Order, String>("total"));

        viewDetails.setCellValueFactory(
                new PropertyValueFactory<Order, String>("details"));


        StoreOrders storeOrders =  MainMenuController.getStoreOrders();

        tableView.getItems().setAll(storeOrders.getOrderList());



        select.setMinWidth(20);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<Order, CheckBox> arg0) {
                Order order = arg0.getValue();

                CheckBox checkBox = new CheckBox();

                checkBox.selectedProperty().setValue(order.isRemoved());



                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                       order.setRemoved(new_val);

                    }
                });

                return new SimpleObjectProperty<CheckBox>(checkBox);

            }

        });




    }

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

    public void cancelOrder() {
        StoreOrders storeOrders =  MainMenuController.getStoreOrders();
        List<Order> orders = storeOrders.getOrderList();

        List<Order> removedOrders = new ArrayList<>();

        for(Order order: orders) {
            if(order.isRemoved()) {
                removedOrders.add(order);
            }
        }

        for (Order order: removedOrders) {
            storeOrders.remove(order);
        }

        initialize();
        textArea.clear();

    }

    public void export() {
        MainMenuController.getStoreOrders().exportOrders();
    }

    public void itemClicked() {
        Order order = (Order)tableView.getSelectionModel().getSelectedItem();
        textArea.setText(order.toString());
    }
}
