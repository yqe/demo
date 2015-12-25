package manager;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.EmploeePO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.MTextfield;

public class staff {
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
	
	public staff(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("staff");
		background = new ImageIcon(bgp);	
		p1.setBounds(0, 0, 1029, 840);
		
	

		String[] organ = { "营业厅", "中转中心", "总部" };

		JComboBox organbox = new JComboBox(organ);

		final MTextfield t1 = new MTextfield();
		
		t1.settextFont();
		
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton("确认");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stafforgan sfo = null;
				try {
					sfo = new stafforgan();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sfo.setVisible(true);
			}

		});
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffchange sfc = null;
				try {
					if (!t1.getText().equals("")) {
						sfc = new staffchange();
						sfc.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "请输入员工ID!");
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(organbox);
		p1.add(t1);

		p1.add(b4);
		p1.add(b5);

		p1.setOpaque(false);

		

		b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
		
		organbox.setBounds(440, 285, 281, 45);
		t1.setBounds(445, 492, 281, 45);

//		b4.setBounds(b4xloc, b4yloc, 100, 40);
		b5.setBounds(718, 662, 200, 72);

		return p1;

	}
}