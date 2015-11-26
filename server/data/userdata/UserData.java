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
		MySqlImp mysqlimp;
		public UserInfoPO getLoginPO(String name) {
			// TODO Auto-generated method stub
			//根据id查找密码，返回一个PO
			try {
				this.username=name;
				mysqlimp=new MySqlImp();
				String getLoginPO="SELECT 账户密码"+" FROM 登录时所需信息"+" WHERE 账户ID='"+username+"'";
				ResultSet rs=mysqlimp.query(getLoginPO);
				rs.next();
				this.password=rs.getString(1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				UserInfoPO userinfo=new UserInfoPO(username,password);
				//System.out.println(password);
			return userinfo;
		}

		
}
