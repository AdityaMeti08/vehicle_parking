package org.fog.scheduler;
import java.util.List;
import org.fog.entities.FogDevice;

public class CentralizedScheduler {

    private List<FogDevice> devices;
    private int currentIndex = 0;

    public CentralizedScheduler(List<FogDevice> fogDevices) {
        this.devices = fogDevices;
    }

    public void setDevices(List<FogDevice> devices) {
        this.devices = devices;
    }

    public String getNextDeviceName() {
        FogDevice device = selectNextDevice();
        return device.getName();
    }

    private FogDevice selectNextDevice() {
        // Implement your centralized scheduling logic here
        // For example, you might choose the device with the lowest load, highest available resources, etc.

        // For simplicity, let's assume the centralized scheduler always selects devices in a circular manner.
        FogDevice selectedDevice = devices.get(currentIndex);
        currentIndex = (currentIndex + 1) % devices.size(); // Move to the next device in a circular manner

        return selectedDevice;
    }
}
