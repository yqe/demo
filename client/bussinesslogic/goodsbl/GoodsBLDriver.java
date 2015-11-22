package goodsbl;

import goodsblService.GoodsBLService;

public class GoodsBLDriver {
    public void drive(GoodsBLService goodsblStub){
    	String ID="1234567890";
    	double weight=20;
    	String depatureplace="南京";
    	String destination="上海";
    	System.out.println(goodsblStub.GoodsInquiry(ID));
    	System.out.println(goodsblStub.Goodsgetinfo(ID));
    	System.out.println(goodsblStub.Goodsgetfee(weight, depatureplace, destination));
    	System.out.println(goodsblStub.Goodsgetdate(depatureplace, destination));
    	
    }
}
