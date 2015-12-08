package manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import emploeebl.EmploeeBl;
import po.EmploeePO;
import po.UserInfoPO;
import userbl.UserBl;

public class deleteemployee {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 650, 700);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>删除员工");
		int b2size = 16;
		l2.setFont(new Font("—>主页", Font.PLAIN, b2size));
		JLabel l3 = new JLabel("员工ID:");

		JLabel l4 = new JLabel("姓名:");
		JLabel l5 = new JLabel("职位:");
		JLabel l6 = new JLabel("年龄:");
		JLabel l7 = new JLabel("手机:");
		JLabel l8 = new JLabel("薪水:");
		JLabel l9 = new JLabel("身份证:");
		JLabel l10 = new JLabel("地址:");
		JLabel l11 = new JLabel("性别:");
		JLabel l12 = new JLabel("地区:");

		l3.setFont(new Font("", Font.PLAIN, b2size));
		l4.setFont(new Font("", Font.PLAIN, b2size));
		l5.setFont(new Font("", Font.PLAIN, b2size));
		l6.setFont(new Font("", Font.PLAIN, b2size));
		l7.setFont(new Font("", Font.PLAIN, b2size));
		l8.setFont(new Font("", Font.PLAIN, b2size));
		l9.setFont(new Font("", Font.PLAIN, b2size));
		l10.setFont(new Font("", Font.PLAIN, b2size));
		l11.setFont(new Font("", Font.PLAIN, b2size));
		l12.setFont(new Font("", Font.PLAIN, b2size));

		final JTextField id = new JTextField();
		final JTextField name = new JTextField();
		final JTextField age = new JTextField();
		final JTextField tel = new JTextField();
		final JTextField salary = new JTextField();
		final JTextField identity = new JTextField();
		final JTextField address = new JTextField();
		final JTextField job = new JTextField();
		final JTextField place = new JTextField();
		final JTextField sex = new JTextField();
		
		name.setOpaque(false);
		name.setEditable(false);
		age.setOpaque(false);
		age.setEditable(false);
		tel.setOpaque(false);
		tel.setEditable(false);
		salary.setOpaque(false);
		salary.setEditable(false);
		identity.setOpaque(false);
		identity.setEditable(false);
		address.setOpaque(false);
		address.setEditable(false);
		job.setOpaque(false);
		job.setEditable(false);
		place.setOpaque(false);
		place.setEditable(false);
		sex.setOpaque(false);
		sex.setEditable(false);
//		final String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };
//
//		final JComboBox job = new JComboBox(jobs);
//		final String[] places = {"南京","北京","杭州","深圳","广州"};
//		
//		final JComboBox place = new JComboBox(places);
//		
//		final JRadioButton jb1 = new JRadioButton("男");
//		jb1.setSelected(true);
//		jb1.setOpaque(false);
//		final JRadioButton jb2 = new JRadioButton("女");
//		jb2.setOpaque(false);
//		ButtonGroup bg = new ButtonGroup();
//		bg.add(jb1);
//		bg.add(jb2);

//		t2.setOpaque(false);
//		t3.setOpaque(false);
//		t2.setEditable(false);
//		t3.setEditable(false);

		JButton b4 = new JButton("查询ID");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmploeeBl jk= new EmploeeBl();
				EmploeePO fc=jk.IDGetEmp(id.getText());
				System.out.println(fc.getName());
				name.setText(fc.getName());
				place.setText(fc.getArea());
				age.setText(String.valueOf(fc.getAge()));
				sex.setText(fc.getSex());
				tel.setText(fc.getPhonenum());
				address.setText(fc.getAddress());
				salary.setText(String.valueOf(fc.getSalary()));
			     job.setText(fc.getPosition());
			     identity.setText(fc.getIdendity());
			}

		});
		
		
		
		
		
		
		
		JButton b5 = new JButton("确认删除");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PO传数据
//				UserBl userbl = new UserBl();
//				UserInfoPO userpotemp = userbl.CheckUserInfoPO(t1.getText());
//				boolean IsOk=userbl.cancellation(userpotemp);
		    	boolean idisempty=id.getText().equals("");
				boolean nameisempty=name.getText().equals("");
				boolean isempty= idisempty||nameisempty;
				EmploeeBl ac =new EmploeeBl();
				boolean isOk=ac.DeleteEmp(id.getText());
				if(!isempty&&isOk)
				JOptionPane.showMessageDialog(null, "删除成功!");
				else
				JOptionPane.showMessageDialog(null, "删除失败，请重试!");
				
			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		p1.add(l8);
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(l12);

		p1.add(id);
		p1.add(name);
		p1.add(age);
		p1.add(tel);
		p1.add(salary);
		p1.add(identity);
		p1.add(address);
		p1.add(sex);
		
		p1.add(place);
		
		p1.add(job);

		p1.add(b4);
		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5;
		int b4yloc = 650, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, 50, 150, 30);

		l3.setBounds(150, 100, 150, 30);

		l4.setBounds(150, 200, 150, 30);
		l5.setBounds(150, 300, 150, 30);
		l6.setBounds(150, 350, 150, 30);
		l7.setBounds(150, 400, 150, 30);
		l8.setBounds(150, 450, 150, 30);
		l9.setBounds(150, 500, 150, 30);
		l10.setBounds(150, 550, 150, 30);
		l11.setBounds(150, 600, 150, 30);
		l12.setBounds(150, 250, 150, 30);

		id.setBounds(300, 100, 150, 30);
		name.setBounds(300, 200, 150, 30);
		job.setBounds(300, 300, 150, 30);
		age.setBounds(300, 350, 150, 30);
		tel.setBounds(300, 400, 150, 30);
		salary.setBounds(300, 450, 150, 30);
		identity.setBounds(300, 500, 150, 30);
	    address.setBounds(300, 550, 150, 30);
	    sex.setBounds(300, 600, 150, 30);
		place.setBounds(300, 250, 150, 30);
		
		b4.setBounds(300, 150, 150, 30);
		
		b5.setBounds(300, b4yloc, 150, 30);
		return p1;

	}
}

