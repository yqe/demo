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
					r.login();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Receiver {
		Socket socket;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		Receiver(Socket socket) {
			this.socket = socket;
		}

		public void login() {
			String logininfo = null;
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				if (((String) ois.readObject()).equals("login"))
					logininfo = new AdminInfoStream().Login(ois, oos);
				if (!logininfo.equals("NoAccount") && !logininfo.equals("PasswordError"))
					dealcmd(ois,oos);
				else
					login();
			} catch (Exception e) {
				login();
			}
		}

		public void dealcmd(ObjectInputStream ois,ObjectOutputStream oos) {
			 System.out.println("csd");
			while (true) {
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
						break;
					}
//					ois.close();
//					oos.close();
//					socket.close();
				} catch (Exception e) {
					try {
						ois.close();
						oos.close();
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new ServerThread();
	}
}
