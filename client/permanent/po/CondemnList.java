package po;

import java.io.Serializable;
import java.util.ArrayList;

public class CondemnList implements Serializable {
	private static final long serialVersionUID = 1L;

	ArrayList<CondemnDocuPO> cdlist = new ArrayList<CondemnDocuPO>();

	public void AddCondemnDocuPO(CondemnDocuPO cdpo) {
		cdlist.add(cdpo);
	}

	public int GetSize() {
		return cdlist.size();
	}

	public CondemnDocuPO GetIndexOf(int i) {
		return cdlist.get(i);
	}
}
