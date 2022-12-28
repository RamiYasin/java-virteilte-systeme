package configuration;

public abstract class Defaults {
    /** The default host to connect to.*/
    public static final String DST_HOST = "127.0.0.1";
    /**
     * Private constructor to hide the implicit public one and to void any instantiation.
     */
    private Defaults() {
        throw new IllegalStateException("Utility class");
    }
}
