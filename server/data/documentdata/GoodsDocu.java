package documentdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdataService.GoodsDocuService;
import goodsdata.ExpressTrail;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
import po.GoodsDocuPO;

/**
 * @author jjlb 快递单
 */
public class GoodsDocu implements GoodsDocuService {
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
	private double wrappedfee;// 包装费
	private double totalfee;// 费用合计
	private String expresstype;// 快递类型
	private String goodsID;// 订单条形码号
	private double weight;// 重量
	private String goodsname;// 货物名
	private int goodsnumber;// 货物数量
	private double length;// 长度
	private double width;// 宽//
	private double height;// 高
	private double v;// 体积
	private String goodsinfo;// 货物信息
	private String wrappedtype;// 包装种类
	private String expectedtime;// 预期到达时间
	private String generatetime;// 寄件单生成日期
	private String courier;// 快递员姓名
	private ArrayList<GoodsDocuPO> goodsList;
	MySqlImp mysqlimp;

	public GoodsDocuPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		goodsID = ID;
		try {
			mysqlimp = new MySqlImp();
			String find = "SELECT 寄件人姓名,寄件人住址,寄件人单位,寄件人手机,收件人姓名,收件人住址,收件人单位"
					+ ",收件人手机,包装费,费用合计,快递类型,订单条形码号,重量,货物名称,货物数量,长,宽,高,体积,货物信息,包装选择,预计到达时间,寄件单生成日期,快递员姓名" + " FROM 快递单"
					+ " WHERE 订单条形码号='" + goodsID + "'";
			ResultSet rs = mysqlimp.query(find);
			rs.next();
			this.dilivername = rs.getString(1);
			this.diliveraddress = rs.getString(2);
			this.diliverworkspace = rs.getString(3);
			this.dilivermobile = rs.getString(4);
			this.receivername = rs.getString(5);
			this.receiveraddress = rs.getString(6);
			this.receiverworkspace = rs.getString(7);
			this.receivermobile = rs.getString(8);
			this.wrappedfee = rs.getDouble(9);
			this.totalfee = rs.getDouble(10);
			this.expresstype = rs.getString(11);
			this.goodsID = rs.getString(12);
			this.weight = rs.getDouble(13);
			this.goodsname = rs.getString(14);
			this.goodsnumber = rs.getInt(15);
			this.length = rs.getDouble(16);
			this.width = rs.getDouble(17);
			this.height = rs.getDouble(18);
			this.v = rs.getDouble(19);
			this.goodsinfo = rs.getString(20);
			this.wrappedtype = rs.getString(21);
			this.expectedtime = rs.getString(22);
			this.generatetime = rs.getString(23);
			this.courier = rs.getString(24);
			rs.close();
			GoodsDocuPO goodsdocuPO = new GoodsDocuPO(dilivername, diliveraddress, diliverworkspace, dilivermobile,
					receivername, receiveraddress, receiverworkspace, receivermobile, wrappedfee, totalfee, expresstype,
					goodsID, weight, goodsname, goodsnumber, length, width, height, v, goodsinfo, wrappedtype,
					expectedtime, generatetime, courier);
			
			return goodsdocuPO;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Class has some problem in GoodsDocu!");
			return new GoodsDocuPO("不存在", "", "", "", "", "", "", " ", 0, 0, "", "", 0, "", 0, 0, 0, 0, 0, "", "", "",
					"", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Some MySql problem has happened in GoodsDocu!");
			return new GoodsDocuPO("不存在", "", "", "", "", "", "", " ", 0, 0, "", "", 0, "", 0, 0, 0, 0, 0, "", "", "",
					"", "");
		}

	}

	public void insert(GoodsDocuPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CondemnDocu condocu = new CondemnDocu();
		ExpressTrail expre=new ExpressTrail();
		try {
			this.dilivername = po.getDilivername();
			this.diliveraddress = po.getDiliveraddress();
			this.diliverworkspace = po.getDiliverworkspace();
			this.dilivermobile = po.getDilivermobile();
			this.receivername = po.getReceivername();
			this.receiveraddress = po.getReceiveraddress();
			this.receiverworkspace = po.getReceiverworkspace();
			this.receivermobile = po.getReceivermobile();
			this.wrappedfee = po.getWrappedfee();
			this.totalfee = po.getTotalfee();
			this.expresstype = po.getExpresstype();
			this.goodsID = po.getGoodsID();
			this.weight = po.getWeight();
			this.goodsname = po.getGoodsname();
			this.goodsnumber = po.getGoodsnumber();
			this.length = po.getLength();
			this.width = po.getWidth();
			this.height = po.getHeight();
			this.v = po.getV();
			this.goodsinfo = po.getGoodsinfo();
			this.wrappedtype = po.getWrappedtype();
			this.expectedtime = po.getExpectedtime();
			this.generatetime = po.getGeneratetime();
			this.courier = po.getCourier();
			condocu.insert(new CondemnDocuPO("快递单", goodsID, "未审批"));
			String insert = "INSERT INTO 快递单" + " (寄件人姓名,寄件人住址,寄件人单位,寄件人手机,收件人姓名,收件人住址,收件人单位,收件人手机,"
					+ "包装费,费用合计,快递类型,订单条形码号,重量,货物名称,货物数量,长,宽,高,体积,货物信息,包装选择,预计到达时间,寄件单生成日期,快递员姓名)" + " VALUES('"
					+ dilivername + "','" + diliveraddress + "','" + diliverworkspace + "','" + dilivermobile + "','"
					+ receivername + "','" + receiveraddress + "','" + receiverworkspace + "','" + receivermobile + "',"
					+ wrappedfee + "," + totalfee + ",'" + expresstype + "','" + goodsID + "'," + weight + "," + "'"
					+ goodsname + "'," + goodsnumber + "," + length + "," + width + "," + height + "," + v + ",'"
					+ goodsinfo + "','" + wrappedtype + "','" + expectedtime + "','" + generatetime + "','" + courier
					+ "')";
			//System.out.println(insert);
			mysqlimp = new MySqlImp();
			mysqlimp.update(insert);
			String track="快递编号为"+goodsID+"已出发";
			expre.insert(goodsID, track);
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
			mysqlimp = new MySqlImp();
			String delete = "DELETE FROM 快递单" + " WHERE 订单条形码号='" + goodsID + "'";
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
		GoodsDocu goods = new GoodsDocu();
		goods.delete(pos.getGoodsID());
		goods.insert(pos);
	}

	public ArrayList<GoodsDocuPO> findmore() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			mysqlimp = new MySqlImp();
			goodsList = new ArrayList<GoodsDocuPO>();
			String findmore = "SELECT *" + " FROM 快递单";
			ResultSet rs = mysqlimp.query(findmore);
			while (rs.next()) {
				this.dilivername = rs.getString(1);
				this.diliveraddress = rs.getString(2);
				this.diliverworkspace = rs.getString(3);
				this.dilivermobile = rs.getString(4);
				this.receivername = rs.getString(5);
				this.receiveraddress = rs.getString(6);
				this.receiverworkspace = rs.getString(7);
				this.receivermobile = rs.getString(8);
				this.wrappedfee = rs.getDouble(9);
				this.totalfee = rs.getDouble(10);
				this.expresstype = rs.getString(11);
				this.goodsID = rs.getString(12);
				this.weight = rs.getDouble(13);
				this.goodsname = rs.getString(14);
				this.goodsnumber = rs.getInt(15);
				this.length = rs.getDouble(16);
				this.width = rs.getDouble(17);
				this.height = rs.getDouble(18);
				this.v = rs.getDouble(19);
				this.goodsinfo = rs.getString(20);
				this.wrappedtype = rs.getString(21);
				this.expectedtime = rs.getString(22);
				this.generatetime = rs.getString(23);
				this.courier = rs.getString(24);

				goodsList.add(new GoodsDocuPO(dilivername, diliveraddress, diliverworkspace, dilivermobile,
						receivername, receiveraddress, receiverworkspace, receivermobile, wrappedfee, totalfee,
						expresstype, goodsID, weight, goodsname, goodsnumber, length, width, height, v, goodsinfo,
						wrappedtype, expectedtime, generatetime, courier));
			}
			rs.close();
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
			goodsList = new ArrayList<GoodsDocuPO>();
			goodsList.add(new GoodsDocuPO("不存在", "", "", "", "", "", "", " ", 0, 0, "", "", 0, "", 0, 0, 0, 0, 0, "", "", "",
					"", ""));
			return goodsList;
		}

	}

	@Override
	public String getgoodsidmax() {
		// TODO Auto-generated method stub
		try {
			mysqlimp=new MySqlImp();
			String getnum="SELECT MAX(订单条形码号) FROM 快递单";
			ResultSet rs=mysqlimp.query(getnum);
			rs.next();
			String max=rs.getString(1);
			return max;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "出错啦";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "出错啦";
		}
		
	}
}
