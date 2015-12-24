package finance;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;

import documentbl.Earneddocu;
import image.ImageGet;
import login.MTextfield;
import po.EarnedPOList;
import po.EmploeePO;

public class CheckBill {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public CheckBill(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void CheckBill(JPanelContent content) {
		content.removeAll();
		Image bgp = new ImageGet().GetFinanceImage("CheckBill");
		content.setConpanel(bgp);

		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setLocale(Locale.CHINA);// 设置显示语言
		datepick.setPattern("yyyy-MM-dd");// 设置日期格式化字符串
		datepick.setEditorable(true);// 设置是否可编辑
		datepick.setPreferredSize(new Dimension(100, 30));// 设置大小
		datepick.setBounds(244, 248, 175, 42);
		content.add(datepick);

		final MTextfield hallno = new MTextfield();
		hallno.settextFont();
		hallno.HideTheField();
		hallno.setBounds(244, 298, 175, 42);

		String[] columnnames = { "营业厅编号", "订单条形码号", "收款日期", "收款金额", "收款快递员" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		final JTable bill = new JTable(model);
		bill.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jp = new JScrollPane(bill);

		JButtonM timecheck = new JButtonM("按天查询");
		timecheck.setBounds(454, 249, 182, 39);
		timecheck.HideTheButton();
		timecheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = datepick.getText();
				Earneddocu earneddocu = new Earneddocu(oos, ois);
				EarnedPOList epolist = earneddocu.GetEarnedDocu("day", date);
				if (epolist.GetIndex(0).getPaydate().equals("不存在")) {
					JOptionPane.showMessageDialog(null, "当天没有收款单!");
				} else {
					for (int i = 0; i < epolist.Getsize(); i++) {
						Object[] add = { epolist.GetIndex(i).getPaydate(), epolist.GetIndex(i).getEarnedmoney(),
								epolist.GetIndex(i).getDilivername(), epolist.GetIndex(i).getOrderID(),
								epolist.GetIndex(i).getBussinessID() };
						DefaultTableModel model = (DefaultTableModel) bill.getModel();
						model.insertRow(model.getRowCount(), add);
					}
				}
			}
		});

		JButtonM hallcheck = new JButtonM("按营业厅查询");
		hallcheck.setBounds(454, 298, 182, 39);
		hallcheck.HideTheButton();
		hallcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = hallno.getText();
				// System.out.println(id);
				Earneddocu earneddocu = new Earneddocu(oos, ois);
				EarnedPOList epolist = earneddocu.GetEarnedDocu("ID", id);

				if (epolist.GetIndex(0).getPaydate().equals("不存在")) {
					JOptionPane.showMessageDialog(null, "当天没有收款单!");
				} else {
					for (int i = 0; i < epolist.Getsize(); i++) {
						Object[] add = { epolist.GetIndex(i).getPaydate(), epolist.GetIndex(i).getEarnedmoney(),
								epolist.GetIndex(i).getDilivername(), epolist.GetIndex(i).getOrderID(),
								epolist.GetIndex(i).getBussinessID() };
						DefaultTableModel model = (DefaultTableModel) bill.getModel();
						model.insertRow(model.getRowCount(), add);
					}
				}
			}
		});

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);
		jp.setBounds(110, 358, 376, 350);

		content.add(jp);
		content.add(timecheck);
		content.add(hallcheck);
		content.add(hallno);
	}
}
