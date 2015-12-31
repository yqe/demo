package clientmain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import login.Mdialog;

public class IntManage {
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public boolean InitInternet() {
		String hostid = new ReadIP().ReturnIP();
		try {
			socket = new Socket(hostid, 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			return true;
		} catch (IOException e) {
			Mdialog.showMessageDialog("请确认您的网络ip是否正确"+"\n"+"服务器是否开启");
			return false;
		}
	}

	public void CloseInternet(Socket socket2, ObjectOutputStream oos2, ObjectInputStream ois2) {
		try {
			oos2.writeUTF("exit");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			socket2.close();
			oos2.close();
			ois2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Socket getSocket() {
		return socket;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public ObjectInputStream getOis() {
		return ois;
	}
}
