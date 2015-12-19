package managedataService;

public interface CheckProfitService {
	public double getearnedtotal();
	
	public double getcosttotal();
	
	public double profittotal();
	
	public boolean setearned(double earned);
	
	public boolean setcost(double cost);
	
	public boolean setprofit();
}
