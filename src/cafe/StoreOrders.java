package cafe;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *This class implements Customizable and includes specific data
 * and operations pertaining to all store orders
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class StoreOrders implements Customizable {
    private List<Order> orderList = new ArrayList();
    private int numOrders = 0;

    /**
     * This method adds an order object to the list of store orders
     * @param 'an' Object obj
     * @return
     */
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            orderList.add((Order)obj);
            this.numOrders++;
            return true;
        }
        return false;
    }

    /**
     *This method removes an order object from the list of store orders
     * @param 'an' Object obj
     * @return
     */
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            for (int i = 0; i <= numOrders; i++) {
                Order currOrder = (Order) orderList.get(i);
                if (order.equals(currOrder)) {
                    orderList.remove(i);
                    this.numOrders--;
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
    @Override
    public String toString() {
        String output = "";
        for (Object obj : orderList) {
            if (obj instanceof Order) {
                Order currOrder = (Order) obj;
                output = output + currOrder.toString();
                output = output + "====================" + "\n";
            }
        }
        return output;
    }

    /**
     *
     * @return
     */
    public File exportOrders() {
        if (orderList.size() == 0) {
            return null;
        }

        File file = new File("Store Orders.txt");
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(this.toString());
            pw.close();
        }
        catch (FileNotFoundException e) {
            return null;
        }
        return file;
    }

    public List<Order> getOrderList(){
        return orderList;
    }
}
