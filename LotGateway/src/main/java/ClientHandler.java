import configuration.CliParameters;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientHandler implements Runnable {
    Socket clientSocket;
    int ID, temperature, humidity, brightness;
    BufferedWriter out;

    // Constructor
    public ClientHandler(int ID, int temperature, int humidity, int brightness){
        try {
            clientSocket = new Socket(InetAddress.getByName(CliParameters.getInstance().getDestination()), 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.ID = ID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.brightness = brightness;
    }

    // For RTT test Protocol 2
    public String sendRTT_ToServer(){
        LocalDateTime now;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        JSONObject objTime = new JSONObject();
        now = LocalDateTime.now();
        objTime.put("Time", dtf.format(now));
        return objTime.toString();
    }

    @Override
    public void run() {
        try {
            String dataOut;
            JSONObject jsonStr = new JSONObject();
            jsonStr.put("ID", ID);
            jsonStr.put("temperature", temperature);
            jsonStr.put("humidity", humidity);
            jsonStr.put("brightness", brightness);
            dataOut = jsonStr.toString();
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            out.write("POST HTTP/1.1 200 OK\r\n");
            out.write(dataOut);
            out.newLine();
            out.write(sendRTT_ToServer());
            out.flush();
           } catch (IOException e) {
                e.printStackTrace();
            }finally {
            try {
                 out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}