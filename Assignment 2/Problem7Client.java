// Implement TCP Echo Client–Server program 
 
// Problem7Client.java

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Problem7Client {
    public static void main(String[] args) {

        try {
            // Connect to server (localhost, port 5000)
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to server!");

            // Input and Output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            String message;

            // Send messages to server
            while (true) {
                System.out.print("Enter message: ");
                message = sc.nextLine();

                out.println(message);

                // Receive echo from server
                String response = in.readLine();
                System.out.println("Server: " + response);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            sc.close();

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}