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
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

/**
 *The "control" class that implements functionalities for the ordering coffee GUI,
 * such as selecting the size, adding add-ins, and adding to the order
 * @author Sailokesh Mondi, Tanay Somisetty
 */
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
    private TextArea coffeeTextArea;
    /**
     *
     */
    @FXML
    public void initialize() {
        sizesComboBox.getItems().addAll("Short", "Tall", "Grande", "Venti");
        coffeeOrder = new Coffee();
        subtotalText.setText(Double.toString(coffeeOrder.getPrice()));
    }

    /**
     *Method to go to the main menu GUI from the ordering coffee GUI.
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
            coffeeGridPane.getScene().getWindow().hide();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Method to set the coffee size of the coffee order. When the user
     * selects a size, the size is displayed and appended to the text area.
     * @return 'none'
     */
    public void setCoffeeSize() {

        if (sizesComboBox.getSelectionModel().getSelectedItem() != null) {
            coffeeOrder.setSize((String) sizesComboBox.getSelectionModel().getSelectedItem());
            coffeeTextArea.appendText("Coffee size set to: " + coffeeOrder.getSize() + "\n");
        }
        coffeeOrder.itemPrice();
        subtotalText.setText(Double.toString(coffeeOrder.getPrice()));
    }

    /**
     *Method to
     * @param event
     */
    @FXML
    public void addInSelect(ActionEvent event) {
        if (event.getSource() instanceof CheckBox) {
            CheckBox chk = (CheckBox) event.getSource();
            if (chk.isSelected() && sizesComboBox.getSelectionModel().getSelectedItem() == null) {
                coffeeTextArea.appendText("You must first select a size" + "\n");
                chk.setSelected(false);
            }
            else if (sizesComboBox.getSelectionModel().getSelectedItem() != null){
                if (chk.getText().equals("Cream")) {
                    if (chk.isSelected()) {
                        AddIn cream = new AddIn("cream");
                        coffeeOrder.add(cream);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Cream added" + "\n");
                    }
                    else {
                        AddIn cream = new AddIn("cream");
                        coffeeOrder.remove(cream);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Cream removed" + "\n");
                    }
                }
                else if (chk.getText().equals("Syrup")) {
                    if (chk.isSelected()) {
                        AddIn syrup = new AddIn("syrup");
                        coffeeOrder.add(syrup);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Syrup added" + "\n");
                    }
                    else {
                        AddIn syrup = new AddIn("syrup");
                        coffeeOrder.remove(syrup);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Syrup removed" + "\n");
                    }
                }
                else if (chk.getText().equals("Milk")) {
                    if (chk.isSelected()) {
                        AddIn milk = new AddIn("milk");
                        coffeeOrder.add(milk);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Milk added" + "\n");
                    }
                    else {
                        AddIn milk = new AddIn("milk");
                        coffeeOrder.remove(milk);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Milk removed" + "\n");
                    }
                }
                else if (chk.getText().equals("Caramel")) {
                    if (chk.isSelected()) {
                        AddIn caramel = new AddIn("caramel");
                        coffeeOrder.add(caramel);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Caramel added" + "\n");
                    }
                    else {
                        AddIn caramel = new AddIn("caramel");
                        coffeeOrder.remove(caramel);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Caramel removed" + "\n");
                    }
                }
                else if (chk.getText().equals("Whipped Cream")) {
                    if (chk.isSelected()) {
                        AddIn whippedCream = new AddIn("whippedCream");
                        coffeeOrder.add(whippedCream);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Whipped Cream added" + "\n");
                    }
                    else {
                        AddIn whippedCream = new AddIn("whippedCream");
                        coffeeOrder.remove(whippedCream);
                        subtotalText.setText(Double.toString(coffeeOrder.itemPrice()));
                        coffeeTextArea.appendText("Whipped Cream removed" + "\n");
                    }
                }
            }
        }
    }

    /**
     *Method to add an instance of coffee order to the overall
     * @return 'none'
     */
    public void addToOrder() {
        if (coffeeOrder.getSize().equals("")) {
            coffeeTextArea.appendText("You must first select a size" + "\n");
        }
        else {
            Order currOrder = MainMenuController.getOrder();
            currOrder.add(coffeeOrder);
            coffeeTextArea.appendText("Order placed for " + coffeeOrder.toString() + "\n");
            sizesComboBox.getSelectionModel().clearSelection();
            cream.setSelected(false);
            syrup.setSelected(false);
            milk.setSelected(false);
            caramel.setSelected(false);
            whippedCream.setSelected(false);
            coffeeOrder = new Coffee();
            subtotalText.setText(Double.toString(coffeeOrder.getPrice()));
        }
    }
}
