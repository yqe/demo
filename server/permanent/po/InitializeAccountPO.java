package po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitializeAccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankaccountid;//银行 账户ID
	private String jigou;
	private String affair;//人员数
	private int car;//车辆数
	private int storage;//库存量
	private double money;//账户余额
	private ArrayList<InitializeAccountPO> account;
	public InitializeAccountPO(String bankaccountid,String jigou,String affair,int car,int storage, double money)
	{ 
		this.bankaccountid=bankaccountid;
		this.jigou=jigou;
		this.affair=affair;
		this.car=car;
		this.storage=storage;

		this.money=money;
	}
     public String getId(){return bankaccountid;}
     public String getJigou(){return jigou;}
     public String getAffair(){return affair;}
     public int getCar(){return car;}
     public int getStorage(){return storage;}
     public double getMoney(){return money;}
     public ArrayList<InitializeAccountPO> getAccount(){return account;}
}
