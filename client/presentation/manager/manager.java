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

import login.loginframe;
import po.EmploeePO;

public class manager {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 356;
	JPanel content = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};
	final JPanel control = new JPanel();
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel strategypanel;
	JPanel approvepanel;
	JPanel staffpanel;
	JPanel addempopanel;
	JPanel deleteempopanel;
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
		
		manager.setBounds(0, 0, 1344, 756);

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
		
		control.setBounds(0, 0, size, 700);
		content.setBounds(size, 0, 650, 700);

	

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

		JButton b4 = new JButton("制定经营策略");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(strategypanel);
			}

		});
		JButton b5 = new JButton("审批单据");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(approvepanel);
			}

		});

		JButton b6 = new JButton("查看表单");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					cd.Panel(content).repaint();
					content.setBounds(size, 0, content.getWidth(), content.getHeight());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b7 = new JButton("人员调度");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(staffpanel);
			}

		});
		JButton b8 = new JButton("添加员工");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(addempopanel);
			}

		});
		JButton b9 = new JButton("删除员工");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(deleteempopanel);
			}

		});

		control.setLayout(null);
		control.setOpaque(false);
	
	
		JTextField idt=new JTextField();
		JTextField namet=new JTextField();
		JTextField jobt=new JTextField();
	
		idt.setOpaque(false);
		idt.setEditable(false);
		idt.setBorder(BorderFactory.createEmptyBorder());
		namet.setOpaque(false);
		namet.setEditable(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		jobt.setOpaque(false);
		jobt.setEditable(false);
		jobt.setBorder(BorderFactory.createEmptyBorder());	
	
    	namet.setBounds(40, 170, 80, 30);
		idt.setBounds(100, 210, 80, 30);
		jobt.setBounds(100, 250, 80, 30);	
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
		control.add(b7);
		control.add(b8);
		control.add(b9);

		int b4xloc = size / 6, b4yloc = 3*control.getHeight() / 7, b4ysize = control.getHeight() /13;
		b4.setBounds(b4xloc, b4yloc, 120, 30);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 120, 30);
		b6.setBounds(b4xloc, b4yloc + 2 * b4ysize, 120, 30);
		b7.setBounds(b4xloc, b4yloc + 3 * b4ysize, 120, 30);
		b8.setBounds(b4xloc, b4yloc + 4 * b4ysize, 120, 30);
		b9.setBounds(b4xloc, b4yloc + 5 * b4ysize, 120, 30);
		b3.setBounds(b4xloc, b4yloc + 6 * b4ysize, 120, 30);

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