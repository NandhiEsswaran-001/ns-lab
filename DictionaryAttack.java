import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryAttack {
    public static void main(String[] args) {
        String username = "user123";
        String dictionaryFile = "passwords.txt";
        boolean accessGranted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String password;
            while ((password = reader.readLine()) != null) {
                if (authenticate(username, password)) {
                    System.out.println("Access granted for username: " + username + " with password: " + password);
                    accessGranted = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!accessGranted) {
            System.out.println("Dictionary attack failed. Access not granted.");
        }
    }

    private static boolean authenticate(String username, String password) {
        return password.equals("123456");
    }
}
