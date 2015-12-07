package admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.UserInfoPO;
import userbl.UserBl;

public class adduser {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 500);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—> 新建账户");
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
		final String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };

		final JComboBox job = new JComboBox(jobs);

//		t2.setOpaque(false);
//		t3.setOpaque(false);
//		t2.setEditable(false);
//		t3.setEditable(false);

		JButton b5 = new JButton("确认新建");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PO传数据
//				UserBl userbl = new UserBl();
//				UserInfoPO userpotemp = userbl.CheckUserInfoPO(t1.getText());
//				boolean IsOk=userbl.cancellation(userpotemp);
			boolean idisempty=t1.getText().equals("");
				boolean nameisempty=t2.getText().equals("");
				boolean isempty= idisempty||nameisempty;
				
				
				
				if(!isempty)
				JOptionPane.showMessageDialog(null, "新建成功!");
				else
				JOptionPane.showMessageDialog(null, "新建失败，请确认信息填写完整!");
				
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

		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5;
		int b4yloc = p1.getHeight() * 12 / 15 + 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, b1yloc, 150, 30);

		l3.setBounds(150, 180, 150, 30);

		l4.setBounds(150, 240, 150, 30);
		l5.setBounds(150, 300, 150, 30);

		t1.setBounds(300, 180, 180, 30);
		t2.setBounds(300, 240, 180, 30);
		job.setBounds(300, 300, 180, 30);

		b5.setBounds(b4xloc, b4yloc, 150, 30);
		return p1;

	}
}
