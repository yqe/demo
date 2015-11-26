package po;

import java.io.Serializable;

public class IncomePO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String date;
	private double cash;
	private String  shoukuanren;
	private String barcode;
	public IncomePO(String date,double cash,String  shoukuanren,String barcode){
		this.date=date;
		this.cash=cash;
		this.shoukuanren=shoukuanren;
		this.barcode=barcode;
	}
	 public String getDate(){return date;}
	 public double getCash(){return cash;}
	 public String getShoukuanren(){return shoukuanren;}
	 public String getBarcode(){return barcode;}
}
