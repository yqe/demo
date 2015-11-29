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
		InputStorageDocu inputdocu=new InputStorageDocu();
		inputdocu.finddataname(inslt);
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
				String insert="INSERT INTO '"+transcentername+"'"+" (快递编号,入库日期,目的地,区号,排号,架号,位号,中转中心编号）"+" VALUES（'"+goodsID+"','"+intime+"','"+destination+"','"+area+"','"+queue+"','"+shelf+"','"+local+"','"+transcenterID+"')";
				//数据库中生成一条入库单
				String insertintocheck="INSERT INTO '"+transcentercheckname+"'"+" (快递编号,区号,排号,架号,位号,入库日期)"+" VALUES('"+goodsID+"','"+area+"','"+queue+"','"+shelf+"','"+local+"','"+intime+"')";
				//库存盘点中生成一条记录
				mysqlimp.update(insert);
				mysqlimp.update(insertintocheck);
				i--;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StorageList StorageDataCheck() {
		// TODO Auto-generated method stub
		return null;
	}
	//返回入库单中的所有单据
	public ArrayList<InputStorageDocuPO> StorageDataSee(String transcenterID) {
		// TODO Auto-generated method stub
		InputStorageDocu inputdocu=new InputStorageDocu();
		inputdocu.findnamebyID(transcenterID);
		try {
			ArrayList<InputStorageDocuPO> insee=new ArrayList<InputStorageDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT *"+" FROM '"+transcentername+"'";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				insee.add(new InputStorageDocuPO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insee;
		
	}
	
	public void finddataname(InputStorageList inslt){
		ArrayList<InputStorageDocuPO> in=inslt.getSlist();
		InputStorageDocuPO inputpo=in.get(0);
		switch(inputpo.getTranscenterID()){
		case "025000":
			 transcentername="南京入库单";
			 transcentercheckname="南京库存盘点";
			 break;
		case "010000":
			 transcentername="北京入库单";
			 transcentercheckname="北京库存盘点";
			 break;
		case "020000":
			 transcentername="广州入库单";
			 transcentercheckname="广州库存盘点";
			 break;
		case "021000":
			 transcentername="上海入库单";
			 transcentercheckname="上海库存盘点";
			 break;
		}
			
	}
	
	public void findnamebyID(String transcenterID){
		switch(transcenterID){
		case "025000":
			 transcentername="南京入库单";
			 transcentercheckname="南京库存盘点";
			 break;
		case "010000":
			 transcentername="北京入库单";
			 transcentercheckname="北京库存盘点";
			 break;
		case "020000":
			 transcentername="广州入库单";
			 transcentercheckname="广州库存盘点";
			 break;
		case "021000":
			 transcentername="上海入库单";
			 transcentercheckname="上海库存盘点";
			 break;
		}
			
	}
}
