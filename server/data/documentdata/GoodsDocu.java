package documentdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlimp.MySqlImp;
import po.GoodsDocuPO;

public class GoodsDocu {
	private String dilivername;
	private String diliveraddress;
	private String diliverworkspace;
	private String diliverhomephone;
	private String dilivermobile;
	private String receivername;
	private String receiveraddress;
	private String receiverworkspace;
	private String receiverhomephone;
	private String receivermobile;
	private double wrappedfee;//包装费
	private double totalfee;//费用合计
	private String expresstype;//快递类型
	private String goodsID;//订单条形码号
	private String receivedtime;//收件日期
	private double receivedmoney;//收款金额
	MySqlImp mysqlimp;
	
	
public GoodsDocuPO find(String ID) throws RemoteException {
	// TODO Auto-generated method stub
	goodsID=ID;
	try {
		mysqlimp=new MySqlImp();
		String find="SELECT 寄件人姓名,寄件人住址,寄件人单位,寄件人电话,寄件人手机,收件人姓名,收件人住址,收件人单位,收件人电话"
				+ "，收件人手机,包装费,费用合计,快递类型,收件日期,收款金额"+" FROM 快递单"+" WHERE 订单条形码号="+goodsID;
		ResultSet rs=mysqlimp.query(find);
		rs.next();
		dilivername=rs.getString(1);
		diliveraddress=rs.getString(2);
		diliverworkspace=rs.getString(3);
		diliverhomephone=rs.getString(4);
		dilivermobile=rs.getString(5);
		receivername=rs.getString(6);
		receiveraddress=rs.getString(7);
		receiverworkspace=rs.getString(8);
		receiverhomephone=rs.getString(9);
		receivermobile=rs.getString(10);
		wrappedfee=rs.getDouble(11);
		totalfee=rs.getDouble(12);
		receivedtime=rs.getString(13);
		receivedmoney=rs.getDouble(14);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	GoodsDocuPO goodsdocuPO=new GoodsDocuPO(dilivername,diliveraddress,diliverworkspace,diliverhomephone,
			dilivermobile,receivername,receiveraddress,receiverworkspace,receiverhomephone,receivermobile,wrappedfee,
			totalfee,expresstype,goodsID,receivedtime,receivedmoney);
	return goodsdocuPO;
}

public void insert(GoodsDocuPO po) throws RemoteException {
	// TODO Auto-generated method stub
	this.dilivername=po.getDilivername();
	this.diliveraddress=po.getDiliveraddress();po.getReceiveraddress();
	this.diliverworkspace=po.getDiliverworkspace();
	this.diliverhomephone=po.getDiliverhomephone();
	this.dilivermobile=po.getDilivermobile();
	this.receivername=po.getReceivername();
	this.receiveraddress=po.getReceiveraddress();
	this.receiverworkspace=po.getReceiverworkspace();
	this.receiverhomephone=po.getReceiverhomephone();
	this.receivermobile=po.getReceivermobile();
	this.wrappedfee=po.getWrappedfee();
	this.totalfee=po.getTotalfee();
	this.expresstype=po.getExpresstype();
	this.receivedtime=po.getReceivedtime();
	this.receivedmoney=po.getReceivedmoney();
	this.goodsID=po.getGoodsID();
	String insert="INSERT INTO 快递单"+" (寄件人姓名,寄件人地址,寄件人单位,寄件人电话,寄件人手机,收件人姓名,收件人地址,收件人单位,收件人电话,收件人手机,"
			+ "包装费,合计费用,快递类型,订单条形码号,收件日期,收款金额)"+" VALUES('"+dilivername+"','"+diliveraddress+"','"+diliverworkspace+"','"+diliverhomephone+"','"+receivername+"','"+receiveraddress+"','"+receiverworkspace+"','"+receiverhomephone+"','"+receivermobile+"',"+wrappedfee+","+totalfee+",'"+expresstype+"','"+goodsID+"','"+receivedtime+"',"+receivedmoney+")";
	try {
		mysqlimp=new MySqlImp();
		mysqlimp.update(insert);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public void delete(String goodsID) throws RemoteException {
	// TODO Auto-generated method stub
	
}

public void update(GoodsDocuPO pos) throws RemoteException {
	// TODO Auto-generated method stub
	
}
}
