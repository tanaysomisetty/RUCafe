package cafe;

import java.util.ArrayList;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);

        if (this.size == null) {
            return 0;
        }
        else if (this.size.equals("Short")) {
            super.setPrice(SHORT_PRICE + addInsList.size() * .20);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else if (this.size.equals("Tall")) {
            super.setPrice(TALL_PRICE + addInsList.size() * .20);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else if (this.size.equals("Grande")) {
            super.setPrice(GRANDE_PRICE + addInsList.size() *.20);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else if (this.size.equals("Venti")) {
            super.setPrice(VENTI_PRICE + addInsList.size() * .20);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else {
            return 0.00;
        }
    }

    /**
     * Gives a string representation of a Coffee object
     * @param 'none'
     * @return a string in the format "Coffee,Size,Addin #1,Addin #2,etc"
     */
    @Override
    public String toString() {
        String addins = "";

        for (int i = 0; i < numAddIns; i++) {
            String currAddIn = addInsList.get(i).toString();
            addins = addins + "," + currAddIn;
        }

        return "Coffee," + this.size + addins;
    }
}
