package storage;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;

import po.EmploeePO;
import po.LookStoragePO;
import storagebl.StorageBl;

public class checkstorage {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	JPanel p1 = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public checkstorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("checkstorage");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 988, 756);
		p1.setOpaque(false);
//		JLabel l3 = new JLabel("时间选择:");
//		JLabel l4 = new JLabel("到");
//		JLabel l5 = new JLabel("出库数量:");
//		JLabel l6 = new JLabel("入库数量:");
//		JLabel l7 = new JLabel("金额:");
//		JLabel l8 = new JLabel("元");
//		JLabel l9 = new JLabel("库存数量:");
//
//		JLabel l10 = new JLabel("中转中心:");



		final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();
		final JTextField t3 = new JTextField();
		final JTextField t4 = new JTextField();
		
		final JTextField zzzx = new JTextField();

		t1.setOpaque(false);
		t1.setEditable(false);
		t2.setOpaque(false);
		t2.setEditable(false);
		t3.setOpaque(false);
		t3.setEditable(false);
		t4.setOpaque(false);
		t4.setEditable(false);
		
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setBorder(BorderFactory.createEmptyBorder());
		t3.setBorder(BorderFactory.createEmptyBorder());
		t4.setBorder(BorderFactory.createEmptyBorder());

		final JTextField time1 = new JTextField();
		final DatePicker datepick1 = new DatePicker(time1);
		datepick1.setOpaque(false);
		datepick1.setLocale(Locale.CHINA);//设置显示语言
	    datepick1.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick1.setEditorable(false);//设置是否可编辑
		datepick1.setPreferredSize(new Dimension(100,30));//设置大小
		
		final JTextField time2 = new JTextField();
		final DatePicker datepick2 = new DatePicker(time2);
		datepick2.setOpaque(false);
		datepick2.setLocale(Locale.CHINA);//设置显示语言
	    datepick2.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick2.setEditorable(false);//设置是否可编辑
		datepick2.setPreferredSize(new Dimension(100,30));//设置大小
		
		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageBl stobl = new StorageBl(oos, ois);
				LookStoragePO look=stobl.StorageSee(zzzx.getText(), datepick1.getText(), datepick2.getText());
                t1.setText(String.valueOf(look.getOutputnum()));
                t2.setText(String.valueOf(look.getIntputnum()));
                t3.setText(String.valueOf(look.getMoney()));
                t4.setText(String.valueOf(look.getStorednum()));
			}
		});

		p1.setLayout(null);
	

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		
		p1.add(zzzx);

		p1.add(b4);
		p1.add(datepick1);
		p1.add(datepick2);
	

		int b1yloc = p1.getHeight() * 2 / 19;

		
		datepick1.setBounds(195, 271, 177, 43);

		datepick2.setBounds(281+177, 271, 177, 43);
	

		zzzx.setOpaque(false);
		zzzx.setBorder(BorderFactory.createEmptyBorder());
		
		zzzx.setBounds(470, 152, 196, 42);
		

		b4.setContentAreaFilled(false);
		
		int xloc=315,yloc=445,length=174,width=43,xinterval=200,yinterval=100;
		t1.setBounds(xloc, yloc+yinterval-3, length, width);
		t2.setBounds(xloc, yloc, length, width);
		t3.setBounds(xloc+xinterval, yloc+yinterval, length, width);
		t4.setBounds(xloc+xinterval, yloc, length, width);
		
		b4.setBounds(679, 265, 200, 54);

		return p1;

	}

}