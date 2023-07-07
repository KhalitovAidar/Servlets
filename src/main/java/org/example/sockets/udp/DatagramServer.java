package org.example.sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServer {
    public static void main(String[] args) throws SocketException {
        try (
                DatagramSocket datagramServer = new DatagramSocket(7777)
                ){
            byte[] bytes = new byte[512];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            datagramServer.receive(packet);

            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
