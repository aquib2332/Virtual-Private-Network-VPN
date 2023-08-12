package VPN;

import java.io.*;
import java.net.Socket;

public class VPNClientHandler implements Runnable {
    private final Socket clientSocket;

    public VPNClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputFromClient = clientSocket.getInputStream();
            OutputStream outputToClient = clientSocket.getOutputStream();

            // Simulate forwarding data from client to server and vice versa
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputFromClient.read(buffer)) != -1) {
                outputToClient.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
