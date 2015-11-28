package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.InputStorageDocuPO;
import po.InputStorageList;
import po.OutStorageDocuPO;
import po.StorageList;
import storagedataService.InputStorageService;

public class InputStorageDocu implements InputStorageService{
	private String goodsID;
	private String intime;
	private String destination;
	private String area;//区号
	private String queue;//排号
	private String shelf;//架号
	private String local;//位号
	private String databasestoragename;//数据库里的入库单名字
	MySqlImp mysqlimp;
	ArrayList<InputStorageDocuPO> insee;
	public void InputStorageAdd(InputStorageList inslt) {
		// TODO Auto-generated method stub
		try {
			int i=0;
			ArrayList<InputStorageDocuPO> in=inslt.getSlist();
			mysqlimp=new MySqlImp();
			i=in.size();
			while(i>0){
				InputStorageDocuPO inpo=in.get(i);
				this.goodsID=inpo.getGoodsID();
				this.intime=inpo.getIntime();
				this.destination=inpo.getDestination();
				this.area=inpo.getArea();
				this.queue=inpo.getQueue();
				this.shelf=inpo.getShelf();
				this.local=inpo.getLocal();
				String insert="INSERT INTO 入库单"+" (快递编号,入库日期,目的地,区号,排号,架号,位号）"+" VALUES（'"+goodsID+"','"+intime+"','"+destination+"','"+area+"','"+queue+"','"+shelf+"','"+local+"')";
				mysqlimp.update(insert);
				i--;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void InputStorageDelete(String goodsID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 入库单"+" WHERE 快递编号='"+goodsID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InputStorageDocuPO> StorageDataSee() {
		// TODO Auto-generated method stub
		try {
			ArrayList<InputStorageDocuPO> insee=new ArrayList<InputStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 入库单";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				insee.add(new InputStorageDocuPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insee;
		
	}
	
	public String finddataname(InputStorageList inslt){
		ArrayList<InputStorageDocuPO> in=inslt.getSlist();
		InputStorageDocuPO inputpo=in.get(0);
		
		return area;
		
	}
}
