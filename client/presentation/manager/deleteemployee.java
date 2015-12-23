package manager;

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
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public deleteemployee(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/deleteemployee.jpg"));
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 988, 756);
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
		final JTextField job = new JTextField();
		final JTextField place = new JTextField();
		final JTextField sex = new JTextField();
		final JTextField posidtext = new JTextField();
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		
		name.setOpaque(false);
		name.setBorder(BorderFactory.createEmptyBorder());
		name.setEditable(false);
		age.setOpaque(false);
		age.setBorder(BorderFactory.createEmptyBorder());
		age.setEditable(false);
		tel.setOpaque(false);
		tel.setBorder(BorderFactory.createEmptyBorder());
		tel.setEditable(false);
		salary.setOpaque(false);
		salary.setBorder(BorderFactory.createEmptyBorder());
		salary.setEditable(false);
		identity.setOpaque(false);
		identity.setBorder(BorderFactory.createEmptyBorder());
		identity.setEditable(false);
		address.setOpaque(false);
		address.setBorder(BorderFactory.createEmptyBorder());
		address.setEditable(false);
		job.setOpaque(false);
		job.setBorder(BorderFactory.createEmptyBorder());
		job.setEditable(false);
		place.setOpaque(false);
		place.setBorder(BorderFactory.createEmptyBorder());
		place.setEditable(false);
		sex.setOpaque(false);
		sex.setBorder(BorderFactory.createEmptyBorder());
		sex.setEditable(false);
		posidtext.setOpaque(false);
		posidtext.setBorder(BorderFactory.createEmptyBorder());
		posidtext.setEditable(false);
		
	

		JButton b4 = new JButton("查询ID");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmploeeBl jk = new EmploeeBl(oos,ois);
				EmploeePO empo = jk.IDGetEmp(id.getText());
				
				if(empo.getPosition().equals("不存在")){
					JOptionPane.showMessageDialog(null, "没有该员工ID!");
		     	}
				else{
					name.setText(empo.getName());
					place.setText(empo.getArea());
					age.setText(String.valueOf(empo.getAge()));
					sex.setText(empo.getSex());
					tel.setText(empo.getPhonenum());
					address.setText(empo.getAddress());
					salary.setText(String.valueOf(empo.getSalary()));
					job.setText(empo.getPosition());
					identity.setText(empo.getIdendity());
					posidtext.setText(empo.getPosID());
				}
			}

		});

		JButton b5 = new JButton("确认删除");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				boolean idisempty = id.getText().equals("");
				boolean nameisempty = name.getText().equals("");
				boolean isempty = idisempty || nameisempty;
				EmploeeBl ac = new EmploeeBl(oos,ois);
				boolean isOk = ac.DeleteEmp(id.getText());
				if (!isempty && isOk)
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
		p1.add(posIDlabel);

		p1.add(id);
		p1.add(name);
		p1.add(age);
		p1.add(tel);
		p1.add(salary);
		p1.add(identity);
		p1.add(address);
		p1.add(sex);
		p1.add(place);
		p1.add(posidtext);
		p1.add(job);

		p1.add(b4);
		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5;
		int b4yloc = 620, b4ysize = p1.getHeight() * 1 / 5 + 10;
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
		sex.setBounds(300, 600, textw, texth);
		place.setBounds(300, 200, textw, texth);
		posidtext.setBounds(300, 250, textw, texth);

		b4.setBounds(150 + labelw + textw + 30, 100, 150, 30);

		b5.setBounds(300, b4yloc, 150, 30);
		return p1;

	}
}
