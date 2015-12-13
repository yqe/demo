package manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

public class addemployee {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public addemployee(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 720, 700);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>添加员工");
		int b2size = 16;
		l2.setFont(new Font("—>主页", Font.PLAIN, b2size));
		JLabel l3 = new JLabel("ID:");

		JLabel l4 = new JLabel("姓名:");
		JLabel l5 = new JLabel("职位:");
		JLabel l6 = new JLabel("年龄:");
		JLabel l7 = new JLabel("手机:");
		JLabel l8 = new JLabel("薪水:");
		JLabel l9 = new JLabel("身份证:");
		JLabel l10 = new JLabel("地址:");
		JLabel l11 = new JLabel("性别:");
		JLabel l12 = new JLabel("地区:");
		JLabel posIDlabel = new JLabel("机构编号:");
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
		posIDlabel.setFont(new Font("", Font.PLAIN, b2size));

		final JTextField id = new JTextField();
		final JTextField name = new JTextField();
		final JTextField age = new JTextField();
		final JTextField tel = new JTextField();
		final JTextField salary = new JTextField();
		final JTextField identity = new JTextField();
		final JTextField address = new JTextField();
		final JTextField posidtext = new JTextField();
		final String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };

		final JComboBox job = new JComboBox(jobs);
		final String[] places = { "南京", "北京", "杭州", "深圳", "广州" };

		final JComboBox place = new JComboBox(places);

		final JRadioButton jb1 = new JRadioButton("男");
		jb1.setSelected(true);
		jb1.setOpaque(false);
		final JRadioButton jb2 = new JRadioButton("女");
		jb2.setOpaque(false);
		final ButtonGroup bg = new ButtonGroup();
		bg.add(jb1);
		bg.add(jb2);

		// t2.setOpaque(false);
		// t3.setOpaque(false);
		// t2.setEditable(false);
		// t3.setEditable(false);

		JButton b5 = new JButton("确认添加");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				boolean idisempty = id.getText().equals("");
				boolean nameisempty = name.getText().equals("");
				boolean ageisempty = age.getText().equals("");
				boolean telisempty = tel.getText().equals("");
				boolean salaryisempty = salary.getText().equals("");
				boolean identityisempty = identity.getText().equals("");
				boolean addressisempty = address.getText().equals("");
				boolean posidtextisempty = posidtext.getText().equals("");
				
				
				boolean isempty = idisempty || nameisempty||ageisempty||telisempty||salaryisempty||identityisempty
						||addressisempty||posidtextisempty;

				if (!isempty ){
					EmploeePO epo = new EmploeePO(job.getSelectedItem().toString(), id.getText(), name.getText(),
							Integer.parseInt(salary.getText()), bg.getElements().toString(),
							Integer.parseInt(age.getText()), tel.getText(), identity.getText(), address.getText(),
							place.getSelectedItem().toString(), posidtext.getText());
					EmploeeBl ac = new EmploeeBl(oos,ois);
					boolean isOk = ac.AddEmpInfo(epo);
					if(isOk){
					   JOptionPane.showMessageDialog(null, "添加成功!");
					   }
					}
				else{
					JOptionPane.showMessageDialog(null, "添加失败，请确认信息填写完整!");
				   }
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
		p1.add(posIDlabel);

		p1.add(id);
		p1.add(name);
		p1.add(age);
		p1.add(tel);
		p1.add(salary);
		p1.add(identity);
		p1.add(address);
		p1.add(jb1);
		p1.add(jb2);
		p1.add(place);
		p1.add(posidtext);
		p1.add(job);

		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5;
		int b4yloc = 600, b4ysize = p1.getHeight() * 1 / 5 + 10;
		int labelw = 150;
		int labelh = 30;
		l1.setBounds(220, -20, 180, 80);
		l2.setBounds(50, 50, labelw, labelh);
		l3.setBounds(150, 100, labelw, labelh);
		l4.setBounds(150, 150, labelw, labelh);
		l5.setBounds(150, 300, labelw, labelh);
		l6.setBounds(150, 350, labelw, labelh);
		l7.setBounds(150, 400, labelw, labelh);
		l8.setBounds(150, 450, labelw, labelh);
		l9.setBounds(150, 500, labelw, labelh);
		l10.setBounds(150, 550, labelw, labelh);
		l11.setBounds(150, 600, labelw, labelh);
		l12.setBounds(150, 200, labelw, labelh);
		posIDlabel.setBounds(150, 250, labelw, labelh);
		int textw = 150;
		int texth = 30;
		id.setBounds(300, 100, textw, texth);
		name.setBounds(300, 150, textw, texth);
		job.setBounds(300, 300, textw, texth);
		age.setBounds(300, 350, textw, texth);
		tel.setBounds(300, 400, textw, texth);
		salary.setBounds(300, 450, textw, texth);
		identity.setBounds(300, 500, textw, texth);
		address.setBounds(300, 550, textw, texth);
		jb1.setBounds(300, 600, 50, 30);
		jb2.setBounds(350, 600, 50, 30);
		place.setBounds(300, 200, 100, 30);
		posidtext.setBounds(300, 250, textw, texth);

		b5.setBounds(b4xloc, b4yloc + 50, 150, 30);
		return p1;

	}
}
