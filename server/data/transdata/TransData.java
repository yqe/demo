package transdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlimp.MySqlImp;
import po.TransPO;
import transdataService.TransDataService;

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransPO trapo=new TransPO(date,bussinessID,expreID,destination,carsID,monitor,supercargo,fee,orderID);
		return trapo;
		}

}
