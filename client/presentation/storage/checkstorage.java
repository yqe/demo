package storage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;

import po.EmploeePO;
import storagebl.StorageBl;

public class checkstorage {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public checkstorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 900, 700);
		p1.setOpaque(false);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>库存查看");
		int l2size = 16;
		l2.setFont(new Font("", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("时间选择:");
		JLabel l4 = new JLabel("到");
		JLabel l5 = new JLabel("出库数量:");
		JLabel l6 = new JLabel("入库数量:");
		JLabel l7 = new JLabel("金额:");
		JLabel l8 = new JLabel("元");
		JLabel l9 = new JLabel("库存数量:");

		int lmain = 16;
		l3.setFont(new Font("", Font.PLAIN, lmain));
		l4.setFont(new Font("", Font.PLAIN, lmain));
		l5.setFont(new Font("", Font.PLAIN, lmain));
		l6.setFont(new Font("", Font.PLAIN, lmain));
		l7.setFont(new Font("", Font.PLAIN, lmain));
		l8.setFont(new Font("", Font.PLAIN, lmain));
		l9.setFont(new Font("", Font.PLAIN, lmain));

		final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();
		final JTextField t3 = new JTextField();
		final JTextField t4 = new JTextField();

		t1.setOpaque(false);
		t1.setEditable(false);
		t2.setOpaque(false);
		t2.setEditable(false);
		t3.setOpaque(false);
		t3.setEditable(false);
		t4.setOpaque(false);
		t4.setEditable(false);
		
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setBorder(BorderFactory.createEmptyBorder());
		t3.setBorder(BorderFactory.createEmptyBorder());
		t4.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton("查 看");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageBl stobl = new StorageBl(oos, ois);
				t1.setText("100");
				t2.setText("50");
				t3.setText("500");
				t4.setText("50");// 到时候传PO读取数据

			}
		});

		final JTextField time1 = new JTextField();
		final DatePicker datepick1 = new DatePicker(time1);
		datepick1.setOpaque(false);
		datepick1.setLocale(Locale.CHINA);//设置显示语言
	    datepick1.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick1.setEditorable(false);//设置是否可编辑
		datepick1.setPreferredSize(new Dimension(100,30));//设置大小
		
		final JTextField time2 = new JTextField();
		final DatePicker datepick2 = new DatePicker(time2);
		datepick2.setOpaque(false);
		datepick2.setLocale(Locale.CHINA);//设置显示语言
	    datepick2.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick2.setEditorable(false);//设置是否可编辑
		datepick2.setPreferredSize(new Dimension(100,30));//设置大小

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

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);

		p1.add(b4);
		p1.add(datepick1);
		p1.add(datepick2);
	

		int b1yloc = p1.getHeight() * 2 / 19;

		l1.setBounds(260, -20, 180, 80);
		l2.setBounds(50, b1yloc, 300, 30);
		datepick1.setBounds(150, 100, 150, 30);

		datepick2.setBounds(450, 100, 80, 30);
	

		l3.setBounds(75, 100, 100, 30);
		l4.setBounds(410, 100, 50, 30);
		l5.setBounds(250, 250, 150, 30);
		l6.setBounds(250, 300, 150, 30);
		l7.setBounds(250, 350, 150, 30);
		l8.setBounds(550, 350, 150, 30);
		l9.setBounds(250, 400, 150, 30);

		t1.setBounds(375, 250, 150, 30);
		t2.setBounds(375, 300, 150, 30);
		t3.setBounds(375, 350, 150, 30);
		t4.setBounds(375, 400, 150, 30);
		b4.setBounds(375, 480, 150, 40);

		return p1;

	}

}