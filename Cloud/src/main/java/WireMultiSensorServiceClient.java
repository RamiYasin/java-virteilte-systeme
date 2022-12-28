import com.opencsv.CSVWriter;
import configuration.CliParameters;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class WireMultiSensorServiceClient {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
    static LocalDateTime now = null;
    static ArrayList <LocalDateTime> servertime= new ArrayList<LocalDateTime>();
    static ArrayList <LocalDateTime> clienttime= new ArrayList<LocalDateTime>();
    static ArrayList <Long> diffrent= new ArrayList<Long>();
    private double RRT() {
        double messen = 0;
        for (int i = 0; i <= 99; i++) {
            messen = +diffrent.get(i);
        }
        return (messen / 100) ;
    }
    public void persist(int id, int Temperature, int Humidity, int Brightness, int port) throws UnknownHostException, TException {
        TTransport transport;

        boolean persist1=false;
        boolean online2=false;
        try {
                transport = new TSocket(InetAddress.getByName(CliParameters.getInstance().getDestination1()).getHostAddress(), port);
                transport.open();

                TProtocol protocol = new TBinaryProtocol(transport);
                WireMultiSensorService.Client client = new WireMultiSensorService.Client(protocol);

                // Call the methode insert MultiSensor for insert a WireMultiSensor in the list
                client.insertWireMultiSensor(id, Temperature, Humidity, Brightness);
                now = LocalDateTime.now();
                client.RTT(dtf.format(now));
            System.out.println("Size von diffrent ist: "+diffrent.size()+ " in Stcuk");
            if (diffrent.size()>=100){
                try {
                    // create FileWriter object with file as parameter
                    //FileWriter outputfile = new FileWriter(file);

                    // create CSVWriter object filewriter object as parameter
                    CSVWriter writer = new CSVWriter(new FileWriter("RPC(Thrift).csv"));

                    // adding header to csv
                    String[] header = {"recive_Zeit","send_Zeit,different"};
                    String[] rrt ={"Durchschnitt von RRT fuer 100 Pakete"};
                    writer.writeNext(rrt);
                    double tempp = RRT();
                    String nb = String.valueOf(tempp);
                    String[] bbb = new String[2];
                    bbb[0] = nb;
                    bbb[1]="Nano_seconden";
                    writer.writeNext(bbb);
                    writer.writeNext(header);
                    for (int i = 0; i <= 99; i++) {
                        String[] bb = new String[3];
                        bb[0] = servertime.get(i).toString();
                        bb[1] = clienttime.get(i).toString();
                        bb[2]=diffrent.get(i).toString();
                        writer.writeNext(bb);
                    }

                    // closing writer connection
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                transport.close();
        } catch (TException | UnknownHostException e) {
                e.printStackTrace();
                transport = new TSocket(InetAddress.getByName(CliParameters.getInstance().getDestination2()).getHostAddress(), 9595);
                transport.open();

                TProtocol protocol = new TBinaryProtocol(transport);
                WireMultiSensorService.Client client = new WireMultiSensorService.Client(protocol);

                // Call the methode insert MultiSensor for insert a WireMultiSensor in the list
                client.insertWireMultiSensor(id, Temperature, Humidity, Brightness);
                now = LocalDateTime.now();
                client.RTT(dtf.format(now));

                transport.close();
        }
    }
}
