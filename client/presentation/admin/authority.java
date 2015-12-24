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

public class authority {
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
	
	public authority(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO empPO) {
		this.oos = oos;
		this.ois = ois;
		this.empPO=empPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	       Image bgp=ImageGet.getImageByState("authority");
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 988, 756);
	


	

		final MTextfield t1 = new MTextfield();

		final MTextfield t2 = new MTextfield();
		
		
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());

		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setEditable(false);

		final String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };

		final JComboBox job = new JComboBox(jobs);

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PO传数据
				//
				UserBl m = new UserBl(oos,ois);
				UserInfoPO a = m.GetUserAccount(t1.getText());
				if (a.getUserID().equals("不存在"))
					JOptionPane.showMessageDialog(null, "请输入正确账号!");
				if (!t1.getText().equals("")) {
					t2.setText(a.getUsername());
					for (int i = 0; i < 7; i++) {
						if (jobs[i].equals(a.getPosition()))
							job.setSelectedIndex(i);
					} // 参照String的jobs
				}
			}

		});

		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!t2.getText().equals("")) {
					UserBl userbl = new UserBl(oos,ois);
					UserInfoPO usertemp = userbl.GetUserAccount(t1.getText());
					String ID = usertemp.getUserID();
					String name = usertemp.getUsername();
					String pass = usertemp.getPassword();
					boolean isOk = userbl
							.positionTransfer(new UserInfoPO(ID, pass, name, job.getSelectedItem().toString()));
					if (isOk)
						JOptionPane.showMessageDialog(null, "修改成功!");
					else
						JOptionPane.showMessageDialog(null, "修改失败!");
				} else
					JOptionPane.showMessageDialog(null, "请确认员工信息!");
			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(t1);
		p1.add(t2);

		p1.add(job);

		p1.add(b4);
		p1.add(b5);

	
		t1.settextFont();
		t2.settextFont();
		
		t1.setBounds(170, 293, 176, 43);
		t2.setBounds(605, 319, 176, 43);
		job.setBounds(605, 409, 176, 43);

		
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		b4.setBounds(154, 409, 211, 56);
		b5.setBounds(595, 590, 200, 53);

		return p1;
	}
}