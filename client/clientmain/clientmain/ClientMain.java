package clientmain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import login.loginframe;

public class ClientMain {
	public static void main(String[] args) {

		IntManage client = new IntManage();
		System.out.println(client.getSocket());
		if (client.InitInternet()) {
			loginframe login = new loginframe(client.getSocket(), client.getOos(), client.getOis());
			try {
				login.Frame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
