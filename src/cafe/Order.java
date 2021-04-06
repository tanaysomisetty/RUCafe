package cafe;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Order implements Customizable {
    private List<MenuItem> menuItemList = new ArrayList<>();
    private int numItems = 0;
    private int orderID;
    private static int nextOrderID = 1;
    private double subtotal = 0;
    final static double SALES_TAX = .06625;

    /**
     *
     */
    public Order() {
        this.orderID = nextOrderID;
        nextOrderID++;
    }

    /**
     *
     * @param orderID
     */
    public Order(int orderID) {
        this.orderID = orderID;
    }

    /**
     *
     * @param obj
     * @return
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
     *
     * @param obj
     * @return
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
     *
     * @param obj
     * @return
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
     *
     * @return
     */
    public double calculateTotalAmt() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble( df.format( this.subtotal + (this.subtotal * SALES_TAX)));
    }


    /**
     *
     * @return
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     *
     * @return
     */
    public List getMenuItemList(){
        return this.menuItemList;
    }

    /**
     *
     */
    private void reCalculateSubTotal() {
        subtotal = 0.0;
        for(MenuItem item: menuItemList) {
            subtotal = subtotal + item.getPrice();
        }
    }

    /**
     *
     */
    public void removeAllItems() {
        menuItemList.clear();
        reCalculateSubTotal();
    }

    @Override
    public String toString() {  //format: "Coffee,3 Cream,2 Caramel,Size,
        return "placeholder";
    }
}
