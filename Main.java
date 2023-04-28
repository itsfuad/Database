import java.util.*;

class User{
    public String userID;
    public String password;
    public String info;
    public String role;

    public User(String userID, String password, String info, String role){
        this.userID = userID;
        this.password = password;
        this.info = info;
        this.role = role;
    }

    public void PrintInfo(){
        System.out.println("UserID: " + this.userID);
        System.out.println("Password: " + this.password);
        System.out.println("Info: " + this.info);
        System.out.println("Role: " + this.role);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //create database
        UserDatabase userDatabase = new UserDatabase("users.txt");

        userDatabase.insertUser("Markferry1", "myAw3s0m3P4ssw0rd", "Mark Ferry|South Basabo|D-23/A", "merchant");
        userDatabase.insertUser("Mahdi Hossain", "f4k3P4ssw0rd", "Mahdi Hossain|North California|23/9", "merchant");
        userDatabase.insertUser("Johndoe82", "tH3B3stP4ssw0rd", "John Doe|New york city|98/3", "merchant");


        userDatabase.deleteUser("Mahdi Hossain");
        userDatabase.deleteUser("user3");

        userDatabase.printAll();
    }
}