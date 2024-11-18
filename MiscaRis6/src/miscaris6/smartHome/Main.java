package miscaris6.smartHome;

public class Main {
    public static void main(String[] args) {
        LightDevice light = new LightDevice();
        ThermostatDevice thermostat = new ThermostatDevice();
        CameraDevice camera = new CameraDevice(1080);

        SmartHome smartHome = new SmartHome();
        smartHome.addDevice(light);
        smartHome.addDevice(thermostat);
        smartHome.addDevice(camera);
        smartHome.controlDevices();

        light.adjustBrightness(75);
        thermostat.setTemperature(24);
        camera.record();
    }
}
