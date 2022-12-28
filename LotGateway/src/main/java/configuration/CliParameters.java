package configuration;

public class CliParameters {

    /** The one and only instance of CLI parameters. */
    private static CliParameters instance;

    /** The port of the UDP socket server. Initially set to the default port. */
    private int port = Defaults.PORT;
    /** The buffer size of the UDP buffer. */
    private int bufferSize = Defaults.BUFFER_SIZE;
    /** The destination host to connect to. */
    private String destination = Defaults.DST_HOST;
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
    public int getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = Integer.parseInt(port);
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(String bufferSize) {
        this.bufferSize = Integer.parseInt(bufferSize);
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    /**
     * A private constructor to avoid
     * instantiation.
     */
    private CliParameters() {}
}
