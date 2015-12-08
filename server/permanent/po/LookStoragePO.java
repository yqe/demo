package po;

import java.io.Serializable;

public class LookStoragePO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int intputnum;//入库数量
	private int outputnum;//出库数量
	private int storednum;//库存数量
	private double money;//库存里的快递金额
	public LookStoragePO(int inputnum,int outnum,int snum,double money){
		this.intputnum=inputnum;
		this.outputnum=outnum;
		this.storednum=snum;
		this.money=money;
	}
	public int getIntputnum() {
		return intputnum;
	}
	public int getOutputnum() {
		return outputnum;
	}
	public int getStorednum() {
		return storednum;
	}
	public double getMoney() {
		return money;
	}
}
