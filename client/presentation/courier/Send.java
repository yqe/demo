package courier;

import goodsbl.GoodsBl;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import po.GoodsDocuPO;
import documentbl.Goodsdocu;

public class Send {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 800, 800);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>生成寄件单");
		int l2size = 16;
		l2.setFont(new Font("", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("寄件人:");
		JLabel l4 = new JLabel("寄件人单位:");
		JLabel l5 = new JLabel("手机号:");
		JLabel l6 = new JLabel("寄件人地址:");

		JLabel l7 = new JLabel("收件人:");
		JLabel l8 = new JLabel("收件人单位:");
		JLabel l9 = new JLabel("手机号:");
		JLabel l10 = new JLabel("收件人地址:");

		JLabel l11 = new JLabel("货物名称:");
		JLabel l12 = new JLabel("货物数量:");
		JLabel l13 = new JLabel("货物重量(Kg):");
		JLabel l14 = new JLabel("长(cm):");
		JLabel l15 = new JLabel("宽(cm):");
		JLabel l16 = new JLabel("高(cm):");
		JLabel l17 = new JLabel("体积(cm^3):");
		JLabel l18 = new JLabel("货物信息:");

		JLabel l19 = new JLabel("快递类型:");
		JLabel l20 = new JLabel("包装选择:");
		JLabel l21 = new JLabel("快递运费(自动):");
		JLabel l22 = new JLabel("预计到达时间:");
		// JLabel l23=new JLabel("订单条形码号:");

		JLabel l24 = new JLabel("寄件单生成日期:");
		JLabel l25 = new JLabel("快递员:");

		JLabel l26 = new JLabel("元");

		JLabel l27 = new JLabel("出发地:");
		JLabel l28 = new JLabel("目的地:");

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
		l13.setFont(new Font("", Font.PLAIN, lmain));
		l14.setFont(new Font("", Font.PLAIN, lmain));
		l15.setFont(new Font("", Font.PLAIN, lmain));
		l16.setFont(new Font("", Font.PLAIN, lmain));
		l17.setFont(new Font("", Font.PLAIN, lmain));
		l18.setFont(new Font("", Font.PLAIN, lmain));
		l19.setFont(new Font("", Font.PLAIN, lmain));
		l20.setFont(new Font("", Font.PLAIN, lmain));
		l21.setFont(new Font("", Font.PLAIN, lmain));
		l22.setFont(new Font("", Font.PLAIN, lmain));

		l24.setFont(new Font("", Font.PLAIN, lmain));
		l25.setFont(new Font("", Font.PLAIN, lmain));
		l26.setFont(new Font("", Font.PLAIN, lmain));
		l27.setFont(new Font("", Font.PLAIN, lmain));
		l28.setFont(new Font("", Font.PLAIN, lmain));

		final JTextField sender = new JTextField();
		final JTextField senderinfo = new JTextField();
		final JTextField sendertel = new JTextField();
		final JTextField sendersite = new JTextField();
		final JTextField getter = new JTextField();
		final JTextField getterinfo = new JTextField();
		final JTextField gettertel = new JTextField();
		final JTextField gettersite = new JTextField();
		final JTextField goodsname = new JTextField();
		final JTextField goodsnumber = new JTextField();
		final JTextField goodsweight = new JTextField();
		final JTextField length = new JTextField();
		final JTextField width = new JTextField();
		final JTextField height = new JTextField();
		final JTextField V = new JTextField();
		final JTextField goodsinfo = new JTextField();
		final JTextField price = new JTextField();
		// JTextField t17=new JTextField();
		final JTextField courier = new JTextField();

		length.getDocument().addDocumentListener(new DocumentListener() {
			String goodslength;

			public void removeUpdate(DocumentEvent e) {
			}

			public void insertUpdate(DocumentEvent e) {
			}

			public void changedUpdate(DocumentEvent e) {

			}
		});

		width.getDocument().addDocumentListener(new DocumentListener() {
			String goodswidth;

			public void removeUpdate(DocumentEvent e) {
			}

			public void insertUpdate(DocumentEvent e) {
			}

			public void changedUpdate(DocumentEvent e) {

			}
		});
		height.getDocument().addDocumentListener(new DocumentListener() {
			String goodsheight;

			public void removeUpdate(DocumentEvent e) {
				try {
					double v = Double.valueOf(length.getText())
							* Double.valueOf(width.getText())
							* Double.valueOf(height.getText());
					V.setText(String.valueOf(v));
					
				} catch (Exception e1) {
					return;
				}
			}

			public void insertUpdate(DocumentEvent e) {
				try {
					double v = Double.valueOf(length.getText())
							* Double.valueOf(width.getText())
							* Double.valueOf(height.getText());
					V.setText(String.valueOf(v));
				} catch (Exception e1) {
					return;
				}
			}

			public void changedUpdate(DocumentEvent e) {

			}
		});


		
		String[] num = new String[500];
		for (int i = 1; i < 500; i++) {
			num[i - 1] = String.valueOf(i);
		}
		JComboBox numbox = new JComboBox(num);

		String[] type = { "普通快递", "经济快递", "次晨特快" };
		final JComboBox typebox = new JComboBox(type);

		String[] depature = { "南京", "广州", "上海", "北京", "深圳", "苏州" };
		final JComboBox depaturebox = new JComboBox(depature);

		String[] destination = { "南京", "广州", "上海", "北京", "深圳", "苏州" };
		final JComboBox destinationbox = new JComboBox(destination);

		String[] pack = { "纸箱(5元)", "木箱(10元)", "快递袋(1元)" };
		final JComboBox packagebox = new JComboBox(pack);

		
		String[] year = new String[100];
		for (int i = 2015; i < 2115; i++) {
			year[i - 2015] = i + "年";

		}
		final JComboBox yearbox1 = new JComboBox(year);
		final JComboBox yearbox2 = new JComboBox(year);
		String[] month = new String[12];
		for (int i = 1; i <= 12; i++) {
			month[i - 1] = i + "月";

		}
		final JComboBox monthbox1 = new JComboBox(month);
		final JComboBox monthbox2 = new JComboBox(month);
		String[] day = new String[31];
		for (int i = 1; i <= 31; i++) {
			day[i - 1] = i + "日";

		}
		final JComboBox daybox1 = new JComboBox(day);
		final JComboBox daybox2 = new JComboBox(day);
		
		
		
		
		
		JButton b4 = new JButton("生成寄件单");
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			 
			 boolean senderisempty=sender.getText().equals("");
			 boolean senderinfoisempty=senderinfo.getText().equals("");
			 boolean sendertelisempty=sendertel.getText().equals("");
			 boolean sendersiteisempty=sendersite.getText().equals("");
			 
			 boolean getterisempty=getter.getText().equals("");
			 boolean getterinfoisempty=getterinfo.getText().equals("");
			 boolean gettertelisempty=sendertel.getText().equals("");
			 boolean gettersiteisempty=sendersite.getText().equals("");
			 
			 boolean goodsnameisempty=goodsname.getText().equals("");
			 boolean goodsweightisempty=goodsweight.getText().equals("");
			 boolean lengthisempty=length.getText().equals("");
			 boolean widthisempty=width.getText().equals("");
			 boolean heightisempty=height.getText().equals("");			 
			 boolean goodsinfoisempty=goodsinfo.getText().equals("");
			 boolean courierisempty=courier.getText().equals("");
			 
			 boolean isempty=senderisempty||senderinfoisempty||sendertelisempty||sendersiteisempty||getterisempty||getterinfoisempty||gettertelisempty||gettersiteisempty
		||goodsnameisempty||goodsweightisempty||lengthisempty||widthisempty||heightisempty||goodsinfoisempty||courierisempty;

			 String exceptedtime=yearbox1.getSelectedItem().toString()+monthbox1.getSelectedItem().toString()+daybox1.getSelectedItem().toString();
			 String generatetime=yearbox2.getSelectedItem().toString()+monthbox2.getSelectedItem().toString()+daybox2.getSelectedItem().toString();
			 
			 if(!isempty){				 
//			 GoodsBl goodsbl=new GoodsBl();//生成PO中的两个null分别为没有的Goodsid和收件日期
//			 GoodsDocuPO gpo=new GoodsDocuPO(sender.getText(), senderinfo.getText(),
//					 sendertel.getText(), sendersite.getText(), getter.getText(), getterinfo.getText(), 
//					 gettertel.getText(), gettersite.getText(),
//					 Double.valueOf(price.getText()),//此处应为包装费
//					 Double.valueOf(price.getText()),//此处应为总快递费
//					 typebox.getSelectedItem().toString(),null,null,goodsname.getText(),
//					 Integer.valueOf(goodsnumber.getText()), Double.valueOf(length.getText()),
//					 Double.valueOf(width.getText()),Double.valueOf(height.getText()),Double.valueOf(V.getText()),goodsinfo.getText(),
//					 packagebox.getSelectedItem().toString(), exceptedtime, generatetime,courier.getText());
			 JOptionPane.showMessageDialog(null, "成功生成寄件单!");
			 }
			 else{
				 JOptionPane.showMessageDialog(null, "信息未填写完整!");
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
		p1.add(l6);// �ļ���

		p1.add(l7);
		p1.add(l8);
		p1.add(l9);
		p1.add(l10);// �ռ���

		p1.add(l11);
		p1.add(l12);
		p1.add(l13);
		p1.add(l14);
		p1.add(l15);
		p1.add(l16);
		p1.add(l17);
		p1.add(l18);// ����

		p1.add(l19);
		p1.add(l20);
		p1.add(l21);
		p1.add(l22);
		p1.add(l24);
		p1.add(l25);
		p1.add(l26);
		p1.add(l27);
		p1.add(l28);

		p1.add(sender);
		p1.add(senderinfo);
		p1.add(sendertel);
		p1.add(sendersite);// �ļ���
		p1.add(getter);
		p1.add(getterinfo);
		p1.add(gettertel);
		p1.add(gettersite);// �ռ���
		p1.add(goodsname);
		p1.add(goodsweight);
		p1.add(length);
		p1.add(width);
		p1.add(height);
		p1.add(V);
		p1.add(goodsinfo);
		p1.add(numbox);// ����
		p1.add(price);
		p1.add(depaturebox);
		p1.add(destinationbox);

		// p1.add(t17);
		p1.add(courier);
		p1.add(typebox);
		p1.add(packagebox);
		p1.add(yearbox1);
		p1.add(monthbox1);
		p1.add(daybox1);// ����
		p1.add(yearbox2);
		p1.add(monthbox2);
		p1.add(daybox2);

		p1.add(b4);

		p1.setOpaque(false);

		l1.setBounds(300, -20, 180, 80);
		l2.setBounds(50, p1.getHeight() * 1 / 15, 150, 30);

		int l3xloc = p1.getWidth() / 15;
		int l4xloc = p1.getWidth() / 3;
		int l3yloc = 3 * p1.getWidth() / 20;
		int interval = 50;
		l3.setBounds(l3xloc, l3yloc, 80, 30);
		l4.setBounds(l4xloc, l3yloc, 120, 30);
		l5.setBounds(l3xloc, l3yloc + interval, 80, 30);
		l6.setBounds(l4xloc, l3yloc + interval, 120, 30);// �ļ���

		l7.setBounds(l3xloc, l3yloc + 2 * interval, 80, 30);
		l8.setBounds(l4xloc, l3yloc + 2 * interval, 120, 30);
		l9.setBounds(l3xloc, l3yloc + 3 * interval, 80, 30);
		l10.setBounds(l4xloc, l3yloc + 3 * interval, 120, 30);// �ռ���

		l11.setBounds(l3xloc, l3yloc + 4 * interval, 80, 30);
		l12.setBounds(l4xloc, l3yloc + 4 * interval, 120, 30);
		l13.setBounds(l4xloc + 150, l3yloc + 4 * interval, 120, 30);
		l14.setBounds(l3xloc, l3yloc + 5 * interval, 120, 30);
		l15.setBounds(l3xloc + 180, l3yloc + 5 * interval, 120, 30);
		l16.setBounds(l3xloc + 360, l3yloc + 5 * interval, 120, 30);
		l17.setBounds(l3xloc + 540, l3yloc + 5 * interval, 120, 30);
		l18.setBounds(l3xloc, l3yloc + 6 * interval, 120, 30); // ����

		l19.setBounds(l3xloc, l3yloc + 7 * interval, 120, 30);
		l20.setBounds(l3xloc + 200, l3yloc + 7 * interval, 120, 30);
		l21.setBounds(l3xloc + 400, l3yloc + 8 * interval, 120, 30);
		l22.setBounds(l3xloc, l3yloc + 8 * interval, 150, 30);
		// l23.setBounds(l3xloc+400, l3yloc+8*interval, 150, 30);

		l24.setBounds(l3xloc, l3yloc + 9 * interval, 150, 30);
		l25.setBounds(l3xloc + 450, l3yloc + 9 * interval, 150, 30);
		l26.setBounds(l3xloc + 660, l3yloc + 8 * interval, 100, 30);
		l27.setBounds(l3xloc + 400, l3yloc + 7 * interval, 120, 30);
		l28.setBounds(l3xloc + 550, l3yloc + 7 * interval, 120, 30);

		int t1xloc = l3xloc + 80;
		int t2xloc = l4xloc + 100;
		int t1yloc = l3yloc;
		sender.setBounds(t1xloc, t1yloc, 100, 30);
		senderinfo.setBounds(t2xloc, t1yloc, 350, 30);
		sendertel.setBounds(t1xloc, t1yloc + interval, 100, 30);
		sendersite.setBounds(t2xloc, t1yloc + interval, 350, 30);// �ļ���

		getter.setBounds(t1xloc, t1yloc + 2 * interval, 100, 30);
		getterinfo.setBounds(t2xloc, t1yloc + 2 * +interval, 350, 30);
		gettertel.setBounds(t1xloc, t1yloc + 3 * interval, 100, 30);
		gettersite.setBounds(t2xloc, t1yloc + 3 * interval, 350, 30);// �ռ���

		goodsname.setBounds(t1xloc, t1yloc + 4 * interval, 100, 30);
		goodsweight.setBounds(t2xloc + 160, t1yloc + 4 * interval, 100, 30);
		length.setBounds(t1xloc, t1yloc + 5 * interval, 80, 30);
		width.setBounds(t1xloc + 180, t1yloc + 5 * interval, 80, 30);
		height.setBounds(t1xloc + 360, t1yloc + 5 * interval, 80, 30);
		V.setBounds(t1xloc + 560, t1yloc + 5 * interval, 80, 30);
		goodsinfo.setBounds(t1xloc, t1yloc + 6 * interval, 650, 30);
		numbox.setBounds(t1xloc + 210, t1yloc + 4 * interval, 60, 30);// ����

		typebox.setBounds(t1xloc, t1yloc + 7 * interval, 80, 30);
		packagebox.setBounds(t1xloc + 200, t1yloc + 7 * interval, 120, 30);
		price.setBounds(t1xloc + 450, t1yloc + 8 * interval, 120, 30);
		yearbox1.setBounds(t1xloc + 30, t1yloc + 8 * interval, 80, 30);
		monthbox1.setBounds(t1xloc + 120, t1yloc + 8 * interval, 80, 30);
		daybox1.setBounds(t1xloc + 210, t1yloc + 8 * interval, 80, 30);
		depaturebox.setBounds(t1xloc + 380, t1yloc + 7 * interval, 80, 30);
		destinationbox.setBounds(t1xloc + 530, t1yloc + 7 * interval, 80, 30);

		// t17.setBounds(t1xloc+450,t1yloc+8*interval, 200, 30);
		// ����

		yearbox2.setBounds(t1xloc + 50, t1yloc + 9 * interval, 80, 30);
		monthbox2.setBounds(t1xloc + 140, t1yloc + 9 * interval, 80, 30);
		daybox2.setBounds(t1xloc + 230, t1yloc + 9 * interval, 80, 30);
		courier.setBounds(t1xloc + 450, t1yloc + 9 * interval, 120, 30);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 1 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 13 / 15;

		b4.setBounds(b4xloc, b4yloc, 180, 40);
		return p1;

	}
}