package cafe;

/**
 *
 */
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
     *Constructor that gets the menuID
     *
     * @param menuItemID
     */
    public MenuItem(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    /**
     *Method to
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
     Accessory method to get the price
     @param 'none'
     @return double value price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     Accessory method to set the price
     @param price
     @return 'none'
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Accessory method to get the menu item id
     * @return integer value that corresponds to the menu ID
     */
    public int getMenuItemID() {
        return this.menuItemID;
    }


    /**
     * Accessory method that gets the details of an item
     * @return a string that corresponds to the details of the item
     */
    public String getItemDetails(){
        return this.itemDetails;
    }

    /**
     * Accessory method that
     * @return 'none'
     */
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
