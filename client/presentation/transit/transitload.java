package transit;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/transitload.jpg"));
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 942, 821);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>装运管理");
		int l2size = 16;
		l2.setFont(new Font("—", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("中转单编号:");
		JLabel l4 = new JLabel("装车日期:");
		JLabel l5 = new JLabel("航班号:");
		JLabel l6 = new JLabel("到达地:");
		JLabel l7 = new JLabel("出发地:");
		JLabel l8 = new JLabel("货柜号:");
		JLabel l9 = new JLabel("监装员:");
		JLabel l10 = new JLabel("押运员:");
		JLabel l11 = new JLabel("运费:");
		JLabel l12 = new JLabel("元");

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

		final JTextField zzdid = new JTextField();
		final JTextField hbid = new JTextField();
		final JTextField hgid = new JTextField();
		final JTextField jz = new JTextField();
		final JTextField yy = new JTextField();
		final JTextField price = new JTextField();
		
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

		JButton b4 = new JButton("生成装车单");

		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小

		String[] site = { "上海", "北京", "南京", "深圳", "广州", "杭州" };

		final JComboBox sitebox1 = new JComboBox(site);
		final JComboBox sitebox2 = new JComboBox(site);

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
						JOptionPane.showMessageDialog(null, "成功生成装车单!");
					else
						JOptionPane.showMessageDialog(null, "生成装车单失败!");
				} else if (isempty) {
					JOptionPane.showMessageDialog(null, "请输入完整的信息!");
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
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(l12);

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

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 1 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 13 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(300, -20, 180, 80);
		l2.setBounds(50, b1yloc, 150, 30);
		l3.setBounds(200, 100, 150, 30);
		l4.setBounds(200, 150, 150, 30);
		datepick.setBounds(375, 150, 150, 30);

		l5.setBounds(200, 200, 150, 30);
		l6.setBounds(200, 250, 150, 30);
		l7.setBounds(200, 300, 150, 30);
		l8.setBounds(200, 350, 150, 30);
		l9.setBounds(200, 400, 150, 30);
		l10.setBounds(200, 450, 150, 30);
		l11.setBounds(200, 500, 150, 30);
		l12.setBounds(450, 500, 100, 30);

		zzdid.setBounds(375, 100, 150, 30);
		hbid.setBounds(375, 200, 150, 30);
		sitebox1.setBounds(375, 250, 80, 30);
		sitebox2.setBounds(375, 300, 80, 30);
		hgid.setBounds(375, 350, 150, 30);
		jz.setBounds(375, 400, 150, 30);
		yy.setBounds(375, 450, 150, 30);
		price.setBounds(375, 500, 150, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);

		return p1;

	}

}