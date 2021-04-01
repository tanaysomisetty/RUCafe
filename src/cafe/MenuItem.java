package cafe;

public class MenuItem {
    private double price;
    private int menuItemID;
    private static int nextMenuItemID = 1;

    public MenuItem() {
        this.menuItemID = nextMenuItemID;
        nextMenuItemID++;
        this.price = 0;
    }

    public MenuItem(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            if (this.menuItemID == item.menuItemID) {
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

    public int getMenuItemID() {
        return this.menuItemID;
    }

    public double itemPrice() {
        return 0;
    }

}
