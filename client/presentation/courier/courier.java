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

import login.MTextfield;
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

	

		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.setContentAreaFilled(false);
		b3.setBorder(BorderFactory.createEmptyBorder());
		
		JButton b4 = new JButton();
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		JButton b5 = new JButton();
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		JButton b6 = new JButton();
		b6.setContentAreaFilled(false);
		b6.setBorder(BorderFactory.createEmptyBorder());
		
		control.setOpaque(false);
		control.setLayout(null);

		

		MTextfield idt = new MTextfield();
	
		MTextfield namet = new MTextfield();
		
		MTextfield jobt = new MTextfield();
		
		idt.settextFont();namet.settextFont();jobt.settextFont();
		

		idt.setOpaque(false);
		idt.setEditable(false);
		idt.setBorder(BorderFactory.createEmptyBorder());
		namet.setOpaque(false);
		namet.setEditable(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		jobt.setOpaque(false);
		jobt.setEditable(false);
		jobt.setBorder(BorderFactory.createEmptyBorder());

	

		namet.setBounds(200, 110, 150, 35);
		jobt.setBounds(200, 150, 200, 35);		
		idt.setBounds(82, 238, 150, 30);

		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText(emPO.getPosition());

		
		control.add(idt);
		control.add(namet);
		control.add(jobt);
		control.add(b3);
		control.add(b4);
		control.add(b5);
		control.add(b6);

	

		b3.setBounds(37, 670 , 334, 66);
		b4.setBounds(37, 387, 334, 66);
		b5.setBounds(37, 479, 334, 66);
		b6.setBounds(37, 573, 334, 66);

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