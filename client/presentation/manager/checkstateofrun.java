package manager;

import image.ImageGet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import login.Mdialog;
import po.CostManList;
import po.EarnedPOList;
import po.EmploeePO;

import com.eltima.components.ui.DatePicker;

import documentbl.Earneddocu;
import finance.BuildExcel;
import finance.JButtonM;
import finance.JPanelContent;
import financebl.CostManage;

public class checkstateofrun {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	private ImageIcon background;

	public checkstateofrun(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}
	JPanel p1 = new JPanel() 
	{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};
	
	public JPanel checkstateofrun() {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("checkstateofrun");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 1029, 840);
		p1.setOpaque(false);
		p1.setLayout(null);
		final JTextField time1 = new JTextField();
		final DatePicker datepick1 = new DatePicker(time1);
		// datepick1.setLocale(Locale.CHINA);// 设置显示语言
		datepick1.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick1.setEditorable(false);// 设置是否可编辑
		datepick1.setPreferredSize(new Dimension(100, 30));// 设置大小

		final JTextField time2 = new JTextField();
		final DatePicker datepick2 = new DatePicker(time2);
//		datepick2.setLocale(Locale.CHINA);// 设置显示语言
		datepick2.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick2.setEditorable(false);// 设置是否可编辑
		datepick2.setPreferredSize(new Dimension(100, 30));// 设置大小


		String[] columnnames = { "收款日期", "收款金额", "收款快递员", "订单条形码号", "营业厅编号" };
		String[] columnnames2 = { "付款日期", "付款金额", "付款人", "付款人账号", "条目", "备注" };
		Object[][] data = {};
		Object[][] data2 = {};
		DefaultTableModel model1 = new DefaultTableModel(data, columnnames);
		DefaultTableModel model2 = new DefaultTableModel(data2, columnnames2);
		final JTable table = new JTable(model1) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};// 重写JTable
		table.setRowHeight(24);// 设置行距
		final JTable table2 = new JTable(model2) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		table2.setRowHeight(24);// 设置行距
		table.setOpaque(false);
//		table.getTableHeader().setOpaque(false);// 表头设置成透明，并且columnnames里面都设成 ""
												// ""

		table2.setOpaque(false);
//		table2.getTableHeader().setOpaque(false);
	
        table.setForeground(Color.white);
        table2.setForeground(Color.white);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane jp1 = new JScrollPane(table);
		JScrollPane jp2 = new JScrollPane(table2);

		jp1.setOpaque(false);
		jp1.getViewport().setOpaque(false);
		jp2.setOpaque(false);
		jp2.getViewport().setOpaque(false);


		JButtonM okbtn = new JButtonM();
//		okbtn.HideTheButton();
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String startdate = datepick1.getText();
				String enddate = datepick2.getText();

				CostManage costmanage = new CostManage(oos, ois);
				Earneddocu earneddocu = new Earneddocu(oos, ois);

				CostManList cpolist = costmanage.GetCostManageDocu(startdate, enddate);

				if (cpolist.GetIndex(0).getDate().equals("不存在")) {
					Mdialog.showMessageDialog("当天没有付款单!");
				} else {
					for (int i = 0; i < cpolist.GetSize(); i++) {
						Object[] add = { cpolist.GetIndex(i).getDate(), cpolist.GetIndex(i).getPayment(),
								cpolist.GetIndex(i).getPayer(), cpolist.GetIndex(i).getPayaccount(),
								cpolist.GetIndex(i).getTiaomu(), cpolist.GetIndex(i).getTip() };
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.insertRow(model.getRowCount(), add);
					}

					EarnedPOList epolist = earneddocu.GetEarnedDocu(startdate, enddate);
					if (epolist.GetIndex(0).getPaydate().equals("不存在")) {
						Mdialog.showMessageDialog("当天没有收款单!");
					} else {
						for (int i = 0; i < epolist.Getsize(); i++) {
							Object[] add = { epolist.GetIndex(i).getPaydate(), epolist.GetIndex(i).getEarnedmoney(),
									epolist.GetIndex(i).getDilivername(), epolist.GetIndex(i).getOrderID(),
									epolist.GetIndex(i).getBussinessID() };
							DefaultTableModel model = (DefaultTableModel) table2.getModel();
							model.insertRow(model.getRowCount(), add);
						}
					}
				}
			}
		});

		JButtonM excelbtn = new JButtonM();
		excelbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String startdate = datepick1.getText();
				String enddate = datepick2.getText();
				CostManage costmanage = new CostManage(oos, ois);
				Earneddocu earneddocu = new Earneddocu(oos, ois);
				CostManList cpolist = costmanage.GetCostManageDocu(startdate, enddate);
				EarnedPOList epolist = earneddocu.GetEarnedDocu(startdate, enddate);
				BuildExcel excel = new BuildExcel();
				if (excel.CreateCostExcel(cpolist))
					Mdialog.showMessageDialog("生成付款单Excel表格成功!");
				else
					Mdialog.showMessageDialog("抱歉，生成付款单Excel表格失败!");
				if (excel.CreateEarnExcel(epolist))
					Mdialog.showMessageDialog("生成收款单Excel表格成功!");
				else
					Mdialog.showMessageDialog("抱歉，生成收款单Excel表格失败!");
			}
		});
	
		
		
		p1.add(datepick1);
		p1.add(datepick2);
		p1.add(jp1);
		p1.add(jp2);
		p1.add(okbtn);
		
		okbtn.setContentAreaFilled(false);
		okbtn.setBorder(BorderFactory.createEmptyBorder());
		
		datepick1.setBounds(238, 272+57, 174, 42);
		datepick2.setBounds(484, 272+57, 174, 42);
		table.setBounds(80, 400, 380, 282);
		jp1.setBounds(80, 400, 380, 282);
		table2.setBounds(500, 400, 433, 282);
		jp2.setBounds(500, 400, 453, 282);
		okbtn.setBounds(721, 272+53, 190, 45);
		return p1;
	}


}
