// Implement TCP Echo Client–Server program 

// Problem7Server.java

import java.io.*;
import java.net.*;

public class Problem7Server {
    public static void main(String[] args) {

        try {
            // Create Server Socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running and waiting for client...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Input and Output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            // Echo loop
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);

                // Send back same message
                out.println("Echo: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}