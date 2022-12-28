package configuration;

/**
 * A container class that contains all the
 * CLI parameters.
 *
 * @author Michael Bredel
 */
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
    /** The buffer size of the UDP buffer. */
    private int bufferSize = Defaults.BUFFER_SIZE;
    /** The destination host to connect to. */
    private String destination = Defaults.DST_HOST;
    /** The port of the UDP socket server. Initially set to the default port. */
    private int port = Defaults.PORT;
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

    // Getter and Setter

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = Integer.parseInt(port);
    }

    public int getBufferSize() {
        return this.bufferSize;
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
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * A private constructor to avoid
     * instantiation.
     */
    private CliParameters() {}
}
