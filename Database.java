import java.io.File;
import java.util.ArrayList;

public class Database{
    //contructor

    private String filename;
    private File file;

    public Database(String filename){
        System.out.println("Database constructor");

        this.filename = filename;

        file = new File(filename);

        if(file.exists()){
            System.out.println("File exists");
        }else{
            System.out.println("File does not exist");
            //create file
            try{
                System.out.println("Creating file");
                file.createNewFile();
            }catch(Exception e){
                System.out.println("Error creating file");
            }
        }
    }

    //get info
    public String getInfo(String userID){
        //store database info in arraylist

        ArrayList<String> databaseInfo = new ArrayList<String>();

        try{
            java.util.Scanner scanner = new java.util.Scanner(file);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                databaseInfo.add(line);
            }
            scanner.close();
        }catch(Exception e){
            System.out.println("Error reading file");
        }

        //search arraylist for userID
        for(int i = 0; i < databaseInfo.size(); i++){
            String line = databaseInfo.get(i);
            String[] lineArray = line.split(";");

            if(lineArray[0].equals(userID)){
                return line;
            }
        }

        return "User not found";
    }

    //print all
    public void printAll(String userID){
        System.out.println("Printing all");
        System.out.println(getInfo(userID));
    }
}
