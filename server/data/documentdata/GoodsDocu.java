package documentdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.GoodsDocuService;
import mysqlimp.MySqlImp;
import po.GoodsDocuPO;

/**
 * @author jjlb
 *快递单
 */
public class GoodsDocu implements GoodsDocuService{
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
	private String goodsname;//货物名
	private int goodsnumber;//货物数量
	private double length;//长度
	private double width;//宽//
	private double height;//高
	private double v;//体积	
	private String goodsinfo;//货物信息
	private String wrappedtype;//包装种类
	private String expectedtime;//预期到达时间
	private String generatetime;//寄件单生成日期
	private String courier;//快递员姓名
	private ArrayList<GoodsDocuPO> goodsList;
	MySqlImp mysqlimp;
	
	
public GoodsDocuPO find(String ID) throws RemoteException {
	// TODO Auto-generated method stub
	goodsID=ID;
	try {
		mysqlimp=new MySqlImp();
		String find="SELECT 寄件人姓名,寄件人住址,寄件人单位,寄件人手机,收件人姓名,收件人住址,收件人单位"
				+ "，收件人手机,包装费,费用合计,快递类型,收件日期,收款金额,货物名称,货物数量,货物重量,长,宽,高,体积,货物信息,包装选择,预计到达时间,寄件单生成日期,快递员姓名"+" FROM 快递单"+" WHERE 订单条形码号='"+goodsID+"'";
		ResultSet rs=mysqlimp.query(find);
		rs.next();
		this.dilivername=rs.getString(1);
		this.diliveraddress=rs.getString(2);
		this.diliverworkspace=rs.getString(3);
		this.dilivermobile=rs.getString(4);
		this.receivername=rs.getString(5);
		this.receiveraddress=rs.getString(6);
		this.receiverworkspace=rs.getString(7);
		this.receivermobile=rs.getString(8);
		this.wrappedfee=rs.getDouble(9);
		this.totalfee=rs.getDouble(10);
		this.receivedtime=rs.getString(11);
		this.receivedmoney=rs.getDouble(12);
		this.goodsname=rs.getString(13);
		this.goodsnumber=rs.getInt(14);
		this.length=rs.getDouble(15);
		this.width=rs.getDouble(16);
		this.height=rs.getDouble(17);
		this.v=rs.getDouble(18);
		this.goodsinfo=rs.getString(19);
		this.wrappedtype=rs.getString(20);
		this.expectedtime=rs.getString(21);
		this.generatetime=rs.getString(22);
		this.courier=rs.getString(23);
		GoodsDocuPO goodsdocuPO=new GoodsDocuPO(dilivername,diliveraddress,diliverworkspace,
			dilivermobile,receivername,receiveraddress,receiverworkspace,receivermobile,wrappedfee,
			totalfee,expresstype,goodsID,receivedtime,receivedmoney,goodsname,goodsnumber,length,width,height,v,goodsinfo,wrappedtype,expectedtime,generatetime,courier);
		return goodsdocuPO;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Class has some problem in GoodsDocu!");
		return new GoodsDocuPO("不存在","","",
				"","","","","",0,
				0,"","","",0,"",0,0,0,0,0,"","","","","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Some MySql problem has happened in GoodsDocu!");
		return new GoodsDocuPO("不存在","","",
				"","","","","",0,
				0,"","","",0,"",0,0,0,0,0,"","","","","");
	}
	
}

public void insert(GoodsDocuPO po) throws RemoteException {
	// TODO Auto-generated method stub
	this.dilivername=po.getDilivername();
	this.diliveraddress=po.getDiliveraddress();
	this.diliverworkspace=po.getDiliverworkspace();
	this.dilivermobile=po.getDilivermobile();
	this.receivername=po.getReceivername();
	this.receiveraddress=po.getReceiveraddress();
	this.receiverworkspace=po.getReceiverworkspace();
	this.receivermobile=po.getReceivermobile();
	this.wrappedfee=po.getWrappedfee();
	this.totalfee=po.getTotalfee();
	this.expresstype=po.getExpresstype();
	this.receivedtime=po.getReceivedtime();
	this.receivedmoney=po.getReceivedmoney();
	this.goodsID=po.getGoodsID();
	this.goodsname=po.getGoodsname();
	this.goodsnumber=po.getGoodsnumber();
	this.length=po.getLength();
	this.width=po.getWidth();
	this.height=po.getHeight();
	this.v=po.getV();
	this.goodsinfo=po.getGoodsinfo();
	this.wrappedtype=po.getWrappedtype();
	this.expectedtime=po.getExpectedtime();
	this.generatetime=po.getGeneratetime();
	this.courier=po.getCourier();
	String insert="INSERT INTO 快递单"+" (寄件人姓名,寄件人地址,寄件人单位,寄件人电话,寄件人手机,收件人姓名,收件人地址,收件人单位,收件人电话,收件人手机,"
			+ "包装费,合计费用,快递类型,订单条形码号,收件日期,收款金额,货物名称,货物数量,货物重量,长,宽,高,体积,货物信息,包装选择,预计到达时间,寄件单生成日期,快递员姓名)"+" VALUES('"+dilivername+"','"+diliveraddress+"','"+diliverworkspace+"','"+diliverhomephone+"','"+receivername+"','"+receiveraddress+"','"+receiverworkspace+"','"+receiverhomephone+"','"+receivermobile+"',"+wrappedfee+","+totalfee+",'"+expresstype+"','"+goodsID+"','"+receivedtime+"',"+receivedmoney+","
					+ "'"+goodsname+"','"+goodsnumber+"',"+length+","+width+","+height+","+v+",'"+goodsinfo+"','"+wrappedtype+"','"+expectedtime+"','"+generatetime+"','"+courier+"')";
	try {
		mysqlimp=new MySqlImp();
		mysqlimp.update(insert);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Class has some problem in GoodsDocu!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Some MySql problem has happened in GoodsDocu!");
	}
}
	
public void delete(String goodsID) throws RemoteException {
	// TODO Auto-generated method stub
	try {
		mysqlimp=new MySqlImp();
		String delete="DELETE FROM 快递单"+" WHERE 订单条形码号='"+goodsID+"'";
		mysqlimp.update(delete);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Class has some problem in GoodsDocu!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Some MySql problem has happened in GoodsDocu!");
	}
}

public void update(GoodsDocuPO pos) throws RemoteException {
	// TODO Auto-generated method stub
		GoodsDocu goods=new GoodsDocu();
		goods.delete(pos.getGoodsID());
		goods.insert(pos);
}

public ArrayList<GoodsDocuPO> findmore() throws RemoteException {
	// TODO Auto-generated method stub
	try {
		mysqlimp=new MySqlImp();
		goodsList=new ArrayList<GoodsDocuPO>();
		String findmore="SELECT *"+" FROM 快递单";
		ResultSet rs=mysqlimp.query(findmore);
		while(rs.next()){
			this.dilivername=rs.getString(1);
			this.diliveraddress=rs.getString(2);
			this.diliverworkspace=rs.getString(3);
			this.dilivermobile=rs.getString(4);
			this.receivername=rs.getString(5);
			this.receiveraddress=rs.getString(6);
			this.receiverworkspace=rs.getString(7);
			this.receivermobile=rs.getString(8);
			this.wrappedfee=rs.getDouble(9);
			this.totalfee=rs.getDouble(10);
			this.receivedtime=rs.getString(11);
			this.receivedmoney=rs.getDouble(12);
			this.goodsname=rs.getString(13);
			this.goodsnumber=rs.getInt(14);
			this.length=rs.getDouble(15);
			this.width=rs.getDouble(16);
			this.height=rs.getDouble(17);
			this.v=rs.getDouble(18);
			this.goodsinfo=rs.getString(19);
			this.wrappedtype=rs.getString(20);
			this.expectedtime=rs.getString(21);
			this.generatetime=rs.getString(22);
			this.courier=rs.getString(23);
			goodsList.add(new GoodsDocuPO(dilivername,diliveraddress,diliverworkspace,
					dilivermobile,receivername,receiveraddress,receiverworkspace,receivermobile,wrappedfee,
					totalfee,expresstype,goodsID,receivedtime,receivedmoney,goodsname,goodsnumber,length,width,height,v,goodsinfo,wrappedtype,expectedtime,generatetime,courier));
		}
		return goodsList;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Class has some problem in GoodsDocu!");
		return null;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Some MySql problem has happened in GoodsDocu!");
		return null;
	}
	
}
}
