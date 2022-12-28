package mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple MQTT callback implementation that
 * logs (prints) information if the connection to the
 * broker got lost, when a message arrived, and
 * when the delivery was completed, i.e., when
 * a delivery token arrived.
 *
 * @author Michael Bredel
 */
public class SimpleMqttCallback implements MqttCallback {

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMqttCallback.class);
    private UDPSocketClient udpSocketClient = new UDPSocketClient(3);
    @Override
    public void connectionLost(Throwable throwable) {
        LOGGER.error("Connection to MQTT broker lost!");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) {
        LOGGER.info("Message received: "+ new String(mqttMessage.getPayload()));
        String msg = mqttMessage.toString();
        udpSocketClient.sendMsg(msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken mqttDeliveryToken) {
        try {
            LOGGER.info("Delivery completed: "+ mqttDeliveryToken.getMessage() );
        } catch (MqttException e) {
            LOGGER.error("Failed to get delivery token message: " + e.getMessage());
        }
    }
}
