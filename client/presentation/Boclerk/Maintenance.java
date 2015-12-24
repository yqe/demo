package Boclerk;

import image.ImageGet;

import java.awt.Color;
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

import login.MTextfield;
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
	JPanel p1 = new JPanel()
	{public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};
	public Maintenance(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
        new ImageGet();
        Image bgp=ImageGet.getImageByState("Maintenance");
		background = new ImageIcon(bgp);
		p1.setBounds(0, 0, 942, 821);
//		JLabel l2 = new JLabel("—>车辆信息维护");
		int l2size = 16;
//		l2.setFont(new Font("", Font.PLAIN, l2size));
//		JLabel l3 = new JLabel("车辆代号:");
//		JLabel l4 = new JLabel("车牌号:");
//		JLabel l5 = new JLabel("司机编号:");
//		JLabel l6 = new JLabel("司机姓名:");
//		JLabel l7 = new JLabel("出生日期:");
//		JLabel l8 = new JLabel("身份证号:");
//		JLabel l9 = new JLabel("手机:");
//		JLabel l10 = new JLabel("性别:");
//		JLabel l11 = new JLabel("行驶证期限:");
//		JLabel l12 = new JLabel("司机服役时间:");

//		int lmain = 16;
//		l3.setFont(new Font("", Font.PLAIN, lmain));
//		l4.setFont(new Font("", Font.PLAIN, lmain));
//		l5.setFont(new Font("", Font.PLAIN, lmain));
//		l6.setFont(new Font("", Font.PLAIN, lmain));
//		l7.setFont(new Font("", Font.PLAIN, lmain));
//		l8.setFont(new Font("", Font.PLAIN, lmain));
//		l9.setFont(new Font("", Font.PLAIN, lmain));
//		l10.setFont(new Font("", Font.PLAIN, lmain));
//		l11.setFont(new Font("", Font.PLAIN, lmain));
//		l12.setFont(new Font("", Font.PLAIN, lmain));

		final MTextfield carid = new MTextfield();
		final MTextfield carnumber = new MTextfield();
		final MTextfield driverid = new MTextfield();
		final MTextfield drivername = new MTextfield();
		final MTextfield driversfz = new MTextfield();
		final MTextfield tel = new MTextfield();
		final MTextfield date = new MTextfield();
		
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
		
		Color text=new Color(175,172,172);
		
		final JComboBox timebox1 = new JComboBox(time);
		
		timebox1.setBackground(text);
		timebox1.setForeground(Color.white);

		final JComboBox timebox2 = new JComboBox(time);
		
		timebox2.setBackground(text);
		timebox2.setForeground(Color.white);

		final JRadioButton jb1 = new JRadioButton();
		jb1.setSelected(true);
		jb1.setOpaque(false);
		final JRadioButton jb2 = new JRadioButton();
		jb2.setOpaque(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jb1);
		bg.add(jb2);

		JButton b1 = new JButton();
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

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean iscarid = (carid.getText().length()==9);
				boolean iscarnumber =(carnumber.getText().length()==7);
				boolean isdriverid = (driverid.getText().length()==9);
				boolean isidentity=(driversfz.getText().length()==18);

				boolean caridisempty = carid.getText().equals("");
				boolean carnumberisempty = carnumber.getText().equals("");
				boolean driveridisempty = driverid.getText().equals("");
				boolean drivernameisempty = drivername.getText().equals("");
				boolean driversfzisempty = driversfz.getText().equals("");
				boolean telisempty = tel.getText().equals("");

				boolean isempty = caridisempty || carnumberisempty || driveridisempty || drivernameisempty
						|| driversfzisempty || telisempty;

				String s = jb1.isSelected() ? "男" : "女";
				if (iscarid && iscarnumber && isdriverid &&isidentity &&!isempty) {
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
				} 
				 else if (!isdriverid && !driveridisempty) {
						JOptionPane.showMessageDialog(null, "请输入正确的身份证号!");
				}else if (isempty) {
					JOptionPane.showMessageDialog(null, "请完整填写信息!");// 123
				}

			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);
//		p1.add(l1);
//		p1.add(l2);
//		p1.add(l3);
//		p1.add(l4);
//		p1.add(l5);
//		p1.add(l6);
//		p1.add(l7);
//		p1.add(l8);
//		p1.add(l9);
//		p1.add(l10);
//		p1.add(l11);
//		p1.add(l12);

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


		int xloc=270,yloc=132;
		int length=234,width=38;
		int interval=55;
		
		carid.settextFont();carnumber.settextFont();driverid.settextFont();
		drivername.settextFont();date.settextFont();driversfz.settextFont();
		tel.settextFont();
		
		carid.setBounds(xloc, yloc, length, width);
		carnumber.setBounds(xloc, yloc+interval, length, width);
		timebox1.setBounds(xloc, yloc+interval*8+10, length, width);
		timebox2.setBounds(xloc, yloc+interval*9+23, length, width);
		driverid.setBounds(xloc, yloc+interval*2, length, width);
		drivername.setBounds(xloc, yloc+interval*3, length, width);
		date.setBounds(xloc, yloc+interval*4, length, width);
		driversfz.setBounds(xloc, yloc+interval*5+10, length, width);
		tel.setBounds(xloc, yloc+interval*6+10, length, width);

		b1.setContentAreaFilled(false);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		
		b1.setBounds(551,130,145,39);
		b4.setBounds(219, 713, 277, 85);

		jb1.setBounds(xloc+50, yloc+interval*7+20, 50, 30);
		jb2.setBounds(xloc+195, yloc+interval*7+20, 50, 30);

		return p1;

	}

}