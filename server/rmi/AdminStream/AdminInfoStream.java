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
			default:
				break;
			}
		} catch (IOException e) {
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
			// TODO
			if (ud.getLoginPO(up.getUserID()) == null) {
				oos.writeBoolean(false);
			} else {
				ud.update(up);
				oos.writeBoolean(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
