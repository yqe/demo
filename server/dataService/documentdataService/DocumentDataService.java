/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package documentdataService;

import java.rmi.RemoteException;

import po.DocumentPO;

public interface DocumentDataService{
	public String[] getAll( ) throws RemoteException;
	//得到所有单据类型
	
	public DocumentPO find(String ID ) throws RemoteException;
	//根据ID查找到单据
	
	
	public void insert(DocumentPO pos) throws RemoteException;
	//插入单据
	
	
	public void delete(String ID) throws RemoteException;
	//删除单据
	
	
	public void update(DocumentPO pos) throws RemoteException;
	//更新单据信息
	
	
	public DocumentPO findmore() throws RemoteException;
	//根据单据类型返回多个单据
	
	
	public void finish()throws RemoteException;

}