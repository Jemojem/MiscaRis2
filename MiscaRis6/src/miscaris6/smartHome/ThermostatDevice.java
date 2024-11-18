package miscaris6.smartHome;

public class ThermostatDevice implements SmartDevice {
    private int temperature;

    public ThermostatDevice() {
        this.temperature = 22;
    }

    @Override
    public void turnOn() {
        System.out.println("Термостат включён");
    }

    @Override
    public void turnOff() {
        System.out.println("Термостат выключен");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Темература термостата установлена на: " + temperature + "°C");
    }
}