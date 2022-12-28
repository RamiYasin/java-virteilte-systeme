import configuration.CliParameters;
import mqtt.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Parse the command line.
        CliParameters.getInstance().setBrokerAddress(System.getenv("DESTINATION"));
        CliParameters.getInstance().setSensorID(Integer.parseInt(System.getenv("SensorID")));
        // Start the MQTT subscriber.
        Publisher publisher = new Publisher();
        publisher.run();
    }
}
