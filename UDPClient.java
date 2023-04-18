import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buffer = new byte[1024];
            InetAddress address = InetAddress.getByName("localhost");

            // Create a request packet with an empty message
            DatagramPacket requestPacket = new DatagramPacket(new byte[1], 1, address, 17);

            // Send the request to the server
            socket.send(requestPacket);

            // Receive the response from the server
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            // Print the response
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Received response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
