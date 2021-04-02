package cafe;

public class AddIn {
    private String type;

    public AddIn(String type) {
        this.type = type;
    }

    /**
     *Getter method to get the type of add in
     * @param 'none'
     * @return the type of add in
     */
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AddIn) {
            AddIn addIn = (AddIn) obj;
            if (addIn.getType().equals(this.type)) {
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

    @Override
    public String toString() {
        return this.type;
    }

}
