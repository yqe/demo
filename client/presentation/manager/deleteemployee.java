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

public class deleteemployee {
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

	public deleteemployee(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("deleteemployee");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 1029, 840);

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

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmploeeBl jk = new EmploeeBl(oos, ois);
				EmploeePO empo = jk.IDGetEmp(id.getText());

				if (empo.getPosition().equals("不存在")) {
					JOptionPane.showMessageDialog(null, "没有该员工ID!");
				} else {
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

		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean idisempty = id.getText().equals("");
				boolean nameisempty = name.getText().equals("");
				boolean isempty = idisempty || nameisempty;
				EmploeeBl ac = new EmploeeBl(oos, ois);
				boolean isOk = ac.DeleteEmp(id.getText());
				if (!isempty && isOk)
					JOptionPane.showMessageDialog(null, "删除成功!");
				else
					JOptionPane.showMessageDialog(null, "删除失败，请重试!");

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
		p1.add(sex);
		p1.add(place);
		p1.add(posidtext);
		p1.add(job);

		p1.add(b4);
		p1.add(b5);

		int textw = 140;
		int texth = 29;
		id.setBounds(182, 237, textw, texth);
		name.setBounds(644, 167, 94, 27);
		job.setBounds(182, 467, textw, texth);
		age.setBounds(300, 350, 94, 27);
		tel.setBounds(644, 237, 279, 30);
		salary.setBounds(182, 555, textw, texth);
		identity.setBounds(644, 389, 279, 30);
		address.setBounds(644, 463, 279, 30);
		sex.setBounds(646, 555, 94, 27);
		place.setBounds(182, 310, textw, texth);
		posidtext.setBounds(182, 386, textw, texth);

		b4.setBounds(398, 235, 88, 34);
		b5.setBounds(410, 697, 283, 63);
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());
		return p1;

	}
}
