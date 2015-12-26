package Boclerk;

import image.ImageGet;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

import com.eltima.components.ui.DatePicker;

import login.MTextfield;
import login.Mdialog;
import login.Tran;
import documentbl.Earneddocu;
import po.EarnedPO;
import po.EmploeePO;

public class collection {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private EmploeePO emPO;
	JPanel p1 = new JPanel()
	{public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};
	public collection(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("collection");
		background = new ImageIcon(bgp);
		p1.setBounds(0, 0, 942, 821);
		int l2size = 16;
	
//		JLabel l3 = new JLabel("订单条形码号：");
//		JLabel l4 = new JLabel("到达日期:");
//		JLabel l5 = new JLabel("收款金额:");
//		JLabel l6 = new JLabel("快递员:");
//
//		JLabel l7 = new JLabel("元");
//		JLabel l8 = new JLabel("营业厅编号:");
//		l3.setFont(new Font("", Font.PLAIN, lmain));
//		l4.setFont(new Font("", Font.PLAIN, lmain));
//		l5.setFont(new Font("", Font.PLAIN, lmain));
//		l6.setFont(new Font("", Font.PLAIN, lmain));
//		l7.setFont(new Font("", Font.PLAIN, lmain));
//		l8.setFont(new Font("", Font.PLAIN, lmain));

		final MTextfield id = new MTextfield();
		final MTextfield profit = new MTextfield();
		final MTextfield courier = new MTextfield();
		final MTextfield yyt = new MTextfield();
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		profit.setOpaque(false);
		profit.setBorder(BorderFactory.createEmptyBorder());
		courier.setOpaque(false);
		courier.setBorder(BorderFactory.createEmptyBorder());
		
		
		yyt.setText(emPO.getPosID());
		yyt.setOpaque(false);
		yyt.setBorder(BorderFactory.createEmptyBorder());
		yyt.setEditable(false);

		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setOpaque(false);
//		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String newdate=datepick.getText();
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
					Mdialog.showMessageDialog( "所输入订单条形码号非法!");
				else if (cisempty)
					Mdialog.showMessageDialog( "请完整填写信息!");
				else if (pisempty&&isnum)
					Mdialog.showMessageDialog("抱歉，请输入正确的收款金额!");
				else {
					Earneddocu edocu = new Earneddocu(oos,ois);
					boolean IsOk = edocu
							.BuildEarnedDocu(new EarnedPO(newdate, rececash, courier.getText(), id.getText(), yyt.getText()));
					if (IsOk) {
						Mdialog.showMessageDialog( "成功建立收款单!");
					} else {
						Mdialog.showMessageDialog( "建立收款单失敗!");
					}
				}
			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
//		p1.add(l1);
//		p1.add(l2);
//		p1.add(l3);
//		p1.add(l4);
//		p1.add(l5);
//		p1.add(l6);
//		p1.add(l7);
//		p1.add(l8);

		p1.add(id);
		p1.add(profit);
		p1.add(courier);
		p1.add(yyt);

		p1.add(b4);
		p1.add(datepick);
	

		p1.setOpaque(false);

		

//		l1.setBounds(180, -20, 180, 80);
//		l2.setBounds(50, b1yloc, 150, 30);
//		l3.setBounds(100, 200, 150, 30);
//		l4.setBounds(100, 250, 150, 30);

//		l5.setBounds(100, 300, 150, 30);
//		l7.setBounds(450, 300, 200, 30);
//
//		l6.setBounds(100, 350, 150, 30);
//		l8.setBounds(100, 400, 150, 30);

		int xloc=271,yloc=77; int length=234,width=38;
		int interval=55;
		
		id.settextFont();	profit.settextFont();	courier.settextFont();	yyt.settextFont();
		
		id.setBounds(xloc, yloc+interval, length, width);
		datepick.setBounds(xloc, yloc+interval*2, length, width);
		profit.setBounds(xloc, yloc+interval*3, length, width);
		courier.setBounds(xloc, yloc+interval*4, length, width);
		yyt.setBounds(xloc,yloc+interval*5, length, width);

		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		
		b4.setBounds(224, 482, 277, 84);

		return p1;

	}

}