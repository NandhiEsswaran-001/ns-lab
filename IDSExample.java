import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IDSExample {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Monitoring for intrusions on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            String clientAddress = socket.getInetAddress().getHostAddress();
            System.out.println("Potential intrusion detected from: " + clientAddress);
        }
    }
}

