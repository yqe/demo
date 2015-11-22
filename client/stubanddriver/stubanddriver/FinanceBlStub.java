package stubanddriver;

import financeblService.FinanceBlService;

public class FinanceBlStub implements FinanceBlService{

	public void getIncome(long[] inNumber) {
		// TODO Auto-generated method stub
		System.out.println("getIncome successfully");
	}

	public void getProfit(long[] outNumber) {
		// TODO Auto-generated method stub
		System.out.println("getProfit successfully");
	}

	public void account(String name) {
		// TODO Auto-generated method stub
		System.out.println("account successfully");
	}

	public void add(long id) {
		// TODO Auto-generated method stub
		System.out.println("add successfully");
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		System.out.println("delete successfully");
	}

	public void modify(long id) {
		// TODO Auto-generated method stub
		System.out.println("modify successfully");
	}

	public void look(long id) {
		// TODO Auto-generated method stub
		System.out.println("look successfully");
	}

}