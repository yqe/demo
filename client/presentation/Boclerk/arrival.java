package Boclerk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import documentbl.HallArrivalDocu;
import po.BussinessArrivalDocuPO;
import po.EmploeePO;

public class arrival {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private EmploeePO emPO;

	public arrival(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}
	public JPanel Panel() throws IOException {

		final JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 800, 800);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>生成到达单");
		int b2size = 16;
		JLabel l3 = new JLabel("营业厅编号:");
		JLabel l4 = new JLabel("到达日期:");
		JLabel l5 = new JLabel("出发地:");
		JLabel l6 = new JLabel("货物到达状态:");
		JLabel l7 = new JLabel("中转单编号:");

		JLabel l8 = new JLabel("营业厅到达单列表:");

		l2.setFont(new Font("", Font.PLAIN, b2size));
		l3.setFont(new Font("", Font.PLAIN, b2size));
		l4.setFont(new Font("", Font.PLAIN, b2size));
		l5.setFont(new Font("", Font.PLAIN, b2size));
		l6.setFont(new Font("", Font.PLAIN, b2size));
		l7.setFont(new Font("", Font.PLAIN, b2size));
		l8.setFont(new Font("", Font.PLAIN, b2size));

		final JTextField t1 = new JTextField();
		t1.setText(emPO.getPosID());
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setEditable(false);
		final JTextField t2 = new JTextField();
		
		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());

		String[] year = new String[201];
		for (int i = 2000; i < 2100; i++) {
			year[i - 2000] = i + "年";

		}
		final JComboBox yearbox = new JComboBox(year);
		String[] month = new String[12];
		for (int i = 1; i <= 12; i++) {
			month[i - 1] = i + "月";

		}
		final JComboBox monthbox = new JComboBox(month);
		String[] day = new String[31];
		for (int i = 1; i <= 31; i++) {
			day[i - 1] = i + "日";

		}
		final JComboBox daybox = new JComboBox(day);

		String[] site = { "南京", "上海", "北京", "杭州", "广州", "苏州", "成都", "武汉" };
		final JComboBox sitebox = new JComboBox(site);

		String[] state = { "损坏", "完整", "丢失" };
		final JComboBox statebox = new JComboBox(state);

		String[] columnnames = { "营业厅编号", "到达日期", "出发地", "货物到达状态", "中转单编号" };
		Object[][] data = { { "000001", "2015年9月27日", "上海", "完整", "0000001" },
				{ "000002", "2015年9月27日", "南京", "完整", "0000151" }, { "000003", "2015年9月27日", "北京", "完整", "0000202" },

		};

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		final JTable table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn dateColumn = table.getColumnModel().getColumn(1);
		dateColumn.setPreferredWidth(100);

		JScrollPane jp = new JScrollPane(table);

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		JButton b4 = new JButton("确定添加");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = (String) yearbox.getSelectedItem() + monthbox.getSelectedItem()
						+ daybox.getSelectedItem();
				String place = (String) sitebox.getSelectedItem();
				String state = (String) statebox.getSelectedItem();
				HallArrivalDocu bussari = new HallArrivalDocu(oos,ois);
				boolean IsOk = bussari.BuildHallArrivalDocu(
						new BussinessArrivalDocuPO(date, t2.getText(), place, state, t1.getText()));
				if (IsOk) {
					JOptionPane.showMessageDialog(null, "成功建立到达单!");
				} else {
					JOptionPane.showMessageDialog(null, "建立到达单失败!");
				}

				// System.out.println(model.getRowCount());
			}
		});

		JButton b5 = new JButton("删除");
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ��ȡҪɾ�����,û��ѡ����-1
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				// System.out.println(row);
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "请选中要删除的行!");
				} else {
					model.removeRow(row);
				}
			}
		});

		JButton b6 = new JButton("生成到达单");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

		p1.add(t1);
		p1.add(t2);

		p1.add(yearbox);
		p1.add(monthbox);
		p1.add(daybox);
		p1.add(sitebox);
		p1.add(statebox);

		p1.add(b4);
		p1.add(b5);
		p1.add(b6);

		p1.add(jp);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 1 / 19;
		int b4xloc = p1.getWidth() * 11 / 13;
		int b4yloc = p1.getHeight() * 3 / 19 + 20, b4ysize = p1.getHeight() * 1 / 5;

		l1.setBounds(180, -20, 180, 80);

		l2.setBounds(50, b1yloc, 180, 30);

		l3.setBounds(50, b1yloc + 50, 100, 30);// ���
		l4.setBounds(50, b1yloc + 100, 100, 30);// ��������
		l5.setBounds(50, b1yloc + 150, 100, 30);// ������

		l6.setBounds(205, b1yloc + 150, 100, 30);// ״̬
		l7.setBounds(50, b1yloc + 200, 100, 30);
		l8.setBounds(50, b1yloc + 250, 200, 30);

		jp.setBounds(50, b1yloc + 300, 403, 350);

		yearbox.setBounds(150, b1yloc + 100, 80, 30);
		monthbox.setBounds(250, b1yloc + 100, 80, 30);
		daybox.setBounds(350, b1yloc + 100, 80, 30);
		sitebox.setBounds(120, b1yloc + 150, 80, 30);
		statebox.setBounds(315, b1yloc + 150, 80, 30);

		t1.setBounds(150, b1yloc + 50, 120, 30);
		t2.setBounds(150, b1yloc + 200, 120, 30);

		b4.setBounds(480, b4yloc, 100, 40);
		b5.setBounds(480, b4yloc + 2 * b4ysize, 100, 40);
		b6.setBounds(480, b4yloc + 3 * b4ysize, 100, 40);

		return p1;

	}
}