package org.fog.scheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.fog.entities.FogDevice;

public class DBSCANClustering {
    private DBSCANScheduler dbscanScheduler;

    public DBSCANClustering(List<FogDevice> fogDevices) {
        dbscanScheduler = new DBSCANScheduler(fogDevices);
    }

    public void setDevices(List<FogDevice> devices) {
        dbscanScheduler.setDevices(devices);
    }

    public String getNextDeviceName() {
        return dbscanScheduler.getNextDeviceName();
    }

    private static class DBSCANScheduler {
        private List<FogDevice> devices;
        private int currentIndex = 0;

        public DBSCANScheduler(List<FogDevice> devices) {
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

    // Method to read the dataset and extract relevant features
    public static List<double[]> readDataset(String edge) throws IOException {
        List<double[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(edge));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(","); // Assuming CSV format
            // Extract relevant features and convert to double
            double[] features = new double[8];
            // Populate features array from values
            data.add(features);
        }
        br.close();
        return data;
    }
}
