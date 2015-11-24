package po;

import java.io.Serializable;

public class OutStorageDocuPO implements Serializable{
	private static final long serialVersionUID = 1L;
	/* ��ݱ�� */
	public String goodno;
	/* �������� */
	public String outtime;
	/* Ŀ�ĵ� */
	public String destination;
	/* װ����ʽ */
	public String loadform;
	/* ��ת�����or���˱�� */
	public String transferno;
	public OutStorageDocuPO(String goodno,String outtime,String destination,String loadform,String transferno) {
		this.goodno=goodno;
		this.outtime=outtime;
		this.destination=destination;
		this.loadform=loadform;
		this.transferno=transferno;
	}
	public String getGoodno() {
		return goodno;
	}
	public String getOuttime() {
		return outtime;
	}
	public String getDestination() {
		return destination;
	}
	public String getLoadform() {
		return loadform;
	}
	public String getTransferno() {
		return transferno;
	}

}
