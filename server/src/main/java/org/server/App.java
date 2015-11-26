package org.server;

import java.rmi.RemoteException;

import distancedata.DistanceData;
import strategydata.EmploeeData;
import strategydata.StrategyData;

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
        try {
			s.observe(); 
			d.find("114500");
			dis.getdistance("天津", "北京");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
