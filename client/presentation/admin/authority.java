package admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	
	public authority(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO empPO) {
		this.oos = oos;
		this.ois = ois;
		this.empPO=empPO;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 500);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>修改权限");
		int b2size = 16;
		l2.setFont(new Font("", Font.PLAIN, b2size));
		JLabel l3 = new JLabel("输入账号:");

		JLabel l4 = new JLabel("姓名:");
		JLabel l5 = new JLabel("职位:");

		l3.setFont(new Font("", Font.PLAIN, b2size));
		l4.setFont(new Font("", Font.PLAIN, b2size));
		l5.setFont(new Font("", Font.PLAIN, b2size));

		final JTextField t1 = new JTextField();

		final JTextField t2 = new JTextField();

		t2.setOpaque(false);
		t2.setEditable(false);

		final String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };

		final JComboBox job = new JComboBox(jobs);

		JButton b4 = new JButton("确定");
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

		JButton b5 = new JButton("确认修改");
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
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);

		p1.add(t1);
		p1.add(t2);

		p1.add(job);

		p1.add(b4);
		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5;
		int b4yloc = p1.getHeight() * 12 / 15 + 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, b1yloc, 150, 30);

		l3.setBounds(150, 120, 150, 30);

		l4.setBounds(150, 240, 150, 30);
		l5.setBounds(150, 300, 150, 30);
		job.setBounds(300, 300, 180, 30);

		t1.setBounds(300, 120, 150, 30);
		t2.setBounds(300, 240, 150, 30);

		b4.setBounds(300, 180, 100, 30);
		b5.setBounds(b4xloc, b4yloc, 150, 30);

		return p1;
	}
}