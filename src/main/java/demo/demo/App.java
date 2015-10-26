package demo.demo;
import java.rmi.RemoteException;

import transbl.TransBLDriver;
import transbl.transblStub;
import transdata.TransDataDriver;
import transdata.transdataStub;
import userbl.UserblDriver;
import userbl.UserblStub;
import userdata.UserDataDriver;
import userdata.UserdataStub;
import distancedata.DistanceDataDriver;
import distancedata.DistancedataStub;
import goodsbl.GoodsBLDriver;
import goodsbl.goodsblStub;
import goodsdata.GoodsDataDriver;
import goodsdata.goodsdataStub;


public class App {
	public static void main(String[]args) throws RemoteException{
		goodsblStub goodsblstub=new goodsblStub();
		GoodsBLDriver goodbldriver=new GoodsBLDriver();
		goodbldriver.drive(goodsblstub);
		transblStub tranblstub=new transblStub();
		TransBLDriver transbldriver=new TransBLDriver();
		transbldriver.drive(tranblstub);
		UserblStub userblstub=new UserblStub();
		UserblDriver userbldriver=new UserblDriver();
		userbldriver.drive(userblstub);
		
		
		TransDataDriver transdatadriver=new TransDataDriver();
		transdataStub transdatastub=new transdataStub();
		transdatadriver.drive(transdatastub);
		goodsdataStub goodsdatastub=new goodsdataStub();
		GoodsDataDriver goodsdatadriver=new GoodsDataDriver();
		goodsdatadriver.drive(goodsdatastub);
		DistancedataStub distancedatastub=new DistancedataStub();
	    DistanceDataDriver distancedatadriver=new DistanceDataDriver();
		distancedatadriver.drive(distancedatastub);
		UserdataStub userdatastub=new UserdataStub();
		UserDataDriver userdatadriver=new UserDataDriver();	
		userdatadriver.drive(userdatastub);
		
		
	}
}
