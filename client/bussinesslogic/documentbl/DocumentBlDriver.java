package documentbl;

import vo.DocumentVO;


public class DocumentBlDriver {
	public  void  drive(documentblService.DocumentBlService DocumentBlStub){
		  String[]  info=new String[]{"gwe"};
		  DocumentBlStub.choose("ID");
		  DocumentBlStub.getDo("payment");
		  DocumentBlStub.modifyinfo("23134", new DocumentVO("payment"));
		  DocumentBlStub.deleteDo("23234");
		  DocumentBlStub.show();
		  DocumentBlStub.add("payment", info);
		  DocumentBlStub.inputPri("2015/10/25", "2015/10/25");
	  }
}