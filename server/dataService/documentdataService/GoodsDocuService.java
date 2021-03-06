package documentdataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsDocuPO;

public interface GoodsDocuService {
	public GoodsDocuPO find(String ID ) throws RemoteException;
	//根据ID查找到单据
	
	
	public boolean insert(GoodsDocuPO po) throws RemoteException;
	//插入单据
	
	
	public boolean delete(String goodsID) throws RemoteException;
	//删除单据
	
	
	public boolean update(GoodsDocuPO pos) throws RemoteException;
	//更新单据信息

	public ArrayList<GoodsDocuPO> findmore() throws RemoteException;

	public String getgoodsidmax();
}

