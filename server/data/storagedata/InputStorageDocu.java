package storagedata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import documentdata.CondemnDocu;
import goodsdata.ExpressTrail;
import mysqlimp.MySqlImp;
import po.CondemnDocuPO;
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
	private String transcenterID;//中转中心编号
	private String transcentername;//中转中心名字
	MySqlImp mysqlimp;
	ArrayList<InputStorageDocuPO> insee;
	//生成入库单，同时自动向当地中转中心库存盘点里面添加记录
	public void InputStorageAdd(InputStorageList inslt) {
		// TODO Auto-generated method stub
		this.findnamebyID(inslt.getSlist().get(0).getTranscenterID());
		CondemnDocu condocu=new CondemnDocu();
		ExpressTrail expre=new ExpressTrail();
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
				this.transcenterID=inpo.getTranscenterID();
				condocu.insert(new CondemnDocuPO("入库单",goodsID, "未审批"));
				String insert="INSERT INTO 入库单"+" (快递编号,入库日期,目的地,区号,排号,架号,位号,中转中心编号）"+" VALUES（'"+goodsID+"','"+intime+"','"+destination+"','"+area+"','"+queue+"','"+shelf+"','"+local+"','"+transcenterID+"')";
				//数据库中生成一条入库单
				String insertintocheck="INSERT INTO 库存盘点"+" (快递编号,区号,排号,架号,位号,入库日期,中转中心编号)"+" VALUES('"+goodsID+"','"+area+"','"+queue+"','"+shelf+"','"+local+"','"+intime+"','"+transcenterID+"')";
				//库存盘点中生成一条记录
				String track="快件已到达"+transcentername;
				
				mysqlimp.update(insert);//向数据库插入一条记录
				mysqlimp.update(insertintocheck);
				expre.set(inpo.getGoodsID(), "中转中心轨迹", track);//插入一条货运轨迹记录
				i--;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in InputStorageDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in InputStorageDocu!");
		}
	}
		//删除，但是单据要保存~~暂时没用
	public void InputStorageDelete(String goodsID) {
		// TODO Auto-generated method stub
		
		try {
			mysqlimp=new MySqlImp();
			String delete="DELETE FROM 入库单"+" WHERE 快递编号='"+goodsID+"'";
			mysqlimp.update(delete);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in InputStorageDocu!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in InputStorageDocu!");
		}
	}

	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		return null;
	}
	//返回入库单中转中心中的所有单据
	public ArrayList<InputStorageDocuPO> StorageDataSee(String transcenterID) {
		// TODO Auto-generated method stub
		try {
			ArrayList<InputStorageDocuPO> insee=new ArrayList<InputStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM 入库单"+" WHERE 中转中心编号='"+transcenterID+"'";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				insee.add(new InputStorageDocuPO(rs.getString(1),rs.getDate(2).toString(),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			rs.close();
			return insee;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in InputStorageDocu!");
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in InputStorageDocu!");
			ArrayList<InputStorageDocuPO> insee=new ArrayList<InputStorageDocuPO>();
			insee.add(new InputStorageDocuPO("不存在", "", "", "", "", "", "", ""));
			return insee;
		}
	
		
	}
	
	//一段时间内某个中转中心的入库数量
	
	@Override
	public int storagenum(String transcenterID, String timebegin,String timeend) {
		// TODO Auto-generated method stub
		//	返回某一时间段入库单数量
		try {
			int num=0;
			mysqlimp=new MySqlImp();
			String findbytime="SELECT 快递编号,入库日期,目的地,区号,排号,架号,位号,中转中心编号"+" FROM 入库单"+" WHERE 入库日期>='"+timebegin+"' and 入库日期<='"+timeend+"' and 中转中心编号='"+transcenterID+"'";
			ResultSet rs=mysqlimp.query(findbytime);
			while(rs.next()){
			num++;
			}
			rs.close();
			return num;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class has some problem in InputStorageDocu!");
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some MySql problem has happened in InputStorageDocu!");
			return 0;
		}
		
		
	}
	
	//根据ID找中转中心名字
	public void findnamebyID(String transID) {
		switch (transID) {
		case "025000":
			transcentername = "南京中转中心";
			break;
		case "010000":
			transcentername = "北京中转中心";
			break;
		case "020000":
			transcentername = "广州中转中心";
			break;
		case "021000":
			transcentername = "上海中转中心";
			break;
		}
	}
}
