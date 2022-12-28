import configuration.CliParameters;
import configuration.Defaults;
import java.io.IOException;
import java.net.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UDPSocketClient extends Thread{

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UDPSocketClient.class);
    /** A buffer array to store the datagram information. */
    private final byte[] buf;
    private final byte[] bufReceivedData;
    /** States the server running. */
    private boolean running = true;
    /** The IP address the client connects to. */
    private InetAddress address;
    private int id;

    public UDPSocketClient(int id) {
        this.id = id;
        // Initialize the UDP buffer.
        buf = new byte[CliParameters.getInstance().getBufferSize()];
        bufReceivedData = new byte[CliParameters.getInstance().getBufferSize()];
        try {
            address = InetAddress.getByName(CliParameters.getInstance().getDestination());
        } catch (UnknownHostException e) {
            //LOGGER.error("Can not parse the destination host address.\n{}", e.getMessage());
            System.exit(Defaults.EXIT_CODE_ERROR);
        }
    }

    public void sendMsg() {
        JSONObject obj = new JSONObject();
        // Create a new UDP packet with the byte-array as payload.
        obj.put("SensorID",this.id);
        obj.put("temperature", (int)(Math.random()*20));
        obj.put("humidity", (int)(Math.random()*50));
        obj.put("brightness", (int)(Math.random()*1000-300+1+300));
        // Create the UDP datagram socket.
        try (DatagramSocket udpSocket = new DatagramSocket()) {
            //LOGGER.info("Started the UDP socket that connects to {}.", address.getHostAddress());
            // Convert the message into a byte-array.
            byte[] buf = obj.toString().getBytes();
            // Create a new UDP packet with the byte-array as payload.
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, CliParameters.getInstance().getPort());
            // Send data.
            udpSocket.send(packet);
            LOGGER.info("Message sent with payload: {}", new String(packet.getData()));
            // Receive data
            packet = new DatagramPacket(bufReceivedData, bufReceivedData.length);
            udpSocket.receive(packet);
            // Send data again to the server to calculate the RTT
            udpSocket.send(new DatagramPacket(bufReceivedData, bufReceivedData.length, address, CliParameters.getInstance().getPort()));
            LOGGER.info("Message sent with payload: {}", new String(packet.getData()));
        } catch (SocketException e) {
            LOGGER.error("Could not start the UDP socket server.\n{}", e.getLocalizedMessage());
        } catch (IOException e) {
            LOGGER.error("Could not send data.\n{}", e);
        }
    }
}