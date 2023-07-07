package org.example.sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream os = new DataOutputStream(socket.getOutputStream());
             DataInputStream is = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in);
        ) {
            String request = is.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Client request: " + request);
                String response = scanner.nextLine();
                os.writeUTF(response);
                request = is.readUTF();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
