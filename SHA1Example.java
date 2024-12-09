import java.security.MessageDigest;
import java.util.Scanner;

public class SHA1Example {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        // Generate SHA-1 hash
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = sha1.digest(message.getBytes());

        // Convert to hex
        StringBuilder hashHex = new StringBuilder();
        for (byte b : hashBytes) {
            hashHex.append(String.format("%02x", b));
        }

        System.out.println("SHA-1 Digest: " + hashHex.toString());
    }
}

