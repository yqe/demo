package clientmain;

import po.InputStorageDocuPO;
import po.InputStorageList;
import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StoragePO;
import storagebl.StorageBl;

public class ClientMain {
	
	public static void main(String[] args) {
		//TODO
		InputStorageDocuPO sto=new InputStorageDocuPO("0000000001",  "2015-10-11","南京",
				"航运区", "1","1","1","0001") ;
		InputStorageDocuPO sto2=new InputStorageDocuPO("0000000002",  "2015-10-11","南京",
				"机动区","1","1","1","0001" ) ;
		InputStorageList slt=new InputStorageList();
		slt.addInputStoragePO(sto);
		slt.addInputStoragePO(sto2);
		
		OutStorageDocuPO osto=new OutStorageDocuPO("0000000001", "2015-10-11",
				"上海","航运","02501201510110123456") ;
		OutStorageDocuPO osto2=new OutStorageDocuPO("0000000002", "2015-10-11",
				"上海","航运","02501201510110123456") ;
		OutStorageList oslt=new OutStorageList();
		oslt.addOutStoragePO(osto);
		oslt.addOutStoragePO(osto2);
		StorageBl sb=new StorageBl();
		sb.InStorageInput(slt);
		sb.OutStorageInput(oslt);
	}
}
