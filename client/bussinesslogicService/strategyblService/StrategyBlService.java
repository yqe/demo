/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package strategyblService;

import java.util.ArrayList;

import po.StrategyPO;


public interface StrategyBlService{
		
	public ArrayList<StrategyPO> show();
	//显示查看内容
	
	public boolean modifySalary(StrategyPO spo);
	
	public double calPrice(double weight,String depatureplace,String destination,String type);
	//根据快递 重量距离，类型计算出快递费
	
	public boolean modifyDistance(String city,Double distance);
	//修改营业厅距离
	
	public void observe(String stra);
	//查看经营策略
}