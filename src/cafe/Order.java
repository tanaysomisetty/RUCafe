package cafe;

import java.util.ArrayList;

public class Order implements Customizable {
    private ArrayList MenuItemList = new ArrayList();
    private int numItems = 0;
    private int orderID;
    private static int nextOrderID = 1;
    private double subtotal = 0;
    final static double SALES_TAX = .06625;

    public Order() {
        this.orderID = nextOrderID;
        nextOrderID++;
    }

    public Order(int orderID) {
        this.orderID = orderID;
    }

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

    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            MenuItemList.add(item);
            this.numItems++;
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            for (int i = 0; i <= numItems; i++) {
                MenuItem currItem = (MenuItem) MenuItemList.get(i);
                if (item.equals(currItem)) {
                    MenuItemList.remove(i);
                    this.numItems--;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public double calculateTotalAmt() {
        return this.subtotal + (this.subtotal * SALES_TAX);
    }

    @Override
    public String toString() {  //format: "Coffee,3 Cream,2 Caramel,Size,
        return "placeholder";
    }
}
