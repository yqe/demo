package storage;

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
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.MTextfield;
import login.Mdialog;
import login.loginframe;
import po.EmploeePO;
import storagebl.StorageBl;

public class storagemain {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 356;
	JPanel content = new JPanel();

	final JPanel control = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};
	private EmploeePO emPO;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	JPanel inspanel;
	JPanel ouspanel;
	JPanel chspanel;
	JPanel cospanel;
	JPanel caspanel;
	JPanel storagemain = new JPanel();

	public storagemain(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("storagemaincontrol");
		background = new ImageIcon(bgp);

		storagemain.setBounds(0, 0, 1344, 756);

		storagemain.setOpaque(false);
		storagemain.setLayout(null);

		final instorage ins = new instorage(oos, ois, emPO);
		final outstorage ous = new outstorage(oos, ois, emPO);
		final checkstorage chs = new checkstorage(oos, ois, emPO);
		final countstorage cos = new countstorage(oos, ois, emPO);
		final changestorage cas = new changestorage(oos, ois, emPO);

		inspanel = ins.Panel();
		ouspanel = ous.Panel();
		chspanel = chs.Panel();
		cospanel = cos.Panel(emPO.getPosID());
		caspanel = cas.Panel();

		control.setBounds(0, 0, size, 756);
		content.setBounds(size, 0, 988, 756);

		int b2size = 16;
		// l2.setFont(new Font("—> 主页", Font.PLAIN, b2size));

		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(inspanel);
			}

		});
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(ouspanel);
			}

		});

		JButton b6 = new JButton();
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(chspanel);
			}

		});
		JButton b7 = new JButton();
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(cospanel);
			}

		});
		JButton b8 = new JButton();
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(caspanel);
			}

		});

		control.setLayout(null);
		control.setOpaque(false);

		MTextfield idt = new MTextfield();
		MTextfield namet = new MTextfield();
		MTextfield jobt = new MTextfield();

		idt.settextFont();
		namet.settextFont();
		jobt.settextFont();

		idt.setOpaque(false);
		idt.setEditable(false);
		idt.setBorder(BorderFactory.createEmptyBorder());
		namet.setOpaque(false);
		namet.setEditable(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		jobt.setOpaque(false);
		jobt.setEditable(false);
		jobt.setBorder(BorderFactory.createEmptyBorder());

		namet.setBounds(120, 90, 150, 35);
		jobt.setBounds(120, 140, 200, 35);
		idt.setBounds(82, 225, 150, 30);

		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText("库存管理人员");// 因为显示不下所以填的这个

		control.add(idt);
		control.add(namet);
		control.add(jobt);

		control.add(b3);
		control.add(b4);
		control.add(b5);
		control.add(b6);
		control.add(b7);
		control.add(b8);

		b3.setContentAreaFilled(false);
		b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		b6.setContentAreaFilled(false);
		b6.setBorder(BorderFactory.createEmptyBorder());
		b7.setContentAreaFilled(false);
		b7.setBorder(BorderFactory.createEmptyBorder());
		b8.setContentAreaFilled(false);
		b8.setBorder(BorderFactory.createEmptyBorder());

		int xloc = 87, yloc = 341, length = 194, width = 45, interval = 70;
		b4.setBounds(xloc, yloc, length, width);
		b5.setBounds(xloc, yloc + interval, length, width);
		b6.setBounds(xloc, yloc + 2 * interval, length, width);
		b7.setBounds(xloc, yloc + 3 * interval, length, width + 2);
		b8.setBounds(xloc, yloc + 4 * interval - 3, length, width);
		b3.setBounds(xloc, yloc + 5 * interval - 3, length, width);

		content.add(inspanel);
		content.setLayout(null);
		content.setOpaque(false);

		storagemain.add(control);
		storagemain.add(content);
//		AlarmStorage();
		return storagemain;

	}

	public void AlarmStorage() {
		boolean alarm = new StorageBl(oos, ois).Storage110(emPO.getPosID());
		if (alarm)
			Mdialog.showMessageDialog("库存容量已达报警值请尽快调整！");
		else
			Mdialog.showMessageDialog("库存容量尚未到达报警值");
	}

	public void changepanel(JPanel p1) {
		storagemain.remove(content);
		content = p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		storagemain.add(content);
		storagemain.repaint();
		storagemain.revalidate();
	}
}