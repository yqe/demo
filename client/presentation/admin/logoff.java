package admin;

import java.awt.Font;
import java.awt.Graphics;
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
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/logoff.jpg"));
		background = new ImageIcon(bgp);
		p1.setBounds(0, 0, 988, 756);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—> 注销账户");
		int b2size = 16;
		l2.setFont(new Font("—>主页", Font.PLAIN, b2size));
		JLabel l3 = new JLabel("输入账号:");

		JLabel l4 = new JLabel("姓名:");
		JLabel l5 = new JLabel("职位:");

		l3.setFont(new Font("", Font.PLAIN, b2size));
		l4.setFont(new Font("", Font.PLAIN, b2size));
		l5.setFont(new Font("", Font.PLAIN, b2size));

		final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();
		final JTextField t3 = new JTextField();

		
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

		JButton b4 = new JButton("确定");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PO传给数据
				UserBl userbl = new UserBl(oos, ois);
				UserInfoPO userpo = userbl.GetUserAccount(t1.getText());
				String username = userpo.getUsername();
				String userposition = userpo.getPosition();
				if (!t1.getText().equals("")) {
					if (userpo != null) {
						t2.setText(username);
						t3.setText(userposition);
					} else {
						JOptionPane.showMessageDialog(null, "账号有误!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入账号!");
				}
			}

		});

		JButton b5 = new JButton("确认注销");
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
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);

		p1.add(b4);
		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5;
		int b4yloc = p1.getHeight() * 11 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, b1yloc, 150, 30);

		l3.setBounds(150, 120, 150, 30);

		l4.setBounds(150, 250, 150, 30);
		l5.setBounds(150, 350, 150, 30);

		t1.setBounds(300, 120, 180, 30);
		t2.setBounds(300, 250, 180, 30);
		t3.setBounds(300, 350, 180, 30);

		b4.setBounds(300, 180, 100, 30);
		b5.setBounds(b4xloc, b4yloc, 150, 30);
		return p1;

	}
}