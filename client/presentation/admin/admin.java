package admin;

import image.ImageGet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

import login.MTextfield;
import login.loginframe;
import po.EmploeePO;
import courier.Send;
import courier.check;
import courier.dispatch;

public class admin {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 356;
	JPanel content = new JPanel();
	final JPanel control = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
	};
	public Socket socket;
	public ObjectOutputStream oos;
	public ObjectInputStream ois;
	public EmploeePO empPO;
	JPanel admin = new JPanel() ;

	public admin(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.empPO = emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	       Image bgp=ImageGet.getImageByState("admincontrol");
		background = new ImageIcon(bgp);
		int b2size=16;
		admin.setBounds(0, 0, 1344, 756);

		admin.setOpaque(false);
		admin.setLayout(null);

		final changepasswordmain change = new changepasswordmain(oos,ois,empPO);

		control.setBounds(0, 0, size,756);
		content.setBounds(size, 0, 988, 756);

		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					oos.close();
					ois.close();
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changepanel(change.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final logoff logoff = new logoff(oos,ois,empPO);
					changepanel(logoff.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton b6 = new JButton();
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final authority au = new authority(oos,ois,empPO);
					changepanel(au.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton b7 = new JButton();
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					final adduser add = new adduser(oos,ois,empPO);
					changepanel(add.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		control.setLayout(null);
		control.setOpaque(false);
	

		
		MTextfield idt=new MTextfield();
		MTextfield namet=new MTextfield();	
		MTextfield jobt=new MTextfield();
		
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
			
		namet.setBounds(120, 90, 150, 35);
		jobt.setBounds(120, 140, 200, 35);		
		idt.setBounds(82, 228, 150, 30);	
	
		idt.setText(empPO.getEmpID());
		namet.setText(empPO.getName());
		jobt.setText(empPO.getPosition());

		
	
		control.add(idt);
		control.add(namet);
		control.add(jobt);
	
		control.add(b3);
		control.add(b4);
		control.add(b5);
		control.add(b6);
		control.add(b7);

	
		
		
		b3.setContentAreaFilled(false);b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
		b6.setContentAreaFilled(false);b6.setBorder(BorderFactory.createEmptyBorder());
		b7.setContentAreaFilled(false);b7.setBorder(BorderFactory.createEmptyBorder());
		
		
		int xloc=87,yloc=340,length=196,width=49,interval=70;
		b4.setBounds(xloc, yloc, length, width);
		b5.setBounds(xloc, yloc + interval, length, width);
		b6.setBounds(xloc, yloc + 2 * interval, length, width);
		b3.setBounds(xloc, yloc + 4 * interval+6, length, width);
		b7.setBounds(xloc, yloc + 3 * interval+6, length, width);

		content.add(change.Panel());
		content.setLayout(null);
		content.setOpaque(false);

		admin.add(control);
		admin.add(content);

		return admin;

	}

	public void changepanel(JPanel p1) {
		admin.remove(content);
		content=p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		admin.add(content);
		admin.repaint();
	}

}