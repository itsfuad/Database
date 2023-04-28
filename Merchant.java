public class Merchant {

    private String name;
    private short age;
    private String userID;
    private String password;
    private Shop[] shops;

    //constructor
    public Merchant() {
        System.out.println("Merchant constructor");
    }

    public Merchant(String name, short age, String userID, String password, Shop[] shops){
        this.name = name;
        this.age = age;
        this.userID = userID;
        this.password = password;
        this.shops = shops;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShops(Shop[] shops){
        this.shops = shops;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public short getAge() {
        return this.age;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getPassword() {
        return this.password;
    }

    public Shop[] getShops(){
        return this.shops;
    }

    //methods
    public void addShop(Shop shop){
        Shop[] temp = new Shop[this.shops.length + 1];
        for(int i = 0; i < this.shops.length; i++){
            temp[i] = this.shops[i];
        }
        temp[this.shops.length] = shop;
        this.shops = temp;
    }

    public void removeShop(Shop shop){
        Shop[] temp = new Shop[this.shops.length - 1];
        int j = 0;
        for(int i = 0; i < this.shops.length; i++){
            if(this.shops[i] != shop){
                temp[j] = this.shops[i];
                j++;
            }
        }
        this.shops = temp;
    }
}
