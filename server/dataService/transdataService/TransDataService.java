/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package transdataService;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransPO;
public interface TransDataService{
	public TransPO find(String carsID)throws RemoteException;//按所输入info查找返回相应的TransPO
	public boolean delete(String goodsID);
	public boolean insert(TransPO po);
	public boolean update(TransPO po);
	public ArrayList<TransPO> findmore();
}