package Boclerk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

import po.EmploeePO;
import po.VehicleMaintanceInfoPO;
import transbl.TransBl;

public class Maintenance {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private EmploeePO emPO;

	public Maintenance(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 700);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>车辆信息维护");
		int l2size = 16;
		l2.setFont(new Font("", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("车辆代号:");
		JLabel l4 = new JLabel("车牌号:");
		JLabel l5 = new JLabel("司机编号:");
		JLabel l6 = new JLabel("司机姓名:");
		JLabel l7 = new JLabel("出生日期:");
		JLabel l8 = new JLabel("身份证号:");
		JLabel l9 = new JLabel("手机:");
		JLabel l10 = new JLabel("性别:");
		JLabel l11 = new JLabel("行驶证期限:");
		JLabel l12 = new JLabel("司机服役时间:");

		int lmain = 16;
		l3.setFont(new Font("", Font.PLAIN, lmain));
		l4.setFont(new Font("", Font.PLAIN, lmain));
		l5.setFont(new Font("", Font.PLAIN, lmain));
		l6.setFont(new Font("", Font.PLAIN, lmain));
		l7.setFont(new Font("", Font.PLAIN, lmain));
		l8.setFont(new Font("", Font.PLAIN, lmain));
		l9.setFont(new Font("", Font.PLAIN, lmain));
		l10.setFont(new Font("", Font.PLAIN, lmain));
		l11.setFont(new Font("", Font.PLAIN, lmain));
		l12.setFont(new Font("", Font.PLAIN, lmain));

		final JTextField carid = new JTextField();
		final JTextField carnumber = new JTextField();
		final JTextField driverid = new JTextField();
		final JTextField drivername = new JTextField();
		final JTextField driversfz = new JTextField();
		final JTextField tel = new JTextField();
		final JTextField date = new JTextField();
		
		carid.setOpaque(false);
		carid.setBorder(BorderFactory.createEmptyBorder());
		carnumber.setOpaque(false);
		carnumber.setBorder(BorderFactory.createEmptyBorder());
		driverid.setOpaque(false);
		driverid.setBorder(BorderFactory.createEmptyBorder());
		drivername.setOpaque(false);
		drivername.setBorder(BorderFactory.createEmptyBorder());
		driversfz.setOpaque(false);
		driversfz.setBorder(BorderFactory.createEmptyBorder());
		tel.setOpaque(false);
		tel.setBorder(BorderFactory.createEmptyBorder());
		date.setOpaque(false);
		date.setBorder(BorderFactory.createEmptyBorder());

		final String[] time = new String[20];
		for (int i = 1; i <= 20; i++) {
			time[i - 1] = i + "年";
		}
		final JComboBox timebox1 = new JComboBox(time);

		final JComboBox timebox2 = new JComboBox(time);

		final JRadioButton jb1 = new JRadioButton("男");
		jb1.setSelected(true);
		jb1.setOpaque(false);
		final JRadioButton jb2 = new JRadioButton("女");
		jb2.setOpaque(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jb1);
		bg.add(jb2);

		JButton b1 = new JButton("查询车辆信息");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransBl trans = new TransBl(oos,ois);
				// System.out.println(carid.getText());
				VehicleMaintanceInfoPO vpo = trans.GetVehicleInfoPO(carid.getText());
				String ss = vpo.getVehicleID();
				// System.out.println(ss);
				if (vpo.getVehicleID().equals("不存在")) {
					JOptionPane.showMessageDialog(null, "所输入车辆ID不存在");
				} else {
					carnumber.setText(vpo.getCarsID());
					driverid.setText(vpo.getDriverID());
					drivername.setText(vpo.getDrivername());
					driversfz.setText(vpo.getIdendity());
					tel.setText(vpo.getMobile());
					date.setText(vpo.getBirthday());
					for(int i=0;i<20;i++){
						if(timebox1.getItemAt(i).equals(vpo.getLimittime())){
							timebox1.setSelectedIndex(i);
						}							
                    }	
					for(int i=0;i<20;i++){
						if(timebox2.getItemAt(i).equals(vpo.getWorktime())){
							timebox2.setSelectedIndex(i);
						}							
                    }	
					String sex = jb1.getText();
					System.out.println(sex);
					if (!jb1.getText().equals(vpo.getSex())) {
						jb1.setSelected(false);
						jb2.setSelected(true);
					}

					for (int i = 0; i < time.length; i++) {
						if (time[i].equals(vpo.getLimittime())) {
							timebox1.setSelectedIndex(i);
							break;
						}
					}

					for (int i = 0; i < time.length; i++) {
						if (time[i].equals(vpo.getWorktime())) {
							timebox2.setSelectedIndex(i);
							break;
						}
					}

				}

			}
		});

		JButton b4 = new JButton("更新车辆信息");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean iscarid = true;
				boolean iscarnumber = true;
				boolean isdriverid = true;

				boolean caridisempty = carid.getText().equals("");
				boolean carnumberisempty = carnumber.getText().equals("");
				boolean driveridisempty = driverid.getText().equals("");
				boolean drivernameisempty = drivername.getText().equals("");
				boolean driversfzisempty = driversfz.getText().equals("");
				boolean telisempty = tel.getText().equals("");

				boolean isempty = caridisempty || carnumberisempty || driveridisempty || drivernameisempty
						|| driversfzisempty || telisempty;

				String s = jb1.isSelected() ? "男" : "女";
				if (iscarid && iscarnumber && isdriverid && !isempty) {
					VehicleMaintanceInfoPO vpo = new VehicleMaintanceInfoPO(carid.getText(), null, carnumber.getText(),
							timebox2.getSelectedItem().toString(), driverid.getText(), drivername.getText(),
							date.getText(), driversfz.getText(), tel.getText(), s,
							timebox1.getSelectedItem().toString());
					TransBl trans = new TransBl(oos,ois);
					if (trans.ChangeVehicleInfoPO(vpo))
						JOptionPane.showMessageDialog(null, "更新成功!");
					else
						JOptionPane.showMessageDialog(null, "抱歉，更新失败!");
				} else if (!iscarid && !caridisempty) {
					JOptionPane.showMessageDialog(null, "请输入正确的车辆代号!");
				} else if (!iscarnumber && !carnumberisempty) {
					JOptionPane.showMessageDialog(null, "请输入正确的车牌号!");
				} else if (!isdriverid && !driveridisempty) {
					JOptionPane.showMessageDialog(null, "请输入正确的司机代号!");
				} else if (isempty) {
					JOptionPane.showMessageDialog(null, "请完整填写信息!");// 123
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

		p1.add(carid);
		p1.add(carnumber);
		p1.add(driverid);
		p1.add(drivername);
		p1.add(driversfz);
		p1.add(tel);

		p1.add(b1);
		p1.add(b4);
		p1.add(date);
		p1.add(timebox1);
		p1.add(timebox2);

		p1.add(jb1);
		p1.add(jb2);

		p1.setOpaque(false);
		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 1 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 13 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(180, -20, 180, 80);
		l2.setBounds(50, b1yloc, 150, 30);
		l3.setBounds(100, 100, 150, 30);
		l4.setBounds(100, 150, 150, 30);
		date.setBounds(275, 300, 150, 30);

		l5.setBounds(100, 200, 150, 30);
		l6.setBounds(100, 250, 150, 30);
		l7.setBounds(100, 300, 150, 30);
		l8.setBounds(100, 350, 150, 30);
		l9.setBounds(100, 400, 150, 30);
		l10.setBounds(100, 450, 150, 30);
		l11.setBounds(100, 500, 100, 30);
		l12.setBounds(100, 550, 150, 30);

		carid.setBounds(275, 100, 150, 30);
		carnumber.setBounds(275, 150, 150, 30);
		timebox1.setBounds(275, 500, 80, 30);
		timebox2.setBounds(275, 550, 80, 30);
		driverid.setBounds(275, 200, 150, 30);
		drivername.setBounds(275, 250, 150, 30);
		driversfz.setBounds(275, 350, 150, 30);
		tel.setBounds(275, 400, 150, 30);

		b1.setBounds(450, 100, 120, 30);
		b4.setBounds(b4xloc, b4yloc, 180, 40);

		jb1.setBounds(275, 450, 50, 30);
		jb2.setBounds(325, 450, 50, 30);

		return p1;

	}

}