package org.example.sockets.tcp;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SockerRunner {
    public static void main(String[] args) throws UnknownHostException {
        // http 80
        // https 443
        // tcp
        InetAddress inetAddress = Inet4Address.getByName("localhost");

        try(
                Socket socket = new Socket(inetAddress, 7777);
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                DataInputStream is = new DataInputStream(socket.getInputStream());
                Scanner scanner = new Scanner(System.in);
                ) {
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                os.writeUTF(request);
                System.out.println("Response from server: "  + is.readUTF());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}