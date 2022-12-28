import configuration.CliParameters;
import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        // Parse the command line arguments.
        CliParameters.getInstance().setDestination(System.getenv("DESTINATION"));
        try {
            Thread thread = new Thread(new UDPSocketServer());
            thread.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
