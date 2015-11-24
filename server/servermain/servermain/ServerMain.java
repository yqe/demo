package servermain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import StorageStream.StorageinfoStream;

public class ServerMain {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8889);
			Socket socket = server.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String cmd=ois.readUTF();
			if(cmd.equals("Storage")){
				StorageinfoStream ss=new StorageinfoStream();
				if(ois.readUTF().equals("InStorageInput")){
					ss.InStorageInfoGet(ois);
				}
			}
			ois.close();
//			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
