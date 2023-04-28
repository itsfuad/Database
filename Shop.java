import java.lang.*;

public class Shop {
    private String name;
    private String address;
    private Merchant merchant;
    private String shopID;
    private Product[] products;

    //constructor
    public Shop() {
        System.out.println("Shop constructor");
    }

    public Shop(String name, String address, Merchant merchant, String shopID, Product[] products) {
        this.name = name;
        this.address = address;
        this.merchant = merchant;
        this.shopID = shopID;
        this.products = products;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public Merchant getMerchant() {
        return this.merchant;
    }

    public String getShopID() {
        return this.shopID;
    }

    public Product[] getProducts() {
        return this.products;
    }

    //methods
    public void addProduct(Product product) {
        //adds a product to the shop
        if (this.products == null) { //if there are no products in the shop
            this.products = new Product[1]; //create a new array of products
            this.products[0] = product; //add the product to the array
        } else {
            Product[] temp = new Product[this.products.length + 1]; //create a new array of products with a length of the old array + 1
            for (int i = 0; i < this.products.length; i++) { //copy the old array into the new array
                temp[i] = this.products[i];
            }
            temp[temp.length - 1] = product; //add the product to the end of the new array
            this.products = temp;
        }
    }

    public void removeProduct(Product product) {
        //removes a product from the shop
        for (int i = 0; i < this.products.length; i++){
            if (this.products[i] == product){
                System.out.println("Product: " + product.getName() + " removed");
                for (int j = i; j < this.products.length - 1; j++){
                    this.products[j] = this.products[j + 1];
                }
                break;
            }
        }
    }

    public void viewProduct(Product product) {
        //Show all info
        System.out.println("Product name: " + product.getName());
        System.out.println("Product ID: " + product.getProductID());
        System.out.println("Product Price: " + product.getPrice());
        System.out.println("Product Description: " + product.getDescription());
    }

    public void viewAllProducts() {
        ///show all product info
        for (Product product : products){
            viewProduct(product);
        }
    }
}
