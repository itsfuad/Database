import java.io.*;
import java.lang.*;
import java.io.FileWriter;
import java.util.*;

public class Database {
    // contructor

    private String filename;
    private File file;

    protected Database(String filename) {
        System.out.println("Database constructor");

        this.filename = filename;

        file = new File(filename);

        if (file.exists()) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
            // create file
            try {
                System.out.println("Creating file");
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error creating file");
            }
        }
    }

    // insert record
    protected void insertRecord(String _Key, String _Value) {
        // check if username already exists
        if (keyExists(_Key)) {
            System.out.println("Key already exists");
            return;
        }

        // append to file
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(_Value + "\n");
            fw.close();

            System.out.println("Record inserted. Key: " + _Key + " Value: " + _Value);
        } catch (Exception e) {
            System.out.println("Error inserting record");
        }
    }

    // delete record
    protected void deleteRecord(String _Key) {

        if (!keyExists(_Key)) {
            System.out.println("Key not found");
            return;
        }

        // store database info in arraylist
        ArrayList<String> databaseInfo = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String lineArray[] = line.split(";");
                if (!lineArray[0].equals(_Key)) {
                    databaseInfo.add(line);
                }
            }
            scanner.close();

            // write updated database info to file
            try {
                FileWriter fw = new FileWriter(filename);
                for (String line : databaseInfo) {
                    fw.write(line + "\n");
                }
                fw.close();

                System.out.println("Record deleted. Key: " + _Key);
            } catch (Exception e) {
                System.out.println("Error deleting record");
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        }


    }

    // update record (username, password and info)
    protected  void updateRecord(String _Key, String _Value) {
        //check if user exists
        if (!keyExists(_Key)) {
            System.out.println("Key not found");
            return;
        }

        // store database info in arraylist
        ArrayList<String> databaseInfo = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(";");
                if (lineArray[0].equals(_Key)) {
                    databaseInfo.add(_Value);
                } else {
                    databaseInfo.add(line);
                }
            }
            scanner.close();

            // write updated database info to file
            try {
                FileWriter fw = new FileWriter(filename);
                for (String line : databaseInfo) {
                    fw.write(line + "\n");
                }
                fw.close();

                System.out.println("Record updated. Key: " + _Key + " Value: " + _Value + "\n");
            } catch (Exception e) {
                System.out.println("Error updating record");
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    // check if user exists
    private boolean keyExists(String _Key) {
        // store database info in arraylist
        ArrayList<String> databaseInfo = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(this.filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                databaseInfo.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }

        // search arraylist for matching username
        for (int i = 0; i < databaseInfo.size(); i++) {
            String line = databaseInfo.get(i);
            String[] lineArray = line.split(";");

            if (lineArray[0].equals(_Key)) {
                return true;
            }
        }

        return false;
    }

    // get info
    public String getInfo(String _Key) {
        // store database info in arraylist

        ArrayList<String> databaseInfo = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                databaseInfo.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }

        // search arraylist for userID
        for (int i = 0; i < databaseInfo.size(); i++) {
            String line = databaseInfo.get(i);
            String[] lineArray = line.split(";");

            if (lineArray[0].equals(_Key)) {
                return line;
            }
        }

        return "Key not found";
    }

    // print all
    public void printAll() {
        System.out.println("Printing all");
        
        //read file and print each line
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }
}
