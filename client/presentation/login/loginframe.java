package login;

import image.ImageGet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Boclerk.Boclerk;
import Inquiry.Inquiry;
import admin.admin;
import courier.courier;
import finance.financemainui;
import manager.manager;
import storage.storagemain;
import transit.transitmain;
import userbl.UserBl;

public class loginframe {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private int xx, yy;
	private boolean isDraging;
	public Socket socket;
	public ObjectOutputStream oos;
	public ObjectInputStream ois;

	public loginframe(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
		this.socket=socket;
		this.oos=oos;
		this.ois=ois;
	}

	public void Frame() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("background");
		background = new ImageIcon(bgp);

		final JFrame frame = new JFrame("");
		frame.setBounds(300, 100, 1000, 611);
		final JPanel p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}
		};
//		JLabel l1 = new JLabel("ID:");
//		JLabel l2 = new JLabel("Password:");
		final JTextField id = new JTextField();
		final JPasswordField password = new JPasswordField();
		final JButton b1 = new JButton();
		b1.setEnabled(true);

		// final String idinfo=id.getText();
		// final String passwordinfo=password.getText();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass = password.getPassword();
				String passwordstr = new String(pass);
				try {
					UserBl userui = new UserBl(oos,ois);
					String userid=id.getText();
					String cmdui = userui.look(userid, passwordstr);
					switch (cmdui) {
					case "管理员":
						admin ad = new admin(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.remove(p1);
						frame.setBounds(500, 100, ad.Panel().getWidth(), ad.Panel().getHeight());
						frame.add(ad.Panel());
						break;
					case "营业厅业务员":
						frame.remove(p1);
						Boclerk bo = new Boclerk(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.setBounds(500, 100, bo.Panel().getWidth(), bo.Panel().getHeight());
						frame.add(bo.Panel());
						break;
					case "快递员":
						frame.remove(p1);
						courier c = new courier(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.setBounds(400, 100, c.Panel().getWidth(), c.Panel().getHeight());
						frame.add(c.Panel());
						break;
					case "总经理":
						frame.remove(p1);
						manager m = new manager(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.setBounds(500, 100, m.Panel().getWidth(), m.Panel().getHeight());
						frame.add(m.Panel());
						break;
					case "中转中心业务员":
						frame.remove(p1);
						transitmain t = new transitmain(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.setBounds(500, 100, t.Panel().getWidth(), t.Panel().getHeight());
						frame.add(t.Panel());
						break;
					case "中转中心库存管理人员":
						frame.remove(p1);
						storagemain s = new storagemain(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.setBounds(500, 100, s.Panel().getWidth(), s.Panel().getHeight());
						frame.add(s.Panel());
						break;
					case "财务人员":
						frame.remove(p1);
						financemainui f = new financemainui(socket,ois,oos,userui.GetEmployeePO(userid));
						frame.setBounds(500, 100, f.financemainui().getWidth(), f.financemainui().getHeight());
						frame.add(f.financemainui());
						break;
					case "PasswordError":
						JOptionPane.showMessageDialog(null, "所输入账号密码错误");
						break;
					default: {
						JOptionPane.showMessageDialog(null, "所输入账号不存在!");
					}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// b1.setEnabled(true);
		JButton b2 = new JButton();
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Inquiry in = new Inquiry(oos,ois);
				try {
					frame.remove(p1);
					frame.setBounds(500, 300, in.Panel().getWidth(), in.Panel().getHeight());
					frame.add(in.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});


		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		p1.setOpaque(false);
		p1.setLayout(null);
//		p1.add(l1);
//		p1.add(l2);
		p1.add(id);
		p1.add(password);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		frame.add(p1);
		frame.getLayeredPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				xx = e.getX();
				yy = e.getY();
			}

			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) {
					int left = frame.getLocation().x;
					int top = frame.getLocation().y;
					frame.setLocation(left + e.getX() - xx, top + e.getY() - yy);
				}
			}
		});
		
		id.setOpaque(false);id.setBorder(BorderFactory.createEmptyBorder());
		id.setFont(new Font("幼圆", Font.PLAIN, 25));id.setForeground(Color.white);
		password.setOpaque(false);password.setBorder(BorderFactory.createEmptyBorder());
		password.setFont(new Font("幼圆", Font.PLAIN, 25));password.setForeground(Color.white);
//		l1.setBounds(150, 50, 40, 30);
		id.setBounds(443, 177, 189, 41);
//		l2.setBounds(150, 100, 80, 30);
		password.setBounds(442, 265, 189, 41);
		
		b1.setContentAreaFilled(false);b1.setBorder(BorderFactory.createEmptyBorder());
		b2.setContentAreaFilled(false);b2.setBorder(BorderFactory.createEmptyBorder());
		b3.setContentAreaFilled(false);b3.setBorder(BorderFactory.createEmptyBorder());
		
		b1.setBounds(700, 250, 272, 85);
		b2.setBounds(367, 358, 272, 85);
		b3.setBounds(700, 373, 272, 85);
	}

}
