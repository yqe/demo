/**
 * 
 */
/**
 * @author jjlb
 *
 */
package emploeeblService;

import java.util.ArrayList;

import vo.EmploeeVO;

public interface EmploeeBlService{
	public ArrayList<EmploeeVO> getEmp(String ID);
	//得到一个员工
	
	
	public boolean modifyEmpInfo(String ID,EmploeeVO vo);
	//修改员工信息
	
	
	public ArrayList<EmploeeVO> addEmp(String ID,String info);
	//增加一个员工
	
	public boolean DeleteEmp(String ID);
	//删除一个员工
	
	
	
}