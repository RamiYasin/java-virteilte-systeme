package mqtt;

import configuration.CliParameters;
import configuration.Constants;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class Publisher {
    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);
    /** The global CLI parameters that have been parsed in Main. */
    private CliParameters cliParameters;
    /** The broker URL. */
    private String broker;
    /** How many Sensor data will be sending to Subscriber */
    int count = 0;

    /**
     * Default constructor that initializes
     * various class attributes.
     */
    public Publisher() {

        // Get the CLI parameters.
        cliParameters = CliParameters.getInstance();

        // Create the broker string from command line arguments.
        broker = cliParameters.getBrokerProtocol() + "://" +
                 cliParameters.getBrokerAddress() + ":" +
                 cliParameters.getBrokerPort();
    }

    /**
     * Runs the MQTT client and publishes a message.
     */
    public void run() {
        // Create some MQTT connection options.
        MqttConnectOptions mqttConnectOpts = new MqttConnectOptions();
        mqttConnectOpts.setCleanSession(true);

        try {
            MqttClient client = new MqttClient(broker, MqttClient.generateClientId());

            // Connect to the MQTT broker using the connection options.
            client.connect(mqttConnectOpts);
            LOGGER.info("Connected to MQTT broker: " + client.getServerURI());
            do {
                count++;
                sleep(3000);
                // Create the message and set a quality-of-service parameter.
                MqttMessage message = new MqttMessage(cliParameters.getMessage().getBytes());
                message.setQos(Constants.QOS_EXACTLY_ONCE);

                // Publish the message.
                client.publish(cliParameters.getTopic(), message);
                LOGGER.info("Published message: " + message);
            } while (count < 100);

            // Disconnect from the MQTT broker.
            client.disconnect();
            LOGGER.info("Disconnected from MQTT broker.");

            // Exit the app explicitly.
            System.exit(Constants.EXIT_CODE_SUCCESS);

        } catch (MqttException e) {
            LOGGER.error("An error occurred: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
