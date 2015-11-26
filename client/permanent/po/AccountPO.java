package po;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String jigou;
	private int affair;
	private int car;
	private int storage;
	private String name;
	private double money;
	private ArrayList<AccountPO> account;
	public AccountPO(long id,String jigou,int affair,int car,int storage, String name,double money)
	{ 
		this.id=id;
		this.jigou=jigou;
		this.affair=affair;
		this.car=car;
		this.storage=storage;
		this.name=name;
		this.money=money;
	}
     public long getId(){return id;}
     public String getJigou(){return jigou;}
     public int getAffair(){return affair;}
     public int getCar(){return car;}
     public int getStorage(){return storage;}
     public String getName(){return name;}
     public double getMoney(){return money;}
     public ArrayList<AccountPO> getAccount(){return account;}
}
