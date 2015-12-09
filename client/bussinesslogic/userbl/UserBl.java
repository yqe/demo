
/**
 * @author acer-pc
 *
 */

package userbl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.EmploeePO;
import po.UserInfoPO;
import userblService.UserBlService;

public class UserBl implements UserBlService {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String hostid = "localhost";
	/**
	 * 根据id，密码，查找用户登录信息;
	 * 
	 * @param String id, String password;
	 * @return String;
	 * @exception @author
	 *                zxc
	 */
	public String look(String id, String password) {
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("GetAccount");
			oos.writeObject(new UserInfoPO(id, password, "", ""));
			UserInfoPO upo = (UserInfoPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
			if (password.equals(upo.getPassword()))
				return upo.getPosition();
			else if (upo == null)
				return "NoAccount";// 无账户
			else
				return "PasswordError";// 密码错误
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据id查找用户信息;
	 * 
	 * @param String id;
	 * @return UserInfoPO;
	 * @exception @author
	 *                zxc
	 */
	public UserInfoPO CheckUserInfoPO(String id){
		UserInfoPO upo=null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("GetAccount");
			oos.writeObject(new UserInfoPO(id, "", "", ""));
			upo = (UserInfoPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upo;
	}
	/**
	 * 根据id查找用户信息;
	 * @param String id, String password;
	 * @return String;
	 * @exception @author
	 *                zxc
	 */
	public UserInfoPO GetUserAccount(String id) {
		UserInfoPO upo = null;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("GetAccount");
			oos.writeObject(new UserInfoPO(id, "", "", ""));
			upo = (UserInfoPO) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upo;
	}
	/**
	 * 权限调整;
	 * @param UserInfoPO upo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean positionTransfer(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("PowerChange");
			oos.writeObject(upo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
	/**
	 * 修改密码;
	 * @param UserInfoPO upo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean changePassword(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("PasswordChange");
			oos.writeObject(upo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
			return IsOk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}

	/**
	 * 删除用户;
	 * @param UserInfoPO upo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean cancellation(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("DeleteAcc");
			oos.writeObject(upo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
	/**
	 * 增加用户;
	 * @param UserInfoPO upo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean AddUser(UserInfoPO upo) {
		boolean IsOk = false;
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("AddAccount");
			oos.writeObject(upo);
			IsOk = (boolean) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsOk;
	}
	/**
	 * 根据姓名返回给客户端雇员信息;
	 * @param String name;
	 * @return String;
	 * @exception @author
	 *                zxc
	 */
	public String GetPosID(String userid) {
		String posid = "";
		try {
			String name=GetUserAccount(userid).getUsername();
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("Admin");
			oos.writeUTF("GetEmloyeePO");
			oos.writeObject(new String(name));
			posid=(String)ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posid;
	}
}
