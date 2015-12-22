package transit;

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

public class transitmain {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 180;
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	private EmploeePO emPO;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	JPanel tspanel;
	JPanel tslpanel;
	
	JPanel transitmain = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public transitmain(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/tbackground.jpg"));
		background = new ImageIcon(bgp);

		transitmain.setBounds(0, 0, 980, 700);

		transitmain.setOpaque(false);
		transitmain.setLayout(null);

		final transit ts = new transit(oos, ois, emPO);
		tspanel=ts.Panel();
		final transitload tsl = new transitload(oos, ois, emPO);
        tslpanel=tsl.Panel();
		
		control.setBounds(0, 0, size, 700);
		content.setBounds(size, 0, 800, 700);

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
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		JButton b4 = new JButton("中转接收");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(tspanel);
			}

		});
		JButton b5 = new JButton("装运管理");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(tslpanel);
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

		int b4xloc = size / 6, b4yloc = 4*control.getHeight() / 9, b4ysize = control.getHeight() / 9;
		b4.setBounds(b4xloc, b4yloc, 120, 30);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 120, 30);
		b3.setBounds(b4xloc, b4yloc + 2 * b4ysize, 120, 30);

		content.add(tspanel);
		content.setLayout(null);
		content.setOpaque(false);

		transitmain.add(control);
		transitmain.add(content);

		return transitmain;

	}

	public void changepanel(JPanel p1) {
		transitmain.remove(content);
		content = p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		transitmain.add(content);
		content.repaint();
		transitmain.repaint();
		transitmain.revalidate();
	}

}