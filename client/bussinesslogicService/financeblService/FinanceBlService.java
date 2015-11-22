/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package financeblService;




public interface FinanceBlService {
	public void getIncome(long inNumber[]);//计算总收入
	public void getProfit(long outNumber[]);//计算总支出及总利润
	public void account(String name);//期初建账
	public void add(long id);//增加账户
	public void delete(long id);//删除账户
	public void modify(long id);//修改账户
	public void look(long id);//查询账户
}
