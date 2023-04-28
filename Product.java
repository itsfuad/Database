public class Product {
    private String name;
    private String description;
    private double price;
    private String productID;
    private String shopID;
    private String manufacturer;

    //constructor
    public Product() {
        System.out.println("Product constructor");
    }

    public Product(String name, String description, double price, String productID, String shopID, String manufacturer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productID = productID;
        this.shopID = shopID;
        this.manufacturer = manufacturer;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice(){
        return this.price;
    }

    public String getProductID() {
        return this.productID;
    }

    public String getShopID() {
        return this.shopID;
    }

    public String getManfacturer(){
        return this.manufacturer;
    }
}
