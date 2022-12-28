package configuration;

public class CliParameters {

    /** The one and only instance of CLI parameters. */
    private static CliParameters instance;

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
