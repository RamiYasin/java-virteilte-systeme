package mqtt;

import configuration.CliParameters;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Subscriber {

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Subscriber.class);

    /** The global CLI parameters that have been parsed in Main. */
    private CliParameters cliParameters;
    /** The broker URL. */
    private String broker;

    /**
     * Default constructor that initializes
     * various class attributes.
     */
    public Subscriber() {

        // Get the CLI parameters.
        cliParameters = CliParameters.getInstance();

        // Create the broker string from command line arguments.
        broker =
                cliParameters.getBrokerProtocol() + "://" +
                cliParameters.getBrokerAddress() + ":" +
                cliParameters.getBrokerPort();
    }

    /**
     * Runs the MQTT client.
     */
    public void run() {
        try {
            MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
            client.setCallback(new SimpleMqttCallback());

            // Connect to the MQTT broker.
            client.connect();
            LOGGER.info("Connected to MQTT broker: " + client.getServerURI());

            // Subscribe to a topic.
            client.subscribe(cliParameters.getTopic());
            LOGGER.info("Subscribed to topic: " + client.getTopic(cliParameters.getTopic()));
        } catch (MqttException e) {
            LOGGER.error("An error occurred: " + e.getMessage());
        }
    }
}