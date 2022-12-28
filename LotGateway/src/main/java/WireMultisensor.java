
public class WireMultisensor {
    private int ID;
    private int temperature;
    private int humidity;
    private int brightness;

    public WireMultisensor(int ID, int temperature, int humidity, int brightness) {
        this.ID = ID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.brightness = brightness;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTemperatur() {
        return temperature;
    }

    public void setTemperatur(int temperatur) {
        this.temperature = temperatur;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
