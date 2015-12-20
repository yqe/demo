package clientmain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class IntManage {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	public void InitInternet() {
		String hostid = "localhost";
		Socket socket;
		try {
			socket = new Socket(hostid, 8888);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseInternet(Socket socket2,ObjectOutputStream oos2,ObjectInputStream ois2){
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
