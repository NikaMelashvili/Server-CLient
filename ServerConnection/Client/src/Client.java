import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket s;
    public void connection() throws IOException {
        s = new Socket("localhost", 3600);
    }
    public void sendMessage() throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter message for server: ");
        String message = userInput.readLine();
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(message);
    }
    public void printServerMessage() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(in.readLine());
    }
}
