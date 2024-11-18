package miscaris6.smartHome;

public class LightDevice implements SmartDevice {
    private int brightness;

    public LightDevice() {
        this.brightness = 50;
    }
    @Override
    public void turnOn() {
        System.out.println("Светильники включены");
    }
    @Override
    public void turnOff() {
        System.out.println("Светильники выключены");
    }
    public void adjustBrightness(int brightness) {
        this.brightness = brightness;
        System.out.println("Яркость света установлена на: " + brightness + "%");
    }
}