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

import login.MTextfield;
import goodsbl.GoodsBl;

public class Inquiry {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	final JPanel p1 = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public Inquiry(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("Inquiry");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 1000, 611);

	

		final MTextfield t1 = new MTextfield();
		final MTextfield t2 = new MTextfield();

		t1.settextFont();t2.settextFont();
		
		t1.setOpaque(false);
		t2.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setBorder(BorderFactory.createEmptyBorder());

		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String goodid = t1.getText();
				if (goodid.length() == 10) {
					GoodsBl gb = new GoodsBl(oos, ois);
					String route = gb.GoodsInquiry(goodid);
					t2.setText(route);
				} else
					JOptionPane.showMessageDialog(null, "请输入正确的订单条形码号!");
			
			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(t1);
		p1.add(t2);

		p1.add(b3);
		p1.add(b4);

	

	
		t1.setBounds(402, 75, 271, 70);
		t2.setBounds(146, 178, 712, 358);

		b3.setContentAreaFilled(false);b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		
		b4.setBounds(751, 75, 246, 70);
		b3.setBounds(865, 540, 120, 54);

		return p1;

	}
}