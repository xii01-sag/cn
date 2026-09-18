import java.io.*;
import java.net.*;

class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        byte[] receiveData = new byte[1024];
        byte[] sendData;

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("RECEIVED: " + sentence);

        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();

        System.out.print("Enter the Message: ");
        String data = br.readLine();
        sendData = data.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);

        serverSocket.close();
    }
}
