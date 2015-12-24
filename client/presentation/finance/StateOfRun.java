package finance;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;

import login.Tran;
import po.CostManList;
import po.CostManagePO;
import po.EarnedPO;
import po.EarnedPOList;
import po.EmploeePO;
import documentbl.Earneddocu;
import financebl.CostManage;
import image.ImageGet;

public class StateOfRun {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public StateOfRun(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void stateofrun(JPanelContent content) {
		content.removeAll();
		Image bgp = new ImageGet().GetFinanceImage("StateOfRun");
		content.setConpanel(bgp);

		final JTextField time1 = new JTextField();
		final DatePicker datepick1 = new DatePicker(time1);
		datepick1.setLocale(Locale.CHINA);// 设置显示语言
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

		String[] columnnames = { "订单条形码号", "到达日期", "收款金额", "快递员" };
		String[] columnnames2 = { "付款日期", "付款金额", "付款人", "付款账户", "条目", "备注" };
		Object[][] data = {};
		Object[][] data2 = {};
		DefaultTableModel model1 = new DefaultTableModel(data, columnnames);
		DefaultTableModel model2 = new DefaultTableModel(data2, columnnames2);
		final JTable table = new JTable(model1);
		final JTable table2 = new JTable(model2);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane jp1 = new JScrollPane(table);
		JScrollPane jp2 = new JScrollPane(table2);

		jp1.setOpaque(false);
		jp1.getViewport().setOpaque(false);
		jp2.setOpaque(false);
		jp2.getViewport().setOpaque(false);

		jp1.setBounds(92, 362, 300, 352);
		jp2.setBounds(544, 362, 460, 352);
		content.add(jp1);
		content.add(jp2);

		JButtonM okbtn = new JButtonM("确定查看");
		okbtn.HideTheButton();
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String startdate = datepick1.getText();
				String enddate = datepick2.getText();

				CostManage costmanage = new CostManage(oos, ois);
				Earneddocu earneddocu = new Earneddocu(oos, ois);

				CostManList cpolist = costmanage.GetCostManageDocu(startdate, enddate);

				if (cpolist.GetIndex(0).getDate().equals("不存在")) {
					JOptionPane.showMessageDialog(null, "当天没有付款单!");
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
						JOptionPane.showMessageDialog(null, "当天没有收款单!");
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

	public String[] GetBoxStr(int n, String meanth) {
		String[] str = new String[n];
		int year = 0;
		int num;
		if (meanth.equals("年"))
			year = 2000;
		for (int i = 0; i < n; i++) {
			num = i + 1 + year;
			if (num < 10)
				str[i] = "0" + num + meanth;
			else
				str[i] = num + meanth;

		}
		return str;
	}
}
