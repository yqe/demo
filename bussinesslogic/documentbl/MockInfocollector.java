package documentbl;

public class MockInfocollector extends Infocollector {
	int time;
	String custom;
	String chome;
	String cworkplace;
	String ctelephone;
	String receiver;
	String rhome;
	String rworkplace;
	String rtelephone;
	String goodstype;
	String yytID;
	String depar;
	String destination;
	String jianzhuang;
	String yayun;
	String transID;
	String godocuID;
	double price;
	public MockInfocollector(int time,String yytID,String depar,String destination,String jianzhuang,String yayun,String transID,double price){
		this.time=time;
		this.yytID=yytID;
		this.depar=depar;
		this.destination=destination;
		this.jianzhuang=jianzhuang;
		this.yayun=yayun;
		this.transID=transID;
		this.price=price;
	}
//	public  getprice(){
//		return price;
//	}
	public MockInfocollector(String custom,String chome,String cworkplace,String ctelephone,String receiver,String rhome,String rworkplace,String rtelephone,String goodstype,String godocuID,double price){
		this.custom=custom;
		this.chome=chome;
		this.cworkplace=cworkplace;
		this.ctelephone=ctelephone;
		this.receiver=receiver;
		this.rhome=rhome;
		this.rtelephone=rtelephone;
		this.rworkplace=rworkplace;
		this.price=price;
	}
	
}
