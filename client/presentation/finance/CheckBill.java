package finance;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import po.CostManagePO;
import po.EarnedPO;
import po.EarnedPOList;
import po.EmploeePO;
import documentbl.Earneddocu;
import financebl.CostManage;

public class CheckBill {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public CheckBill(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public void CheckBill(JPanel context) {
		int sw = 40;
		int sh = 200;
		int gap = 40;
		int wordsize = 16;
		int buttonw = 120;
		int buttonh = 30;
		int boxwidth = 100;
		int boxheight = 30;
		int boxgap = 30;
		
		JLabel timelabel = new JLabel("时间:");
		JLabel yytlabel = new JLabel("营业厅编号:");
		timelabel.setFont(new Font("", Font.PLAIN, 18));
		yytlabel.setFont(new Font("", Font.PLAIN, 18));
		context.removeAll();
		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小
		
			datepick.setBounds(sw + 110 , sh, 150,
					boxheight);
			context.add(datepick);
		

		final JTextField hallno = new JTextField();
		
		hallno.setOpaque(false);
		hallno.setBorder(BorderFactory.createEmptyBorder());
		timelabel.setBounds(sw + 10, sh, 100, boxheight);
		yytlabel.setBounds(sw + 10, sh + gap, 100, boxheight);
		hallno.setBounds(sw + 150, sh + gap, 200, boxheight);

		String[] columnnames = { "营业厅编号", "订单条形码号", "收款日期", "收款金额", "收款快递员" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		final JTable bill = new JTable(model);
		bill.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jp = new JScrollPane(bill);

		JButton timecheck = new JButton("按天查询");
		timecheck.setBounds(sw + 10 + (boxgap + boxwidth) * 3 + 200, sh,
				buttonw, buttonh);
		timecheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String date=datepick.getText();
//				System.out.println(date+"&&&");
				Earneddocu earneddocu = new Earneddocu(oos,ois);
				EarnedPOList epolist = earneddocu.GetEarnedDocu("day", date);
                 if(epolist.GetIndex(0).getPaydate().equals("不存在")){
                	 JOptionPane.showMessageDialog(null, "当天没有收款单!");
                }
				
                 else{	for (int i = 0; i < epolist.Getsize(); i++) {
					Object[] add = { epolist.GetIndex(i).getPaydate(),
							epolist.GetIndex(i).getEarnedmoney(),
							epolist.GetIndex(i).getDilivername(),
							epolist.GetIndex(i).getOrderID(),
							epolist.GetIndex(i).getBussinessID() };
					DefaultTableModel model = (DefaultTableModel) bill
							.getModel();
					model.insertRow(model.getRowCount(), add);
				   }
                 }
			}

		});

		JButton hallcheck = new JButton("按营业厅查询");
		hallcheck.setBounds(sw + 10 + (boxgap + boxwidth) * 3 + 200, sh + gap,
				buttonw, buttonh);
		hallcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = hallno.getText();
//				System.out.println(id);
				Earneddocu earneddocu = new Earneddocu(oos,ois);
				EarnedPOList epolist = earneddocu.GetEarnedDocu("ID", id);
				
				  if(epolist.GetIndex(0).getPaydate().equals("不存在")){
	                	 JOptionPane.showMessageDialog(null, "当天没有收款单!");
	                }
				  else{for (int i = 0; i < epolist.Getsize(); i++) {
					Object[] add = { epolist.GetIndex(i).getPaydate(),
							epolist.GetIndex(i).getEarnedmoney(),
							epolist.GetIndex(i).getDilivername(),
							epolist.GetIndex(i).getOrderID(),
							epolist.GetIndex(i).getBussinessID() };
					DefaultTableModel model = (DefaultTableModel) bill
							.getModel();
					model.insertRow(model.getRowCount(), add);
				}
				  }
			}
		});

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);
		jp.setBounds(sw+110, sh+buttonh+boxheight+20, 378, 350);

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
			if (num < 10)
				str[i] = "0" + num + meanth ;
			else
				str[i] = num + meanth ;
		
		}
		return str;
	}
}
