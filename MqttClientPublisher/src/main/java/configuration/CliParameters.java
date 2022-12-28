package configuration;

import org.json.JSONObject;

public class CliParameters {

    /** The one and only instance of CLI parameters. */
    private static CliParameters instance;
    /** The address of the broker. */
    private String brokerAddress = "localhost";
    /** The port of the broker. */
    private String brokerPort = "1883";
    /** The port of the protocol. */
    private String brokerProtocol = "tcp";
    /** The topic the MQTT client subscribes to. */
    private String topic = "hda/mbredel/ds";
    /** The Sensor ID who is running*/
    private int SensorID = 0;
    /**
     * The static getter for the CLI parameters instance.
     *
     * @return The CLI parameters instance.
     */
    public static CliParameters getInstance() {
        if (instance == null)
            instance = new CliParameters();
        return instance;
    }

    //
    // Getter and Setter
    //

    public int getSensorID() {
        return this.SensorID;
    }

    public void setSensorID(int sensorID) {
        this.SensorID = sensorID;
    }

    public String getBrokerAddress() {
        return this.brokerAddress;
    }

    public void setBrokerAddress(String brokerAddress) {
        this.brokerAddress = brokerAddress;
    }

    public String getBrokerPort() {
        return this.brokerPort;
    }

    public void setBrokerPort(String brokerPort) {
        this.brokerPort = brokerPort;
    }

    public String getBrokerProtocol() {
        return this.brokerProtocol;
    }

    public void setBrokerProtocol(String brokerProtocol) {
        this.brokerProtocol = brokerProtocol;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        JSONObject obj = new JSONObject();
        // Create a new UDP packet with the byte-array as payload.
        obj.put("SensorID", getSensorID());
        obj.put("temperature", (int)(Math.random()*20));
        obj.put("humidity", (int)(Math.random()*50));
        obj.put("brightness", (int)(Math.random()*1000-300+1+300));
        return obj.toString();
    }

    /**
     * A private constructor to avoid
     * instantiation.
     */
    private CliParameters() {}
}
