package po;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 期初建账
 * @author jjlb
 *
 */
public class InitializeAccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankaccoundname;//银行 账户名称
	private String jigou;
	private int affair;//人员数
	private int car;//车辆数
	private int storage;//库存量
	private double money;//账户余额
	private ArrayList<InitializeAccountPO> account;
	public InitializeAccountPO(String bankaccoundname,String jigou,int affair,int car,int storage, double money)
	{ 
		this.bankaccoundname=bankaccoundname;
		this.jigou=jigou;
		this.affair=affair;
		this.car=car;
		this.storage=storage;

		this.money=money;
	}
     public String getId(){return bankaccoundname;}
     public String getJigou(){return jigou;}
     public int getAffair(){return affair;}
     public int getCar(){return car;}
     public int getStorage(){return storage;}
     public double getMoney(){return money;}
     public ArrayList<InitializeAccountPO> getAccount(){return account;}
}
