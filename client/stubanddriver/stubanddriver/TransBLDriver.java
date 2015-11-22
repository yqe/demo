package stubanddriver;

import transblService.TransBLService;



public class TransBLDriver {
	public void drive(TransBLService transsblStub){
		String info="车辆信息";
		String type="汽车",depatureplace="南京",destination="上海";
    System.out.println(transsblStub.TransMaintenance(info));
    System.out.println(transsblStub.Transgetfee(type, depatureplace, destination));
    }
}
