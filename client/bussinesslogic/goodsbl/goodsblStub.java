package goodsbl;

import goodsblService.GoodsBLService;

public class goodsblStub implements GoodsBLService {

	public String GoodsInquiry(String ID) {
		// TODO Auto-generated method stub
		String s;
		s="GoodsInquiry Success";
		return s;
	}

	public String Goodsgetinfo(String ID) {
		// TODO Auto-generated method stub
		String s;
		s="Goodsgetinfo Success";
		return s;
	}

	public String Goodsgetfee(Double weight, String depatureplace,
			String destination) {
		// TODO Auto-generated method stub
		String s;
		s="Goodsgetfee Success";
		return s;
	}

	public String Goodsgetdate(String depatureplace, String destination) {
		// TODO Auto-generated method stub
		String s;
		s="Goodsgetdate Success";
		return s;
	}

}
