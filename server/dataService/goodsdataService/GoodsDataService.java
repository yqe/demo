/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package goodsdataService;
import java.rmi.RemoteException;
import po.GoodsPO;
public interface GoodsDataService{
	public GoodsPO find(String ID) throws RemoteException;//按ID进行查找返回相应的GoodsPO
	public double average(GoodsPO po)throws RemoteException;//根据这些po的运送时间进行求平均，给出预计到达时间
	
}