package org.server;

import java.rmi.RemoteException;

import distancedata.DistanceData;
import managedata.ManageCostData;
import po.EmploeePO;
import po.UserInfoPO;
import storagedata.InputStorageDocu;
import strategydata.EmploeeData;
import strategydata.StrategyData;
import userdata.UserData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StrategyData s=new StrategyData();
        EmploeeData d=new EmploeeData();
        DistanceData dis=new DistanceData();
        UserData	u=new UserData();
        ManageCostData ma=new ManageCostData();
        InputStorageDocu input=new InputStorageDocu();
        try {
			//s.observe(); 
			//s.updatesalary("总经理", 50000);
			//s.updateconstant(30);
			//d.find("114500");
			//d.delete("114500");
			//d.insertEmp(new EmploeePO("总经理","114500","啊皮豪",50000,"男",20,"15111001110","321282199605111140","江苏省常熟市虞山镇大皮村1号"));
			//d.update(new EmploeePO("总经理","114500","啊皮豪",50000,"女",20,"15111001110","321282199605111140","江苏省常熟市虞山镇大皮村1号"));
        	//dis.getdistance("天津", "北京");
			//u.getLoginPO("24");
			//u.delete("1124");
			//u.insert(new UserInfoPO("1124","5678"));
			//ma.find();
        	//u.update(new UserInfoPO("1124","2","jj","tt"));
        	//input.storagenum("010000", "20151124");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
