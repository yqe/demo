package AdminStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.UserInfoPO;
import userdata.UserData;

public class AdminInfoStream {
	UserData ud = new UserData();

	public void JudgeCmd(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			switch (ois.readUTF()) {
			case "PasswordChange":
				PasswordChange(ois, oos);
				break;
			case "PowerChange":
				PowerChange(ois, oos);
				break;
			case "DeleteAcc":
				DeleteAcc(ois, oos);
				break;
			case "AddAccount":
				AddAccount(ois, oos);
				break;
			case "GetAccount":
				GetAccount(ois, oos);
				break;
			default:
				System.out.println("NJ");
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回给客户端用户信息;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void GetAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO upoCilent = (UserInfoPO) ois.readObject();
			UserInfoPO upo = ud.getLoginPO(upoCilent.getUserID());
			oos.writeObject(upo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * 增加用户到数据库;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void AddAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			ud.insert(up);
			oos.writeObject(new Boolean(true));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用户权限调整;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void PowerChange(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			UserInfoPO up2 = ud.getLoginPO(up.getUserID());
			UserInfoPO upo = new UserInfoPO(up.getUserID(), up2.getPassword(), up2.getUsername(), up.getPosition());
			ud.update(upo);
			oos.writeObject(new Boolean(true));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 在数据库删除用户信息;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void DeleteAcc(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			ud.delete(up.getUserID());
			oos.writeObject(new Boolean(true));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 在数据库修改用户密码;
	 * 
	 * @param ObjectInputStream
	 *            ois, ObjectOutputStream oos;
	 * @exception @author
	 *                zxc
	 */
	private void PasswordChange(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			UserInfoPO up2 = ud.getLoginPO(up.getUserID());
			UserInfoPO upo = new UserInfoPO(up.getUserID(), up.getPassword(), up2.getUsername(), up2.getPosition());
			ud.update(upo);
			oos.writeObject(new Boolean(true));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
