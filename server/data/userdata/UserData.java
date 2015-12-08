package userdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysqlimp.MySqlImp;
import po.UserInfoPO;
import userdataService.UserDataService;

public class UserData implements UserDataService{
		private String username;
		private String password;
		private String userID;
		private String position;
		MySqlImp mysqlimp;
		public UserInfoPO getLoginPO(String ID) {
			// TODO Auto-generated method stub
			//根据id查找密码，返回一个PO
			try {
				this.userID=ID;
				mysqlimp=new MySqlImp();
				String getLoginPO="SELECT 账户密码,账户人姓名,职位"+" FROM 登录时所需信息"+" WHERE 账户ID='"+userID+"'";
				ResultSet rs=mysqlimp.query(getLoginPO);
				rs.next();
				this.password=rs.getString(1);
				this.username=rs.getString(2);
				this.position=rs.getString(3);
				UserInfoPO userinfo=new UserInfoPO(userID,password,username,position);
				//System.out.println(password+username+position);
				rs.close();
				return userinfo;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Class has some problem in UserData!");
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Some MySql problem has happened in UserData!");
				return new UserInfoPO("不存在","","","");
			}
				
		}
		public void delete(String ID) {
			// TODO Auto-generated method stub
			try {
				mysqlimp=new MySqlImp();
				String delete="DELETE FROM 登录时所需信息"+" WHERE 账户ID='"+ID+"'";
				mysqlimp.update(delete);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Class has some problem in UserData!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Some MySql problem has happened in UserData!");
			}
			
		}
		public void insert(UserInfoPO po) {
			// TODO Auto-generated method stub
			try {
				mysqlimp=new MySqlImp();
				this.userID=po.getUserID();
				this.password=po.getPassword();
				this.username=po.getUsername();
				this.position=po.getPosition();
				String insert="INSERT INTO 登录时所需信息"+" (账户ID,账户密码,账户人姓名,职位)"+" VALUES('"+userID+"','"+password+"','"+username+"','"+position+"')";
				//System.out.println(insert);
				mysqlimp.update(insert);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Class has some problem in UserData!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Some MySql problem has happened in UserData!");
			}
		}
		public void update(UserInfoPO po) {
			// TODO Auto-generated method stub
			UserData user=new UserData();
			user.delete(po.getUserID());
			user.insert(po);
		}

		
}
