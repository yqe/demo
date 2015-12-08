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

/**
 * @author jjlb 查看库存
 */
public class LookStorage implements LookStorageService {
	// 查看一段时间内的入库/出库/金额
	private String transcentercheckname;// 库存盘点中数据库的表单名字
	InputStorageDocu inputdocu = new InputStorageDocu();
	OutStorageDocu outdocu = new OutStorageDocu();
	GoodsDocu goodsdocu = new GoodsDocu();
	LookStorage look = new LookStorage();
	MySqlImp mysqlimp;

	// 一段时间内的入库数量
	@Override
	public int inputStorageDataSeeNum(String transcenterID, String time) {
		// TODO Auto-generated method stub
		int num = inputdocu.storagenum(transcenterID, time);
		return num;
	}

	// 一段时间内的出库数量
	@Override
	public int outStorageDataSeeNum(String transID, String time) {
		// TODO Auto-generated method stub

		int num = outdocu.OutStorageNum(transID, time);
		return num;
	}

	// 盘点库存快递的金额
	@Override
	public double findmoney(String transcenterID) {
		// TODO Auto-generated method stub
		try {
			double sum = 0;
			mysqlimp = new MySqlImp();
			String find = "SELECT 快递编号" + " FROM 库存盘点" + " WHERE 中转中心编号='" + transcenterID + "'";
			ResultSet rs = mysqlimp.query(find);
			while (rs.next()) {
				try {
					sum += goodsdocu.find(rs.getString(1)).getTotalfee();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rs.close();
			return sum;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in LookStorage!");
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in LookStorage!");
			return 0;
		}

	}

}
