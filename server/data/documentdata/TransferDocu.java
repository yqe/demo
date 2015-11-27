package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import documentdataService.TransferDocuService;
import mysqlimp.MySqlImp;
import po.TransferDocuPO;

public class TransferDocu implements TransferDocuService{
			MySqlImp mysqlimp;
			 private String transportType;//交通工具种类
			 private String date;//装车日期
			 private String transferNumber;//本中转中心单编号
			 private String flightNumber;//航班号
			 private String startPlace;//出发地
			 private String destination;//目的地
			 private String goodsNumber;//货柜号
			 private String monitor;//监装员
			 private String carryNumber;//本次装箱托运单号
			 private double money;
	public ArrayList<TransferDocuPO> findall() {
		// TODO Auto-generated method stub
		ArrayList<TransferDocuPO> transpo=new ArrayList<TransferDocuPO>();
		try {
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 中转单";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				this.transportType=rs.getString(1);
				this.date=rs.getString(2);
				this.transferNumber=rs.getString(3);
				this.flightNumber=rs.getString(4);
				this.startPlace=rs.getString(5);
				this.destination=rs.getString(6);
				this.goodsNumber=rs.getString(7);
				this.monitor=rs.getString(8);
				this.carryNumber=rs.getString(9);
				this.money=rs.getDouble(10);
				transpo.add(new TransferDocuPO(transportType,date,transferNumber,flightNumber,startPlace,destination,goodsNumber,carryNumber,monitor,money));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transpo;
	}

	public void delete(String goodsID) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 中转单"+"　WHERE 本次装箱托运单号='"+goodsID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(TransferDocuPO po) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			this.transportType=po.getTransportType();
			this.date=po.getDate();
			this.transferNumber=po.getTransferNumber();
			this.flightNumber=po.getFlightNumber();
			this.startPlace=po.getStartPlace();
			this.destination=po.getDestination();
			this.goodsNumber=po.getGoodsNumber();
			this.monitor=po.getMonitor();
			this.carryNumber=po.getCarryNumber();
			this.money=po.getMoney();
			String insert="INSERT INTO 中转单"+" (交通工具种类,装车日期,本中转中心编号,航班号,出发地,到达地,货柜号,监装员,本次装箱托运单号,运费)"
			+" VALUES('"+transportType+"','"+date+"','"+transferNumber+"','"+flightNumber+"','"+startPlace+"','"+destination+"','"+goodsNumber+"','"+monitor+"','"+carryNumber+"',"+money+")";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(TransferDocuPO po) {
		// TODO Auto-generated method stub
		TransferDocu trans=new TransferDocu();
		trans.delete(po.getGoodsNumber());
		trans.insert(po);
	}

	public TransferDocuPO find(String carryNumber) {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String find="SELECT 交通工具种类,装车日期,本中转中心编号,航班号,出发地,到达地,货柜号,监装员,本次装箱托运单号,运费"+" FROM 中转单"+" WHERE 本次装箱托运单号='"+carryNumber+"'";
			ResultSet rs=mysqlimp.query(find);
			this.transportType=rs.getString(1);
			this.date=rs.getString(2);
			this.transferNumber=rs.getString(3);
			this.flightNumber=rs.getString(4);
			this.startPlace=rs.getString(5);
			this.destination=rs.getString(6);
			this.goodsNumber=rs.getString(7);
			this.monitor=rs.getString(8);
			this.carryNumber=rs.getString(9);
			this.money=rs.getDouble(10);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransferDocuPO docupo=new TransferDocuPO(transportType,date,transferNumber,flightNumber,startPlace,destination,goodsNumber,monitor,carryNumber,money);
		return docupo;
	}


}
