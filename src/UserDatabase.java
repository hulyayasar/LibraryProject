
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static final String CSV_FILE = "users.csv";

    public static void saveUser(User user, String type) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            if (new File(CSV_FILE).length() == 0) {
                writer.println("name,email,type,password");
            }
            writer.println(user.getName() + "," + user.getEmail() + "," + type + "," +user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String email = parts[1];
              String type = parts[2];
                    String password = parts[3];
                    
                    User user;
                    
                    if(type.equals("M")) {
                    	user  = new MTeam(name,email,password);
                    	users.add(user);
                    }
                    else if(type.equals("St")){
                    	user  = new Student(name,email,password);
                    	users.add(user);
                    }
                    else if(type.equals("F")){
                    	user  = new Faculty(name,email,password);
                    	users.add(user);
                    }
                    else if(type.equals("S")){
                    	user  = new Staff(name,email,password);
                    	users.add(user);
                    }
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}




