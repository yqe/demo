package documentdataService;

import java.util.ArrayList;

import po.DiliverDocuPO;

public interface DiliverDocuService {
	public DiliverDocuPO find(String ID);
	public ArrayList<DiliverDocuPO> findall();
	public boolean insert(DiliverDocuPO po);
	public boolean update(DiliverDocuPO po);
	public boolean delete(String ID);
}
