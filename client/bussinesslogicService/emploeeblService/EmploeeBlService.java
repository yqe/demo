/**
 * 
 */
/**
 * @author jjlb
 *
 */
package emploeeblService;

import java.util.ArrayList;

import po.EmploeePO;
import vo.EmploeeVO;

public interface EmploeeBlService {
	public EmploeePO IDGetEmp(String ID);

	// 得到一个员工
	// 根据机构得到此机构所有员工信息
	public ArrayList<EmploeePO> GetOEmployee(String oname);

	//根据ID修改员工信息,若没有这个ID则增加员工信息
	public boolean ModifyOrAddEmpInfo(EmploeePO empo);
	// 修改员工信息

	public boolean DeleteEmp(String ID);
	// 删除一个员工

}