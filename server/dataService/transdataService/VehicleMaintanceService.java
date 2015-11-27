package transdataService;

import java.util.ArrayList;

import po.VehicleMaintanceInfoPO;

public interface VehicleMaintanceService {
		public VehicleMaintanceInfoPO find(String vehicleID);
		public void delete(String vehicleID);
		public void insert(VehicleMaintanceInfoPO po);
		public void update(String vehicleID);
		public ArrayList<VehicleMaintanceInfoPO> findmore();
}
