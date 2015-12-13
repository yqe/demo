package finance;

import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import financebl.FinanceBl;
import po.EmploeePO;

public class CostIncome {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public CostIncome(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public void costincome(JPanel context) {
		context.removeAll();
		int labelw = 100;
		int labelh = 30;
		int textw = 150;
		int texth = 30;
		int gap = 20;
		int gaph = 80;
		JLabel[] label = new JLabel[] { new JLabel("总收入:"), new JLabel("总支出:"),
				new JLabel("总利润:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("", Font.PLAIN, 25));
			label[i].setBounds(80, 100 + (labelh + gaph) * i, labelw, labelh);
			context.add(label[i]);
		}
		JTextField[] textfield = new JTextField[] { new JTextField(),
				new JTextField(), new JTextField() };
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].setOpaque(false);
			textfield[i].setEditable(false);
			textfield[i].setBounds(80 + gap + labelw, 100 + (texth + gaph) * i,
					textw, texth);
			context.add(textfield[i]);
		}
		FinanceBl finance = new FinanceBl(oos,ois);
		String s[] = finance.GetCostInfo();
		textfield[0].setText(s[0]);
		textfield[1].setText(s[1]);
		textfield[2].setText(s[2]);// 得到支出收入利润

	}

}
