package login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import storage.changestorage;
import storage.checkstorage;
import storage.countstorage;
import storage.instorage;
import storage.outstorage;
import storage.storageinfo;
import storage.storagemain;
import transit.transit;
import transit.transitload;
import transit.transitmain;
import manager.Strategy;
import manager.checkdocuments;
import manager.manager;
import manager.staff;
import manager.staffchange;
import manager.stafforgan;
import courier.Send;
import courier.courier;
import courier.dispatch;
import finance.financemainui;
import Boclerk.Boclerk;
import Boclerk.Maintenance;
import Boclerk.collection;
import Inquiry.Inquiry;
import admin.admin;
import admin.authority;
import admin.changepasswordmain;
import admin.logoff;

public class loginframe {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;

	public void Frame() throws IOException {
		BufferedImage bgp = ImageIO.read(new File(
				"D:/快递物流系统/demo/client/presentation/background.png"));
		background = new ImageIcon(bgp);

		final JFrame frame = new JFrame("快递物流系统");
		frame.setBounds(500, 300, 600, 375);
		frame.setUndecorated(true);
		final JPanel p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, frame.getSize().width,
						frame.getSize().height, frame);
			}
		};
		JLabel l1 = new JLabel("ID:");
		JLabel l2 = new JLabel("Password:");
		final JTextField id = new JTextField();
		final JPasswordField password = new JPasswordField();
		final JButton b1 = new JButton("登  录");
		b1.setEnabled(true);

		// final String idinfo=id.getText();
		// final String passwordinfo=password.getText();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad = new admin();
				Boclerk bo = new Boclerk();
				courier c = new courier();
				manager m = new manager();
				transitmain t = new transitmain();
				storagemain s = new storagemain();
				financemainui f=new financemainui();
				char[] pass = password.getPassword();
				String passwordstr = new String(pass);
				try {

					switch (id.getText()) {
					case "1": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(500, 100, ad.Panel().getWidth(), ad
								.Panel().getHeight());
						frame.add(ad.Panel());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					case "2": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(500, 100, bo.Panel().getWidth(), bo
								.Panel().getHeight());
						frame.add(bo.Panel());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					case "3": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(400, 100, c.Panel().getWidth(), c
								.Panel().getHeight());
						frame.add(c.Panel());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					case "4": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(500, 100, m.Panel().getWidth(), m
								.Panel().getHeight());
						frame.add(m.Panel());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					case "5": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(500, 100, t.Panel().getWidth(), t
								.Panel().getHeight());
						frame.add(t.Panel());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					case "6": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(500, 100, s.Panel().getWidth(), s
								.Panel().getHeight());
						frame.add(s.Panel());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					case "7": {
						if(passwordstr.equals("123")){
						frame.remove(p1);
						frame.setBounds(500, 100, f.financemainui().getWidth(), f
								.financemainui().getHeight());
						frame.add(f.financemainui());}
						else{
							JOptionPane.showMessageDialog(null, "密码错误!");
						}
						break;
					}
					default: {
						JOptionPane.showMessageDialog(null, "所输入账号不存在!");
//						p1.repaint();
					}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		// b1.setEnabled(true);
		JButton b2 = new JButton("免登录物流信息查询");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquiry in = new Inquiry();
				try {
					frame.remove(p1);
					frame.setBounds(500, 300, in.Panel().getWidth(), in.Panel()
							.getHeight());
					frame.add(in.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton b3 = new JButton("退出");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		p1.setOpaque(false);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(l2);
		p1.add(id);
		p1.add(password);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		frame.add(p1);
		frame.getLayeredPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		frame.setVisible(true);

		l1.setBounds(150, 50, 40, 30);
		id.setBounds(240, 50, 120, 30);
		l2.setBounds(150, 100, 80, 30);
		password.setBounds(240, 100, 120, 30);
		b1.setBounds(240, 160, 80, 35);
		b2.setBounds(240, 240, 160, 40);
		b3.setBounds(540, 1, 60, 30);
	}

	public static void main(String[] args) throws IOException {
		loginframe f1 = new loginframe();
		f1.Frame();

	}
}
