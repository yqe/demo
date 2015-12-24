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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.MTextfield;
import po.EmploeePO;
import po.UserInfoPO;
import userbl.UserBl;

public class adduser {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private EmploeePO empPO;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
	};

	public adduser(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO empPO) {
		this.oos=oos;
		this.ois=ois;
		this.empPO=empPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	       Image bgp=ImageGet.getImageByState("adduser");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 988, 756);
	



		final MTextfield t1 = new MTextfield();
		final MTextfield t2 = new MTextfield();
		final MTextfield t3 = new MTextfield();
		final String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };
		final JComboBox job = new JComboBox(jobs);

		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setBorder(BorderFactory.createEmptyBorder());
		t3.setBorder(BorderFactory.createEmptyBorder());
		
		
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean idisempty = t1.getText().equals("");
				boolean nameisempty = t2.getText().equals("");
				boolean passwordisempty = t3.getText().equals("");
				boolean isempty = idisempty || nameisempty || passwordisempty;

				if (!isempty) {
					UserInfoPO user = new UserInfoPO(t1.getText(), t3.getText(), t2.getText(),
							job.getSelectedItem().toString());
					UserBl userbl = new UserBl(oos,ois);
					if (userbl.AddUser(user))
						JOptionPane.showMessageDialog(null, "新建成功!");
					else
						JOptionPane.showMessageDialog(null, "抱歉，新建失败!");
				} else
					JOptionPane.showMessageDialog(null, "新建失败，请确认信息填写完整!");

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(job);

		p1.add(b5);

		

	
          int length=174,width=43;		

		t1.setBounds(194, 319, length, width);
		t1.settextFont();
		t2.setBounds(194, 409, length, width);
		t2.settextFont();
		t3.setBounds(600, 319, length, width);
		t3.settextFont();
		job.setBounds(600, 409, length, width);

		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		b5.setBounds(582, 606, 200, 54);
		return p1;

	}
}
