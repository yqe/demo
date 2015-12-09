package clientmain;

import java.io.IOException;

import login.loginframe;

public class ClientMain {
	
	public static void main(String[] args) {
		loginframe login=new loginframe();
		try {
			login.Frame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
