package cafe;

public class MenuItem {
    private double price;
    private int menuItemID;
    private String itemDetails;
    private static int nextMenuItemID = 1;
    private boolean removed;

    public MenuItem() {
        this.menuItemID = nextMenuItemID;
        nextMenuItemID++;
        this.price = 0;
    }

    /**
     *
     * @param menuItemID
     */
    public MenuItem(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    /**
     *
     * @param obj
     * @return
     */
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



    public String getItemDetails(){
        return this.itemDetails;
    }

    public void setItemDetails(){

    }


    public void setDetails(String itemDetails){
        this.itemDetails = itemDetails;
    }

    public double itemPrice(){
        return price;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}
