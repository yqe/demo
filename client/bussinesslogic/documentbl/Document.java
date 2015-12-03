package documentbl;

import java.util.ArrayList;

import vo.DocumentVO;
import documentblService.DocumentBlService;

public class Document implements DocumentBlService{
	

	public boolean choose(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<DocumentVO> getDo(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modifyinfo(String ID, DocumentVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteDo(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	public DocumentVO show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocumentVO> add(String type, String[] info) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocumentVO> inputPri(String begin, String end) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean generate(Infocollector infoco){
		
		return true;
	}

}
