package miscaris6.smartHome;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<SmartDevice> devices;

    public SmartHome() {
        this.devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void controlDevices() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }
}