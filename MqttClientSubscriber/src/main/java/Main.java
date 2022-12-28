import configuration.CliParameters;
import mqtt.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Parse the command line.
        CliParameters.getInstance().setBrokerAddress(System.getenv("DESTINATION1"));
        CliParameters.getInstance().setDestination(System.getenv("DESTINATION2"));
        // Start the MQTT subscriber.
        Subscriber subscriber = new Subscriber();
        subscriber.run();
    }
}
