package cafe;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *This class implements Customizable and specific data and operations pertaining to an order
 * such as the orderID, number of items, sales tax and subtotal
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class Order implements Customizable {
    private List<MenuItem> menuItemList = new ArrayList<>();
    private int numItems = 0;
    private int orderID;
    private static int nextOrderID = 1;
    private double subtotal = 0;
    final static double SALES_TAX = .06625;

    /**
     *Default constructor that
     */
    public Order() {
        this.orderID = nextOrderID;
        nextOrderID++;
    }

    /**
     *Clone constructor that creates a new order ID
     * @param orderID of value int
     */
    public Order(int orderID) {
        this.orderID = orderID;
    }

    /**
     *Method to check if two order items are equal based on their order IDS
     * @param 'An' Object obj
     * @return true if the two order items are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            if (this.orderID == order.orderID) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     *Method to add instances of order in the currentOrder controller
     * @param 'An' Object obj
     * @return true if the order is added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            item.setItemDetails();
            menuItemList.add(item);
            this.numItems++;
            subtotal = subtotal + item.getPrice();
            return true;
        }
        return false;
    }

    /**
     *Method to remove instances of order in the currentOrder controller
     * @param 'An' Object obj
     * @return true if the order is removed, false otherwise
     */
    public boolean remove(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            for (int i = 0; i <= numItems; i++) {
                MenuItem currItem = (MenuItem) menuItemList.get(i);
                if (item.equals(currItem)) {
                    menuItemList.remove(i);
                    this.numItems--;
                    reCalculateSubTotal();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     *Method to calculate the total price of all items in the order, including the sales tax
     * @return double value that corresponds to the total price of an instance of order
     */
    public double calculateTotalAmt() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble( df.format( this.subtotal + (this.subtotal * SALES_TAX)));
    }


    /**
     *Accessory method to get the subtotal
     * @return a double value that corresponds to the subtotal
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     *Accessory method to get the list of menu items
     * @return a List object
     */
    public List getMenuItemList(){
        return this.menuItemList;
    }

    /**
     *Method to recalculate the subtotal in the
     * @return 'none'
     */
    private void reCalculateSubTotal() {
        subtotal = 0.0;
        for(MenuItem item: menuItemList) {
            subtotal = subtotal + item.getPrice();
        }
    }

    /**
     *Method to remove all the items from the current order list and reset the subtotal
     * This method is called in the currentOrderController when the order is placed
     * @return 'none'
     */
    public void removeAllItems() {
        menuItemList.clear();
        reCalculateSubTotal();
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String output = "";
        for (Object obj : menuItemList) {
            if (obj instanceof Donut) {
                Donut currDonut = (Donut) obj;
                output = output + currDonut.toString() + "\n";
            }
            else if (obj instanceof Coffee) {
                Coffee currCoffee = (Coffee) obj;
                output = output + currCoffee.toString() + "\n";
            }
        }
        return output + "Total Amount: $" + this.calculateTotalAmt() + "\n";
    }
}
