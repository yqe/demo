package po;

import java.io.Serializable;

/**
 * @author jjlb 审批单据
 */
public class CondemnDocuPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;// 单据类型o
	private String ID;// 单据编号
	private String state;// 审批状态

	public CondemnDocuPO(String type, String ID, String state) {
		this.type = type;
		this.ID = ID;
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public String getID() {
		return ID;
	}

	public String getState() {
		return state;
	}

}
