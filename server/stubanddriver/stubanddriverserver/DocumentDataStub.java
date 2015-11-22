package stubanddriverserver;



import java.rmi.RemoteException;

import po.DocumentPO;

public class DocumentDataStub implements documentdataService.DocumentDataService{

	public String[] getAll() throws RemoteException {
		// TODO Auto-generated method stub
		String[]  j=new String[]{"all is get"};
		System.out.println(j[0]);
		return j;
	}

	public DocumentPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		DocumentPO docupo=new  DocumentPO(ID);
		System.out.println("find docupo");
		return docupo;
	}

	public void insert(DocumentPO pos) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("插入成功");
	}

	public void delete(DocumentPO pos) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("删除成功");
	}

	public void update(DocumentPO pos) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("更新成功");
	}

	public DocumentPO findmore(String type) throws RemoteException {
		// TODO Auto-generated method stub
		DocumentPO docupo=new  DocumentPO(type);
		System.out.println("成功找到");
		return docupo;
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("本次服务已关闭");
	}

}

