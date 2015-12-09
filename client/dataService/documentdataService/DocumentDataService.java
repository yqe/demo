/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package documentdataService;

import java.rmi.RemoteException;

import po.CondemnList;
import po.DocumentPO;

public interface DocumentDataService{
	/**
	 * 返回未审批的单据
	 * 
	 * @param 
	 * @return ArrayList<CondemnDocuPO>
	 * @exception @author
	 *                zxc
	 */
	public CondemnList GetUnapproveBill();
	
	/**
	 * 批量审批单据
	 * 
	 * @param 
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean ApproveBill();
	
	public String[] getAll( ) throws RemoteException;
	//得到所有单据类型
	
	public DocumentPO find(String ID ) throws RemoteException;
	//根据ID查找到单据
	
	
	public void insert(DocumentPO pos) throws RemoteException;
	//插入单据
	
	
	public void delete(DocumentPO pos) throws RemoteException;
	//删除单据
	
	
	public void update(DocumentPO pos) throws RemoteException;
	//更新单据信息
	
	
	public DocumentPO findmore(String type) throws RemoteException;
	//根据单据类型返回多个单据
	
	
	public void finish()throws RemoteException;

}