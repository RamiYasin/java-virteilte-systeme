import configuration.CliParameters;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

public class WireMultiSensorServiceClient {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    public void persist() {
        try {
            TTransport transport;
            transport = new TSocket(InetAddress.getByName(CliParameters.getInstance().getDestination()).getHostAddress(), 8585);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            WireMultiSensorService.Client client = new WireMultiSensorService.Client(protocol);

            // Call the methode insert MultiSensor for insert a WireMultiSensor in the list
            client.RTT(dtf.format(LocalDateTime.now()));

            transport.close();
        } catch (TException | UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
