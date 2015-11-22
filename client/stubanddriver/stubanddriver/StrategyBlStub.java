package stubanddriver;



import java.util.ArrayList;

import vo.EmploeeVO;
import vo.StrategyVO;

public class StrategyBlStub implements strategyblService.StrategyBlService,emploeeblService.EmploeeBlService{

	public ArrayList<EmploeeVO> getEmp(String ID) {
		// TODO Auto-generated method stub
		EmploeeVO emploee = new EmploeeVO( "12324", "张三", 42, "南京营业厅", 4200);
		EmploeeVO emploees = new EmploeeVO( "12323", "张三", 43, "南京营业厅", 4200);
		ArrayList<EmploeeVO> list=new ArrayList();
		list.add(emploee);
		list.add(emploees);
		System.out.println("getemp  successfully");
		return list;
	}

	public boolean modifyEmpInfo(String ID, EmploeeVO vo) {
		// TODO Auto-generbted method stub
		System.out.println("modify successfully");
		return true;
	}

	public StrategyVO show() {
		// TODO Auto-generated method stub
		System.out.println("show all");
		return null;
	}

	public ArrayList<EmploeeVO> addEmp(String ID, String info) {
		// TODO Auto-generated method stub
		EmploeeVO emploee = new EmploeeVO( "123546", "han", 42, "营业厅", 4200);
	
		ArrayList<EmploeeVO> list=new ArrayList();
		list.add(emploee);
		System.out.println("addemp successfully");
		return list;
	}

	public boolean DeleteEmp(String ID) {
		// TODO Auto-generated method stub
		System.out.println("delette successfully");
		return true;
	}

	public void observe(String stra) {
		// TODO Auto-generated method stub
		System.out.println("observe you want");
		return;
	}

	public boolean modifySalary(String postion, Double salary) {
		// TODO Auto-generated method stub
		System.out.println("salary has been modified");
		return true;
	}

	public boolean modifyPrice(Double kilo, Double constant,
			Double uniprice) {
		// TODO Auto-generated method stub
		System.out.println("price has been modified");
		return true;
	}

	public double calPrice(double weight, String depatureplace,
			String destination, String type) {
		// TODO Auto-generated method stub
		System.out.println("2.0");
		return 2.0;
	}

	public boolean modifyDistance(String city, Double distance) {
		// TODO Auto-generated method stub
		System.out.println("distance has been modified");
		return true;
	}
	

}
