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
	private String transcentername;//数据库里的入库单名字
	private String transcenterID;//中转中心编号
	private String transcentercheckname;//库存盘点仓库名字
	MySqlImp mysqlimp;
	ArrayList<InputStorageDocuPO> insee;
	//生成入库单，同时自动向当地中转中心库存盘点里面添加记录
	public void InputStorageAdd(InputStorageList inslt) {
		// TODO Auto-generated method stub
		
		this.finddataname(inslt);
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
				String insert="INSERT INTO "+transcentername+""+" (快递编号,入库日期,目的地,区号,排号,架号,位号,中转中心编号）"+" VALUES（'"+goodsID+"','"+intime+"','"+destination+"','"+area+"','"+queue+"','"+shelf+"','"+local+"','"+transcenterID+"')";
				//数据库中生成一条入库单
				String insertintocheck="INSERT INTO "+transcentercheckname+""+" (快递编号,区号,排号,架号,位号,入库日期)"+" VALUES('"+goodsID+"','"+area+"','"+queue+"','"+shelf+"','"+local+"','"+intime+"')";
				//库存盘点中生成一条记录
				mysqlimp.update(insert);
				mysqlimp.update(insertintocheck);
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
	//返回入库单中的所有单据
	public ArrayList<InputStorageDocuPO> StorageDataSee(String transcenterID) {
		// TODO Auto-generated method stub
		this.findnamebyID(transcenterID);
		try {
			ArrayList<InputStorageDocuPO> insee=new ArrayList<InputStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM "+transcentername+"";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				insee.add(new InputStorageDocuPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
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
			return null;
		}
	
		
	}
	//寻找哪个中转中心
	public void finddataname(InputStorageList inslt){
		ArrayList<InputStorageDocuPO> in=inslt.getSlist();
		InputStorageDocuPO inputpo=in.get(0);
		switch(inputpo.getTranscenterID()){
		case "025000":
			 this.transcentername="南京入库单";
			 this.transcentercheckname="南京库存盘点";
			 break;
		case "010000":
			 this.transcentername="北京入库单";
			 this.transcentercheckname="北京库存盘点";
			 break;
		case "020000":
			 this.transcentername="广州入库单";
			 this.transcentercheckname="广州库存盘点";
			 break;
		case "021000":
			 this.transcentername="上海入库单";
			 this.transcentercheckname="上海库存盘点";
			 break;
		}
			
	}
	//按照中转中心编号寻找中转中心名字
	public void findnamebyID(String transcenterID){
		switch(transcenterID){
		case "025000":
			 this.transcentername="南京入库单";
			 this.transcentercheckname="南京库存盘点";
			 break;
		case "010000":
			 this.transcentername="北京入库单";
			 this.transcentercheckname="北京库存盘点";
			 break;
		case "020000":
			 this.transcentername="广州入库单";
			 this.transcentercheckname="广州库存盘点";
			 break;
		case "021000":
			 this.transcentername="上海入库单";
			 this.transcentercheckname="上海库存盘点";
			 break;
		}
		
	}
	@Override
	public int storagenum(String transcenterID, String time) {
		// TODO Auto-generated method stub
		//	返回某一时间段入库单数量
		this.findnamebyID(transcenterID);		
		try {
			int num=0;
			mysqlimp=new MySqlImp();
			String findbytime="SELECT 快递编号,入库日期,目的地,区号,排号,架号,位号,中转中心编号"+" FROM "+transcentername+" WHERE 入库日期='"+time+"'";
			ResultSet rs=mysqlimp.query(findbytime);
			while(rs.next()){
			num++;
			}
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
}
