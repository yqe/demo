package storageblService;

import po.InputStorageList;
import po.OutStorageList;

public interface StorageBlService {


	public void InStorageInput(InputStorageList slt);


	public void OutStorageInput(OutStorageList oslt);


	public InputStorageList StorageCheck();

	public String[] StorageSee();

	public void StorageUpdate(InputStorageList svo);

}
