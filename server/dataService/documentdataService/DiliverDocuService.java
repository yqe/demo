package documentdataService;

import java.util.ArrayList;

import po.DiliverDocuPO;

public interface DiliverDocuService {
	public DiliverDocuPO find(String ID);
	public ArrayList<DiliverDocuPO> findall();
	public void insert(DiliverDocuPO po);
	public void update(DiliverDocuPO po);
	public void delete(String ID);
}
