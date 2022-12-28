package configuration;

public abstract class Defaults {

    /** The default port of the UDP socket server. */
    public static final int PORT = 3030;
    /** The exit code if the procedure succeeded. */
    public static final int EXIT_CODE_SUCCESS = 0;
    /** The exit code of the procedure failed. */
    public static final int EXIT_CODE_ERROR = 1;
    /** The default UDP buffer size. */
    public static final int BUFFER_SIZE = 256;
    /** The default message sent to the server. */
    public static final String MESSAGE = "Hello World";
    /** The default host to connect to.*/
    public static final String DST_HOST = "127.0.0.1";

    /**
     * Private constructor to hide the implicit public one
     * and to void any instantiation.
     */
    private Defaults() {
        throw new IllegalStateException("Utility class");
    }
}