package finance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
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

public class CheckBill {

	public void CheckBill(JPanel context) {
		int sw = 40;
		int sh = 40;
		int gap = 40;
		int wordsize = 16;
		int buttonw = 120;
		int buttonh = 30;
		int boxwidth = 100;
		int boxheight = 30;
		int boxgap = 10;
		
		JLabel timelabel = new JLabel("时间:");
		JLabel yytlabel = new JLabel("营业厅编号:");
		 timelabel.setFont(new Font("",Font.PLAIN,18));
		 yytlabel.setFont(new Font("",Font.PLAIN,18));
		context.removeAll();
		final JComboBox[] box = new JComboBox[] { new JComboBox(GetBoxStr(200, "年")), new JComboBox(GetBoxStr(12, "月")),
				new JComboBox(GetBoxStr(31, "日")) };
		for (int i = 0; i < box.length; i++) {
			box[i].setBounds(sw + 110 + (boxgap + boxwidth) * i, sh, boxwidth, boxheight);
			context.add(box[i]);
		}
		

		final JTextField hallno = new JTextField();
	    timelabel.setBounds(sw + 10, sh , 100, boxheight);
		yytlabel.setBounds(sw + 10, sh + gap, 100, boxheight);
		hallno.setBounds(sw + 150, sh + gap, 200, boxheight);

		String[] columnnames = { "营业厅编号", "订单条形码号", "收款日期", "收款金额", "收款快递员" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		final JTable bill = new JTable(model);
		bill.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jp = new JScrollPane(bill);
		
		
		
		
        JButton timecheck = new JButton("按天查询");
        timecheck.setBounds(sw + 10 + (boxgap + boxwidth) * 3 + 200, sh, buttonw, buttonh);
        timecheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String date=box[0].getSelectedItem().toString()+box[1].getSelectedItem().toString()+box[2].getSelectedItem().toString();			
//				System.out.println(date);
				Earneddocu earneddocu=new Earneddocu();
				ArrayList<EarnedPO> epolist = earneddocu.GetEarnedDocu("day", date);
				for (int i = 0; i < epolist.size(); i++) {
					Object[] add={epolist.get(i).getPaydate(),epolist.get(i).getEarnedmoney(),
			epolist.get(i).getDilivername(),epolist.get(i).getOrderID(),epolist.get(i).getBussinessID()};
					DefaultTableModel model = (DefaultTableModel) bill.getModel();            
					model.insertRow(model.getRowCount(), add);
					}
		
				
			}
	
		});
		
		
		
		JButton hallcheck = new JButton("按营业厅查询");
		hallcheck.setBounds(sw + 10 + (boxgap + boxwidth) * 3 + 200, sh + gap, buttonw, buttonh);
		hallcheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String id=hallno.getText();			
				System.out.println(id);
				Earneddocu earneddocu=new Earneddocu();
				ArrayList<EarnedPO> epolist = earneddocu.GetEarnedDocu("ID", id);
				for (int i = 0; i < epolist.size(); i++) {
					Object[] add={epolist.get(i).getPaydate(),epolist.get(i).getEarnedmoney(),
			epolist.get(i).getDilivername(),epolist.get(i).getOrderID(),epolist.get(i).getBussinessID()};
					DefaultTableModel model = (DefaultTableModel) bill.getModel();            
					model.insertRow(model.getRowCount(), add);
					}
		
			}
	
		});
		
		
		


		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);
		jp.setBounds(sw, 120, 378, 500);

		
		context.add(timelabel);
		context.add(yytlabel);
		context.add(jp);
		context.add(timecheck);
		context.add(hallcheck);
		context.add(hallno);
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
