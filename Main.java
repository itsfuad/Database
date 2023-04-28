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

        userDatabase.insertRecord("user1", "password1", "info1", "role1");
        userDatabase.insertRecord("user2", "password2", "info2", "role2");

        userDatabase.deleteRecord("user1");
        userDatabase.deleteRecord("user3");

        userDatabase.printAll("user2");
    }
}