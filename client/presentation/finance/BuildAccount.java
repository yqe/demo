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

import financebl.SetAccount;
import po.InitializeAccountPO;

public class BuildAccount {
	int labelw = 120;
	int labelh = 30;
	int textw = 150;
	int texth = 30;
	int gap = 20;
	int gaph = 30;

	public void buildaccount(JPanel context) {
		context.removeAll();
		
		JLabel[] label = new JLabel[] { new JLabel("机构:"), new JLabel("人员:"), new JLabel("车辆:"), new JLabel("库存:"),
				new JLabel("银行账户名称:"), new JLabel("银行账户金额:") };
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("", Font.PLAIN, 18));
			label[i].setBounds(180, 60 + (labelh + gaph) * i, labelw, labelh);
			context.add(label[i]);
		}
		final JTextField[] textfield = new JTextField[] { new JTextField(), new JTextField(), new JTextField(),
				new JTextField(), new JTextField(), new JTextField() };
		for (int i = 1; i < textfield.length; i++) {
			textfield[i].setBounds(180 + gap + labelw, 60 + (texth + gaph) * i, textw, texth);
			context.add(textfield[i]);
		}
		
		String[]organ={"营业厅","中转中心", "总部"};	    
	    JComboBox organbox = new JComboBox(organ);
	    
	    context.add(organbox);
		organbox.setBounds(180 + gap + labelw, 60, textw, texth);
	    
		JButton btn=new JButton("确定");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {			
				boolean isnum=true;			
				for(int i=0;i<textfield[5].getText().length();i++){
					if(textfield[5].getText().charAt(i)>'9'||textfield[5].getText().charAt(i)<'0'){
	                         				isnum=false;	
					}
				}
				boolean personisempty=textfield[1].getText().equals("");
			    boolean carisempty=textfield[2].getText().equals("");
			    boolean storageisempty=textfield[3].getText().equals("");
			    boolean banknameisempty=textfield[4].getText().equals("");
			    boolean bankmoneyisempty=textfield[5].getText().equals("");
				
			    boolean isempty=personisempty||carisempty||storageisempty||banknameisempty||bankmoneyisempty;
				if(isnum&&!isempty){
				 SetAccount m =new SetAccount();
				 InitializeAccountPO ipo=new InitializeAccountPO(textfield[0].getText(),textfield[1].getText(),textfield[2].getText(),
						 Integer.parseInt(textfield[3].getText()),Integer.parseInt(textfield[4].getText()),Double.parseDouble(textfield[5].getText()));
				boolean isOk=m.BuildAccount(ipo);
				System.out.println(isOk);
				if (isOk)
				     JOptionPane.showMessageDialog(null, "成功建账!");			
				 else
					 JOptionPane.showMessageDialog(null, "建账失败!");	
				}
				else if(!isempty&&!isnum){
					JOptionPane.showMessageDialog(null, "请输入合法的金额!");//只能是整数
				}
				else {
					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				}
				
			}
			
		});

		btn.setBounds(320, 500, labelw, labelh+10);
		context.add(btn);
	}
}

