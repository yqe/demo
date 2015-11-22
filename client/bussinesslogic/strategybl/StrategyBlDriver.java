package strategybl;

import vo.EmploeeVO;

public class StrategyBlDriver {
  public void drive(strategyblService.StrategyBlService StrategyBlStub){
	  double weight=20.0;
	  String depatureplace="南京";
	  String destination="北京";
	  String city="peking";
	  double distance=20000.0;
	  String type="特快";
	  StrategyBlStub.calPrice(weight, depatureplace, destination, type);
	  StrategyBlStub.modifyDistance(city, distance);
	  StrategyBlStub.modifyPrice(2000.0, 3231.0, 3445.0);
	  StrategyBlStub.modifySalary("总经理", 100000000.0);
	  StrategyBlStub.show();
	  StrategyBlStub.observe("salary");
}
  public void drive1(emploeeblService.EmploeeBlService StrategyBlStub){
	  StrategyBlStub.getEmp("21324");
	  StrategyBlStub.modifyEmpInfo("233444",  new EmploeeVO( "12323", "张三", 43, "南京营业厅", 4200));
	  StrategyBlStub.addEmp("23142", "ygegh");
	  StrategyBlStub.DeleteEmp("231421");
  }
}