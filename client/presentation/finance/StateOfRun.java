package finance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import po.CostManagePO;
import po.EarnedPO;
import documentbl.Earneddocu;
import financebl.CostManage;

public class StateOfRun {

	public void stateofrun(JPanel context) {
		context.removeAll();
		int labelw = 80;
		int labelh = 30;
		int boxw = 60;
		int boxh = 30;
		int boxgap = 10;
		final JComboBox[][] box = new JComboBox[][] {
				{ new JComboBox(GetBoxStr(200, "年")), new JComboBox(GetBoxStr(12, "月")),
						new JComboBox(GetBoxStr(31, "日")) },
				{ new JComboBox(GetBoxStr(200, "年")), new JComboBox(GetBoxStr(12, "月")),
						new JComboBox(GetBoxStr(31, "日")) } };
		JLabel[] label = new JLabel[] { new JLabel("开始日期:"), new JLabel("结束日期:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("", Font.PLAIN, 15));
			label[i].setBounds(40 + (labelw + boxgap * 4 + boxw * 3) * i, 50, labelw, labelh);
			context.add(label[i]);
			for (int j = 0; j < box[i].length; j++) {
				box[i][j].setBounds(40 + labelw + (boxgap + boxw) * j + (labelw + boxw * 3 + boxgap * 5) * i, 50, boxw,
						boxh);
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
		okbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String startdate=box[0][0].getSelectedItem().toString()+box[0][1].getSelectedItem().toString()+box[0][2].getSelectedItem().toString();
				String enddate=box[1][0].getSelectedItem().toString()+box[1][1].getSelectedItem().toString()+box[1][2].getSelectedItem().toString();
//			    System.out.println(startdate);
//				System.out.println(enddate);
				
				CostManage costmanage=new CostManage(); 
				Earneddocu earneddocu=new Earneddocu();

				
				ArrayList<CostManagePO> cpolist = costmanage.GetCostManageDocu(startdate, enddate);
				for (int i = 0; i < cpolist.size(); i++) {
				Object[] add={cpolist.get(i).getDate(),cpolist.get(i).getPayment(),
				cpolist.get(i).getPayer(),cpolist.get(i).getPayaccount(),cpolist.get(i).getTiaomu(),cpolist.get(i).getTip()};
				DefaultTableModel model = (DefaultTableModel) table.getModel();            
				model.insertRow(model.getRowCount(), add);
				}
//				this.paydate=paydate;//收款日期
//				this.earnedmoney=money;//收款金额
//				this.dilivername=dname;//收款快递员姓名
//				this.orderID=ID;//订单条形码号
//				this.bussinessID=buID;//所属营业厅ID
				
				ArrayList<EarnedPO> epolist = earneddocu.GetEarnedDocu(startdate, enddate);
				for (int i = 0; i < epolist.size(); i++) {
					Object[] add={epolist.get(i).getPaydate(),epolist.get(i).getEarnedmoney(),
			epolist.get(i).getDilivername(),epolist.get(i).getOrderID(),epolist.get(i).getBussinessID()};
					DefaultTableModel model = (DefaultTableModel) table2.getModel();            
					model.insertRow(model.getRowCount(), add);
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
			str[i] = num + meanth + "";
			;
		}
		return str;
	}
}
