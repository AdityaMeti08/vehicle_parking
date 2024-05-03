package org.fog.scheduler;

import java.util.Collections;
import java.util.List;
import org.fog.entities.FogDevice;

public class HierarchicalClustering {
    private HierarchicalScheduler hierarchicalScheduler;

    public HierarchicalClustering(List<FogDevice> fogDevices) {
        hierarchicalScheduler = new HierarchicalScheduler(fogDevices);
    }

    public void setDevices(List<FogDevice> devices) {
        hierarchicalScheduler.setDevices(devices);
    }

    public String getNextDeviceName() {
        return hierarchicalScheduler.getNextDeviceName();
    }

    private static class HierarchicalScheduler {
        private List<FogDevice> devices;
        private int currentIndex = 0;

        public HierarchicalScheduler(List<FogDevice> devices) {
            this.devices = devices;
        }

        public void setDevices(List<FogDevice> devices) {
            this.devices = devices;
        }

        public String getNextDeviceName() {
            // Shuffle the list to randomize the order
            Collections.shuffle(devices);

            // Get the next device
            FogDevice device = devices.get(currentIndex);
            String deviceName = device.getName();

            // Move to the next device in a circular manner
            currentIndex = (currentIndex + 1) % devices.size();

            return deviceName;
        }
    }
}
