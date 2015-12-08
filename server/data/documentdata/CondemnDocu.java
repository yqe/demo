package documentdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.CondemnDocuPO;

public class CondemnDocu {

	private String type;//单据类型o
	private String ID;//单据编号
	private String state;//审批状态
	MySqlImp mysqlimp;
	public ArrayList<CondemnDocuPO> findall(){
		try {
			ArrayList<CondemnDocuPO> conList=new ArrayList<CondemnDocuPO>();
			mysqlimp=new MySqlImp();
			String findall="SELECT * FROM 审批单据"+" WHERE 状态=未审批";
			ResultSet rs=mysqlimp.query(findall);
			while(rs.next()){
				conList.add(new CondemnDocuPO(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
			rs.close();
			return conList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public void insert(CondemnDocuPO po){
		try {
			this.type=po.getType();
			this.ID=po.getID();
			this.state=po.getState();
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 审批单据"+" (单据类型,编号,状态)"+" VALUES('"+type+"','"+ID+"','"+state+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(){
		try {
			mysqlimp=new MySqlImp();
			String set="UPDATE 审批单据"+" SET 状态=已审批";
			mysqlimp.update(set);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
