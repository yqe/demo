package storageblService;

import po.InputStorageList;
import po.LookStoragePO;
import po.OutStorageList;
import po.StorageAlarmPO;
import po.StorageCheckPO;
import po.StorageList;

public interface StorageBlService {

	/**
	 * 入库登记
	 * 
	 * @param InputStorageList
	 *            slt;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean InStorageInput(InputStorageList slt);

	/**
	 * 出库登记
	 * 
	 * @param OutStorageList
	 *            oslt;
	 * @return boolean
	 * @exception @author
	 *                zxc
	 */
	public boolean OutStorageInput(OutStorageList oslt);

	/**
	 * 库存信息盘点;
	 * 
	 * @param String
	 *            centerid; centerid:中转中心编号;
	 * @return InputStorageList;
	 * @exception @author
	 *                zxc
	 */
	public StorageList StorageCheck(String centerid);

	/**
	 * 库存信息查看
	 * 
	 * @param String
	 *            centerid,String rtime,String ltime;
	 *            centerid:中转中心编号;rtime:前时间;ltime:后时间;
	 * @return String[] re;re[0]:出库数量;re[1]:入库数量;re[2]:金额;re[3]:库存数量;
	 * @exception @author
	 *                zxc
	 */
	public LookStoragePO StorageSee(String centerid, String rtime, String ltime);
	/**
	 * 库存信息更新
	 * 
	 * @param InputStorageDocuPO svo;
	 * @return boolean;
	 * @exception @author
	 *                zxc
	 */
	public boolean StorageUpdate(StorageCheckPO svo) ;
	/**
	 * 根据Id查找库存信息;
	 * 
	 * @param String ID;
	 * @return StorageCheckPO;
	 * @exception @author
	 *                zxc
	 */
	public StorageCheckPO IDStorageGet(String ID);
	/**
	 * 设置库存报警值;
	 * 
	 * @param StorageAlarmPO alarm;
	 * @return 
	 * @exception @author
	 *                zxc
	 */
	public boolean SetStorage110(StorageAlarmPO alarm);
	/**
	 * 判断是否库存报警;
	 * 
	 * @param String posid;//机构编号
	 * @return 
	 * @exception @author
	 *                zxc
	 */
	public boolean Storage110(String posid);
}
