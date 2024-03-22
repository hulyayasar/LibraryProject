
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static final String CSV_FILE = "users.csv";

    public static void saveUser(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            if (new File(CSV_FILE).length() == 0) {
                writer.println("name,email,isFaculty,isStudent,password");
            }
            writer.println(user.getName() + "," + user.getEmail() + "," + user.isFaculty() + "," + user.isStudent()
                    + "," + user.getPassword());
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
                if (parts.length == 5) {
                    String name = parts[0];
                    String email = parts[1];
                    boolean isFaculty = Boolean.parseBoolean(parts[2]);
                    boolean isStudent = Boolean.parseBoolean(parts[3]);
                    String password = parts[4];
                    users.add(new User(name, email, isFaculty, isStudent, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}




