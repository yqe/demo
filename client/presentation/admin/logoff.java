package admin;

import image.ImageGet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.MTextfield;
import po.EmploeePO;
import po.UserInfoPO;
import userbl.UserBl;

public class logoff {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO empPO;
	JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
	};

	public logoff(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO empPO) {
		this.oos = oos;
		this.ois = ois;
		this.empPO=empPO;
	}


	public JPanel Panel() throws IOException {
		 new ImageGet();
	       Image bgp=ImageGet.getImageByState("logoff");
		background = new ImageIcon(bgp);
		p1.setBounds(0, 0, 988, 756);
		

		JLabel l4 = new JLabel("姓名:");
		JLabel l5 = new JLabel("职位:");

	
		l4.setFont(new Font("", Font.PLAIN, 18));
		l5.setFont(new Font("", Font.PLAIN, 18));

		final MTextfield t1 = new MTextfield();
		final MTextfield t2 = new MTextfield();
		final MTextfield t3 = new MTextfield();

		
		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setBorder(BorderFactory.createEmptyBorder());
		t3.setBorder(BorderFactory.createEmptyBorder());
		
		
		t2.setOpaque(false);
		t3.setOpaque(false);
		t2.setEditable(false);
		t3.setEditable(false);

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PO传给数据
				UserBl userbl = new UserBl(oos, ois);
				UserInfoPO userpo = userbl.GetUserAccount(t1.getText());
				String username = userpo.getUsername();
				String userposition = userpo.getPosition();
				if (!t1.getText().equals("")) {
					if (userpo.getUserID().equals("不存在")) {
						JOptionPane.showMessageDialog(null, "没有该账号，请再次确认!");
					} else {
						t2.setText(username);
						t3.setText(userposition);
					}
				} 
				else {
					JOptionPane.showMessageDialog(null, "请输入账号!");
				}
			}

		});

		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!t2.getText().equals("")) {
					UserBl userbl = new UserBl(oos, ois);
					UserInfoPO userpotemp = userbl.GetUserAccount(t1.getText());
					boolean IsOk = userbl.cancellation(userpotemp);
					if (IsOk) {
						JOptionPane.showMessageDialog(null, "注销成功!");
					} else {
						JOptionPane.showMessageDialog(null, "注销失败，请重新再试一次!");
					}
				} else
					JOptionPane.showMessageDialog(null, "注销失败，请确认输入的账户!");
			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
	
		p1.add(l4);
		p1.add(l5);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);

		p1.add(b4);
		p1.add(b5);

		
		
		

		

		l4.setBounds(150, 250, 150, 30);
		l5.setBounds(150, 350, 150, 30);
		
		
		 int length=176,width=43;

		 t1.settextFont();	 t2.settextFont();	 t3.settextFont();
		 
		t1.setBounds(244, 298, length, width);
		t2.setBounds(586, 319, length, width);
		t3.setBounds(586, 409, length, width);

		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		b4.setBounds(231, 422, 212, 56);
		b5.setBounds(568, 563, 212, 57);
		return p1;

	}
}