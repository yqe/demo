package storagedata;


import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.OutStorageDocuPO;
import po.OutStorageList;
import po.StorageList;
import storagedataService.OutStorageService;


public class StorageOutDocu  {
	public String goodno;
	/* 快递编号 */
	public String outtime;
	/* 出库日期*/
	public String destination;
	/*目的地ʽ */
	public String loadform;
	/* 装运形式 */
	public String transferno;
	//中转中心编号
	MySqlImp mysqlimp;
	public void StorageDataAdd(OutStorageList slt) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
//			String 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void StorageDataDelete(OutStorageList oslt) {
		// TODO Auto-generated method stub
		
	}
	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<OutStorageDocuPO> StorageDataSee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
