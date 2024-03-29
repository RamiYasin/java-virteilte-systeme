package configuration;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CliProcessor {

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CliProcessor.class);

    /** The help message. */
    private static final String HELP_MSG = "socket-client.sh [OPTIONS] [MESSAGE]";

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

    public void parseCliOptions(String[] args) {
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
            if (line.hasOption("d")) {
                this.cliParameters.setDestination(line.getOptionValue('d'));
            }
            // Get whatever ist left, after the options have been processed.
            if (line.getArgList() == null || line.getArgList().isEmpty()) {
                LOGGER.info("No message given; using the default message.");
            } else {
                this.cliParameters.setMessage(line.getArgList());
            }
        } catch (MissingOptionException | MissingArgumentException | NumberFormatException e) {
            LOGGER.error("ERROR: " + e.getMessage() + "\n");
            printHelp(options);
            System.exit(Defaults.EXIT_CODE_ERROR);
        } catch (ParseException e) {
            // Oops, something went totally wrong.
            LOGGER.error("ERROR: Parsing failed. Reason: " + e.getMessage());
        }
    }

    /**
     * Creates the command line options for the
     * program.
     *
     * @return An Options object containing all the command line options of the program.
     */
    private Options createCliOptions() {
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
        // The destination host option.
        Option destinationHost = Option.builder("d")
                .longOpt("destination")
                .desc("The destination host to connect to.")
                .hasArg()
                .argName("DEST_HOST")
                .build();

        // Create and add options.
        Options options = new Options();
        options.addOption(help);
        options.addOption(port);
        options.addOption(destinationHost);

        return options;
    }

    /**
     * Prints the help of the command.
     * @param options The command's options.
     */
    private void printHelp(Options options) {
        // A help formatter.
        HelpFormatter formatter = new HelpFormatter();
        // Print help.
        formatter.printHelp(HELP_MSG, options);
    }

    private CliProcessor() {
        this.cliParameters = CliParameters.getInstance();
    }
}
