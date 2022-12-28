package configuration;

public class CliProcessor {

    /** The logger. */
    //private static final Logger LOGGER = LoggerFactory.getLogger(CliProcessor.class);

    /** The help message. */
    private static final String HELP_MSG = "socket-server.sh [OPTIONS]";

    /** The one and only instance of CLI processor. */
    private static CliProcessor instance;

    /** The CLI parameters store object. */
    private CliParameters cliParameters;

    /**
     * The static getter for the CLI processor instance.
     *
     * @return The CLI processor instance.
     */
    public static CliProcessor getInstance() {
        if (instance == null)
            instance = new CliProcessor();
        return instance;
    }

    /*public void parseCliOptions(String[] args) {
        // Command line options.
        Options options = createCliOptions();
        // Command line parser.
        CommandLineParser parser = new DefaultParser();

        try {
            // Parse the command line arguments.
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("h")) {
                printHelp(options);
                System.exit(Defaults.EXIT_CODE_SUCCESS);
            }
            if (line.hasOption("p")) {
                this.cliParameters.setPort(line.getOptionValue('p'));
            }
            if (line.hasOption("b")) {
                this.cliParameters.setBufferSize(line.getOptionValue('b'));
            }
        } catch (MissingOptionException | MissingArgumentException | NumberFormatException e) {
            // LOGGER.error("ERROR: " + e.getMessage() + "\n");
           // printHelp(options);
            System.exit(Defaults.EXIT_CODE_ERROR);
        } catch (ParseException e) {
            // Oops, something went totally wrong.
            //LOGGER.error("ERROR: Parsing failed. Reason: " + e.getMessage());
        }
    }
*/
    /**
     * Creates the command line options for the
     * program.
     *
     * @return An Options object containing all the command line options of the program.
     */
  /*  private Options createCliOptions() {
        // A helper option.
        Option help = Option.builder("h")
                .longOpt("help")
                .desc("Give this help list.")
                .build();
        // The port option.
        Option port = Option.builder("p")
                .longOpt("port")
                .desc("The server port.")
                .hasArg()
                .argName("PORT")
                .build();
        // The buffer size option.
        Option bufferSize = Option.builder("b")
                .longOpt("buffer")
                .desc("The UDP buffer size.")
                .hasArg()
                .argName("BUFFER")
                .build();

        // Create and add options.
        Options options = new Options();
        options.addOption(help);
        options.addOption(port);
        options.addOption(bufferSize);

        // Return options.
        return options;
    }*/

    /**
     * Prints the help of the command.
     *
     * @param options The command's options.
     */
  /*  private void printHelp(Options options) {
        // A help formatter.
        HelpFormatter formatter = new HelpFormatter();
        // Print help.
        formatter.printHelp(HELP_MSG, options);
    }*/

    /**
     * A private constructor to avoid instantiation.
     */
    private CliProcessor() {
        this.cliParameters = CliParameters.getInstance();
    }
}