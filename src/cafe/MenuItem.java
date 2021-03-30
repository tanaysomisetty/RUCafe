package cafe;

public class MenuItem {
    private double price;

    public MenuItem() {

    }

    /**
     Getter method to get the price
     @param 'none'
     @return double value price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     Setter method to set the price
     @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public double itemPrice() {
        return 0;
    }
}
