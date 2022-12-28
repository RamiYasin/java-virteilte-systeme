import configuration.CliParameters;

public class Main {

    public static void main(String[] args) {
        CliParameters.getInstance().setDestination1(System.getenv("DESTINATION1"));
        CliParameters.getInstance().setDestination2(System.getenv("DESTINATION2"));
        Thread thread = new Thread(new WireMultiSensorServiceServer());
        thread.start();

        Thread thread2 = new Thread(new RequestHandler());
        thread2.start();
    }
}