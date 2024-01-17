import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket s;
    private String message;
    public void connect() throws IOException {
        serverSocket = new ServerSocket(3600);
        System.out.println("Waiting for connection");
        s = serverSocket.accept();
        System.out.println("Connection established");
    }
    public void readMessage() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        message = input.readLine();
    }
    public void outputMessage() throws IOException {
        PrintWriter output = new PrintWriter(s.getOutputStream(), true);
        output.println("Server: " + message);
    }
}
