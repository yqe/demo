


package financebl;
import financeblService.FinanceBlService;
public class FinanceBlDriver {
	public void drive(FinanceBlService FinanceBlStub ){
	//public void getIncome(longinNumber[]);//计算总收入
	//public void getProfit(long outNumber[]);//计算总支出及总利润
	//public void account(String name);//期初建账
	//public void add(long id);//增加账户
	//public void delete(long id);//删除账户
	//public void modify(long id);//修改账户
	//public void look(long id);//查询账户
	String name="张三";
	long id1=1333333;long id2=2333333;
	long id3=3333333;long id4=4333333;
	FinanceBlStub.getIncome(new long[1]);
	FinanceBlStub.getProfit(new long[1]);
	FinanceBlStub.account(name);  
	FinanceBlStub.add(id1);
	FinanceBlStub.delete(id2);
	FinanceBlStub.modify(id3);
	FinanceBlStub.look(id4);
   }
}
