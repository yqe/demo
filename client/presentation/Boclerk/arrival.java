package Boclerk;

import image.ImageGet;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.eltima.components.ui.DatePicker;

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
	final JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};

	public arrival(ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.ois=ois;
		this.oos=oos;
		this.emPO=emPO;
	}
	public JPanel Panel() throws IOException {

		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("arrival");
		background = new ImageIcon(bgp);
		p1.setBounds(0, 0, 942, 821);
	

		int b2size = 16;
//		JLabel l3 = new JLabel("营业厅编号:");
//		JLabel l4 = new JLabel("到达日期:");
//		JLabel l5 = new JLabel("出发地:");
//		JLabel l6 = new JLabel("货物到达状态:");
//		JLabel l7 = new JLabel("中转单编号:");
//
//		JLabel l8 = new JLabel("营业厅到达单列表:");

//		l2.setFont(new Font("", Font.PLAIN, b2size));
//		l3.setFont(new Font("", Font.PLAIN, b2size));
//		l4.setFont(new Font("", Font.PLAIN, b2size));
//		l5.setFont(new Font("", Font.PLAIN, b2size));
//		l6.setFont(new Font("", Font.PLAIN, b2size));
//		l7.setFont(new Font("", Font.PLAIN, b2size));
//		l8.setFont(new Font("", Font.PLAIN, b2size));

		final JTextField t1 = new JTextField();
		t1.setText(emPO.getPosID());
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setEditable(false);
		final JTextField t2 = new JTextField();
		
		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());

		

		String[] site = { "南京", "上海", "北京", "杭州", "广州", "苏州", "成都", "武汉" };
		final JComboBox sitebox = new JComboBox(site);
		 sitebox.setBackground(Color.gray);
			sitebox.setForeground(Color.white);

		String[] state = { "损坏", "完整", "丢失" };
		final JComboBox statebox = new JComboBox(state);
		 statebox.setBackground(Color.gray);
			statebox.setForeground(Color.white);

		String[] columnnames = { "", "", "", "", "" };
		Object[][] data = { { "000001", "2015年9月27日", "上海", "完整", "0000001" },
				{ "000002", "2015年9月27日", "南京", "完整", "0000151" }, { "000003", "2015年9月27日", "北京", "完整", "0000202" },

		};

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		final JTable table = new JTable(model){
			   public Component prepareRenderer(TableCellRenderer renderer,
					     int row, int column) {
					    Component c = super.prepareRenderer(renderer, row, column);
					    if (c instanceof JComponent) {
					     ((JComponent) c).setOpaque(false);
					    }
					    return c;
					   }
					  };
		table.setOpaque(false);
		table.setRowHeight(31);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn yytidColumn = table.getColumnModel().getColumn(0);
		TableColumn dateColumn = table.getColumnModel().getColumn(1);
		TableColumn siteColumn = table.getColumnModel().getColumn(2);
		TableColumn stateColumn = table.getColumnModel().getColumn(3);
		TableColumn zzzxidColumn = table.getColumnModel().getColumn(4);
		yytidColumn.setPreferredWidth(87);
		dateColumn.setPreferredWidth(87);
		siteColumn.setPreferredWidth(78);
		stateColumn.setPreferredWidth(80);
		zzzxidColumn.setPreferredWidth(118);
		table.getTableHeader().setOpaque(false);

		
		JScrollPane jp = new JScrollPane(table);

		
		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);
		
		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setOpaque(false);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(150,38));//设置大小

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = datepick.getText();
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

		JButton b5 = new JButton();
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

		JButton b6 = new JButton();
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
//		p1.add(l1);
//		p1.add(l2);
//
//		p1.add(l3);
//		p1.add(l4);
//		p1.add(l5);
//		p1.add(l6);
//		p1.add(l7);
//		p1.add(l8);

		p1.add(t1);
		p1.add(t2);

		p1.add(datepick);
		p1.add(sitebox);
		p1.add(statebox);

		p1.add(b4);
		p1.add(b5);
		p1.add(b6);

		p1.add(jp);

		

		
        b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
        b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
        b6.setContentAreaFilled(false);b6.setBorder(BorderFactory.createEmptyBorder());
        
		int xloc=184,yloc=128,length=150,width=38,interval=58;
		
		t1.setBounds(xloc, yloc, length, width);
		datepick.setBounds(xloc, yloc+interval, length, width);
		sitebox.setBounds(xloc, yloc+interval*2, length, width);
		statebox.setBounds(xloc, yloc+interval*3, length, width);
		t2.setBounds(xloc, yloc+interval*4, length, width);

		jp.setBounds(470, 196, 454, 250);
		
		b4.setBounds(96, 455, 280, 82);
		b5.setBounds(723, 471, 187, 66);
		b6.setBounds(348, 634, 268, 91);

		return p1;

	}
}