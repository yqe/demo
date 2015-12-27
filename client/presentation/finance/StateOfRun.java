package finance;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.eltima.components.ui.DatePicker;

import documentbl.Earneddocu;
import financebl.CostManage;
import image.ImageGet;
import login.Mdialog;
import po.CostManList;
import po.EarnedPOList;
import po.EmploeePO;

public class StateOfRun {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public StateOfRun(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void stateofrun(JPanel content) {
		final JTextField time1 = new JTextField();
		final DatePicker datepick1 = new DatePicker(time1);
		// datepick1.setLocale(Locale.CHINA);// 设置显示语言
		datepick1.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick1.setEditorable(false);// 设置是否可编辑
		datepick1.setPreferredSize(new Dimension(100, 30));// 设置大小

		final JTextField time2 = new JTextField();
		final DatePicker datepick2 = new DatePicker(time2);
		datepick2.setLocale(Locale.CHINA);// 设置显示语言
		datepick2.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick2.setEditorable(false);// 设置是否可编辑
		datepick2.setPreferredSize(new Dimension(100, 30));// 设置大小

		datepick1.setBounds(207, 272, 174, 42);
		datepick2.setBounds(453, 272, 174, 42);
		content.add(datepick1);
		content.add(datepick2);

		String[] columnnames = { "", "", "", "",""};
		String[] columnnames2 = { "", "", "", "", "", "" };
		Object[][] data = {};
		Object[][] data2 = {};
		DefaultTableModel model1 = new DefaultTableModel(data, columnnames);
		DefaultTableModel model2 = new DefaultTableModel(data2, columnnames2);
		final JTable table = new JTable(model1){
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};//重写JTable
		table.setRowHeight(24);//设置行距
		final JTable table2 = new JTable(model2){
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		table2.setRowHeight(24);//设置行距
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);//表头设置成透明，并且columnnames里面都设成 "" ""
		TableColumn Column0 = table.getColumnModel().getColumn(0);
		Column0.setPreferredWidth(76);//设置每一列的列宽

		TableColumn Column1 = table.getColumnModel().getColumn(1);
		Column1.setPreferredWidth(72);

		TableColumn Column2 = table.getColumnModel().getColumn(2);
		Column2.setPreferredWidth(76);

		TableColumn Column3 = table.getColumnModel().getColumn(3);
		Column3.setPreferredWidth(68);

		TableColumn Column4 = table.getColumnModel().getColumn(4);		
		Column4.setPreferredWidth(74);
		
		
		table2.setOpaque(false);
		table2.getTableHeader().setOpaque(false);
		TableColumn Column00 = table2.getColumnModel().getColumn(0);
		Column00.setPreferredWidth(82);

		TableColumn Column01 = table2.getColumnModel().getColumn(1);
		Column01.setPreferredWidth(80);

		TableColumn Column02 = table2.getColumnModel().getColumn(2);
		Column02.setPreferredWidth(78);

		TableColumn Column03 = table2.getColumnModel().getColumn(3);
		Column03.setPreferredWidth(68);

		TableColumn Column04 = table2.getColumnModel().getColumn(4);		
		Column04.setPreferredWidth(62);
		
		TableColumn Column05 = table2.getColumnModel().getColumn(5);		
		Column05.setPreferredWidth(57);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane jp1 = new JScrollPane(table);
		JScrollPane jp2 = new JScrollPane(table2);

		jp1.setOpaque(false);
		jp1.getViewport().setOpaque(false);
		jp2.setOpaque(false);
		jp2.getViewport().setOpaque(false);

		jp1.setBounds(89, 421, 370, 282);
		jp2.setBounds(818-356, 421, 433, 282);
		content.add(jp1);
		content.add(jp2);

		JButtonM okbtn = new JButtonM();
		okbtn.HideTheButton();
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

		okbtn.setBounds(702, 272, 175, 42);
		content.add(okbtn);
	}

	public void stateofrun(JPanelContent content) {
		content.removeAll();
		Image bgp = new ImageGet().GetFinanceImage("StateOfRun");
		content.setConpanel(bgp);
		stateofrun(content.GetPanel());
	}
}
