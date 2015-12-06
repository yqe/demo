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

	private void GetAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO upoCilent = (UserInfoPO)ois.readObject();
			UserInfoPO upo = ud.getLoginPO(upoCilent.getUserID());
			oos.writeObject(upo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void AddAccount(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			ud.insert(up);
			oos.writeBoolean(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void PowerChange(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			UserInfoPO up2 = ud.getLoginPO(up.getUserID());
			if (up2 == null) {
				oos.writeBoolean(false);
			} else {
				UserInfoPO upo = new UserInfoPO(up.getUserID(), up2.getPassword(), up2.getUsername(), up.getPosition());
				ud.update(upo);
				oos.writeBoolean(true);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void DeleteAcc(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			if (ud.getLoginPO(up.getUserID()) == null) {
				oos.writeBoolean(false);
			} else {
				ud.delete(up.getUserID());
				oos.writeBoolean(true);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void PasswordChange(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			UserInfoPO up = (UserInfoPO) ois.readObject();
			UserInfoPO up2 = ud.getLoginPO(up.getUserID());
			// TODO
			if (up2 == null) {
				oos.writeBoolean(false);
			} else {
				UserInfoPO upo = new UserInfoPO(up.getUserID(), up.getPassword(), up2.getUsername(), up2.getPosition());
				ud.update(upo);
				oos.writeBoolean(true);
				oos.writeObject(upo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
