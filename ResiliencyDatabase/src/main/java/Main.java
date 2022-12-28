import configuration.CliParameters;
import org.apache.thrift.transport.TTransportException;

public class Main {
    public static void main(String[] args) throws TTransportException {
        CliParameters.getInstance().setDestination(System.getenv("DESTINATION"));
        WireMultiSensorServiceServer server = new WireMultiSensorServiceServer();
        server.start();
    }
}
