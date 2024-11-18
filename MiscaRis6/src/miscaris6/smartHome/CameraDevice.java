package miscaris6.smartHome;

public class CameraDevice implements SmartDevice {
    private int resolution;

    public CameraDevice(int resolution) {
        this.resolution = resolution;
    }

    @Override
    public void turnOn() {
        System.out.println("Камера включена");
    }

    @Override
    public void turnOff() {
        System.out.println("Камера выключена");
    }

    public void record() {
        System.out.println("Камера записывает в разрешении: " + resolution + "p");
    }
}