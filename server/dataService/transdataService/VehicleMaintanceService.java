package transdataService;

import java.util.ArrayList;

import po.VehicleMaintanceInfoPO;

public interface VehicleMaintanceService {
		public VehicleMaintanceInfoPO find(String vehicleID);
		public boolean delete(String vehicleID);
		public boolean insert(VehicleMaintanceInfoPO po);
		public boolean update(VehicleMaintanceInfoPO po);
		public ArrayList<VehicleMaintanceInfoPO> findmore();
}
