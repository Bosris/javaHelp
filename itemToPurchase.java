class ItemToPurchase
{
    String itemName = "none"; //Initialized in default constructor to "none"
    int itemPrice = 0; // Initialized in default constructor to 0
    int itemQuantity = 0; //Initialized in default constructor to 0

    //returns name of item object when called
    public String getName() {
        return itemName;
    }
    //returns price of item object when called
    public int getPrice() {
        return itemPrice;
    }
    //returns quantity of item object when called
    public int getQuantity() {
        return itemQuantity;
    }
    //sets item variable for name when called
    public void setName(String newValue) {
        itemName = newValue;
    }
    //sets item variable for price when called
    public void setPrice(int newValue) {
        itemPrice = newValue;
    }
    //sets item variable for quantity when called
    public void setQuantity(int newValue) {
        itemQuantity = newValue;
    }
}
