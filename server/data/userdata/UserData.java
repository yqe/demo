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
				String getLoginPO="SELECT 账户密码,账户人姓名,职位"+" FROM 登录时所需信息"+" WHERE 账户ID='"+username+"'";
				ResultSet rs=mysqlimp.query(getLoginPO);
				rs.next();
				this.password=rs.getString(1);
				this.username=rs.getString(2);
				this.position=rs.getString(3);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
				UserInfoPO userinfo=new UserInfoPO(userID,password,username,position);
				System.out.println(password);
			return userinfo;
		}
		public void delete(String ID) {
			// TODO Auto-generated method stub
			try {
				mysqlimp=new MySqlImp();
				String delete="DELETE FROM 登录时所需信息"+" WHERE 账户ID='"+ID+"'";
				mysqlimp.update(delete);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				String insert="INSERT INTO 登录时所需信息"+" (账户ID,账户密码,账户人姓名,职位)"+" VALUES('"+username+"','"+password+"'，'"+username+"','"+position+"')";
				mysqlimp.update(insert);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void update(UserInfoPO po) {
			// TODO Auto-generated method stub
			UserData user=new UserData();
			user.delete(po.getUserID());
			user.insert(po);
		}

		
}
