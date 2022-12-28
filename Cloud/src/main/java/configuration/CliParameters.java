package configuration;

public class CliParameters {

    /** The one and only instance of CLI parameters. */
    private static CliParameters instance;

    /** The destination host to connect to. */
    private String destination1 = Defaults.DST_HOST;

    /** The destination host to connect to. */
    private String destination2 = Defaults.DST_HOST;
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

    public String getDestination1() {
        return this.destination1;
    }

    public void setDestination1(String destination) {
        this.destination1 = destination;
    }

    public String getDestination2() {
        return this.destination2;
    }

    public void setDestination2(String destination) {
        this.destination2 = destination;
    }
    /**
     * A private constructor to avoid
     * instantiation.
     */
    private CliParameters() {}
}
