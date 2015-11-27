package po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitializeAccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankaccountid;
	private String jigou;
	private String affair;
	private int car;
	private int storage;
	private String name;
	private double money;
	private ArrayList<InitializeAccountPO> account;
	public InitializeAccountPO(String bankaccountid,String jigou,String affair,int car,int storage, String name,double money)
	{ 
		this.bankaccountid=bankaccountid;
		this.jigou=jigou;
		this.affair=affair;
		this.car=car;
		this.storage=storage;
		this.name=name;
		this.money=money;
	}
     public String getId(){return bankaccountid;}
     public String getJigou(){return jigou;}
     public String getAffair(){return affair;}
     public int getCar(){return car;}
     public int getStorage(){return storage;}
     public String getName(){return name;}
     public double getMoney(){return money;}
     public ArrayList<InitializeAccountPO> getAccount(){return account;}
}
