package strategybl;

import strategyblService.StrategyBlService;
import vo.StrategyVO;

public class Strategy implements StrategyBlService{

	public StrategyVO show() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modifySalary(String postion, Double salary) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyPrice(Double kilo, Double constant, Double uniprice) {
		// TODO Auto-generated method stub
		return false;
	}

	public double calPrice(double weight, String depatureplace,
			String destination, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean modifyDistance(String city, Double distance) {
		// TODO Auto-generated method stub
		return false;
	}

	public void observe(String stra) {
		// TODO Auto-generated method stub
		
	}

}
