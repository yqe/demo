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
	int size = 180;
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel manager = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public manager(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/Mbackground.jpg"));
		background = new ImageIcon(bgp);
		
		manager.setBounds(0, 0, 900, 700);

		manager.setOpaque(false);
		manager.setLayout(null);

		final Strategy strategy = new Strategy(oos, ois, emPO);
		final deleteemployee delete = new deleteemployee(oos,ois,emPO);
		final addemployee add = new addemployee(oos, ois, emPO);
		final checkdocuments cd = new checkdocuments(oos, ois, emPO);
		final approve a = new approve(oos,ois,emPO);
		
		control.setBounds(0, 0, size, 700);
		content.setBounds(size, 0, 650, 700);

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

		JButton b4 = new JButton("制定经营策略");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Strategy strategy = new Strategy(oos, ois, emPO);
					changepanel(strategy.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b5 = new JButton("审批单据");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		
					changepanel(a.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				try {
					final staff sf = new staff(oos, ois, emPO);
					changepanel(sf.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b8 = new JButton("添加员工");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					changepanel(add.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b9 = new JButton("删除员工");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					changepanel(delete.Panel());
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
		content=p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		manager.add(content);
		manager.repaint();
	}

}