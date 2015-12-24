package goodsblstubanddriver;

import po.ExpressTrailPO;
import goodsblService.GoodsBLService;

public class goodsblstub implements GoodsBLService {

	public String GoodsInquiry(String ID) {
		// TODO Auto-generated method stub
		ExpressTrailPO po=new ExpressTrailPO("南京", "0000000001","0032" , "13513", "上海");		
		return "";
	}

	public String[] Goodsgetinfo(String ID) {
		// TODO Auto-generated method stub
		String[] s={"dbnrt","hrt","htrhr","hrt"};
		s[0]="Goodsgetinfo Success";
		return s;
	}

	public String Goodsgetdate(String depatureplace, String destination) {
		// TODO Auto-generated method stub
		String s;
		s="2015-12-12";
		return s;
	}

	public String Goodsgetfee(Double weight, String typebox, String packbox,
			String depatureplace, String destination) {
		// TODO Auto-generated method stub
	
		
		return "12";
	}

	@Override
	public String Goodsgetdate(String depatureplace, String destination, String typebox) {
		// TODO Auto-generated method stub
		return null;
	}

}