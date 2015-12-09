package finance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import financebl.CostManage;
import financebl.FinanceBl;
import po.CostManagePO;
import po.ManageAccountPO;

public class CostMan {

	public void costMan(JPanel context) {
		context.removeAll();
		int labelw=120;
		int labelh=30;
		int textw=120;
		int texth=30;
		int gap=20;
		int gaph=50;
		JLabel[] label = new JLabel[] { new JLabel("付款日期:"), new JLabel("付款金额:"), new JLabel("付款人:"), new JLabel("付款账号:"),
				new JLabel("条目:"), new JLabel("备注:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("",Font.PLAIN,20));
			label[i].setBounds(160, 30+(labelh+gaph)*i, labelw, labelh);
			context.add(label[i]);
		}
		final JTextField[] textfield = new JTextField[] { new JTextField(), new JTextField(), new JTextField(),
				new JTextField(), new JTextField(), new JTextField() };
		for (int i = 1; i < textfield.length-1; i++) {
			textfield[i].setBounds(200+gap+labelw, 30+(texth+gaph)*i, textw, texth);
			context.add(textfield[i]);
		}
		textfield[textfield.length-1].setBounds(200+gap+labelw, 30+(texth+gaph)*(textfield.length-1), 150+textw, texth);
		context.add(textfield[textfield.length-1]);
		 String[] year = new String[201];
		    for (int i = 2000; i < 2100; i++) {
		        year[i-2000] = i+"年";
		    
		    }
		   final  JComboBox yearbox = new JComboBox(year);
		    String[] month = new String[12];
		    for (int i = 1; i <= 12; i++) {
		        month[i-1] = i+"月";
		    
		    }
		   final  JComboBox monthbox = new JComboBox(month);
		    String[] day = new String[31];
		    for (int i = 1; i <= 31; i++) {
		        day[i-1] = i+"日";
		    }
		    final JComboBox daybox = new JComboBox(day);
			context.add(yearbox);   yearbox.setBounds(200+gap+labelw, 30, 80, texth);
			context.add(monthbox);  monthbox.setBounds(200+gap+labelw+90, 30, 80, texth);
			context.add(daybox);    daybox.setBounds(200+gap+labelw+180, 30, 80, texth);
		
		JButton okbtn=new JButton("确定付款");
		okbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {			
				boolean isnum=true;			
				for(int i=0;i<textfield[1].getText().length();i++){
					if(textfield[1].getText().charAt(i)>'9'||textfield[1].getText().charAt(i)<'1'){
	                         				isnum=false;	
					}
				}
				boolean priceisempty=textfield[1].getText().equals("");
			    boolean payerisempty=textfield[2].getText().equals("");
			    boolean idisempty=textfield[3].getText().equals("");
				boolean infoisempty=textfield[4].getText().equals("");
				boolean tipsisempty=textfield[5].getText().equals("");

				boolean isempty=priceisempty||payerisempty||idisempty||infoisempty||tipsisempty;

				FinanceBl finance =new FinanceBl();
				ManageAccountPO check=finance.CheckBankAccount(textfield[3].getText());
				String date=yearbox.getSelectedItem().toString()+monthbox.getSelectedItem().toString()+daybox.getSelectedItem().toString();
				
				CostManage cost=new CostManage();
				
				boolean isid=!check.getAccountname().equals("不存在");//根据银行账户PO判断ID是否合法
				CostManagePO cmpo=new CostManagePO(date,Double.valueOf(textfield[1].getText()),textfield[2].getText(),textfield[3].getText(),textfield[4].getText(),textfield[5].getText());
				
				if(isid&&isnum&&!isempty&& cost.BuildCostManage(cmpo)){								
					JOptionPane.showMessageDialog(null, "成功付款!");			
				}
				else if(!isempty&&!isid){
					JOptionPane.showMessageDialog(null, "所输入账户ID非法!");
				}
				else if(!isempty&&!isnum){
					JOptionPane.showMessageDialog(null, "请输入合法的金额!");//只能是整数
				}
				else if(isempty){
				
					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				}
				
			}
			
		});
		
		
		
		
		
		
		okbtn.setBounds(350, 550, 120, 40);
		context.add(okbtn);
	}


}
