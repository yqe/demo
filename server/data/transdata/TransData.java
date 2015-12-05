package transdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.TransPO;
import transdataService.TransDataService;

/**
 * @author jjlb
 *装车单
 */
public class TransData implements TransDataService{
		private String date;//装车日期
		private String bussinessID;//本营业厅编号
		private String expreID;//汽运编号
		private String destination;//到达地
		private String carsID;//车辆代号
		private String monitor;//监装员
		private String supercargo;//押运员
		private double fee;//运费
		private String orderID;//装箱里的订单号
		MySqlImp mysqlimp;
		public TransPO find(String carsID) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			this.carsID=carsID;
			mysqlimp=new MySqlImp();
			String find="SELECT *"+" FROM 装车单"+" WHERE 车辆代号='"+carsID+"'";
			ResultSet rs=mysqlimp.query(find);
			this.date=rs.getString(1);
			this.bussinessID=rs.getString(2);
			this.expreID=rs.getString(3);
			this.destination=rs.getString(4);
			this.carsID=rs.getString(5);
			this.monitor=rs.getString(6);
			this.supercargo=rs.getString(7);
			this.fee=rs.getDouble(8);
			this.orderID=rs.getString(9);
			TransPO trapo=new TransPO(date,bussinessID,expreID,destination,carsID,monitor,supercargo,fee,orderID);
			return trapo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class has some problem in TransData!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some MySql problem has happened in TransData!");
			return new TransPO("不存在",bussinessID,expreID,destination,carsID,monitor,supercargo,fee,orderID);
		}
		
	}
		
		public void delete(String goodsID) {
			// TODO Auto-generated method stub
			try {
				mysqlimp=new MySqlImp();
				String delete="DELETE FROM 装车单"+" WHERE 装箱中订单条形码号='"+goodsID+"'";
				mysqlimp.update(delete);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Class has some problem in TransData!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Some MySql problem has happened in TransData!");
			}
		}
		public void insert(TransPO po) {
			// TODO Auto-generated method stub
			try {
				mysqlimp=new MySqlImp();
				this.date=po.getDate();
				this.bussinessID=po.getBussinessID();
				this.expreID=po.getExpreID();
				this.destination=po.getDestination();
				this.carsID=po.getCarsID();
				this.monitor=po.getMonitor();
				this.supercargo=po.getSupercargo();
				this.fee=po.getFee();
				this.orderID=po.getOrderID();
				String insert="INSERT INTO 装车单"+" (装车日期,本营业厅编号,汽运编号,到达地,车辆代号,监装员,押运员,运费,装箱中订单条形码号)"
				+" VALUES('"+date+"','"+bussinessID+"','"+expreID+"','"+destination+"','"+carsID+"','"+monitor+"','"+supercargo+"',"+fee+",'"+orderID+"')";
				mysqlimp.update(insert);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Class has some problem in TransData!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Some MySql problem has happened in TransData!");
			}
		}
		public void update(TransPO po) {
			// TODO Auto-generated method stub
			TransData tran=new TransData();
			tran.delete(po.getOrderID());
			tran.insert(po);
		}
		public ArrayList<TransPO> findmore() {
			// TODO Auto-generated method stub
			ArrayList<TransPO> transList=new ArrayList<TransPO>();
			try {
				mysqlimp=new MySqlImp();
				String findmore="SELECT * FROM 装车单";
				ResultSet rs=mysqlimp.query(findmore);
				while(rs.next()){
					transList.add(new TransPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9)));
				}
				return transList;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Class has some problem in TransData!");
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Some MySql problem has happened in TransData!");
				return null;
			}
			
		}

}
