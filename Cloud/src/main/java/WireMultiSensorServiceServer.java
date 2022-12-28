import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class WireMultiSensorServiceServer implements Runnable{
    private TServer server;

    @Override
    public void run() {
        TServerTransport serverTransport;
        try {
            serverTransport = new TServerSocket(8585);
            // TSimpleServer – for simple server
            server = new TSimpleServer(new TServer.Args(serverTransport)
                    .processor(new WireMultiSensorService.Processor<>(new WireMultiSensorServiceImpl())));

            System.out.println("Starting the server... ");

            server.serve();

            System.out.println("done.");
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (server != null && server.isServing()) {
            System.out.print("Stopping the server... ");

            server.stop();

            System.out.println("done.");
        }
    }
}
