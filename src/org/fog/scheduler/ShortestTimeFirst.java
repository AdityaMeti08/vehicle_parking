package org.fog.scheduler;
import java.util.List;
import org.fog.entities.FogDevice;

	public class ShortestTimeFirst {
	    private STFScheduler stfScheduler;

	    public ShortestTimeFirst(List<FogDevice> fogDevices) {
	        stfScheduler = new STFScheduler(fogDevices);
	    }

	    public void setDevices(List<FogDevice> devices) {
	        stfScheduler.setDevices(devices);
	    }

	    public String getNextDeviceName() {
	        return stfScheduler.getNextDeviceName();
	    }

	    private static class STFScheduler {
	        private List<FogDevice> devices;

	        public STFScheduler(List<FogDevice> devices) {
	            this.devices = devices;
	            
	        }

	        public void setDevices(List<FogDevice> devices) {
	            this.devices = devices;
	          
	        }

	       

	        public String getNextDeviceName() {
	            if (!devices.isEmpty()) {
	                FogDevice device = devices.remove(0);
	                return device.getName();
	            }
	            return null;
	        }
	    }
	}
