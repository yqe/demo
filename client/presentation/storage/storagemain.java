package storage;

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

import login.loginframe;
import po.EmploeePO;

public class storagemain {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	int size = 180;
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	private EmploeePO emPO;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	JPanel storagemain = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(Sbackground.getImage(), 0, 0, null);
		}
	};

	public storagemain(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/Sbackground.jpg"));
		Sbackground = new ImageIcon(bgp);

		storagemain.setBounds(0, 0, 1080, 700);

		storagemain.setOpaque(false);
		storagemain.setLayout(null);

		final instorage ins = new instorage(oos, ois, emPO);
		// final storageinfo sinfo = new storageinfo(posid);

		control.setBounds(0, 0, size, 700);
		content.setBounds(size, 0, 900, 700);

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

		JButton b4 = new JButton("入库登记");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final instorage ins = new instorage(oos, ois, emPO);
					changepanel(ins.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b5 = new JButton("出库登记");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final outstorage ous = new outstorage(oos, ois, emPO);
					changepanel(ous.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton b6 = new JButton("库存查看");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final checkstorage chs = new checkstorage(oos, ois, emPO);
					changepanel(chs.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b7 = new JButton("库存盘点");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final countstorage cos = new countstorage(oos, ois, emPO);
					changepanel(cos.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b8 = new JButton("库存更改");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final changestorage cas = new changestorage(oos, ois, emPO);
					changepanel(cas.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		control.setLayout(null);
		control.setOpaque(false);
		
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
		employid.setBounds(20, 180, 50, 30);
		employjob.setBounds(20, 220,50, 30);
	
		namet.setBounds(20, 140, 80, 30);
		idt.setBounds(80, 180, 80, 30);
		jobt.setBounds(80, 220, 110, 30);
	
		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText("库存管理人员");
	
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
		control.add(b8);

		int b4xloc = size / 6, b4yloc = 3*control.getHeight() / 8, b4ysize = control.getHeight() / 11;
		b4.setBounds(b4xloc, b4yloc, 120, 30);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 120, 30);
		b6.setBounds(b4xloc, b4yloc + 2 * b4ysize, 120, 30);
		b7.setBounds(b4xloc, b4yloc + 3 * b4ysize, 120, 30);
		b8.setBounds(b4xloc, b4yloc + 4 * b4ysize, 120, 30);
		b3.setBounds(b4xloc, b4yloc + 5 * b4ysize, 120, 30);

		content.add(ins.Panel());
		content.setLayout(null);
		content.setOpaque(false);

		storagemain.add(control);
		storagemain.add(content);

		return storagemain;

	}

	public void changepanel(JPanel p1) {
		storagemain.remove(content);
		content=p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		storagemain.add(content);
		storagemain.repaint();
	}
}