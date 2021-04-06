package cafe;

import java.util.ArrayList;

/**
 *This class implements Customizable and includes specific data
 * and operations pertaining to all store orders
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class StoreOrders implements Customizable {
    private ArrayList OrderList = new ArrayList();
    private int numOrders = 0;

    /**
     * This method
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            OrderList.add(obj);
            this.numOrders++;
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
        if (obj instanceof Order) {
            Order order = (Order) obj;
            for (int i = 0; i <= numOrders; i++) {
                Order currOrder = (Order) OrderList.get(i);
                if (order.equals(currOrder)) {
                    OrderList.remove(i);
                    this.numOrders--;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void exportOrders() {

    }
}
