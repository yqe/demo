package finance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import login.Tran;
import po.CostManList;
import po.CostManagePO;
import po.EarnedPO;
import po.EarnedPOList;
import po.EmploeePO;
import documentbl.Earneddocu;
import financebl.CostManage;

public class StateOfRun {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public StateOfRun(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public void stateofrun(JPanel context) {
		context.removeAll();
		int labelw = 80;
		int labelh = 30;
		int boxw = 60;
		int boxh = 30;
		int boxgap = 10;
		final JComboBox[][] box = new JComboBox[][] {
				{ new JComboBox(GetBoxStr(200, "年")),
						new JComboBox(GetBoxStr(12, "月")),
						new JComboBox(GetBoxStr(31, "日")) },
				{ new JComboBox(GetBoxStr(200, "年")),
						new JComboBox(GetBoxStr(12, "月")),
						new JComboBox(GetBoxStr(31, "日")) } };
		JLabel[] label = new JLabel[] { new JLabel("开始日期:"),
				new JLabel("结束日期:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("", Font.PLAIN, 15));
			label[i].setBounds(40 + (labelw + boxgap * 4 + boxw * 3) * i, 50,
					labelw, labelh);
			context.add(label[i]);
			for (int j = 0; j < box[i].length; j++) {
				box[i][j].setBounds(40 + labelw + (boxgap + boxw) * j
						+ (labelw + boxw * 3 + boxgap * 5) * i, 50, boxw, boxh);
				context.add(box[i][j]);
			}
		}
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

		jp1.setBounds(40, 100, 300, 500);
		jp2.setBounds(40 + 350 + 20, 100, 300, 500);
		context.add(jp1);
		context.add(jp2);

		JButton okbtn = new JButton("确定");
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startdate1 = box[0][0].getSelectedItem().toString()
						+ box[0][1].getSelectedItem().toString()
						+ box[0][2].getSelectedItem().toString();
				Tran tran = new Tran();
				String startdate=tran.Tran(startdate1);
				
				String enddate1 = box[1][0].getSelectedItem().toString()
						+ box[1][1].getSelectedItem().toString()
						+ box[1][2].getSelectedItem().toString();
				
				String enddate=tran.Tran(enddate1);
				
				// System.out.println(startdate);
				// System.out.println(enddate);

				CostManage costmanage = new CostManage(oos,ois);
				Earneddocu earneddocu = new Earneddocu(oos,ois);

				CostManList cpolist = costmanage.GetCostManageDocu(startdate,
						enddate);
				
				 if(cpolist.GetIndex(0).getDate().equals("不存在")){
                	 JOptionPane.showMessageDialog(null, "当天没有付款单!");
                }
				 else {for (int i = 0; i < cpolist.GetSize(); i++) {
					Object[] add = { cpolist.GetIndex(i).getDate(),
							cpolist.GetIndex(i).getPayment(),
							cpolist.GetIndex(i).getPayer(),
							cpolist.GetIndex(i).getPayaccount(),
							cpolist.GetIndex(i).getTiaomu(),
							cpolist.GetIndex(i).getTip() };
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
					model.insertRow(model.getRowCount(), add);
				}

				EarnedPOList epolist = earneddocu.GetEarnedDocu(startdate,
						enddate);
				 if(epolist.GetIndex(0).getPaydate().equals("不存在")){
                	 JOptionPane.showMessageDialog(null, "当天没有收款单!");
                }
				 else{for (int i = 0; i < epolist.Getsize(); i++) {
					Object[] add = { epolist.GetIndex(i).getPaydate(),
							epolist.GetIndex(i).getEarnedmoney(),
							epolist.GetIndex(i).getDilivername(),
							epolist.GetIndex(i).getOrderID(),
							epolist.GetIndex(i).getBussinessID() };
					DefaultTableModel model = (DefaultTableModel) table2
							.getModel();
					model.insertRow(model.getRowCount(), add);
				}
				 }
			}
			}
		});

		okbtn.setBounds(635, 50, 70, 30);
		context.add(okbtn);

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
				str[i] = "0" + num + meanth ;
			else
				str[i] = num + meanth ;
		
		}
		return str;
	}
}
