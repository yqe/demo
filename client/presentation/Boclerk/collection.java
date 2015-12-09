package Boclerk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.Tran;
import documentbl.Earneddocu;
import po.EarnedPO;

public class collection {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	String PosId;

	public collection(String PosID) {
		this.PosId = PosID;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 700);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>生成收款单");
		int l2size = 16;
		l2.setFont(new Font("—> 主页", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("订单条形码号：");
		JLabel l4 = new JLabel("到达日期:");
		JLabel l5 = new JLabel("收款金额:");
		JLabel l6 = new JLabel("快递员:");

		JLabel l7 = new JLabel("元");
		JLabel l8 = new JLabel("营业厅编号:");
		int lmain = 16;
		l3.setFont(new Font("", Font.PLAIN, lmain));
		l4.setFont(new Font("", Font.PLAIN, lmain));
		l5.setFont(new Font("", Font.PLAIN, lmain));
		l6.setFont(new Font("", Font.PLAIN, lmain));
		l7.setFont(new Font("", Font.PLAIN, lmain));
		l8.setFont(new Font("", Font.PLAIN, lmain));

		final JTextField id = new JTextField();
		final JTextField profit = new JTextField();
		final JTextField courier = new JTextField();
		final JTextField yyt = new JTextField();
		yyt.setText(PosId);
		yyt.setOpaque(false);
		yyt.setEditable(false);

		String[] year = new String[201];
		for (int i = 2000; i < 2100; i++) {
			year[i - 2000] = i + "年";

		}
		final JComboBox yearbox = new JComboBox(year);
		String[] month = new String[12];
		for (int i = 1; i <= 12; i++) {
			if(i<10)
			month[i - 1] = "0"+ i + "月";
			else
			month[i - 1] = i + "月";
		}
		final JComboBox monthbox = new JComboBox(month);
		String[] day = new String[31];
		for (int i = 1; i <= 31; i++) {
			if(i<10)
			day[i - 1] = "0"+ i + "日";
			else
			day[i - 1] = i + "日";
		}
		final JComboBox daybox = new JComboBox(day);

		JButton b4 = new JButton("生成收款单");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = (String) (yearbox.getSelectedItem()) + (String) (monthbox.getSelectedItem())
						+ daybox.getSelectedItem().toString();
				Tran tran=new Tran();
				tran.Tran(date);
				boolean isnum = true;
				for (int i = 0; i < profit.getText().length(); i++) {
					if (profit.getText().charAt(i) > '9' || profit.getText().charAt(i) < '1') {
						isnum = false;
					}
				}
				boolean cisempty = courier.getText().equals("");
				boolean pisempty = profit.getText().equals("");
				double rececash = 0.0;
				try {
					rececash = Double.parseDouble(profit.getText());
				} catch (Exception e1) {
					pisempty = true;
				}
				if (id.getText().length() != 10)
					JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				else if (cisempty)
					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				else if (pisempty)
					JOptionPane.showMessageDialog(null, "抱歉，请输入正确的收款金额!");
				else {
					Earneddocu edocu = new Earneddocu();
					boolean IsOk = edocu
							.BuildEarnedDocu(new EarnedPO(date, rececash, courier.getText(), id.getText(), ""));
					if (IsOk) {
						JOptionPane.showMessageDialog(null, "成功建立收款单!");
					} else {
						JOptionPane.showMessageDialog(null, "建立收款单失敗!");
					}
				}
			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		p1.add(l8);

		p1.add(id);
		p1.add(profit);
		p1.add(courier);
		p1.add(yyt);

		p1.add(b4);
		p1.add(yearbox);
		p1.add(monthbox);
		p1.add(daybox);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 13 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(180, -20, 180, 80);
		l2.setBounds(50, b1yloc, 150, 30);
		l3.setBounds(100, 200, 150, 30);
		l4.setBounds(100, 250, 150, 30);
		yearbox.setBounds(275, 250, 80, 30);
		monthbox.setBounds(375, 250, 80, 30);
		daybox.setBounds(475, 250, 80, 30);

		l5.setBounds(100, 300, 150, 30);
		l7.setBounds(450, 300, 200, 30);

		l6.setBounds(100, 350, 150, 30);
		l8.setBounds(100, 400, 150, 30);

		id.setBounds(275, 200, 150, 30);
		profit.setBounds(275, 300, 150, 30);
		courier.setBounds(275, 350, 150, 30);
		yyt.setBounds(275, 400, 150, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);

		return p1;

	}

}