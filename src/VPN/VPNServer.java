package VPN;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VPNServer {
    public static void main(String[] args) {
        final int PORT = 11111;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("VPN Server Is Running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle client communication in a separate thread
                VPNClientHandler clientHandler = new VPNClientHandler(clientSocket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
