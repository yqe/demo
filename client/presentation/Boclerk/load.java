package Boclerk;

import image.ImageGet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

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

import com.eltima.components.ui.DatePicker;

import documentbl.Transdocu;
import po.EmploeePO;
import po.TransPO;

public class load {
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
	public load(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("load");
		background = new ImageIcon(bgp);
		p1.setBounds(0, 0, 942, 821);

	
//		JLabel l2 = new JLabel("—>生成装车单");
		int l2size = 16;
//		l2.setFont(new Font("", Font.PLAIN, l2size));
//		JLabel l3 = new JLabel("订单条形码号:");
//		JLabel l4 = new JLabel("装车日期:");
//		JLabel l5 = new JLabel("汽运编号:");
//		JLabel l6 = new JLabel("到达地:");
//		JLabel l7 = new JLabel("车辆代号:");
//		JLabel l8 = new JLabel("监装员:");
//		JLabel l9 = new JLabel("押运员:");
//		JLabel l10 = new JLabel("运费:");
//		JLabel l11 = new JLabel("元");
//
//		JLabel l12 = new JLabel("营业厅编号:");


		final MTextfield id = new MTextfield();
		final MTextfield transid = new MTextfield();
		final MTextfield carid = new MTextfield();
		final MTextfield jz = new MTextfield();// ��װԱ
		final MTextfield yy = new MTextfield();// Ѻ��Ա
		final MTextfield price = new MTextfield();
		final MTextfield yyt = new MTextfield();
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		transid.setOpaque(false);
		transid.setBorder(BorderFactory.createEmptyBorder());
		carid.setOpaque(false);
		carid.setBorder(BorderFactory.createEmptyBorder());
		jz.setOpaque(false);
		jz.setBorder(BorderFactory.createEmptyBorder());
		yy.setOpaque(false);
		yy.setBorder(BorderFactory.createEmptyBorder());
		price.setOpaque(false);
		price.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		
		yyt.setText(emPO.getPosID());
		yyt.setOpaque(false);
		yyt.setBorder(BorderFactory.createEmptyBorder());
		yyt.setEditable(false);
		
		final JTextField time = new JTextField();
		time.setOpaque(false);
		final DatePicker datepick = new DatePicker(time);
		
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
	    datepick.setBackground(Color.gray);
	    datepick.setForeground(Color.white);
		datepick.setPreferredSize(new Dimension(100,30));//设置大小

		String[] site = { "上海", "北京", "南京", "深圳", "广州", "杭州" };

		Color text=new Color(175,172,172);
		final JComboBox sitebox = new JComboBox(site);
		
		sitebox.setOpaque(false);
        sitebox.setBackground(text);
		sitebox.setForeground(Color.white);
		
		
		
		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum = true;
				for (int i = 0; i < price.getText().length(); i++) {
					if (price.getText().charAt(i) > '9' || price.getText().charAt(i) < '1') {
						isnum = false;
					}
				}
				boolean istransid = (transid.getText().length()==20);
				boolean iscarid = (carid.getText().length()==9);
			

				boolean cisempty = carid.getText().equals("");
				boolean pisempty = price.getText().equals("");
				boolean tisempty = transid.getText().equals("");
				boolean carisempty = carid.getText().equals("");
				boolean jzisempty = jz.getText().equals("");
				boolean yyisempty = yy.getText().equals("");
				boolean yytisempty = yyt.getText().equals("");

				boolean isempty = cisempty || pisempty || tisempty || carisempty || jzisempty || yyisempty
						|| yytisempty;
				
				String date = datepick.getText();
				boolean IsDouble=false;
				try{
					double priced=Double.parseDouble(price.getText());
					IsDouble=true;
				}catch (Exception e1) {
					IsDouble=false;
				}
				if (istransid&&iscarid&&id.getText().length() != 10)
					JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				else if(!isempty&&!IsDouble)
					JOptionPane.showMessageDialog(null, "请输入合法的金额!");
				else if(!isempty&&!istransid)
					JOptionPane.showMessageDialog(null, "请输入合法的汽运编号!");
				else if(!isempty&&!iscarid)
					JOptionPane.showMessageDialog(null, "请输入合法的车辆代号!");
				else if (isempty)
					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				else {
					Transdocu trans = new Transdocu(oos,ois);
					boolean IsOk = trans.BuildTransDocu(new TransPO(date, yyt.getText(), transid.getText(),
							(String) (sitebox.getSelectedItem()), carid.getText(), jz.getText(), yy.getText(),
							Double.parseDouble(price.getText()), id.getText()));
					if (IsOk) {
						JOptionPane.showMessageDialog(null, "成功生成装车单!");
					} else {
						JOptionPane.showMessageDialog(null, "生成装车单失败!");
					}
				}
				// else if (id.getText().length() != 10) {
				// JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				// } else if (!isnum && !pisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的金额!");// 只能是整数
				// } else if (!isyytid && !yytisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的汽运编号!");
				// } else if (!istransid && !tisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的汽运编号!");
				// } else if (!iscarid && !carisempty) {
				// JOptionPane.showMessageDialog(null, "请输入合法的车辆代号!");
				// } else if (isempty) {
				// JOptionPane.showMessageDialog(null, "请完整填写信息!");
				// }
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

		p1.add(id);
		p1.add(transid);
		p1.add(carid);
		p1.add(jz);
		p1.add(yy);
		p1.add(price);
		p1.add(yyt);

		p1.add(b4);
		p1.add(datepick);
	
		p1.add(sitebox);

		p1.setOpaque(false);


//		l1.setBounds(180, -20, 180, 80);
//		l2.setBounds(50, b1yloc, 150, 30);
//		l3.setBounds(100, 100, 150, 30);
//		l4.setBounds(100, 150, 150, 30);


//		l12.setBounds(100, 200, 150, 30);
//		l5.setBounds(100, 250, 150, 30);
//		l6.setBounds(100, 300, 150, 30);
//		l7.setBounds(100, 350, 150, 30);
//		l8.setBounds(100, 400, 150, 30);
//		l9.setBounds(100, 450, 150, 30);
//		l10.setBounds(100, 500, 150, 30);
//		l11.setBounds(450, 500, 100, 30);

		int interval=55;int xloc=271;
		
		id.settextFont();transid.settextFont();carid.settextFont();jz.settextFont();yy.settextFont();price.settextFont();
		yyt.settextFont();
		
		id.setBounds(xloc, 132, 234, 38);
		datepick.setBounds(xloc, 132+interval, 234, 38);
		transid.setBounds(xloc, 132+interval*3, 234, 38);
		sitebox.setBounds(xloc, 132+interval*4, 234, 40);
		carid.setBounds(xloc, 132+interval*5+4, 234, 38);
		jz.setBounds(xloc, 132+interval*6, 234, 38);
		yy.setBounds(xloc, 132+interval*7, 234, 38);
		price.setBounds(xloc, 132+interval*8+2, 234, 38);
		yyt.setBounds(xloc, 132+2*interval, 234, 38);

		
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		
		b4.setBounds(225, 691, 277, 84);

		return p1;

	}

}