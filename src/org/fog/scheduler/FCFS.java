package org.fog.scheduler;

import java.util.List;
import org.fog.entities.FogDevice;

public class FCFS {
    private FCFSScheduler fcfsScheduler;

    public FCFS(List<FogDevice> fogDevices) {
        fcfsScheduler = new FCFSScheduler(fogDevices);
    }

    public void setDevices(List<FogDevice> devices) {
        fcfsScheduler.setDevices(devices);
    }

    public String getNextDeviceName() {
        return fcfsScheduler.getNextDeviceName();
    }

    private static class FCFSScheduler {
        private List<FogDevice> devices;
        private int currentIndex = 0;

        public FCFSScheduler(List<FogDevice> devices) {
            this.devices = devices;
        }

        public void setDevices(List<FogDevice> devices) {
            this.devices = devices;
        }

        public String getNextDeviceName() {
            FogDevice device = devices.get(currentIndex);
            String deviceName = device.getName();
            currentIndex = (currentIndex + 1) % devices.size(); // Move to the next device in a circular manner
            return deviceName;
        }
    }
}
