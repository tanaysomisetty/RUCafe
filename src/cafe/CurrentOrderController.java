package cafe;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;


public class CurrentOrderController  {

    private Order currentOrder;

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
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MenuItem, CheckBox>, ObservableValue<CheckBox>>() {

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
        salesTaxText.setText(""+Order.SALES_TAX);
        totalText.setText(""+currentOrder.calculateTotalAmt());



    }

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

    public void placeOrder() {

    }


}
