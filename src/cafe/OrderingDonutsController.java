package cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 *The "control" class that implements functionalities for the ordering donuts GUI,
 * such as selecting a flavor, donut type and quantities and adding to the order
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class OrderingDonutsController {

    private Donut donutOrder;

    @FXML
    private ListView donutTypeList;

    @FXML
    private ComboBox flavorsComboBox;

    @FXML
    private GridPane donutGridPane;

    @FXML
    private TextField subtotalText;

    @FXML
    private TextField countText;

    private int donutCount = 0;

    @FXML
    private TextArea donutTextArea;

    /**
     *Method to initialize the listview, combo box, and subtotal and create the donut object
     *@return 'none'
     */
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
        subtotalText.setText(Double.toString(donutOrder.getPrice()));
    }

    /**
     *Method to go to the main menu GUI from the ordering donuts GUI
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
            donutGridPane.getScene().getWindow().hide();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Method to set the donut type in the GUI according to the three different types
     * @return 'none'
     */
    public void setDonutType() {
        if (donutTypeList.getSelectionModel().getSelectedItem() != null) {
            String type = (String) donutTypeList.getSelectionModel().getSelectedItem();
            if (type.equals("Yeast Donut")) {
                donutOrder.setType("yeast");
            }
            else if (type.equals("Cake Donut")) {
                donutOrder.setType("cake");

            }
            else if (type.equals("Donut Hole")) {
                donutOrder.setType("hole");
            }
            if (donutCount == 0) {
                donutCount++;
                donutOrder.add(donutOrder);
                countText.setText(Integer.toString(donutOrder.getQuantity()));
            }
            subtotalText.setText(Double.toString(donutOrder.itemPrice()));
            donutTextArea.appendText(type + " selected" + "\n");
        }
    }

    /**
     *Method to set the donut flavor in the GUI according to three different flavors
     * @return 'none'
     */
    public void setDonutFlavor() {
        if (flavorsComboBox.getSelectionModel().getSelectedItem() != null) {
            donutOrder.setFlavor((String) flavorsComboBox.getSelectionModel().getSelectedItem());
            donutTextArea.appendText("Flavor set to: " + flavorsComboBox.getSelectionModel().getSelectedItem() + "\n");
        }
    }

    /**
     *Method to change the text in the GUI and call the remove method from the Donut class
     * @return 'none'
     */
    public void minusCount() {
        if (donutCount > 0 && donutTypeList.getSelectionModel().getSelectedItem() != null) {
            donutCount--;
            donutOrder.remove(donutOrder);
            countText.setText(Integer.toString(donutOrder.getQuantity()));
            subtotalText.setText(Double.toString(donutOrder.itemPrice()));
        }
    }

    /**
     *Method to change the text in the GUI and call the add method from the Donut class
     * @return 'none'
     */
    public void plusCount() {
        if (donutTypeList.getSelectionModel().getSelectedItem() != null) {
            donutCount++;
            donutOrder.add(donutOrder);
            countText.setText(Integer.toString(donutOrder.getQuantity()));
            subtotalText.setText(Double.toString(donutOrder.itemPrice()));
        }
    }

    /**
     *Method to reset the fields of the order object and add the donut to the order object
     * @return 'none'
     */
    public void addToOrder() {
        if (donutTypeList.getSelectionModel().getSelectedItem() != null &&
                flavorsComboBox.getSelectionModel().getSelectedItem() != null) {
            if (donutCount == 0) {
                donutTextArea.appendText("Please select a quantity greater than zero" + "\n");
            }
            else {
                Order currOrder = MainMenuController.getOrder();
                currOrder.add(donutOrder);
                donutTextArea.appendText("Order placed for " + donutOrder.toString() + "\n");
                donutTypeList.getSelectionModel().clearSelection();
                flavorsComboBox.getSelectionModel().clearSelection();
                donutOrder = new Donut();
                donutCount = 0;
                countText.setText(Integer.toString(donutOrder.getQuantity()));
                subtotalText.setText(Double.toString(donutOrder.itemPrice()));
            }
        }
        else {
            donutTextArea.appendText("Please select a donut type and flavor" + "\n");
        }
    }

}
