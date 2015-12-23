package Boclerk;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import login.loginframe;
import po.EmploeePO;

public class Boclerk {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 402;
	JPanel content = new JPanel();
	final JPanel control = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel loadpanel;
	JPanel collectionpanel;
	JPanel Maintenancepanel;
	JPanel arrivalpanel;
	JPanel Boclerk = new JPanel() ;
	

	public Boclerk(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("boclerkcontrol");
		background = new ImageIcon(bgp);

		Boclerk.setBounds(0, 0, 1344, 821);

		Boclerk.setOpaque(false);
		Boclerk.setLayout(null);
		load load = new load(ois, oos, emPO);
		collection collection = new collection(ois, oos, emPO);
		Maintenance m = new Maintenance(ois, oos, emPO);
		arrival a = new arrival(ois, oos, emPO);
		
		loadpanel=load.Panel();
		collectionpanel=collection.Panel();
		Maintenancepanel=m.Panel();
		arrivalpanel=a.Panel();
		
		control.setBounds(0, 0, size, 821);
		content.setBounds(size, 0, 1344-size, 821);

		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ois.close();
					oos.close();
					socket.close();
				} catch (IOException e1) {
					// TODO
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(loadpanel);
			}

		});
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(collectionpanel);
			}

		});
		JButton b6 = new JButton();
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(Maintenancepanel);
			}

		});
		JButton b7 = new JButton();
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(arrivalpanel);
			}

		});

		control.setOpaque(false);
		control.setLayout(null);

		int b2size=18;
		JLabel employid=new JLabel("工号 :");
		JLabel employjob=new JLabel("职位 :");
		employid.setFont(new Font("", Font.PLAIN, b2size));
		employjob.setFont(new Font("", Font.PLAIN, b2size));		
		JTextField idt=new JTextField();
		idt.setFont(new Font("", Font.PLAIN, b2size));
		JTextField namet=new JTextField();
		namet.setFont(new Font("", Font.PLAIN, b2size));
		JTextField jobt=new JTextField();
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
		employjob.setBounds(40, 250,60, 30);
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
		control.add(b7);

		int b4xloc = 70, b4yloc = 389, b4ysize = 60;
		
		b3.setContentAreaFilled(false);
		b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
		b6.setContentAreaFilled(false);b6.setBorder(BorderFactory.createEmptyBorder());
		b7.setContentAreaFilled(false);b7.setBorder(BorderFactory.createEmptyBorder());
		
		b3.setBounds(b4xloc, b4yloc + 298, 250, 62);
		b4.setBounds(b4xloc, b4yloc, 250, 45);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 250, 45);
		b6.setBounds(b4xloc, b4yloc + 2 * b4ysize, 250, 45);
		b7.setBounds(b4xloc, b4yloc + 3 * b4ysize+2, 250, 45);

		content.add(load.Panel());
		content.setLayout(null);
		content.setOpaque(false);

		Boclerk.add(control);
		Boclerk.add(content);

		return Boclerk;

	}

	public void changepanel(JPanel p1) {
		Boclerk.remove(content);
		content = p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		Boclerk.add(content);

		content.repaint();
		Boclerk.repaint();
		Boclerk.revalidate();
	}

}