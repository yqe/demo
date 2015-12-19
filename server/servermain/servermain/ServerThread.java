package servermain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import AdminStream.AdminInfoStream;
import CourierStream.CourierInfoStream;
import FinanceStream.FinanceInfoStream;
import HallClerkStream.HallClerkInfoStream;
import ManagerStream.ManagerInfoStream;
import StorageStream.StorageInfoStream;
import TransitStream.TransitInfoStream;

public class ServerThread implements Runnable {

	public ServerThread() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() throws Exception {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket socket;
			while (true) {
				socket = server.accept();
				if (socket != null) {
					Receiver r = new Receiver(socket);
					Thread t = new Thread(r);
					t.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Receiver implements Runnable {
		Socket socket;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		boolean login=false;

		Receiver(Socket socket) {
			this.socket = socket;
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public boolean login() {
			String logininfo = null;
			try {
				String cmd=(String) ois.readObject();
				while(cmd.equals("GetRoute")){
					new CourierInfoStream().GetRoute(ois,oos);
				}
				while (cmd.equals("login")) {
					logininfo = new AdminInfoStream().Login(ois, oos);
					if (!logininfo.equals("NoAccount") && !logininfo.equals("PasswordError"))
						return true;
				}
			} catch (ClassNotFoundException | IOException e) {
				close();
			}
			return false;
		}
		public void run() {
			while (!login)
				login = login();
			boolean isRun=true;
			while(isRun)
			try {
				switch (ois.readUTF()) {
				case "Storage":
					new StorageInfoStream().JudgeCmd(ois, oos);
					break;
				case "Admin":
					new AdminInfoStream().JudgeCmd(ois, oos);
					break;
				case "Courier":
					new CourierInfoStream().JudgeCmd(ois, oos);
					break;
				case "Finance":
					new FinanceInfoStream().JudgeCmd(ois, oos);
					break;
				case "HallClerk":
					new HallClerkInfoStream().JudgeCmd(ois, oos);
					break;
				case "Manager":
					new ManagerInfoStream().JudgeCmd(ois, oos);
					break;
				case "Transit":
					new TransitInfoStream().JudgeCmd(ois, oos);
					break;
				default:
					isRun=false;
					break;
				}
			} catch (Exception e) {
				close();
			}
		}

		private void close() {
			try {
				ois.close();
				oos.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ServerThread();
	}
}
