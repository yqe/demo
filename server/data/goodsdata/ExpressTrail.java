package goodsdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.ExpressTrailPO;

/**
 * @author jjlb
 *货运轨迹
 */
public class ExpressTrail {
	private String goodsID;//编号
	private String trail;//货运轨迹
	MySqlImp mysqlimp;
	
	//生成单据是自动调用该方法，向数据库中插入轨迹
	public void set(String goodsID,String trailtype,String track){
		try {
			
			mysqlimp=new MySqlImp();
			String set="UPDATE 货运轨迹"+" SET "+trailtype+"='"+track+"' WHERE 快递编号='"+goodsID+"'";
			mysqlimp.update(set);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//得到轨迹
	public ExpressTrailPO find(String goodsID){
		try {
			ExpressTrailPO exprepo;
			mysqlimp=new MySqlImp();
			String find="SELECT * FROM 货运轨迹"+" WHERE 快递编号='"+goodsID+"'";
			ResultSet rs=mysqlimp.query(find);
			rs.next();
			exprepo=new ExpressTrailPO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			rs.close();
			return exprepo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ExpressTrailPO("不存在","","", "","");
		}
	}
	
	//生成快递单时自动调用
	public void insert(String goodsID,String track){
		try {
			mysqlimp=new MySqlImp();
			String insert="INSERT INTO 货运轨迹"+" (快递编号,出发地)"+" VALUES('"+goodsID+"','"+track+"')";
			mysqlimp.update(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("trail problem mysql");
		}
	}
}
