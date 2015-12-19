package Boclerk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import documentbl.Transdocu;
import po.EmploeePO;
import po.TransPO;

public class load {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private EmploeePO emPO;


	public load(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 700);

		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>生成装车单");
		int l2size = 16;
		l2.setFont(new Font("", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("订单条形码号:");
		JLabel l4 = new JLabel("装车日期:");
		JLabel l5 = new JLabel("汽运编号:");
		JLabel l6 = new JLabel("到达地:");
		JLabel l7 = new JLabel("车辆代号:");
		JLabel l8 = new JLabel("监装员:");
		JLabel l9 = new JLabel("押运员:");
		JLabel l10 = new JLabel("运费:");
		JLabel l11 = new JLabel("元");

		JLabel l12 = new JLabel("营业厅编号:");

		int lmain = 16;
		l3.setFont(new Font("", Font.PLAIN, lmain));
		l4.setFont(new Font("", Font.PLAIN, lmain));
		l5.setFont(new Font("", Font.PLAIN, lmain));
		l6.setFont(new Font("", Font.PLAIN, lmain));
		l7.setFont(new Font("", Font.PLAIN, lmain));
		l8.setFont(new Font("", Font.PLAIN, lmain));
		l9.setFont(new Font("", Font.PLAIN, lmain));
		l10.setFont(new Font("", Font.PLAIN, lmain));
		l11.setFont(new Font("", Font.PLAIN, lmain));
		l12.setFont(new Font("", Font.PLAIN, lmain));

		final JTextField id = new JTextField();
		final JTextField transid = new JTextField();
		final JTextField carid = new JTextField();
		final JTextField jz = new JTextField();// ��װԱ
		final JTextField yy = new JTextField();// Ѻ��Ա
		final JTextField price = new JTextField();
		final JTextField yyt = new JTextField();
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		transid.setOpaque(false);
		transid.setBorder(BorderFactory.createEmptyBorder());
		carid.setOpaque(false);
		carid.setBorder(BorderFactory.createEmptyBorder());
		jz.setOpaque(false);
		jz.setBorder(BorderFactory.createEmptyBorder());
		yy.setOpaque(false);
		yy.setBorder(BorderFactory.createEmptyBorder());
		price.setOpaque(false);
		price.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		
		yyt.setText(emPO.getPosID());
		yyt.setOpaque(false);
		yyt.setBorder(BorderFactory.createEmptyBorder());
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

		String[] site = { "上海", "北京", "南京", "深圳", "广州", "杭州" };

		final JComboBox sitebox = new JComboBox(site);

		JButton b4 = new JButton("生成装车单");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum = true;
				for (int i = 0; i < price.getText().length(); i++) {
					if (price.getText().charAt(i) > '9' || price.getText().charAt(i) < '1') {
						isnum = false;
					}
				}
				boolean istransid = true;
				boolean iscarid = true;
				boolean isyytid = true;

				boolean cisempty = carid.getText().equals("");
				boolean pisempty = price.getText().equals("");
				boolean tisempty = transid.getText().equals("");
				boolean carisempty = carid.getText().equals("");
				boolean jzisempty = jz.getText().equals("");
				boolean yyisempty = yy.getText().equals("");
				boolean yytisempty = yyt.getText().equals("");

				boolean isempty = cisempty || pisempty || tisempty || carisempty || jzisempty || yyisempty
						|| yytisempty;
				
				String date = (String) (yearbox.getSelectedItem()) + (String) (monthbox.getSelectedItem())
						+ (String) (daybox.getSelectedItem());
				boolean IsDouble=false;
				try{
					double priced=Double.parseDouble(price.getText());
					IsDouble=true;
				}catch (Exception e1) {
					IsDouble=false;
				}
				if (id.getText().length() != 10)
					JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				else if(!isempty&&!IsDouble)
					JOptionPane.showMessageDialog(null, "请输入合法的金额!");
				else if (isempty)
					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				else {
					Transdocu trans = new Transdocu(oos,ois);
					boolean IsOk = trans.BuildTransDocu(new TransPO(date, yyt.getText(), transid.getText(),
							(String) (sitebox.getSelectedItem()), carid.getText(), jz.getText(), yy.getText(),
							Double.parseDouble(price.getText()), id.getText()));
					if (IsOk) {
						JOptionPane.showMessageDialog(null, "成功生成装车单!");
					} else {
						JOptionPane.showMessageDialog(null, "生成装车单失败!");
					}
				}
				// else if (id.getText().length() != 10) {
				// JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				// } else if (!isnum && !pisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的金额!");// 只能是整数
				// } else if (!isyytid && !yytisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的汽运编号!");
				// } else if (!istransid && !tisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的汽运编号!");
				// } else if (!iscarid && !carisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的车辆代号!");
				// } else if (isempty) {
				// JOptionPane.showMessageDialog(null, "请完整填写信息!");
				// }
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
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(l12);

		p1.add(id);
		p1.add(transid);
		p1.add(carid);
		p1.add(jz);
		p1.add(yy);
		p1.add(price);
		p1.add(yyt);

		p1.add(b4);
		p1.add(yearbox);
		p1.add(monthbox);
		p1.add(daybox);
		p1.add(sitebox);

		p1.setOpaque(false);
		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 1 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 12 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(180, -20, 180, 80);
		l2.setBounds(50, b1yloc, 150, 30);
		l3.setBounds(100, 100, 150, 30);
		l4.setBounds(100, 150, 150, 30);
		yearbox.setBounds(275, 150, 80, 30);
		monthbox.setBounds(375, 150, 80, 30);
		daybox.setBounds(475, 150, 80, 30);

		l12.setBounds(100, 200, 150, 30);
		l5.setBounds(100, 250, 150, 30);
		l6.setBounds(100, 300, 150, 30);
		l7.setBounds(100, 350, 150, 30);
		l8.setBounds(100, 400, 150, 30);
		l9.setBounds(100, 450, 150, 30);
		l10.setBounds(100, 500, 150, 30);
		l11.setBounds(450, 500, 100, 30);

		id.setBounds(275, 100, 150, 30);
		transid.setBounds(275, 250, 150, 30);
		sitebox.setBounds(275, 300, 80, 30);
		carid.setBounds(275, 350, 150, 30);
		jz.setBounds(275, 400, 150, 30);
		yy.setBounds(275, 450, 150, 30);
		price.setBounds(275, 500, 150, 30);
		yyt.setBounds(275, 200, 150, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);

		return p1;

	}

}