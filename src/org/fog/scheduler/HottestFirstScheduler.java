package org.fog.scheduler;
import java.util.List;

import org.fog.entities.FogDevice;

public class HottestFirstScheduler {
    private List<FogDevice> devices;

    public HottestFirstScheduler(List<FogDevice> fogDevices) {
        this.devices = fogDevices;
    }

    public void setDevices(List<FogDevice> devices) {
        this.devices = devices;
    }

    public String getNextDeviceName() {
        FogDevice hottestDevice = getHottestDevice();
        if (hottestDevice != null) {
            return hottestDevice.getName();
        }
        return null; // Return null if there are no devices
    }

    private FogDevice getHottestDevice() {
        if (!devices.isEmpty()) {
//            return Collections.max(devices, Comparator.comparingDouble(FogDevice::getHotness));
        }
        return null; // Return null if there are no devices
    }
}
