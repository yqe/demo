package po;

import java.io.Serializable;
import java.util.ArrayList;

public class EarnedPOList implements Serializable {
	private static final long serialVersionUID = 1L;

	ArrayList<EarnedPO> Earnlist = new ArrayList<>();

	public void addEarnedPO(EarnedPO earnpo) {
		Earnlist.add(earnpo);
	}

	public int Getsize() {
		return Earnlist.size();
	}

	public EarnedPO GetIndex(int i) {
		return Earnlist.get(i);
	}
}
