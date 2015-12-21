package storagedataService;

import po.StorageAlarmPO;

public interface StorageAlarmService {
	public boolean insert(StorageAlarmPO po);
	public boolean delete(String transcenterID);
	public StorageAlarmPO find(String transcenterID);
	public boolean update(StorageAlarmPO po);
}
