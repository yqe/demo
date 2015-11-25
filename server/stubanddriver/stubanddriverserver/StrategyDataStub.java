package stubanddriverserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;

public class StrategyDataStub implements strategydataService.StrategyDataService{

	public ArrayList<StrategyPO> observe() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("observe strategy successfully");
		String positiion="topmanager";
		int salary=40000;
		int constant=1000;
		ArrayList<StrategyPO> s=new ArrayList<StrategyPO>();
		s.add(new StrategyPO( positiion, salary, constant));
		return s;
	}

	public double calprice(double weight, String departureplace,
			String destination) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("30.2");
		return 30.1;
	}

	public void update(String position, int salary, int constant) {
		// TODO Auto-generated method stub
		
	}

	public void updatesalary(String pos, int sal) {
		// TODO Auto-generated method stub
		
	}

	public void updateconstant(int cons) {
		// TODO Auto-generated method stub
		
	}

}
