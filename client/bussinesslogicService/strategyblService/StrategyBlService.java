/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package strategyblService;

import vo.StrategyVO;


public interface StrategyBlService{
		
	public StrategyVO show();
	//显示查看内容
	
	
	
	public boolean modifySalary(String postion,Double salary);
	//修改薪水信息
	
	public boolean modifyPrice(Double kilo,Double constant,Double uniprice);
	//修改快递费价格，计算方式
	
	public double calPrice(double weight,String depatureplace,String destination,String type);
	//根据快递 重量距离，类型计算出快递费
	
	
	public boolean modifyDistance(String city,Double distance);
	//修改营业厅距离
	
	public void observe(String stra);
	//查看经营策略
}