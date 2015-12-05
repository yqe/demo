package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.StorageCheckPO;
import storagedataService.StorageCheckService;

public class StorageCheck implements StorageCheckService{
	public String goodsID;
	/* 快递编号*/
	public String time;
	/* 入库时间 */
	public String area;
	/* 区位 */
	public String row;
	/* 排号 */
	public String shelf;
	/* 架号 */
	public String location;
	/* 位号 */
	MySqlImp mysqlimp;
	public String transcentername;//中装中心名字
	
	public void update(StorageCheckPO po) {
		// TODO Auto-generated method stub
		StorageCheck scheck=new StorageCheck();
		scheck.delete(po.getGoodno());
		scheck.insert(po);
	}

	
	public void insert(StorageCheckPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.goodsID=po.goodsID;
			this.area=po.getArea();
			this.row=po.getRow();
			this.shelf=po.getShelf();
			this.location=po.getLocation();
			this.time=po.getTime();
			String insert="INSERT INTO "+transcentername+""+" (快递编号,区号,排号,架号,位号,入库日期)"+" VALUES('"+goodsID+"','"+area+"','"+row+"','"+shelf+"','"+location+"','"+time+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in StorageCheck!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in StorageCheck!");
		}
		
	}


	public void delete(String ID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FORM "+transcentername+" WHERE 快递编号='"+ID+"'";
			mysqlimp.update(delete);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in StorageCheck!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in StorageCheck!");
		}
		
	}

	
	public ArrayList<StorageCheckPO> findbydate(String date) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			ArrayList<StorageCheckPO> stoList=new ArrayList<StorageCheckPO>();
			String findbydate="SELECT * FROM "+transcentername+""+" WHERE 入库日期='"+date+"'";
			ResultSet rs=mysqlimp.query(findbydate);
			while(rs.next()){
				stoList.add(new StorageCheckPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			return stoList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in StorageCheck!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in StorageCheck!");
			return null;
		}
		
		
	}

	public StorageCheckPO find(String ID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String find="SELECT * FROM "+transcentername+""+" WHERE 快递编号='"+ID+"'";
			ResultSet rs=mysqlimp.query(find);
			rs.next();
			StorageCheckPO spo=new StorageCheckPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			return spo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in StorageCheck!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in StorageCheck!");
			return new StorageCheckPO("不存在","","","","","");
		}
		
	}
	//逻辑层调用这个方法，设置库存盘点名字
	public void findname(String position){
		switch(position){
		case "南京中转中心仓库管理员":
			this.transcentername="南京库存盘点";
			break;
		case "北京中转中心仓库管理员":
			this.transcentername="北京库存盘点";
			break;
		case "广州中转中心仓库管理员":
			this.transcentername="广州库存盘点";
			break;
		case "上海中转中心仓库管理员":
			this.transcentername="上海库存盘点";
			break;
		}
	}
}
