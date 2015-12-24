package Inquiry;

import image.ImageGet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import goodsbl.GoodsBl;

public class Inquiry {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public Inquiry(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("Inquiry");
		background = new ImageIcon(bgp);

		final JPanel p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};
		p1.setBounds(0, 0, 1000, 611);

	

		final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();

		t1.setOpaque(false);
		t2.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setBorder(BorderFactory.createEmptyBorder());

//		JButton b3 = new JButton("退出");
//		b3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});

		JButton b4 = new JButton("查询");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String goodid = t1.getText();
				if (goodid.length() == 10) {
					GoodsBl gb = new GoodsBl(oos, ois);
					String route = gb.GoodsInquiry(goodid);
					t2.setText(route);
				} else
					JOptionPane.showMessageDialog(null, "请输入订单条形码号!");
				// boolean isid = true;
				// if (!t1.getText().equals("")) {
				// if (isid) {
				// t2.setText("查询成功！");
				// } else {
				// JOptionPane.showMessageDialog(null, "所输入订单条形码号不合法!");
				// }
				// } else {
				// JOptionPane.showMessageDialog(null, "请输入订单条形码号!");
				// }
			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(t1);
		p1.add(t2);

//		p1.add(b3);
		p1.add(b4);

	

	
//		t1.setBounds(275, 2 * b4yloc / 3 - 20, 200, 30);
//		t2.setBounds(275, 7 * b4yloc / 5 - 20, 280, 150);

//		b3.setBounds(b1xloc + 2 * b1xsize, b1yloc, 60, 30);
//		b4.setBounds(275, b4yloc - 20, 180, 40);

		return p1;

	}
}