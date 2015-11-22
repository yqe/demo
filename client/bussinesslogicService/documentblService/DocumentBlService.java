/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package documentblService;
import java.util.ArrayList;

import vo.DocumentVO;

public interface DocumentBlService{
	public boolean choose(String type);
	//选择所有单据种类
	
	
	public ArrayList<DocumentVO> getDo(String type);
	//选择具体的一个种类的单据
	
	
	public boolean  modifyinfo(String ID,DocumentVO vo);
	//修改单据的信息

	public boolean deleteDo(String ID);
	//删除一个单据
	
	public DocumentVO show();
	//显示查看信息
	
	
	public ArrayList<DocumentVO> add(String type,String[] info);
	//添加一个表单
	
	
	public ArrayList<DocumentVO> inputPri(String begin,String end);
	//输入时间返回表单
}