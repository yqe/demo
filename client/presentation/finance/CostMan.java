package finance;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;

import financebl.CostManage;
import financebl.FinanceBl;
import image.ImageGet;
import login.MTextfield;
import po.CostManagePO;
import po.EmploeePO;
import po.ManageAccountPO;

public class CostMan {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public CostMan(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void costMan(JPanelContent content) {
		content.removeAll();
		Image imagebgp = new ImageGet().GetFinanceImage("CostMan");
		content.setConpanel(imagebgp);

		final MTextfield[] textfield = new MTextfield[] { new MTextfield(), new MTextfield(), new MTextfield(),
				new MTextfield(), new MTextfield(), new MTextfield() };

		int Gapw = 399;
		int Gaph = 258;
		int gap = 29;
		int textw = 175;
		int texth = 42;

		for (int i = 1; i < textfield.length - 1; i++) {
			textfield[i].settextFont();
			textfield[i].HideTheField();
			textfield[i].setBounds(Gapw, Gaph + (gap + texth) * i, textw, texth);
			content.add(textfield[i]);
		}
		textfield[textfield.length - 1].setBounds(Gapw, 605, textw, texth);
		textfield[textfield.length - 1].settextFont();
		textfield[textfield.length - 1].HideTheField();
		content.add(textfield[textfield.length - 1]);
		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setLocale(Locale.CHINA);// 设置显示语言
		datepick.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick.setEditorable(false);// 设置是否可编辑
		datepick.setPreferredSize(new Dimension(100, 30));// 设置大小
		content.add(datepick);
		datepick.setBounds(Gapw, Gaph, textw, texth);

		JButtonM okbtn = new JButtonM("确认付款");
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum = true;
				for (int i = 0; i < textfield[1].getText().length(); i++) {
					if (textfield[1].getText().charAt(i) > '9' || textfield[1].getText().charAt(i) < '1') {
						isnum = false;
					}
				}
				boolean priceisempty = textfield[1].getText().equals("");
				boolean payerisempty = textfield[2].getText().equals("");
				boolean idisempty = textfield[3].getText().equals("");
				boolean infoisempty = textfield[4].getText().equals("");
				boolean tipsisempty = textfield[5].getText().equals("");

				boolean isempty = priceisempty || payerisempty || idisempty || infoisempty || tipsisempty;

				FinanceBl finance = new FinanceBl(oos, ois);
				ManageAccountPO check = finance.CheckBankAccount(textfield[3].getText());
				String date = datepick.getText();
				CostManage cost = new CostManage(oos, ois);

				boolean isid = !check.getAccountname().equals("不存在");// 根据银行账户PO判断ID是否合法
				CostManagePO cmpo = new CostManagePO(date, Double.valueOf(textfield[1].getText()),
						textfield[2].getText(), textfield[3].getText(), textfield[4].getText(), textfield[5].getText());

				if (isid && isnum && !isempty && cost.BuildCostManage(cmpo)) {
					JOptionPane.showMessageDialog(null, "成功付款!");
				} else if (!isempty && !isid) {
					JOptionPane.showMessageDialog(null, "所输入账户ID非法!");
				} else if (!isempty && !isnum) {
					JOptionPane.showMessageDialog(null, "请输入合法的金额!");// 只能是整数
				} else if (isempty) {

					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				}

			}

		});
		okbtn.setBounds(746, 631, 199, 52);
		okbtn.HideTheButton();
		content.add(okbtn);
	}

}
