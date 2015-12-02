package storagedata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdata.GoodsDocu;
import mysqlimp.MySqlImp;
import po.GoodsDocuPO;
import po.InputStorageDocuPO;
import po.OutStorageDocuPO;
import storagedataService.LookStorageService;

public class LookStorage implements LookStorageService{
	//查看一段时间内的入库/出库/金额
	private String transcentercheckname;//库存盘点中数据库的表单名字
	InputStorageDocu inputdocu=new InputStorageDocu();
	OutStorageDocu outdocu=new OutStorageDocu();
	GoodsDocu goodsdocu=new GoodsDocu();
	LookStorage look=new LookStorage();
	MySqlImp mysqlimp;
	//一段时间内的入库数量
	@Override
	public int inputStorageDataSeeNum(String transcenterID,String time) {
		// TODO Auto-generated method stub
		int num=inputdocu.storagenum(transcenterID, time);
		return num;
	}
	//一段时间内的出库数量
	@Override
	public int outStorageDataSeeNum(String transID,String time) {
		// TODO Auto-generated method stub
		
		int num=outdocu.OutStorageNum(transID, time);
		return num;
	}
	
	
	//盘点库存快递的金额
	@Override
	public double findmoney(String transcenterID) {
		// TODO Auto-generated method stub
		switch(transcenterID){
		case "025000":
			 this.transcentercheckname="南京库存盘点";
			 break;
		case "010000":
			 this.transcentercheckname="北京库存盘点";
			 break;
		case "020000":
			 this.transcentercheckname="广州库存盘点";
			 break;
		case "021000":
			 this.transcentercheckname="上海库存盘点";
			 break;
		}
		
		try {
			double sum=0;
			mysqlimp=new MySqlImp();
			String find="SELECT 快递编号"+" FROM "+transcentercheckname+"";
			ResultSet rs=mysqlimp.query(find);
			while(rs.next()){
				try {
					sum+=goodsdocu.find(rs.getString(1)).getTotalfee();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return sum;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

}
