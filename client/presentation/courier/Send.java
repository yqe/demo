package courier;

import goodsbl.GoodsBl;
import image.ImageGet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import login.MTextfield;
import login.Mdialog;

import com.eltima.components.ui.DatePicker;

import po.EmploeePO;
import po.GoodsDocuPO;
import documentbl.Goodsdocu;

public class Send {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public Send(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("send");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 942, 815);

		final MTextfield sender = new MTextfield();
		final MTextfield senderinfo = new MTextfield();
		final MTextfield sendertel = new MTextfield();
		final MTextfield sendersite = new MTextfield();
		final MTextfield getter = new MTextfield();
		final MTextfield getterinfo = new MTextfield();
		final MTextfield gettertel = new MTextfield();
		final MTextfield gettersite = new MTextfield();
		final MTextfield goodsname = new MTextfield();
		final MTextfield goodsweight = new MTextfield();
		final MTextfield length = new MTextfield();
		final MTextfield width = new MTextfield();
		final MTextfield height = new MTextfield();
		final MTextfield V = new MTextfield();
		final MTextfield goodsinfo = new MTextfield();
		final MTextfield price = new MTextfield();
		final MTextfield exceptedtime = new MTextfield();
		// JTextField t17=new JTextField();
		final MTextfield courier = new MTextfield();

		final MTextfield id = new MTextfield();
		
		sender.settextFont();
		senderinfo.settextFont();
		sendertel.settextFont();
		sendersite.settextFont();
		getter.settextFont();
		getterinfo.settextFont();
		gettertel.settextFont();
		gettersite.settextFont();

		id.settextFont();
		id.setBorder(BorderFactory.createEmptyBorder());
		id.setOpaque(false);
		
		GoodsBl gbl=new GoodsBl(oos,ois);
		id.setText(gbl.GetExpressID());
		id.setEditable(false);
		
		goodsname.settextFont();
		goodsweight.settextFont();
		length.settextFont();
		width.settextFont();
		height.settextFont();
		V.settextFont();
		goodsinfo.settextFont();
		price.settextFont();		
		exceptedtime.settextFont();
		courier.settextFont();
		
		Calendar c=Calendar.getInstance();
		Date d=c.getTime();
		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time,d);

		// datepick.setLocale(Locale.CHINA);//设置显示语言
		datepick.setBackground(Color.gray);
		// datepick.setFieldForeground(Color.white);
		datepick.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick.setEditorable(false);// 设置是否可编辑
		datepick.setPreferredSize(new Dimension(100, 30));// 设置大小

		sender.setOpaque(false);
		sender.setBorder(BorderFactory.createEmptyBorder());
		senderinfo.setOpaque(false);
		senderinfo.setBorder(BorderFactory.createEmptyBorder());
		sendertel.setOpaque(false);
		sendertel.setBorder(BorderFactory.createEmptyBorder());
		sendersite.setOpaque(false);
		sendersite.setBorder(BorderFactory.createEmptyBorder());

		getter.setOpaque(false);
		getter.setBorder(BorderFactory.createEmptyBorder());
		getterinfo.setOpaque(false);
		getterinfo.setBorder(BorderFactory.createEmptyBorder());
		gettertel.setOpaque(false);
		gettertel.setBorder(BorderFactory.createEmptyBorder());
		gettersite.setOpaque(false);
		gettersite.setBorder(BorderFactory.createEmptyBorder());

		goodsname.setOpaque(false);
		goodsname.setBorder(BorderFactory.createEmptyBorder());
		goodsweight.setOpaque(false);
		goodsweight.setBorder(BorderFactory.createEmptyBorder());
		length.setOpaque(false);
		length.setBorder(BorderFactory.createEmptyBorder());
		width.setOpaque(false);
		width.setBorder(BorderFactory.createEmptyBorder());
		height.setOpaque(false);
		height.setBorder(BorderFactory.createEmptyBorder());

		goodsinfo.setOpaque(false);
		goodsinfo.setBorder(BorderFactory.createEmptyBorder());
		price.setOpaque(false);
		price.setBorder(BorderFactory.createEmptyBorder());
		exceptedtime.setOpaque(false);
		exceptedtime.setBorder(BorderFactory.createEmptyBorder());
		courier.setOpaque(false);
		courier.setBorder(BorderFactory.createEmptyBorder());

		//
		V.setOpaque(false);
		V.setBorder(BorderFactory.createEmptyBorder());
		V.setEditable(false);
		// exceptedtime.setOpaque(false);
		// exceptedtime.setEditable(false);

		String[] num = new String[500];
		for (int i = 1; i < 500; i++) {
			num[i - 1] = String.valueOf(i);
		}
		final JComboBox numbox = new JComboBox(num);
		numbox.setBackground(Color.gray);
		numbox.setForeground(Color.white);
		numbox.setFont(new Font("幼圆", Font.BOLD, 18));
		numbox.setOpaque(false);

		String[] type = { "普通快递", "经济快递", "次晨特快" };
		final JComboBox typebox = new JComboBox(type);
		typebox.setBackground(Color.gray);
		typebox.setForeground(Color.white);
		typebox.setFont(new Font("幼圆", Font.BOLD, 18));
		typebox.setOpaque(false);

		String[] pack = { "纸箱(5元)", "木箱(10元)", "快递袋(1元)" };
		final JComboBox packagebox = new JComboBox(pack);
		packagebox.setBackground(Color.gray);
		packagebox.setForeground(Color.white);
		packagebox.setFont(new Font("幼圆", Font.BOLD, 18));
		packagebox.setOpaque(false);

		String[] depature = { "南京", "广州", "上海", "北京", "深圳", "苏州" };
		final JComboBox depaturebox = new JComboBox(depature);
		depaturebox.setBackground(Color.gray);
		depaturebox.setForeground(Color.white);
		depaturebox.setFont(new Font("幼圆", Font.BOLD, 18));
		depaturebox.setOpaque(false);

		String[] destination = { "南京", "广州", "上海", "北京", "深圳", "苏州" };
		final JComboBox destinationbox = new JComboBox(destination);
		destinationbox.setBackground(Color.gray);
		destinationbox.setForeground(Color.white);
		destinationbox.setFont(new Font("幼圆", Font.BOLD, 18));
		destinationbox.setOpaque(false);

		numbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					GoodsBl goodsbl = new GoodsBl(oos, ois);
					double weight = Double.valueOf(goodsweight.getText());
					String fee = goodsbl.Goodsgetfee(weight, typebox.getSelectedItem().toString(),
							packagebox.getSelectedItem().toString(), depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString());
					double feedou = Double.valueOf(fee);
					double goodsprice = (Double.valueOf(numbox.getSelectedItem().toString())) * feedou;
					price.setText(String.valueOf(goodsprice));
				}
			}
		});

		typebox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					GoodsBl goodsbl = new GoodsBl(oos, ois);
					double weight = Double.valueOf(goodsweight.getText());
					String fee = goodsbl.Goodsgetfee(weight, typebox.getSelectedItem().toString(),
							packagebox.getSelectedItem().toString(), depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString());
					double feedou = Double.valueOf(fee);
					double goodsprice = (Double.valueOf(numbox.getSelectedItem().toString())) * feedou;
					price.setText(String.valueOf(goodsprice));
					
					String days=goodsbl.Goodsgetdate(depaturebox.getSelectedItem().toString(), 
							destinationbox.getSelectedItem().toString(), typebox.getSelectedItem().toString());

		             exceptedtime.setText(days);
				}
			}
		});

		packagebox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					GoodsBl goodsbl = new GoodsBl(oos, ois);
					double weight = Double.valueOf(goodsweight.getText());
					String fee = goodsbl.Goodsgetfee(weight, typebox.getSelectedItem().toString(),
							packagebox.getSelectedItem().toString(), depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString());
					double feedou = Double.valueOf(fee);
					double goodsprice = (Double.valueOf(numbox.getSelectedItem().toString())) * feedou;
					price.setText(String.valueOf(goodsprice));

				}
			}
		});

		depaturebox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					GoodsBl goodsbl = new GoodsBl(oos, ois);
					double weight = Double.valueOf(goodsweight.getText());
					String fee = goodsbl.Goodsgetfee(weight, typebox.getSelectedItem().toString(),
							packagebox.getSelectedItem().toString(), depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString());
					double feedou = Double.valueOf(fee);
					double goodsprice = (Double.valueOf(numbox.getSelectedItem().toString())) * feedou;
					price.setText(String.valueOf(goodsprice));
					
					String days=goodsbl.Goodsgetdate(depaturebox.getSelectedItem().toString(), 
							destinationbox.getSelectedItem().toString(), typebox.getSelectedItem().toString());

		             exceptedtime.setText(days);
				}
			}
		});

		destinationbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					GoodsBl goodsbl = new GoodsBl(oos, ois);
					double weight = Double.valueOf(goodsweight.getText());
					String fee = goodsbl.Goodsgetfee(weight, typebox.getSelectedItem().toString(),
							packagebox.getSelectedItem().toString(), depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString());
					double feedou = Double.valueOf(fee);
					double goodsprice = (Double.valueOf(numbox.getSelectedItem().toString())) * feedou;
					
					price.setText(String.valueOf(goodsprice));
					
					System.out.print(goodsprice);
					System.out.println("&&&&");
					exceptedtime.setText(goodsbl.Goodsgetdate(depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString(), typebox.getSelectedItem().toString()));
			
					String days=goodsbl.Goodsgetdate(depaturebox.getSelectedItem().toString(), 
							destinationbox.getSelectedItem().toString(), typebox.getSelectedItem().toString());

		             exceptedtime.setText(days);
				}
			}
		});

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
					double v = Double.valueOf(length.getText()) * Double.valueOf(width.getText())
							* Double.valueOf(height.getText());
					// System.out.println(v);
					V.setText(String.valueOf(v));
					double weight = Double.valueOf(goodsweight.getText());
					System.out.println(weight);
					if (weight < (v / 5000)) {
						weight = v / 5000;
					}
					goodsweight.setText(String.valueOf(weight));
				} catch (Exception e1) {
					return;
				}

			}

			public void insertUpdate(DocumentEvent e) {
				try {
					double v = Double.valueOf(length.getText()) * Double.valueOf(width.getText())
							* Double.valueOf(height.getText());

					V.setText(String.valueOf(v));
					double weight = Double.valueOf(goodsweight.getText());
					// System.out.println(weight);
					if (weight < (v / 5000)) {
						weight = v / 5000;
					}
					goodsweight.setText(String.valueOf(weight));
					GoodsBl goodsbl = new GoodsBl(oos, ois);
					String fee = goodsbl.Goodsgetfee(weight, typebox.getSelectedItem().toString(),
							packagebox.getSelectedItem().toString(), depaturebox.getSelectedItem().toString(),
							destinationbox.getSelectedItem().toString());
					double feedou = Double.valueOf(fee);
					double goodsprice = (Double.valueOf(numbox.getSelectedItem().toString())) * feedou;
					price.setText(String.valueOf(goodsprice));
				} catch (Exception e1) {
					return;
				}
			}

			public void changedUpdate(DocumentEvent e) {

			}
		});
		goodsweight.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {

			}

			public void insertUpdate(DocumentEvent e) {

			}

			public void changedUpdate(DocumentEvent e) {

			}
		});
		price.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {

			}

			public void insertUpdate(DocumentEvent e) {

			}

			public void changedUpdate(DocumentEvent e) {

			}
		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean senderisempty = sender.getText().equals("");
				boolean senderinfoisempty = senderinfo.getText().equals("");
				boolean sendertelisempty = sendertel.getText().equals("");
				boolean sendersiteisempty = sendersite.getText().equals("");

				boolean getterisempty = getter.getText().equals("");
				boolean getterinfoisempty = getterinfo.getText().equals("");
				boolean gettertelisempty = sendertel.getText().equals("");
				boolean gettersiteisempty = sendersite.getText().equals("");

				boolean goodsnameisempty = goodsname.getText().equals("");
				boolean goodsweightisempty = goodsweight.getText().equals("");
				boolean lengthisempty = length.getText().equals("");
				boolean widthisempty = width.getText().equals("");
				boolean heightisempty = height.getText().equals("");
				boolean goodsinfoisempty = goodsinfo.getText().equals("");
				boolean courierisempty = courier.getText().equals("");

				boolean isempty = senderisempty || senderinfoisempty || sendertelisempty || sendersiteisempty
						|| getterisempty || getterinfoisempty || gettertelisempty || gettersiteisempty
						|| goodsnameisempty || goodsweightisempty || lengthisempty || widthisempty || heightisempty
						|| goodsinfoisempty || courierisempty;

				// String
				// exceptedtime=yearbox1.getSelectedItem().toString()+monthbox1.getSelectedItem().toString()+daybox1.getSelectedItem().toString();
				String generatetime = datepick.getText();
				double j = 0;
				if (packagebox.equals("纸箱(5元)")) {
					j = 5.0;
				} else if (packagebox.equals("木箱(10元)")) {
					j = 10.0;
				} else {
					j = 1.0;
				}

				GoodsBl goodsbl = new GoodsBl(oos, ois);
				String id = goodsbl.GetExpressID();
				GoodsDocuPO gpo = new GoodsDocuPO(sender.getText(), senderinfo.getText(), sendertel.getText(),
						sendersite.getText(), getter.getText(), getterinfo.getText(), gettertel.getText(),
						gettersite.getText(), j, Double.valueOf(price.getText()), typebox.getSelectedItem().toString(),
						id, Double.valueOf(goodsweight.getText()), goodsname.getText(),
						Integer.valueOf(numbox.getSelectedItem().toString()), Double.valueOf(length.getText()),
						Double.valueOf(width.getText()), Double.valueOf(height.getText()), Double.valueOf(V.getText()),
						goodsinfo.getText(), packagebox.getSelectedItem().toString(), exceptedtime.getText(),
						generatetime, courier.getText(), depaturebox.getSelectedItem().toString(),
						destinationbox.getSelectedItem().toString());
				if (!isempty && goodsbl.BuildGoodsDocu(gpo)) {

					// goodsbl.BuildGoodsDocu(gpo);
					Mdialog.showMessageDialog("成功生成寄件单!");
				} else {
					Mdialog.showMessageDialog("信息未填写完整!");
				}

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);

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
		p1.add(id);
		p1.add(courier);
		p1.add(typebox);
		p1.add(packagebox);
		p1.add(exceptedtime);
		// p1.add(yearbox1);
		// p1.add(monthbox1);
		// p1.add(daybox1);// ����
		p1.add(datepick);

		p1.add(b4);

		p1.setOpaque(false);

		int size = 402;
		int senderxloc = 573 - size, getterxloc = 1054 - size;
		
		exceptedtime.setEditable(false);
		
		
		
		
		id.setBounds(891-402, 62, 228, 40);

		sender.setBounds(senderxloc, 194, 167, 38);
		senderinfo.setBounds(senderxloc, 303, 192, 58);
		sendertel.setBounds(senderxloc, 250, 167, 38);
		sendersite.setBounds(senderxloc, 371, 192, 58);

		getter.setBounds(getterxloc, 194, 167, 38);
		getterinfo.setBounds(getterxloc, 316, 190, 55);
		gettertel.setBounds(getterxloc, 254, 167, 38);
		gettersite.setBounds(getterxloc, 382, 190, 55);// �ռ���

		goodsname.setBounds(557 - size, 510, 63, 43);
		goodsweight.setBounds(1140 - size, 510, 63, 43);

		length.setBounds(480 - size, 561, 98, 43);
		width.setBounds(650 - size, 561, 98, 43);
		height.setBounds(827 - size, 567, 98, 43);

		V.setBounds(1041 - size, 563, 99, 40);

		goodsinfo.setBounds(545 - size, 616, 376, 46);
		numbox.setBounds(862 - size, 510, 115, 43);// ����

		typebox.setBounds(1066 - size, 616, 161, 47);
		packagebox.setBounds(557 - size, 671, 115, 27);
		 price.setBounds(585 - size+260, 717, 90, 39);
		exceptedtime.setBounds(585 - size, 717, 164, 39);
		// yearbox1.setBounds(t1xloc + 30, t1yloc + 8 * interval, 80, 30);
		// monthbox1.setBounds(t1xloc + 120, t1yloc + 8 * interval, 80, 30);
		// daybox1.setBounds(t1xloc + 210, t1yloc + 8 * interval, 80, 30);
		depaturebox.setBounds(780 - size, 673, 109, 42);
		destinationbox.setBounds(1003 - size, 673, 104, 42);

		// t17.setBounds(t1xloc+450,t1yloc+8*interval, 200, 30);
		// ����

		datepick.setBounds(1145 - size, 720, 138, 38);
		courier.setBounds(1214 - size, 673, 104, 41);

		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());

		b4.setBounds(708 - size, 759, 326, 41);
		return p1;

	}
}