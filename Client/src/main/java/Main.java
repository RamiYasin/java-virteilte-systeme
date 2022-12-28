import configuration.CliParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.lang.Thread.sleep;

public class Main {

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static int id;

    private static void parseOptionsFromEnv() {
        try {
            CliParameters.getInstance().setDestination(System.getenv("DESTINATION"));
            id = Integer.parseInt(System.getenv("SensorID"));
        } catch (NullPointerException e) {
            LOGGER.debug("Environment variable \"DESTINATION\" does not exist");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        parseOptionsFromEnv();
        UDPSocketClient udpSocketClient = new UDPSocketClient(id);
        int count = 0;
        do {
            count++;
            sleep(3000);
            udpSocketClient.sendMsg();
        } while (count < 50);
    }
}