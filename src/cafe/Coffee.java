package cafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {
    private String size;
    private ArrayList addInsList = new ArrayList();
    final static double SHORT_PRICE = 1.99;
    final static double TALL_PRICE = 2.49;
    final static double GRANDE_PRICE = 2.99;
    final static double VENTI_PRICE = 3.49;


    public boolean add(Object obj) {
        if (obj instanceof AddIn) {
            addInsList.add(obj);
            return true;
        }
        return false;
    }
    public boolean remove(Object obj) {
        if(obj instanceof AddIn) {
            AddIn addin = (AddIn) obj;
            int addInIndex = addInsList.indexOf(addin);
            if (addInIndex < 0) {
                return false;
            }
            addInsList.remove(addInIndex);
            return true;
        }
        return false;
    }

    /**
     * Setter method to set the size
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double itemPrice() {
        if (this.size.equals("short")) {
            super.setPrice(SHORT_PRICE + addInsList.size() * .20);
            return super.getPrice();
        }
        else if (this.size.equals("tall")) {
            super.setPrice(TALL_PRICE + addInsList.size() * .20);
            return super.getPrice();
        }
        else if (this.size.equals("grande")) {
            super.setPrice(GRANDE_PRICE + addInsList.size() *.20);
            return super.getPrice();
        }
        else if (this.size.equals("venti")) {
            super.setPrice(VENTI_PRICE + addInsList.size() * .20);
            return super.getPrice();
        }
        else {
            return 0;
        }
    }
}
