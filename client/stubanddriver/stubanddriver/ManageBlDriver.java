package stubanddriver;

import manageblService.ManageBlService;
public class ManageBlDriver {
	public void drive(ManageBlService ManageBlStub){
		long a=1234232231;
		long id=320102033;
		String position="快递员";
		long account=1232341;
		String password="12124";
		long id2=12231123;
		ManageBlStub.look(id);
		ManageBlStub.positionTransfer(a, position);
		ManageBlStub.changePassword(account, password);
		ManageBlStub.cancellation(id2);
	}
			

}
//public void look(long id) {
	// TODO Auto-generated method stub
	
//}

//@Override
//public void positionTransfer(long id, String position) {
	// TODO Auto-generated method stub
	
//}

//@Override
//public void changePassword(long id, String password) {
	// TODO Auto-generated method stub
	
//}

//@Override
//public void cancellation(long id) {
	// TODO Auto-generated method stub
	
//}