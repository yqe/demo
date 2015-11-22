package storageblService;

import java.util.ArrayList;

import po.OutStorageList;
import po.StorageList;
import po.StoragePO;

public interface StorageBlService {


	public void InStorageInput(StorageList slt);


	public void InStorageDetele(int rank);

	public void OutStorageInput(OutStorageList oslt);


	public void OutStorageDelete(int rank);


	public void StorageCheck(StorageList slt);


	public void StorageSee(String info);

	public void StorageUpdate(StoragePO svo);

}
