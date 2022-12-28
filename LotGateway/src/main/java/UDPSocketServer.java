import com.opencsv.CSVWriter;
import configuration.CliParameters;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UDPSocketServer implements Runnable {
    /** The logger. */
    final Logger LOGGER = LoggerFactory.getLogger(UDPSocketServer.class);
    /** A buffer array to store the datagram information. */
    private final byte[] buf;
    /** States the server running. */
    boolean running = true;
    // my output file
    private FileWriter fileWriter;
    // my wire multi sensor list
    private final List<WireMultisensor> myWireMultiSensor;
    long RTTdiff = 0;
    List<Long> RTTdiffList = new ArrayList<>();
    Thread thread;

    UDPSocketServer() throws IOException {
        buf = new byte[CliParameters.getInstance().getBufferSize()];
        fileWriter = new FileWriter("output.json", true);
        myWireMultiSensor = new ArrayList<>();
    }
    private double RRT() {
        double messen = 0;
        for (int i = 0; i <= 99; i++) {
            messen = +RTTdiffList.get(i);
        }
        return (messen / 100) ;
    }
    @Override
    public void run () {
        int SensorID, temperature, humidity, brightness;
        // Create the UDP datagram socket.
        try (DatagramSocket udpSocket = new DatagramSocket(CliParameters.getInstance().getPort())) {
            LOGGER.info("Started the UDP socket server at port {} with buffer size {}.", CliParameters.getInstance().getPort(), buf.length);
            // Receive packets continuously.
            DatagramPacket udpPacket;
            String response;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
            LocalDateTime now = null;
            LocalDateTime dateTimeFromClient;
            while (running) {
                JSONObject objTime = new JSONObject();
                // Create the datagram packet structure that contains the received datagram information.
                udpPacket = new DatagramPacket(buf, buf.length);
                // Receive message
                udpSocket.receive(udpPacket);
                response = new String(udpPacket.getData());
                JSONObject obj = new JSONObject(response);

                //Print some packet data.
                printPacketData(udpPacket);

                if(response.contains("Time")){
                    dateTimeFromClient = LocalDateTime.now();
                    RTTdiff = ChronoUnit.MILLIS.between(now, dateTimeFromClient);
                    System.out.println("RTTdiff: "+RTTdiff+ " in MILLIS");
                    RTTdiffList.add(RTTdiff);
                    if (RTTdiffList.size()>100){
                        try {
                            // create FileWriter object with file as parameter
                            //FileWriter outputfile = new FileWriter(file);

                            // create CSVWriter object filewriter object as parameter
                            CSVWriter writer = new CSVWriter(new FileWriter("MQTT.csv"));

                            // adding header to csv
                            String[] header = {"different in NanoSeckonde"};
                            String[] rrt ={"Durchschnitt von RRT fuer 100 Pakete"};
                            writer.writeNext(rrt);
                            double tempp = RRT();
                            String nb = String.valueOf(tempp);
                            String[] bbb = new String[2];
                            bbb[0] = nb;
                            bbb[1]="MILI_seconden";
                            writer.writeNext(bbb);
                            writer.writeNext(header);
                            for (int i = 0; i <= 99; i++) {
                                String[] bb = new String[1];
                                bb[0]=RTTdiffList.get(i).toString();
                                writer.writeNext(bb);
                            }

                            // closing writer connection
                            writer.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }else {
                        SensorID = obj.getInt("SensorID");
                        temperature = obj.getInt("temperature");
                        humidity = obj.getInt("humidity");
                        brightness = obj.getInt("brightness");
                        // add the new wire Multi sensor to the list
                        WireMultisensor wireMultisensor = new WireMultisensor(SensorID, temperature, humidity, brightness);
                        this.myWireMultiSensor.add(wireMultisensor);
                        thread = new Thread(new ClientHandler(SensorID, temperature, humidity, brightness));
                        thread.start();
                }
                // write the data in a json file
                this.fileWriter.write(obj + ",");

                // Send data to the client
                InetAddress address = udpPacket.getAddress();
                int port = udpPacket.getPort();

                now = LocalDateTime.now();
                objTime.put("Time", dtf.format(now));
                byte[] bufServer = objTime.toString().getBytes();
                udpPacket = new DatagramPacket(bufServer, bufServer.length, address, port);
                udpSocket.send(udpPacket);

                this.fileWriter.flush();
            }
        } catch (SocketException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                this.fileWriter.flush();
                this.fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Extracts some data of a given datagram packet
     * and prints the result to standard out.
     * @param udpPacket The datagram packet to extract and print.
     */
    private void printPacketData(DatagramPacket udpPacket) {
        // Get IP address and port.
        InetAddress address = udpPacket.getAddress();
        int port = udpPacket.getPort();
        // Get packet length.
        int length = udpPacket.getLength();
        // Get the payload from the buffer. Mind the buffer size and the packet length!
        byte[] playload = Arrays.copyOfRange(udpPacket.getData(), 0, length);
        // Print the packet information.
        System.out.println("Received a packet: IP:Port: " + address + ":" + port + ", length: " + length + ", payload: " + new String(playload));
    }

     // Stop the UDP socket server.
     public void stopUDPSocketListening () {
        this.running = false;
     }
}