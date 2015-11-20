package managebl;

import manageblService.ManageBlService;

public class ManageBlStub implements ManageBlService{

	public void look(long id) {
		// TODO Auto-generated method stub
		System.out.println("look successfully");
	}

	public void positionTransfer(long id, String position) {
		// TODO Auto-generated method stub
		System.out.println("positionTransfer successfully");
	}

	public void changePassword(long id, String password) {
		// TODO Auto-generated method stub
		System.out.println("changePassword successfully");
	}

	public void cancellation(long id) {
		// TODO Auto-generated method stub
		System.out.println("cancellation successfully");
	}

}