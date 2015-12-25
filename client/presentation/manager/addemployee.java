package manager;

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
	JPanel p1 = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public addemployee(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("addemployee");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 1029, 840);

		final JTextField id = new JTextField();
		final JTextField name = new JTextField();
		final JTextField age = new JTextField();
		final JTextField tel = new JTextField();
		final JTextField salary = new JTextField();
		final JTextField identity = new JTextField();
		final JTextField address = new JTextField();
		final JTextField posidtext = new JTextField();
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		name.setOpaque(false);
		name.setBorder(BorderFactory.createEmptyBorder());
		age.setOpaque(false);
		age.setBorder(BorderFactory.createEmptyBorder());
		tel.setOpaque(false);
		tel.setBorder(BorderFactory.createEmptyBorder());
		salary.setOpaque(false);
		salary.setBorder(BorderFactory.createEmptyBorder());
		identity.setOpaque(false);
		identity.setBorder(BorderFactory.createEmptyBorder());
		address.setOpaque(false);
		address.setBorder(BorderFactory.createEmptyBorder());
		posidtext.setOpaque(false);
		posidtext.setBorder(BorderFactory.createEmptyBorder());

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

		JButton b5 = new JButton("");
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

				boolean isempty = idisempty || nameisempty || ageisempty || telisempty || salaryisempty
						|| identityisempty || addressisempty || posidtextisempty;

				if (!isempty) {
					EmploeePO epo = new EmploeePO(job.getSelectedItem().toString(), id.getText(), name.getText(),
							Integer.parseInt(salary.getText()), bg.getElements().toString(),
							Integer.parseInt(age.getText()), tel.getText(), identity.getText(), address.getText(),
							place.getSelectedItem().toString(), posidtext.getText());
					EmploeeBl ac = new EmploeeBl(oos, ois);
					boolean isOk = ac.AddEmpInfo(epo);
					if (isOk) {
						JOptionPane.showMessageDialog(null, "添加成功!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "添加失败，请确认信息填写完整!");
				}
			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);

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

		int textw = 142;
		int texth = 29;
		id.setBounds(182, 232, textw, texth);
		name.setBounds(646, 162, 94, 28);
		job.setBounds(184, 450, textw, texth);
		age.setBounds(646, 232, 94, 28);
		tel.setBounds(646, 306, textw, texth);
		salary.setBounds(184, 534, textw, texth);
		identity.setBounds(646, 384, textw, texth);
		address.setBounds(646, 457, textw, texth);
		jb1.setBounds(651, 536, 44, 28);
		jb2.setBounds(651+47+6, 536, 44, 28);
		place.setBounds(182, 306, textw, texth);
		posidtext.setBounds(182, 378, textw, texth);

		b5.setBounds(603, 652, 288, 63);
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		return p1;

	}
}
