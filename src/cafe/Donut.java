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

    public boolean add(Object obj) {
        if (obj instanceof Donut) {
            this.quantity++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean remove(Object obj) {
        if(obj instanceof Donut) {
            this.quantity--;
            return true;
        }
        else {
            return false;
        }

    }

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
}
