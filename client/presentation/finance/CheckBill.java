package finance;

import java.awt.Font;
import java.nio.channels.SelectableChannel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
		JLabel yytlabel=new JLabel("营业厅编号:");
		JButton timecheck = new JButton("按天查询");
		JButton hallcheck = new JButton("按营业厅查询");
		context.removeAll();
		JComboBox[] box = new JComboBox[] { new JComboBox(GetBoxStr(200, "年")), new JComboBox(GetBoxStr(12, "月")),
				new JComboBox(GetBoxStr(31, "日")) };
		for (int i = 0; i < box.length; i++) {
			box[i].setBounds(sw + 10 + (boxgap + boxwidth) * i, sh, boxwidth, boxheight);
			context.add(box[i]);
		}
		timecheck.setBounds(sw + 10 + (boxgap + boxwidth) * 3 + 200, sh, buttonw, buttonh);

		JTextField hallno = new JTextField();
		yytlabel.setBounds(sw + 10, sh + gap, 100, boxheight);
		hallno.setBounds(sw + 150, sh + gap, 200, boxheight);
		hallcheck.setBounds(sw + 10 + (boxgap + boxwidth) * 3 + 200, sh + gap, buttonw, buttonh);

		String[] columnnames = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		Object[][] data = {};
		
		DefaultTableModel model=new  DefaultTableModel(data,columnnames);
		JTable bill=new JTable(model);
		bill.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jp=new JScrollPane(bill);    
	    
	    jp.setOpaque(false);
	    jp.getViewport().setOpaque(false);
		jp.setBounds(sw, 120, 528, 500);
		
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
