package documentdataService;

import java.rmi.RemoteException;

import po.GoodsDocuPO;

public interface GoodsDocuService {
	public GoodsDocuPO find(String ID ) throws RemoteException;
	//根据ID查找到单据
	
	
	public void insert(GoodsDocuPO po) throws RemoteException;
	//插入单据
	
	
	public void delete(String goodsID) throws RemoteException;
	//删除单据
	
	
	public void update(GoodsDocuPO pos) throws RemoteException;
	//更新单据信息
}
