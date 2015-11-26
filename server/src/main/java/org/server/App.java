package org.server;

import java.rmi.RemoteException;

import distancedata.DistanceData;
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
        try {
			s.observe(); 
			d.find("114500");
			dis.getdistance("天津", "北京");
			u.getLoginPO("1124");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
