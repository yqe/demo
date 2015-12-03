package finance;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StateOfRun {

	public void stateofrun(JPanel context) {
		context.removeAll();
		int labelw = 80;
		int labelh = 30;
		int boxw = 60;
		int boxh = 30;
		int boxgap = 10;
		JComboBox[][] box = new JComboBox[][] {
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
		JButton okbtn = new JButton("确定");
		okbtn.setBounds(650, 50, 100, 30);
		context.add(okbtn);
		String[] columnnames = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		String[] columnnames2 = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		Object[][] data = {};
		Object[][] data2 = {};
		DefaultTableModel model1=new  DefaultTableModel(data,columnnames);
		DefaultTableModel model2=new  DefaultTableModel(data2,columnnames2);
		JTable table=new JTable(model1);
		JTable table2=new JTable(model2);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane jp1=new JScrollPane(table);    
		JScrollPane jp2=new JScrollPane(table2);   
	    
	    jp1.setOpaque(false);
	    jp1.getViewport().setOpaque(false);
	    jp2.setOpaque(false);
	    jp2.getViewport().setOpaque(false);
		
		jp1.setBounds(40, 100, 300, 500);
		jp2.setBounds(40 + 350 + 20, 100, 300, 500);
		context.add(jp1);
		context.add(jp2);
		
		
		
		
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
