package admin;

import image.ImageGet;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.MTextfield;
import login.Mdialog;
import po.EmploeePO;
import po.UserInfoPO;
import userbl.UserBl;

public class changepasswordmain {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO empPO;
	final JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
	};

	public changepasswordmain(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO empPO) {
		this.oos=oos;
		this.ois=ois;
		this.empPO=empPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	       Image bgp=ImageGet.getImageByState("changepassword");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 988, 756);

		

		

		final MTextfield id = new MTextfield();
		final JPasswordField newpassword1 = new JPasswordField();
		final JPasswordField newpassword2 = new JPasswordField();
		
		id.setOpaque(false);
		newpassword1.setOpaque(false);
		newpassword2.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		newpassword1.setBorder(BorderFactory.createEmptyBorder());
		newpassword2.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass1 = newpassword1.getPassword();
				String password1 = new String(pass1);
				char[] pass2 = newpassword2.getPassword();
				String password2 = new String(pass2);
				boolean equal = password1.equals(password2);
				if (!id.getText().equals("")) {
					if (!password1.equals("")) {
						if (equal) {
							UserBl userbl = new UserBl(oos,ois);
							if(userbl.GetUserAccount(id.getText()).getUserID().equals("不存在")){
								Mdialog.showMessageDialog("没有该账户!");
							}
							else{
								boolean IsOk = userbl.changePassword(new UserInfoPO(id.getText(), password1, "", ""));
							if (IsOk)
								Mdialog.showMessageDialog( "修改成功!");// 将新密码传入所对应PO
							else
								Mdialog.showMessageDialog( "修改失败!");}
						} else {
							Mdialog.showMessageDialog("两次所输入新密码不统一，请重新输入!");
							newpassword1.setText("");
							newpassword2.setText("");// 清空
						}
					} else {
						Mdialog.showMessageDialog("请输入新密码!");
					}
				} else {
					Mdialog.showMessageDialog( "请先输入ID!");
				}

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(id);
		p1.add(newpassword1);
		p1.add(newpassword2);

		p1.add(b4);

	

	
		

		id.setBounds(170, 293, 176, 43);
		id.settextFont();
		newpassword1.setBounds(600, 319, 176, 43);
		newpassword2.setBounds(600, 409, 176, 43);
		newpassword1.setFont(new Font("幼圆",Font.BOLD,24));
		newpassword1.setForeground(Color.white);
		newpassword2.setFont(new Font("幼圆",Font.BOLD,24));
		newpassword2.setForeground(Color.white);
		
		b4.setContentAreaFilled(false);
        b4.setBorder(BorderFactory.createEmptyBorder());
		
		b4.setBounds(535, 590, 200, 53);

		return p1;

	}
}
