package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.StorageCheckPO;
import storagedataService.StorageCheckService;

/**
 * @author jjlb
 *库存盘点
 */
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
	public String transcenterID;//中装中心编号
	
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
			String insert="INSERT INTO 库存盘点"+" (快递编号,区号,排号,架号,位号,入库日期,中转中心编号)"+" VALUES('"+goodsID+"','"+area+"','"+row+"','"+shelf+"','"+location+"','"+time+"','"+transcenterID+"')";
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
			String delete="DELETE FORM 库存盘点"+" WHERE 快递编号='"+ID+"'";
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

	
	public ArrayList<StorageCheckPO> findbydate(String date,String transcenterID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			ArrayList<StorageCheckPO> stoList=new ArrayList<StorageCheckPO>();
			String findbydate="SELECT * FROM 库存盘点"+" WHERE 入库日期='"+date+"' and WHERE 中转中心编号='"+transcenterID+"'";
			ResultSet rs=mysqlimp.query(findbydate);
			while(rs.next()){
				stoList.add(new StorageCheckPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
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

	public ArrayList<StorageCheckPO> findall(String transID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			ArrayList<StorageCheckPO> stoList=new ArrayList<StorageCheckPO>();
			String findall="SELECT * FROM 库存盘点"+" WHERE 中转中心编号='"+transID+"'";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				stoList.add(new StorageCheckPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
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
			String find="SELECT * FROM 库存盘点"+" WHERE 快递编号='"+ID+"'";
			ResultSet rs=mysqlimp.query(find);
			rs.next();
			StorageCheckPO spo=new StorageCheckPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
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
			return new StorageCheckPO("不存在","","","","","","");
		}
		
	}
	//逻辑层调用这个方法，设置库存盘点名字
}
