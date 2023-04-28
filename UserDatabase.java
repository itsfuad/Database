public class UserDatabase extends Database {

    private String filename;

    public UserDatabase(String filename){
        super(filename);
        this.filename = filename;
    }

    //insert record
    public void insertUser(String username, String password, String info, String role){
        String value = username + ";" + password + ";" + info + ";" + role;
        insertRecord(username, value);
    }

    //delete record
    public void deleteUser(String userID){
        deleteRecord(userID);
    }

    //update record (username, password and info)
    public void updateUser(String userID, String record){
        updateRecord(userID, record);
    }
}