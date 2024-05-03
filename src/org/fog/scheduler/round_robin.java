package org.fog.scheduler;

import java.util.List;
import org.fog.entities.FogDevice;

public class round_robin {
    private RoundRobinScheduler roundRobinScheduler;

    public round_robin(List<FogDevice> fogDevices) {
        roundRobinScheduler = new RoundRobinScheduler(fogDevices);
    }

    public void setDevices(List<FogDevice> devices) {
        roundRobinScheduler.setDevices(devices);
    }

    public String getNextDeviceName() {
        return roundRobinScheduler.getNextDeviceName();
    }

    private static class RoundRobinScheduler {
        private List<FogDevice> devices;
        private int currentIndex = 0;

        public RoundRobinScheduler(List<FogDevice> devices) {
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
