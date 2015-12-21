package finance;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;

import login.Tran;
import financebl.CostManage;
import financebl.FinanceBl;
import po.CostManagePO;
import po.EmploeePO;
import po.ManageAccountPO;

public class CostMan {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public CostMan(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public void costMan(JPanel context) {
		context.removeAll();
		int labelw=120;
		int labelh=30;
		int textw=120;
		int texth=30;
		int gap=10;
		int gaph=20;
		int Gapw=160;
		int Gaph=250;
		JLabel[] label = new JLabel[] { new JLabel("付款日期:"), new JLabel("付款金额:"), new JLabel("付款人:"), new JLabel("付款账号:"),
				new JLabel("条目:"), new JLabel("备注:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("",Font.PLAIN,20));
			label[i].setBounds(Gapw, Gaph+(labelh+gaph)*i, labelw, labelh);
			context.add(label[i]);
		}
		final JTextField[] textfield = new JTextField[] { new JTextField(), new JTextField(), new JTextField(),
				new JTextField(), new JTextField(), new JTextField() };
		for (int i = 1; i < textfield.length-1; i++) {
			textfield[i].setOpaque(false);
			textfield[i].setBorder(BorderFactory.createEmptyBorder());
			textfield[i].setBounds(Gapw+gap+labelw, Gaph+(texth+gaph)*i, textw, texth);
			context.add(textfield[i]);
		}
		
		textfield[textfield.length-1].setOpaque(false);
		textfield[textfield.length-1].setBorder(BorderFactory.createEmptyBorder());
		textfield[textfield.length-1].setBounds(Gapw+gap+labelw, Gaph+(texth+gaph)*(textfield.length-1), 150+textw, texth);
		context.add(textfield[textfield.length-1]);
		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小
			context.add(datepick);  
			datepick.setBounds(Gapw+gap+labelw, Gaph, 150, texth);
		
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

				FinanceBl finance =new FinanceBl(oos,ois);
				ManageAccountPO check=finance.CheckBankAccount(textfield[3].getText());
				String date=datepick.getText();			
				CostManage cost=new CostManage(oos,ois);
				
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
