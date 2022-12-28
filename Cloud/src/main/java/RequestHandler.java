import org.apache.thrift.TException;
import org.json.JSONObject;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler implements Runnable{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    static public List myWireMultisensorList = new ArrayList();
    static WireMultiSensorServiceClient wireMultiSensorServiceClient = new WireMultiSensorServiceClient();
    int port = 8080;

    public void parse(String responseBody) throws TException, UnknownHostException {
            JSONObject jsonObject = new JSONObject(responseBody);
            int ID = jsonObject.getInt("ID");
            int brightness = jsonObject.getInt("brightness");
            int temperature = jsonObject.getInt("temperature");
            int humidity = jsonObject.getInt("humidity");
            WireMultiSensor wireMultisensor = new WireMultiSensor(ID, temperature, humidity,brightness);
            myWireMultisensorList.add(wireMultisensor);
            // Call Persist WireMultiSensor in Database to insert the new WireMultiSensor in database
            wireMultiSensorServiceClient.persist(ID, temperature, humidity, brightness,9090);
            wireMultiSensorServiceClient.persist(ID, temperature, humidity, brightness,9595);
    }

    public String generateHtmlData(List<WireMultiSensor> wireMultisensor){
        String data = "<html>"
                + "<head>" +
                "<title>Praktikum 2</title> " +
                "<style> " +
                "table {" +
                "font-family: arial, sans-serif;" +
                "border-collapse: collapse;" +
                "width: 100%;" +
                "}"+
                "td, th {" +
                "border: 1px solid #dddddd;" +
                "text-align: left;" +
                "padding: 8px;" +
                "}"+
                "tr:nth-child(even) {" +
                "background-color: #dddddd;" +
                "}"+
                "h2 {" +
                "text-align: center;"+
                "}"+
                "</style>"+
                "</head>"
                + "<body>";
        data += "<h2>Wire Multi Sensor Table</h2>";
        data += "<table>";
        data += "<tr>";
        data += "<th>SensorID</th>"+
                "<th>temperature</th>"+
                "<th>humidity</th>"+
                "<th>brightness</th>";
        data += "</tr>";
        for (WireMultiSensor multisensor: wireMultisensor){
            data += "<tr>";
            data += "<td>"+multisensor.getId()+"</td>";
            data += "<td>"+multisensor.getTemperature()+" C"+"</td>";
            data += "<td>"+multisensor.getHumidity()+" %"+"</td>";
            data += "<td>"+multisensor.getBrightness()+" lm"+"</td>";
            data += "</tr>";
        }
        data += "</table>";
        data += "</body>" + "</html>";
        return data;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            BufferedReader rd;
            BufferedWriter wr;
            while (true) {
                clientSocket = serverSocket.accept();
                rd = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                line = rd.readLine();
                String[] lines = line.split("\\r?\\n");
                String[] header = lines[0].split(" ");
                System.out.println("The http: " + header[0]);
                String dataOut;
                if (header[0].contains("POST")) {
                    System.out.print("The data: ");
                    while ((line = rd.readLine()) != null) {
                        System.out.println(line);
                    if (line.contains("Time")){
                        wr = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        wr.write("POST HTTP/1.1 200 OK\r\n");
                        wr.write(line);
                        System.out.println("Send RTT from cloud to client: "+line);
                        wr.flush();
                    }else{
                        parse(line);
                         }
                    }
                }
                if(header[0].contains("GET")){
                    dataOut = generateHtmlData(myWireMultisensorList);
                    try (OutputStream clientOutput = clientSocket.getOutputStream()) {
                        clientOutput.write("HTTP/1.1 200 OK\r\n".getBytes());
                        clientOutput.write("\r\n".getBytes());
                        clientOutput.write(dataOut.getBytes());
                        clientOutput.write("\r\n\r\n".getBytes());
                        clientOutput.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
