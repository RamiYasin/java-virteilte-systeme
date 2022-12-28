import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class WireMultiSensorServiceImpl implements WireMultiSensorService.Iface {
    List<WireMultiSensor> myWireMultiSensorList = new ArrayList();
    long RTTdiff = 0;
    
    @Override
    public List<WireMultiSensor> findById(int id) {
        List<WireMultiSensor> wireMultiSensorList = new ArrayList<>();
        for(WireMultiSensor wireMultiSensor: myWireMultiSensorList){
            if(wireMultiSensor.getId() == id){
                wireMultiSensorList.add(wireMultiSensor);
            }
        }
        return wireMultiSensorList;
    }

    @Override
    public List<WireMultiSensor> findAll() {
        return this.myWireMultiSensorList;
    }

    @Override
    public boolean insertWireMultiSensor(int id, int temperature, int humidity, int brightness) {
        this.myWireMultiSensorList.add(new WireMultiSensor(id, temperature, humidity, brightness));
        System.out.println("ID: "+id+", temperature: "+temperature+", humidity: "+humidity+ ", brightness: "+brightness);
        return true;
    }

    @Override
    public boolean deleteWireMultiSensor(int id) {
        for(WireMultiSensor wireMultiSensor: myWireMultiSensorList){
            if(wireMultiSensor.getId() == id){
                myWireMultiSensorList.remove(wireMultiSensor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateWireMultiSensor(int id, int temperature, int humidity, int brightness) {
        for (int i = 0; i < myWireMultiSensorList.size(); i++){
            if(myWireMultiSensorList.get(i).getId() == id && myWireMultiSensorList.get(i).getTemperature() == temperature
                && myWireMultiSensorList.get(i).getHumidity() == humidity && myWireMultiSensorList.get(i).getBrightness() == brightness){
                // set the found WireMultiSensor
                myWireMultiSensorList.set(i, myWireMultiSensorList.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public void RTT(String time) {
        System.out.println("HttpServer RTT: "+time);
        RTTdiff = ChronoUnit.NANOS.between(WireMultiSensorServiceClient.now, LocalDateTime.now());
        WireMultiSensorServiceClient.servertime.add(LocalDateTime.now());
        WireMultiSensorServiceClient.clienttime.add(WireMultiSensorServiceClient.now);
        WireMultiSensorServiceClient.diffrent.add(RTTdiff);
        System.out.println("RTTdiff: "+RTTdiff+ " in NANOS");
    }
}
