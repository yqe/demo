package demo.demo;
import java.rmi.RemoteException;

import datadriver.DistanceDataDriver.DistanceDataDriver;
import datadriver.GoodsDataDriver.GoodsDataDriver;
import datadriver.TransDataDriver.TransDataDriver;
import datadriver.UserDataDriver.UserDataDriver;
import Driver.goodsblDriver.GoodsBLDriver;
import Driver.transblDriver.TransBLDriver;
import Driver.userblDriver.UserblDriver;
import Stub.DistancedataStub.DistancedataStub;
import Stub.GoodsdataStub.goodsdataStub;
import Stub.UserdataStub.UserdataStub;
import Stub.goodsblStub.goodsblStub;
import Stub.transblStub.transblStub;
import Stub.transdataStub.transdataStub;
import Stub.userblStub.UserblStub;

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
