package cafe;

public class Donut extends MenuItem implements Customizable{
    private String type;
    private String flavor;
    private int quantity;
    final static double YEAST_PRICE = 1.39;
    final static double CAKE_PRICE = 1.59;
    final static double HOLE_PRICE = 0.33;

    /**
     Constructor for the Donut class that defines all attributes of the donut
     @param type of donut
     @param flavor of donut
     */
    public Donut(String type, String flavor) {
        this.type = type;
        this.flavor = flavor;
        this.quantity = 1;
    }

    /**
     *
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        if (obj instanceof Donut) {
            this.quantity++;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to remove a donut object
     * @param  obj donut
     * @return true if the donut is able to be removed, false otherwise
     */
    public boolean remove(Object obj) {
        if(obj instanceof Donut) {
            this.quantity--;
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Calculates the total price of a donut depending on Donut Type
     * @param 'none'
     * @return price of the donut
     */
    @Override
    public double itemPrice() {
        if (this.type.equals("yeast")) {
            super.setPrice(YEAST_PRICE * this.quantity);
            return super.getPrice();
        }
        else if (this.type.equals("cake")) {
            super.setPrice(CAKE_PRICE * this.quantity);
            return super.getPrice();
        }
        else if(this.type.equals("hole")) {
            super.setPrice(HOLE_PRICE* this.quantity);
            return super.getPrice();
        }
        else {
            return 0;
        }
    }

    /**
     * Gives a string representation of a Donut object
     * @param 'none'
     * @return a string in the format "Donut Type,Flavor,Quantity"
     */
    @Override
    public String toString() {
        String donutType = this.type.substring(0, 1).toUpperCase() + this.type.substring(1);
        String donutFlavor = this.flavor.substring(0, 1).toUpperCase() + this.flavor.substring(1);

        return donutType + " Donut," + donutFlavor + ",Quantity: " + this.quantity;
    }
}
