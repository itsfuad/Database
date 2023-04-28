import java.io.*;
import java.util.ArrayList;

public class UserDatabase extends Database {

    private String filename;

    public UserDatabase(String filename){
        super(filename);
        this.filename = filename;
    }

    //insert record
    public void insertRecord(String username, String password, String info, String role){
        //check if username already exists
        if(userExists(username)){
            System.out.println("User already exists");
            return;
        }

        //append to file
        try{
            FileWriter fw = new FileWriter(filename, true);
            fw.write(username + ";" + password + ";" + info + ";" + role + "\n");
            fw.close();

            System.out.println("Record inserted");
        }catch(Exception e){
            System.out.println("Error inserting record");
        }
    }

    //delete record
    public void deleteRecord(String userID){
        //store database info in arraylist
        ArrayList<String> databaseInfo = new ArrayList<String>();

        try{
            java.util.Scanner scanner = new java.util.Scanner(new File(filename));

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                databaseInfo.add(line);
            }
            scanner.close();
        }catch(Exception e){
            System.out.println("Error reading file");
        }

        boolean found = false;

        //delete record with matching userID
        for(int i = 0; i < databaseInfo.size(); i++){
            String line = databaseInfo.get(i);
            String[] lineArray = line.split(";");

            if(lineArray[0].equals(userID)){
                databaseInfo.remove(i);
                System.out.println("Record deleted");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("User not found");
            return;
        }

        //write updated database info to file
        try{
            FileWriter fw = new FileWriter(filename);
            for(String line : databaseInfo){
                fw.write(line + "\n");
            }
            fw.close();

        }catch(Exception e){
            System.out.println("Error deleting record");
        }
    }

    //update record (username, password and info)
    public void updateRecord(String userID, String record){
        //store database info in arraylist
        ArrayList<String> databaseInfo = new ArrayList<String>();

        try{
            java.util.Scanner scanner = new java.util.Scanner(new File(filename));

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                databaseInfo.add(line);
            }
            scanner.close();
        }catch(Exception e){
            System.out.println("Error reading file");
        }

        boolean found = false;

        //update record with matching userID
        for(int i = 0; i < databaseInfo.size(); i++){
            String line = databaseInfo.get(i);
            String[] lineArray = line.split(";");
            
            if(lineArray[0].equals(userID)){
                found = true;
                databaseInfo.set(i, record);
                System.out.println("Record updated");
                break;
            }
        }

        if(!found){
            System.out.println("User not found");
            return;
        }

        //write updated database info to file
        try{
            FileWriter fw = new FileWriter(filename);
            for(String line : databaseInfo){
                fw.write(line + "\n");
            }
            fw.close();

        }catch(Exception e){
            System.out.println("Error updating record");
        }
    }

    //check if user exists
    private boolean userExists(String username){
        //store database info in arraylist
        ArrayList<String> databaseInfo = new ArrayList<String>();

        try{
            java.util.Scanner scanner = new java.util.Scanner(new File(filename));

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                databaseInfo.add(line);
            }
            scanner.close();
        }catch(Exception e){
            System.out.println("Error reading file");
        }

        //search arraylist for matching username
        for(int i = 0; i < databaseInfo.size(); i++){
            String line = databaseInfo.get(i);
            String[] lineArray = line.split(";");

            if(lineArray[0].equals(username)){
                return true;
            }
        }

        return false;
    }
}