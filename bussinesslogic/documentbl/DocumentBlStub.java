package documentbl;


import java.util.ArrayList;

import vo.DocumentVO;

public class DocumentBlStub implements documentblService.DocumentBlService{

	public boolean choose(String type) {
		// TODO Auto-generated method stub
		System.out.println("successfully choosed");
		return true;
	}

	public ArrayList<DocumentVO> getDo(String type) {
		// TODO Auto-generated method stub
		DocumentVO docu=new DocumentVO(type);
		ArrayList<DocumentVO> list=new ArrayList();
		list.add(docu);
		if(type=="payment"){
			System.out.println("successfully");
		}
		return list;
	}

	public boolean modifyinfo(String ID, DocumentVO vo) {
		// TODO Auto-generated method stub
		System.out.println("information has been modified");
		return true;
	}

	public boolean deleteDo(String ID) {
		// TODO Auto-generated method stub
		System.out.println("docuemnt has been delete");
		return true;
	}

	public DocumentVO show() {
		// TODO Auto-generated method stub
		System.out.println("document has been showed");
		return null;
	}

	public ArrayList<DocumentVO> add(String type, String[] info) {
		// TODO Auto-generated method stub
		DocumentVO docu=new DocumentVO(type,info);
		ArrayList<DocumentVO> list=new ArrayList();
		list.add(docu);
		System.out.println("add successfully");
		return list;
	}

	public ArrayList<DocumentVO> inputPri(String begin, String end) {
		// TODO Auto-generated method stub
		DocumentVO docu=new DocumentVO(begin,end);
		ArrayList<DocumentVO> list=new ArrayList();
		list.add(docu);
		System.out.println("inputpri successfully");
		return list;
	}

	

}
