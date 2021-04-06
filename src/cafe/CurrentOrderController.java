package cafe;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

/**
 * The "control" class that implements functionalities for the current order GUI.
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class CurrentOrderController  {


    @FXML
    private GridPane currentOrderPane;

    @FXML
    private TextField subTotalText;

    @FXML
    private TextField salesTaxText;

    @FXML
    private TextField totalText;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn select;

    @FXML
    private TableColumn itemID;

    @FXML
    private TableColumn itemDetails;

    @FXML
    private TableColumn price;

    @FXML
    private Button btnPlaceOrder;

    final static int SALES_TAX_FACTOR = 100;

    /**
     *Method to initialize all the table columns and create objects pertaining to menuItemID, itemDetails, and price
     */
    @FXML
    public void initialize() {



       itemID.setCellValueFactory(
              new PropertyValueFactory<MenuItem, String>("menuItemID"));

        itemDetails.setCellValueFactory(
                new PropertyValueFactory<MenuItem, String>("itemDetails"));

        price.setCellValueFactory(
            new PropertyValueFactory<MenuItem, String>("price"));

        Order currentOrder =  MainMenuController.getOrder();

        tableView.getItems().setAll(currentOrder.getMenuItemList());



        select.setMinWidth(200);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MenuItem,
                CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<MenuItem, CheckBox> arg0) {
                MenuItem item = arg0.getValue();

                CheckBox checkBox = new CheckBox();

                checkBox.selectedProperty().setValue(item.isRemoved());



                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                        item.setRemoved(new_val);

                    }
                });

                return new SimpleObjectProperty<CheckBox>(checkBox);

            }

        });

        subTotalText.setText(""+currentOrder.getSubtotal());
        salesTaxText.setText(""+Order.SALES_TAX*SALES_TAX_FACTOR);
        totalText.setText(""+currentOrder.calculateTotalAmt());

        if(currentOrder.getMenuItemList().size() == 0) {
            btnPlaceOrder.setDisable(true);
        }else {
            btnPlaceOrder.setDisable(false);
        }



    }

    /**
     * Method to go to the main menu GUI from the current order GUI
     */
    public void goToMainMenu() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("RU Cafe");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
            currentOrderPane.getScene().getWindow().hide();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Method to remove a selection from the item list in the current order GUI
     *Selection is removed when checkbox next to the selection is clicked
     */
    public void removeOrder() {
        Order currentOrder =  MainMenuController.getOrder();
        List<MenuItem> menuItems = currentOrder.getMenuItemList();

        List<MenuItem> removedItems = new ArrayList<>();

        for(MenuItem item: menuItems) {
            if(item.isRemoved()) {
                removedItems.add(item);
            }
        }

        for (MenuItem item: removedItems) {
            currentOrder.remove(item);
        }


        initialize();

    }

    /**
     *Method to place an order from the item list in the current order GUI
     After order is placed, an alert appears indicating it and order is added to the store orders GUI
     */
    public void placeOrder() {
        Order currentOrder =  MainMenuController.getOrder();
        StoreOrders storeOrders =  MainMenuController.getStoreOrders();
        storeOrders.add(currentOrder);
        MainMenuController.setOrder(new Order());
        currentOrder = MainMenuController.getOrder();
        currentOrder.removeAllItems();

        initialize();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(null);
        a.setHeaderText(null);
       a.setContentText("Order has been placed");
       a.showAndWait();
    }


}
