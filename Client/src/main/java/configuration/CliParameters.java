package configuration;

import java.util.List;

public class CliParameters {

    /** The one and only instance of CLI parameters. */
    private static CliParameters instance;
    /** The buffer size of the UDP buffer. */
    private int bufferSize = Defaults.BUFFER_SIZE;
    /** The port of the UDP socket server. Initially set to the default port. */
    private int port = Defaults.PORT;
    /** The message that is published. */
    private String message = Defaults.MESSAGE;
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

    public int getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = Integer.parseInt(port);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(List<String> args) {
        StringBuilder sb = new StringBuilder();
        for (String arg: args) {
            sb.append(arg);
            sb.append(" ");
        }
        this.message = sb.toString().trim();
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    private CliParameters() {}
}
