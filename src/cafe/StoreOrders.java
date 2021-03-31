package cafe;

import java.util.ArrayList;

public class StoreOrders implements Customizable {
    private ArrayList orderList = new ArrayList();

    public boolean add(Object obj) {
        if (obj instanceof StoreOrders) {
            orderList.add(obj);
            return true;
        }
        return false;
    }


    public boolean remove(Object obj) {
        if (obj instanceof StoreOrders) {
            StoreOrders orders = (StoreOrders) obj;
            int storeOrderIndex =orderList.indexOf(orders);
            if (storeOrderIndex < 0) {
                return false;
            }
            orderList.remove(storeOrderIndex);
            return true;
        }
        return false;
    }
}
