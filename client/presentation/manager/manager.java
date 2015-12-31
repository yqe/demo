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
import login.loginframe;
import po.EmploeePO;

public class manager {
	private JPanel imagePanel;
	private ImageIcon background;
	public ImageIcon cdbackground;
	private ImageIcon button1;
	int size = 315;
	JPanel content = new JPanel() ;
	final JPanel control = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};
	
	final JPanel cdp = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(cdbackground.getImage(), 0, 0, null);
		}
	};
	
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel strategypanel;
	JPanel approvepanel;
	JPanel staffpanel;
	JPanel addempopanel;
	JPanel deleteempopanel;
	JPanel checkdocumentspanel;
	JPanel manager = new JPanel();

	public manager(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("managercontrol");
		background = new ImageIcon(bgp);
		
		 new ImageGet();
	        Image cdbgp=ImageGet.getImageByState("checkdocuments");
		cdbackground = new ImageIcon(cdbgp);
		
		manager.setBounds(0, 0, 1344, 840);

		manager.setOpaque(false);
		manager.setLayout(null);

		final Strategy strategy = new Strategy(oos, ois, emPO);
		final deleteemployee delete = new deleteemployee(oos,ois,emPO);
		final addemployee add = new addemployee(oos, ois, emPO);
		final checkdocuments cd = new checkdocuments(oos, ois, emPO);
		final approve a = new approve(oos,ois,emPO);
		final staff sf = new staff(oos, ois, emPO);
		
		
		strategypanel =strategy.Panel();
		deleteempopanel=delete.Panel();
		addempopanel=add.Panel();
		approvepanel=a.Panel();
		staffpanel=sf.Panel();
		checkdocumentspanel=cd.Panel(cdp);
		
		
		control.setBounds(0, 0, size, 840);
		content.setBounds(size, 0, 1029, 840);

	

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
				changepanel(strategypanel);
			}

		});
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(approvepanel);
			}

		});

		JButton b6 = new JButton();
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(checkdocumentspanel);
//					cd.Panel(content).repaint();
//					content.setBounds(size, 0, content.getWidth(), content.getHeight());
			}

		});
		JButton b7 = new JButton();
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(staffpanel);
			}

		});
		JButton b8 = new JButton();
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(addempopanel);
			}

		});
		JButton b9 = new JButton();
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(deleteempopanel);
			}

		});

		control.setLayout(null);
		control.setOpaque(false);
	
	
		MTextfield idt=new MTextfield();
		MTextfield namet=new MTextfield();
		MTextfield jobt=new MTextfield();
		MTextfield post=new MTextfield();
		
		idt.settextFont();namet.settextFont();jobt.settextFont();post.settextFont();
	
		idt.HideTheField();
		idt.setEditable(false);
	
	    namet.HideTheField();
		namet.setEditable(false);

	    jobt.HideTheField();
		jobt.setEditable(false);
		
		post.HideTheField();
		post.setEditable(false);
		
	
		namet.setBounds(200, 110, 150, 35);
		jobt.setBounds(200, 150, 200, 35);		
		idt.setBounds(82, 238, 150, 30);
		post.setBounds(200, 238, 150, 30);
		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText(emPO.getPosition());	
		post.setText(emPO.getPosID());
	
		control.add(idt);
		control.add(namet);
		control.add(jobt);
		control.add(post);
		control.add(b3);
		control.add(b4);
		control.add(b5);
		control.add(b6);
		control.add(b7);
		control.add(b8);
		control.add(b9);

		b3.setContentAreaFilled(false);b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
		b6.setContentAreaFilled(false);b6.setBorder(BorderFactory.createEmptyBorder());
		b7.setContentAreaFilled(false);b7.setBorder(BorderFactory.createEmptyBorder());
		b8.setContentAreaFilled(false);b8.setBorder(BorderFactory.createEmptyBorder());
		b9.setContentAreaFilled(false);b9.setBorder(BorderFactory.createEmptyBorder());
		
		
		int length=195,width=44;
		int xloc=88;
		b4.setBounds(xloc, 339, length, width);
		b5.setBounds(xloc, 392, length, width);
		b6.setBounds(xloc, 442, length, width);
		b7.setBounds(xloc, 495, length, width-2);
		b8.setBounds(xloc, 549, length, width);
		b9.setBounds(xloc, 594, length, width-2);
		b3.setBounds(xloc, 648, length, width+2);

		content.add(delete.Panel());
		content.setLayout(null);
		content.setOpaque(false);

		manager.add(control);
		manager.add(content);

		return manager;
	}

	public void changepanel(JPanel p1) {
		manager.remove(content);
		content = p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		manager.add(content);
		content.repaint();
		manager.repaint();
		manager.revalidate();
	}

}