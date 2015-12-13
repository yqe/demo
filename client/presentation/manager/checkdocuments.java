package manager;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import finance.CostIncome;
import finance.StateOfRun;
import po.EmploeePO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkdocuments {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public checkdocuments(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel(final JPanel p1) throws IOException {
		p1.removeAll();
		p1.setBounds(0, 0, 770, 700);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>查看表单");
		int b2size = 16;
		JLabel l3 = new JLabel("已选表单列表");
		l2.setFont(new Font("", Font.PLAIN, b2size));
		l3.setFont(new Font("", Font.PLAIN, b2size));

		final StateOfRun sr = new StateOfRun(oos,ois,emPO);
		final CostIncome cic = new CostIncome(oos,ois,emPO);
		final JPanel contain = new JPanel();
		contain.setBounds(0, 0, 720, 700);

		JButton b4 = new JButton("查看经营情况表");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new CheckBill().CheckBill(p1);
				new StateOfRun(oos,ois,emPO).stateofrun(p1);
				p1.repaint();
			}
		}); // 这一部分家族企业和我Panel实现方法不同
		JButton b5 = new JButton("查看成本收益表");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CostIncome(oos,ois,emPO).costincome(p1);
				p1.repaint();
			}
		});

		String[] columnnames = { "日期", "表单类型" };
		Object[][] data = { { "2015-11-25", "成本收益表" }, { "2015-11-20", "成本收益表" }, { "2015-09-21", "经营情况表" } };

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		JTable table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);// 设置宽度
		table.getColumnModel().getColumn(1).setPreferredWidth(200);

		JScrollPane jp = new JScrollPane(table);

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		p1.setOpaque(false);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);

		p1.add(b4);
		p1.add(b5);
		p1.add(jp);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 1 / 7;
		int b4yloc = p1.getHeight() * 4 / 17, b4ysize = p1.getHeight() * 1 / 6;

		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, b1yloc, 180, 30);
		l3.setBounds(50, b4yloc + 50, 180, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);
		b5.setBounds(b4xloc + 300, b4yloc, 180, 40);
		jp.setBounds(100, b4yloc + 80, 403, 400);

		return p1;

	}
}