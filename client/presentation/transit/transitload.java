package transit;

import image.ImageGet;

import java.awt.Color;
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

import login.MTextfield;
import login.Mdialog;

import com.eltima.components.ui.DatePicker;

import documentbl.Turndocu;
import po.EmploeePO;
import po.TransferDocuPO;

public class transitload {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	final JPanel p1 = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public transitload(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("transitload");
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 942, 821);
	
		int l2size = 16;
//		l2.setFont(new Font("—", Font.PLAIN, l2size));
//		JLabel l3 = new JLabel("中转单编号:");
//		JLabel l4 = new JLabel("装车日期:");
//		JLabel l5 = new JLabel("航班号:");
//		JLabel l6 = new JLabel("到达地:");
//		JLabel l7 = new JLabel("出发地:");
//		JLabel l8 = new JLabel("货柜号:");
//		JLabel l9 = new JLabel("监装员:");
//		JLabel l10 = new JLabel("押运员:");
//		JLabel l11 = new JLabel("运费:");
//		JLabel l12 = new JLabel("元");

	

		final MTextfield zzdid = new MTextfield();
		final MTextfield hbid = new MTextfield();
		final MTextfield hgid = new MTextfield();
		final MTextfield jz = new MTextfield();
		final MTextfield yy = new MTextfield();
		final MTextfield price = new MTextfield();
		
		zzdid.settextFont();hbid.settextFont();hgid.settextFont();
		jz.settextFont();yy.settextFont();price.settextFont();
		
		
		zzdid.setOpaque(false);
		zzdid.setBorder(BorderFactory.createEmptyBorder());
		hbid.setOpaque(false);
		hbid.setBorder(BorderFactory.createEmptyBorder());
		hgid.setOpaque(false);
		hgid.setBorder(BorderFactory.createEmptyBorder());
		jz.setOpaque(false);
		jz.setBorder(BorderFactory.createEmptyBorder());
		yy.setOpaque(false);
		yy.setBorder(BorderFactory.createEmptyBorder());
		price.setOpaque(false);
		price.setBorder(BorderFactory.createEmptyBorder());
		

		boolean zzdidisempty = zzdid.getText().equals("");
		boolean hbidisempty = hbid.getText().equals("");
		boolean hgidisempty = hgid.getText().equals("");
		boolean jzisempty = jz.getText().equals("");
		boolean yyisempty = yy.getText().equals("");
		boolean priceisempty = price.getText().equals("");

		final boolean isempty = zzdidisempty || hbidisempty || hgidisempty || jzisempty || yyisempty || priceisempty;

		JButton b4 = new JButton();

		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
//		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
//	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小

		String[] site = { "上海", "北京", "南京", "深圳", "广州", "杭州" };
	
//		Color text=new Color(0,0,0);
		
		final JComboBox sitebox1 = new JComboBox(site);
		
		sitebox1.setBackground(Color.gray);
		
		final JComboBox sitebox2 = new JComboBox(site);
		
		sitebox2.setBackground(Color.gray);
		
		String[] transport={"汽车","火车","飞机"};
		
		final JComboBox transportbox = new JComboBox(transport);
		
		transportbox.setBackground(Color.gray);

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isempty) {				
					TransferDocuPO tfpo = new TransferDocuPO("飞机",
							datepick.getText(),
							zzdid.getText(), hbid.getText(), (String) sitebox1.getSelectedItem(),
							(String) sitebox2.getSelectedItem(), hgid.getText(), jz.getText(), yy.getText(),
							Double.parseDouble(price.getText()));
					Turndocu td = new Turndocu(oos,ois);
					boolean IsOk = td.BuildTurnDocu(tfpo);
					if (IsOk)
						Mdialog.showMessageDialog( "成功生成装车单!");
					else
						Mdialog.showMessageDialog( "生成装车单失败!");
				} else if (isempty) {
				
					Mdialog.showMessageDialog( "请输入完整的信息!");
				}

			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(zzdid);
		p1.add(hbid);
		p1.add(hgid);
		p1.add(jz);
		p1.add(yy);
		p1.add(price);

		p1.add(b4);
		p1.add(datepick);
		p1.add(sitebox1);
		p1.add(sitebox2);
        p1.add(transportbox);

		int xloc=268,yloc=145,length=230,width=46,interval=61;
		
		
		
		zzdid.setBounds(xloc, yloc, length, width);
		datepick.setBounds(xloc, yloc+interval, length, width);
		transportbox.setBounds(xloc, yloc+interval*2, length, width);
		hbid.setBounds(xloc, yloc+interval*3, length, width);
		sitebox1.setBounds(xloc, yloc+interval*4, length, width);
		sitebox2.setBounds(xloc, yloc+interval*5-3, length, width);
		hgid.setBounds(xloc, yloc+interval*6-5, length, width);
		jz.setBounds(xloc, yloc+interval*7-7, length, width);
		yy.setBounds(xloc, yloc+interval*8-12, length, width);
		price.setBounds(xloc, yloc+interval*9-12, length, width);

		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		
		b4.setBounds(382, 739, 260, 64);

		return p1;

	}

}