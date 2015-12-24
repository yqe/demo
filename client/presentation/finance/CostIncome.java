package finance;

import java.awt.Image;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import financebl.FinanceBl;
import image.ImageGet;
import login.MTextfield;
import po.EmploeePO;

public class CostIncome {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public CostIncome(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void costincome(JPanelContent content) {
		content.removeAll();
		Image bgp = new ImageGet().GetFinanceImage("CostIncome");
		content.setConpanel(bgp);
		
		int Gapw=470;
		int textw=175;
		int texth=42;

		MTextfield[] textfield = new MTextfield[] { new MTextfield(), new MTextfield(), new MTextfield() };
		textfield[0].setBounds(Gapw, 358, textw, texth);
		textfield[1].setBounds(Gapw, 430, textw, texth);
		textfield[2].setBounds(Gapw, 504, textw, texth);
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].settextFont();
			textfield[i].HideTheField();
			textfield[i].setEditable(false);
			content.add(textfield[i]);
		}
		FinanceBl finance = new FinanceBl(oos, ois);
		String s[] = finance.GetCostInfo();
		textfield[0].setText(s[0]);
		textfield[1].setText(s[1]);
		textfield[2].setText(s[2]);// 得到支出收入利润

	}

}
