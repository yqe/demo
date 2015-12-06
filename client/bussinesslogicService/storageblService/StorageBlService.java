package storageblService;

import po.InputStorageList;
import po.OutStorageList;

public interface StorageBlService {


	public boolean InStorageInput(InputStorageList slt);


	public boolean OutStorageInput(OutStorageList oslt);

	public InputStorageList StorageCheck();

	public String[] StorageSee();

	public void StorageUpdate(InputStorageList svo);

}
