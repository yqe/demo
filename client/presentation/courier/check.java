package courier;

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
import po.EmploeePO;

public class check {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};

	public check(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("check");
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 942, 815);
	

		final MTextfield id = new MTextfield();
		
		id.settextFont();
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoDialog info = null;
				if (id.getText().length() == 10) {
					try {
						GoodsBl goodsbl = new GoodsBl(oos,ois);
						String []infoma=new String[4];
//						System.out.println(id.getText());
						for(int i=0;i<4;i++){
//						infoma[i]= goodsbl.Goodsgetinfo(id.getText())[i];
//						System.out.println(goodsbl.Goodsgetinfo(id.getText()));
						}
						info = new infoDialog(infoma[0], infoma[1], infoma[2], infoma[3]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					info.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				}

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(id);

		p1.add(b4);

		p1.setOpaque(false);

	

	     b4.setContentAreaFilled(false);
	     b4.setBorder(BorderFactory.createEmptyBorder());

		id.setBounds(811-402, 262, 232, 47);

		b4.setBounds(688-402, 479, 310, 88);
		return p1;

	}
}