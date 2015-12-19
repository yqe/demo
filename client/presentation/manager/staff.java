package manager;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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

public class staff {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public staff(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 720, 700);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>人员调度");
		int b2size = 16;
		JLabel l3 = new JLabel("机构选择:");
		JLabel l4 = new JLabel("员工ID:");
		l2.setFont(new Font("", Font.PLAIN, b2size));
		l3.setFont(new Font("", Font.PLAIN, b2size));
		l4.setFont(new Font("", Font.PLAIN, b2size));

		String[] organ = { "营业厅", "中转中心", "总部" };

		JComboBox organbox = new JComboBox(organ);

		final JTextField t1 = new JTextField();
		
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
		JButton b5 = new JButton("确认");
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
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);

		p1.add(organbox);
		p1.add(t1);

		p1.add(b4);
		p1.add(b5);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 3;
		int b4yloc = p1.getHeight() * 4 / 15 + 20, b4ysize = p1.getHeight() * 2 / 5;

		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, b1yloc, 180, 30);

		l3.setBounds(150, b4yloc, 180, 30);
		l4.setBounds(150, b4yloc + b4ysize, 180, 30);

		organbox.setBounds(250, b4yloc, 120, 30);
		t1.setBounds(250, b4yloc + b4ysize, 120, 30);

		b4.setBounds(b4xloc, b4yloc, 100, 40);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 100, 40);

		return p1;

	}
}