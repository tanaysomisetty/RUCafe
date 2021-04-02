package cafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {
    private String size = "";
    private ArrayList addInsList = new ArrayList();
    private int numAddIns = 0;
    final static double SHORT_PRICE = 1.99;
    final static double TALL_PRICE = 2.49;
    final static double GRANDE_PRICE = 2.99;
    final static double VENTI_PRICE = 3.49;


    public boolean add(Object obj) {
        if (obj instanceof AddIn) {
            addInsList.add(obj);
            numAddIns++;
            return true;
        }
        return false;
    }
    public boolean remove(Object obj) {
        if (obj instanceof AddIn) {
            AddIn addin = (AddIn) obj;
            for (int i = 0; i < numAddIns; i++) {
                AddIn currAddIn = (AddIn) addInsList.get(i);
                if (addin.equals(currAddIn)) {
                    addInsList.remove(i);
                    this.numAddIns--;
                    return true;
                }
            }
            return false;
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

    public String getSize() {
        return this.size;
    }

    @Override
    public double itemPrice() {
        if (this.size.equals("Short")) {
            super.setPrice(SHORT_PRICE + addInsList.size() * .20);
            return super.getPrice();
        }
        else if (this.size.equals("Tall")) {
            super.setPrice(TALL_PRICE + addInsList.size() * .20);
            return super.getPrice();
        }
        else if (this.size.equals("Grande")) {
            super.setPrice(GRANDE_PRICE + addInsList.size() *.20);
            return super.getPrice();
        }
        else if (this.size.equals("Venti")) {
            super.setPrice(VENTI_PRICE + addInsList.size() * .20);
            return super.getPrice();
        }
        else {
            return 0;
        }
    }

    /**
     * Gives a string representation of a Coffee object
     * @param 'none'
     * @return a string in the format
     */
    @Override
    public String toString() {
        return "placeholder";
    }
}
