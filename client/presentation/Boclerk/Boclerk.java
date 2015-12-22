package Boclerk;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
	int size = 180;
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	private ObjectOutputStream oos;
	private Socket socket;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel loadpanel;
	JPanel collectionpanel;
	JPanel Maintenancepanel;
	JPanel arrivalpanel;
	JPanel Boclerk = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public Boclerk(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/Bbackground.jpg"));
		background = new ImageIcon(bgp);

		Boclerk.setBounds(0, 0, 780, 700);

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
		
		control.setBounds(0, 0, size, 700);
		content.setBounds(size, 0, 600, 700);

		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—> 主页");
		int b2size = 16;
		l2.setFont(new Font("—> 主页", Font.PLAIN, b2size));

		JButton b3 = new JButton("退出");
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

		JButton b4 = new JButton("生成装车单");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(loadpanel);
			}

		});
		JButton b5 = new JButton("建立收款单");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(collectionpanel);
			}

		});
		JButton b6 = new JButton("车辆信息维护");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(Maintenancepanel);
			}

		});
		JButton b7 = new JButton("生成到达单");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(arrivalpanel);
			}

		});

		control.setOpaque(false);
		control.setLayout(null);

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

		int b4xloc = size / 6, b4yloc = 3*control.getHeight() / 7, b4ysize = control.getHeight() / 9;

		b3.setBounds(b4xloc, b4yloc + 4 * b4ysize, 120, 30);
		b4.setBounds(b4xloc, b4yloc, 120, 30);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 120, 30);
		b6.setBounds(b4xloc, b4yloc + 2 * b4ysize, 120, 30);
		b7.setBounds(b4xloc, b4yloc + 3 * b4ysize, 120, 30);

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