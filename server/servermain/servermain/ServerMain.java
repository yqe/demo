package servermain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
//		s	Socket socket = server.accept();
//			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
