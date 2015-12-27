package storage;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
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

import po.EmploeePO;
import po.InputStorageList;
import po.OutStorageDocuPO;
import po.OutStorageList;
import storagebl.StorageBl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.MTextfield;
import login.Tran;

public class outstorage {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(Sbackground.getImage(), 0, 0, null);
		}
	};

	public outstorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {

		final OutStorageList oslt = new OutStorageList();
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("outstorage");
		Sbackground = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 988, 756);
	
		int b2size = 16;
//		JLabel l3 = new JLabel("快递编号:");
//		JLabel l4 = new JLabel("出库日期:");
//		JLabel l5 = new JLabel("目的地:");
//		JLabel l6 = new JLabel("装运形式:");
//		JLabel l7 = new JLabel("中转编号:");
//
//		JLabel l8 = new JLabel("入库单列表:");


		final MTextfield t1 = new MTextfield();
		final MTextfield t2 = new MTextfield();
		
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setText(emPO.getPosID());
		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setEditable(false);
		final JTextField time = new JTextField();
		Calendar c=Calendar.getInstance();
		Date d=c.getTime();
		final DatePicker datepick = new DatePicker(time,d);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小

		String[] site = { "南京", "上海", "北京", "杭州", "广州", "苏州", "成都", "武汉" };
		final JComboBox sitebox = new JComboBox(site);

		String[] type = { "汽车", "火车", "飞机" };
		final JComboBox typebox = new JComboBox(type);

		String[] columnnames = { "", "", "", "" };
		Object[][] data = { { "000001", "2015年9月27日", "上海", "火车"},
				{ "000002", "2015年9月27日", "南京", "汽车" }, { "000003", "2015年9月27日", "北京", "飞机"},

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
    	table.setRowHeight(30);
    	  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn Column0 = table.getColumnModel().getColumn(0); 
		Column0.setPreferredWidth(84);
		
		TableColumn Column1 = table.getColumnModel().getColumn(1);
		Column1.setPreferredWidth(94);
		
		TableColumn Column2 = table.getColumnModel().getColumn(2);
		Column2.setPreferredWidth(88);
		
		TableColumn Column3 = table.getColumnModel().getColumn(3);
		Column3.setPreferredWidth(103);

		table.setForeground(Color.white);
		JScrollPane jp = new JScrollPane(table);
		
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		
		jp.setOpaque(false);
		
		jp.getViewport().setOpaque(false);

		JButton b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = datepick.getText();
				String place = (String) sitebox.getSelectedItem();
				String type = (String) typebox.getSelectedItem();
				OutStorageDocuPO am = new OutStorageDocuPO(t1.getText(), date, place, type, t2.getText());
				oslt.addOutStoragePO(am);
				Object[] add = { t1.getText(), date, place, type};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.insertRow(model.getRowCount(), add);
				 System.out.println(model.getRowCount());
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

		JButton b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageBl k = new StorageBl(oos,ois);
				boolean isOk = k.OutStorageInput(oslt);
				if (isOk)
					JOptionPane.showMessageDialog(null, "成功完成出库!");
				else
					JOptionPane.showMessageDialog(null, "无法完成出库!");

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(t1);
		p1.add(t2);

		p1.add(datepick);
		p1.add(sitebox);
		p1.add(typebox);

		p1.add(b4);
//		p1.add(b5);
		p1.add(b6);

		p1.add(jp);

//		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
//		int b1yloc = p1.getHeight() * 1 / 19;
//		int b4xloc = p1.getWidth() * 11 / 13;
//		int b4yloc = p1.getHeight() * 3 / 19 + 20, b4ysize = p1.getHeight() * 1 / 5;
//
		int xloc=65,length=175,width=44;
		
	    jp.setBounds(571, 220, 373, 368);
		
		datepick.setBounds(xloc, 408, length, width);

		sitebox.setBounds(xloc, 502, length, width);
		
		t1.settextFont();
		
		t1.setBounds(xloc, 312, length, width);
		
		t2.settextFont();
		
		t2.setBounds(252, 620, 196, 42);

		typebox.setBounds(268, 358, 176, 43);



		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		b6.setContentAreaFilled(false);b6.setBorder(BorderFactory.createEmptyBorder());
		b4.setBounds(254, 455, 200, 54);
//		b5.setBounds(b4xloc, b4yloc + 2 * b4ysize, 100, 40);
		b6.setBounds(707, 648, 200, 54);
		return p1;

	}
}