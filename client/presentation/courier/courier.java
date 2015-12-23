package courier;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.loginframe;
import po.EmploeePO;

public class courier {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 402;
	JPanel content = new JPanel();
	final JPanel control = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};
	private EmploeePO emPO;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	Send send = new Send(oos, ois, emPO);
	dispatch dispatch = new dispatch(oos, ois, emPO);
	check check = new check(oos, ois, emPO);
	JPanel sendpanel = new JPanel();
	JPanel dispatchpanel;
	JPanel checkpanel = new JPanel();
	JPanel courier = new JPanel() ;

	public courier(Socket socket, ObjectInputStream ois,
			ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("couriercontrol");
		background = new ImageIcon(bgp);

		courier.setBounds(0, 0, 1344, 815);

		courier.setOpaque(false);
		courier.setLayout(null);
		// Send send = new Send(oos, ois, emPO);
		sendpanel = send.Panel();
		// dispatch dispatch=new dispatch(oos,ois,emPO);
		dispatchpanel = dispatch.Panel();
		// check check=new check(oos,ois,emPO);
		checkpanel = check.Panel();

		control.setBounds(0, 0, size, 815);
		content.setBounds(size, 0, 942, 815);

		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—> 主页");
		int b2size = 16;
		l2.setFont(new Font("—> 主页", Font.PLAIN, b2size));

		JButton b3 = new JButton("退出");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton b4 = new JButton("生成寄件单");

		JButton b5 = new JButton("生成派件单");

		JButton b6 = new JButton("查询订单信息");

		control.setOpaque(false);
		control.setLayout(null);

		JLabel employid = new JLabel("工号 :");
		JLabel employjob = new JLabel("职位 :");
		employid.setFont(new Font("", Font.PLAIN, b2size));
		employjob.setFont(new Font("", Font.PLAIN, b2size));

		JTextField idt = new JTextField();
		idt.setFont(new Font("", Font.PLAIN, b2size));
		JTextField namet = new JTextField();
		namet.setFont(new Font("", Font.PLAIN, b2size));
		JTextField jobt = new JTextField();
		jobt.setFont(new Font("", Font.PLAIN, b2size));

		idt.setOpaque(false);
		idt.setEditable(false);
		idt.setBorder(BorderFactory.createEmptyBorder());
		namet.setOpaque(false);
		namet.setEditable(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		jobt.setOpaque(false);
		jobt.setEditable(false);
		jobt.setBorder(BorderFactory.createEmptyBorder());

		employid.setBounds(40, 210, 60, 30);
		employjob.setBounds(40, 250, 60, 30);

		namet.setBounds(40, 170, 80, 30);
		idt.setBounds(100, 210, 80, 30);
		jobt.setBounds(100, 250, 80, 30);

		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText(emPO.getPosition());

		control.add(employid);
		control.add(employjob);
		control.add(idt);
		control.add(namet);
		control.add(jobt);
		control.add(b3);
		control.add(b4);
		control.add(b5);
		control.add(b6);

		int b4xloc = size / 6, b4yloc = 3 * control.getHeight() / 7, b4ysize = control
				.getHeight() / 8;

		b3.setBounds(b4xloc, b4yloc + 3 * b4ysize, 120, 40);
		b4.setBounds(b4xloc, b4yloc, 120, 40);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 120, 40);
		b6.setBounds(b4xloc, b4yloc + 2 * b4ysize, 120, 40);

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changepanel(sendpanel);
			}

		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(dispatchpanel);
			}

		});

		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(checkpanel);
			}

		});

		content.add(sendpanel);
		content.setLayout(null);
		content.setOpaque(false);
		courier.add(control);
		courier.add(content);
		return courier;

	}

	public void changepanel(JPanel p1) {
		courier.remove(content);
		content = p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		courier.add(content);

		content.repaint();
		courier.repaint();
		courier.revalidate();
	}
}