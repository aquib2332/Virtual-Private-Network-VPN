package VPN;

import java.io.*;
import java.net.Socket;

public class VPNClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 11111;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println("Connected to VPN Server");

            InputStream inputFromServer = socket.getInputStream();
            OutputStream outputToServer = socket.getOutputStream();

            // Simulate sending and receiving data through the VPN tunnel
            String message = "VPN Is Connected.......!!!";
            outputToServer.write(message.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = inputFromServer.read(buffer);
            if (bytesRead > 0) {
                String receivedMessage = new String(buffer, 0, bytesRead);
                System.out.println("Received from Server: " + receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
