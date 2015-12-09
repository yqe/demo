package finance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import financebl.FinanceBl;
import po.ManageAccountPO;

public class AccountMan {
	int labelw = 120;
	int labelh = 30;
	int textw = 150;
	int texth = 30;
	int gap = 20;
	int gaph = 80;

	public void AddAcc(JPanel context) {
		context.removeAll();
		JLabel[] label = new JLabel[] { new JLabel("账户名称:"), new JLabel("账户金额:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("", Font.PLAIN, 25));
			label[i].setBounds(80, 40 + (labelh + gaph) * i + 150, labelw, labelh);
			context.add(label[i]);
		}
		final JTextField[] textfield = new JTextField[] {new JTextField(), new JTextField() };
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].setBounds(80 + gap + labelw, 40 + (texth + gaph) * i + 150, textw, texth);
			context.add(textfield[i]);
		}
		JButton btn = new JButton("确定增加");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum=true;			
				for(int i=0;i<textfield[1].getText().length();i++){
					if(textfield[1].getText().charAt(i)>'9'||textfield[1].getText().charAt(i)<'1'){
	                         				isnum=false;	
					}
				}
		            boolean idisempty=textfield[0].getText().equals(""); 
					boolean priceisempty=textfield[1].getText().equals("");
					boolean isempty=idisempty||priceisempty;
					
				if(!isempty&&isnum){
					//添加新数据到PO
					ManageAccountPO a=new ManageAccountPO(textfield[0].getText(),Double.parseDouble(textfield[1].getText()),"","");
					FinanceBl adacc=new FinanceBl();
					boolean IsOk=adacc.BuildBankAccount(a);
					if (IsOk)
					JOptionPane.showMessageDialog(null, "添加成功!");
					else 
						JOptionPane.showMessageDialog(null, "添加失败!");
				}	
				else if(!isempty&&!isnum){
					JOptionPane.showMessageDialog(null, "所输入金额非法!");
				}
				else{
					JOptionPane.showMessageDialog(null, "请将信息填写完整!");
				} 
					
				}	
			
		});
		
		
		btn.setBounds(400, 500, 120, 40);
		context.add(btn);
	}

	public void DeleteAcc(JPanel context) {
		context.removeAll();
		JLabel accmean = new JLabel("账户名称:");
		accmean.setBounds(80, 250, 120, texth);
		accmean.setFont(new Font("", Font.PLAIN, 25));
		final JTextField accname = new JTextField();
		JButton delbtn = new JButton("确定删除");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isempty=accname.getText().equals("");
				FinanceBl adacc=new FinanceBl();
				
				if(!isempty&&adacc.DeleteBankAccount(accname.getText())){
				JOptionPane.showMessageDialog(null, "删除成功!");
				}
				else if(isempty) {
					JOptionPane.showMessageDialog(null, "请填写所需要删除的账户!");
				}
				else{
					JOptionPane.showMessageDialog(null, "未查询到该账户!");
				}
			
			}
		});
		
		accname.setBounds(80 + 120+40, 250, textw, texth);
		delbtn.setBounds(240, 300, labelw, labelh);
		
		
		
		
		context.add(accmean);
		context.add(accname);
		context.add(delbtn);
	}

	public void ChangeAcc(JPanel context) {
		context.removeAll();
		JLabel accmean = new JLabel("账户ID:");
		accmean.setBounds(80, 100, 80, texth);
		accmean.setFont(new Font("", Font.PLAIN, 18));
		JLabel[] account = new JLabel[] { new JLabel("原账户名称:"), new JLabel("现账户名称:"), new JLabel("原账户金额:"),
				new JLabel("现账户金额:") };
	
		
		for (int i = 0; i < account.length; i = i + 2) {
			account[i].setBounds(80, 100 + gaph * (i + 1), 80, texth);
			account[i + 1].setBounds(80 + textw + gap + 80+gap, 100 + gaph * (i + 1), 80, texth);
			account[i].setFont(new Font("", Font.PLAIN, 15));
			account[i + 1].setFont(new Font("", Font.PLAIN, 15));
			context.add(account[i]);
			context.add(account[i + 1]);
		}
		final JTextField accname = new JTextField();
		accname.setBounds(80 + 100 + 20, 100, textw, texth);
		final JTextField[] text = new JTextField[] { new JTextField(), new JTextField(), new JTextField(), new JTextField() };
		
		text[0].setOpaque(false);
		text[2].setOpaque(false);
		text[0].setEditable(false);
		text[2].setEditable(false);;
		for (int i = 0; i < text.length; i = i + 2) {
			text[i].setBounds(80+80+gap, 100 + gaph * (i + 1), textw, texth);
			text[i + 1].setBounds(80 + textw + gap + 80+80+gap+gap, 100 + gaph * (i + 1), textw, texth);
			context.add(text[i]);
			context.add(text[i + 1]);
		}
		JButton btn = new JButton("确定搜索");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!accname.getText().equals("")){
					  FinanceBl finance=new FinanceBl();
					    ManageAccountPO	mapo=finance.CheckBankAccount(accname.getText());										
			text[0].setText(mapo.getAccountname());
			text[2].setText(String.valueOf(mapo.getBalance()));
			        }
				else{
			JOptionPane.showMessageDialog(null, "请输入要搜索的账户ID!");
				}
				}
		});
		
		
		btn.setBounds(400, 100, labelw, labelh);
		JButton changebtn=new JButton("确定修改");
		changebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isnum=true;			
				for(int i=0;i<text[3].getText().length();i++){
					if(text[3].getText().charAt(i)>'9'||text[3].getText().charAt(i)<'1'){
	                         				isnum=false;	
					}
				}
				boolean idisempty=text[1].getText().equals("");
				boolean numisempty=text[3].getText().equals("");
				boolean isempty=idisempty||numisempty;
				
			    FinanceBl finance=new FinanceBl();
//			    ManageAccountPO	mapo=finance.CheckBankAccount(accname.getText());	
				if(!isempty&&isnum){
					 ManageAccountPO  mapo=new  ManageAccountPO(text[1].getText(),Double.valueOf(text[3].getText()),accname.getText(),null);
					JOptionPane.showMessageDialog(null, "修改成功!");
				}
				else if(!isempty&&!isnum){
					JOptionPane.showMessageDialog(null, "所输入金额非法!");
				}
				else{
					JOptionPane.showMessageDialog(null, "请将信息输入完整!");
				}
			
			}
		});
		changebtn.setBounds(450, 500, labelw, labelh);
		context.add(accmean);
		context.add(accname);
		context.add(btn);
		context.add(changebtn);

	}

	public void CheckAcc(JPanel context) {
		context.removeAll();
		JLabel[] label = new JLabel[] { new JLabel("账户ID:"), new JLabel("账户金额:") };
		
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("", Font.PLAIN, 25));
			label[i].setBounds(80, 100 + (labelh + gaph) * i + 150, labelw, labelh);
			context.add(label[i]);
		}
		final JTextField[] textfield = new JTextField[] { new JTextField(), new JTextField(), new JTextField() };
		for (int i = 1; i < textfield.length; i++) {
			textfield[i].setBounds(80 + gap + labelw, 100 + (texth + gaph) * (i - 1) + 150, textw, texth);
			context.add(textfield[i]);
		}
		
		textfield[1].setOpaque(false);
		textfield[2].setOpaque(false);
		textfield[1].setEditable(false);
		textfield[2].setEditable(false);
		
		JLabel id=new JLabel("账户ID:");
		id.setFont(new Font("", Font.PLAIN, 20));
		id.setBounds(80, 50, 150, labelh);
		context.add(id);
		textfield[0].setBounds(250, 50, textw, labelh);
		context.add(textfield[0]);
		JButton button = new JButton("确认查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textfield[0].getText().equals("")){
				    FinanceBl finance=new FinanceBl();				    
				    ManageAccountPO	mapo=finance.CheckBankAccount(textfield[0].getText());		
					textfield[1].setText(mapo.getAccountname());
					textfield[2].setText(String.valueOf(mapo.getBalance()));
					        }
						else{
					JOptionPane.showMessageDialog(null, "请输入要查询的账户ID!");
						}
			
			}
		});
		
		
		button.setBounds(270 + textw, 50, labelw, labelh);
		context.add(button);
	}

}
