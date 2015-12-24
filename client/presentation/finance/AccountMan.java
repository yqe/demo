package finance;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import financebl.FinanceBl;
import image.ImageGet;
import login.MTextfield;
import po.EmploeePO;
import po.ManageAccountPO;

public class AccountMan {

	int textw = 140;
	int texth = 15;
	int Gapw = 178;
	int Gaph = 250;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public AccountMan(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void AccMan(JPanelContent content) {
		content.removeAll();
		Image imagebgp = new ImageGet().GetFinanceImage("");
		content.setConpanel(imagebgp);
		AddAcc(content);
		DeleteAcc(content);
		ChangeAcc(content);
		CheckAcc(content);
	}

	public void AddAcc(JPanelContent content) {
		final MTextfield[] textfield = new MTextfield[] { new MTextfield(), new MTextfield() };
		textfield[0].setBounds(Gapw, 237, textw, texth);
		textfield[1].setBounds(Gapw, 282, textw, texth);
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].settextFont();
			textfield[i].HideTheField();
			content.add(textfield[i]);
		}
		JButtonM btn = new JButtonM("确定增加");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum = true;
				for (int i = 0; i < textfield[1].getText().length(); i++) {
					if (textfield[1].getText().charAt(i) > '9' || textfield[1].getText().charAt(i) < '1') {
						isnum = false;
					}
				}
				boolean idisempty = textfield[0].getText().equals("");
				boolean priceisempty = textfield[1].getText().equals("");
				boolean isempty = idisempty || priceisempty;

				if (!isempty && isnum) {
					// 添加新数据到PO
					ManageAccountPO a = new ManageAccountPO(textfield[0].getText(),
							Double.parseDouble(textfield[1].getText()), "", "");
					FinanceBl adacc = new FinanceBl(oos, ois);
					boolean IsOk = adacc.BuildBankAccount(a);
					if (IsOk)
						JOptionPane.showMessageDialog(null, "添加成功!");
					else
						JOptionPane.showMessageDialog(null, "添加失败!");
				} else if (!isempty && !isnum) {
					JOptionPane.showMessageDialog(null, "所输入金额非法!");
				} else {
					JOptionPane.showMessageDialog(null, "请将信息填写完整!");
				}
			}
		});
		btn.setBounds(178, 339, 160, 50);
		btn.HideTheButton();
		content.add(btn);
	}

	public void DeleteAcc(JPanelContent content) {

		final MTextfield accname = new MTextfield();
		accname.settextFont();
		accname.HideTheField();
		JButtonM delbtn = new JButtonM("确定删除");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isempty = accname.getText().equals("");
				FinanceBl adacc = new FinanceBl(oos, ois);

				if (!isempty && adacc.DeleteBankAccount(accname.getText())) {
					JOptionPane.showMessageDialog(null, "删除成功!");
				} else if (isempty) {
					JOptionPane.showMessageDialog(null, "请填写所需要删除的账户!");
				} else {
					JOptionPane.showMessageDialog(null, "未查询到该账户!");
				}

			}
		});

		accname.setBounds(655, 237, textw, texth);
		delbtn.setBounds(587, 337, 160, 50);

		delbtn.HideTheButton();
		content.add(accname);
		content.add(delbtn);
	}

	public void ChangeAcc(JPanelContent content) {

		final MTextfield accname = new MTextfield();
		accname.settextFont();
		accname.HideTheField();
		accname.setBounds(610, 485, textw, texth);
		final MTextfield[] text = new MTextfield[] { new MTextfield(), new MTextfield(), new MTextfield(),
				new MTextfield() };
		text[0].setBounds(631, 538, textw, texth);
		text[1].setBounds(840, 538, textw, texth);
		text[2].setBounds(633, 595, textw, texth);
		text[3].setBounds(840, 595, textw, texth);
		text[0].setEditable(false);
		text[2].setEditable(false);
		text[3].setEditable(false);
		for (int i = 0; i < text.length; i = i + 1) {
			text[i].settextFont();
			text[i].HideTheField();
			content.add(text[i]);
		}
		JButtonM btn = new JButtonM("确定搜索");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!accname.getText().equals("")) {
					FinanceBl finance = new FinanceBl(oos, ois);
					ManageAccountPO mapo = finance.CheckBankAccount(accname.getText());
					if (mapo.getAccountname().equals("不存在")) {
						JOptionPane.showMessageDialog(null, "该账户ID不存在!");
					} else {
						text[0].setText(mapo.getAccountname());
						text[2].setText(String.valueOf(mapo.getBalance()));
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入要搜索的账户ID!");
				}
			}
		});
		btn.setBounds(818, 476, 111, 29);
		btn.HideTheButton();
		JButtonM changebtn = new JButtonM("确定修改");
		changebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum = true;
				for (int i = 0; i < text[3].getText().length(); i++) {
					if (text[3].getText().charAt(i) > '9' || text[3].getText().charAt(i) < '1') {
						isnum = false;
					}
				}
				boolean idisempty = text[1].getText().equals("");
				boolean numisempty = text[3].getText().equals("");
				boolean isempty = idisempty || numisempty;
				if (!isempty && isnum) {
					FinanceBl change = new FinanceBl(oos, ois);
					ManageAccountPO mapo = new ManageAccountPO(text[1].getText(), Double.valueOf(text[3].getText()),
							accname.getText(), null);
					change.ModifyBankAccount(mapo);
					JOptionPane.showMessageDialog(null, "修改成功!");
				} else if (!isempty && !isnum) {
					JOptionPane.showMessageDialog(null, "所输入金额非法!");
				} else {
					JOptionPane.showMessageDialog(null, "请将信息输入完整!");
				}

			}
		});
		changebtn.setBounds(769, 657, 160, 50);
		changebtn.HideTheButton();
		content.add(accname);
		content.add(btn);
		content.add(changebtn);

	}

	public void CheckAcc(JPanelContent content) {

		final MTextfield[] textfield = new MTextfield[] { new MTextfield(), new MTextfield(), new MTextfield() };
		textfield[0].setBounds(Gapw, 501, textw, texth);
		textfield[1].setBounds(Gapw, 554, textw, texth);
		textfield[2].setBounds(Gapw, 611, textw, texth);
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].settextFont();
			textfield[i].HideTheField();
			content.add(textfield[i]);
		}
		textfield[1].setEditable(false);
		textfield[2].setEditable(false);

		JButtonM button = new JButtonM("确认查询");
		button.setFont(new Font("幼圆", Font.BOLD, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textfield[0].getText().equals("")) {
					FinanceBl finance = new FinanceBl(oos, ois);
					ManageAccountPO mapo = finance.CheckBankAccount(textfield[0].getText());
					if (mapo.getAccountname().equals("不存在")) {
						JOptionPane.showMessageDialog(null, "该账户ID不存在!");
					} else {
						textfield[1].setText(mapo.getAccountname());
						textfield[2].setText(String.valueOf(mapo.getBalance()));
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入要查询的账户ID!");
				}

			}
		});

		button.setBounds(375, 496, 91, 30);
		button.HideTheButton();
		content.add(button);
	}

}
