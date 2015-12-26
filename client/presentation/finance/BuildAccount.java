package finance;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import financebl.FinanceBl;
import image.ImageGet;
import login.MTextfield;
import po.EmploeePO;
import po.InitializeAccountPO;

public class BuildAccount {
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public BuildAccount(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public void buildaccount(JPanelContent content) {
		content.removeAll();
		Image imagebgp = new ImageGet().GetFinanceImage("BuildAccount");
		content.setConpanel(imagebgp);
		
		final MTextfield[] textfield = new MTextfield[] { new MTextfield(), new MTextfield(), new MTextfield(),
				new MTextfield(), new MTextfield(), new MTextfield() };

		int Gapw = 399;
		int Gaph = 258;
		int gap = 29;
		int textw = 175;
		int texth = 42;

		for (int i = 1; i < textfield.length - 1; i++) {
			textfield[i].settextFont();
			textfield[i].HideTheField();
			textfield[i].setBounds(Gapw, Gaph + (gap + texth) * i, textw, texth);
			content.add(textfield[i]);
		}
		textfield[textfield.length - 1].setBounds(Gapw, 605, textw, texth);
		textfield[textfield.length - 1].settextFont();
		textfield[textfield.length - 1].HideTheField();
		content.add(textfield[textfield.length - 1]);
		
		String[]organ={"营业厅","中转中心", "总部"};	    
	    final JComboBox organbox = new JComboBox(organ);
	    content.add(organbox);
		organbox.setBounds(Gapw, Gaph, textw, texth);
	    
		JButtonM btn=new JButtonM("确定");
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
				 FinanceBl m =new FinanceBl(oos,ois);
				 InitializeAccountPO ipo=new InitializeAccountPO(textfield[4].getText(),organbox.getSelectedItem().toString(),Integer.parseInt(textfield[1].getText()),
						 Integer.parseInt(textfield[2].getText()),Integer.parseInt(textfield[3].getText()),Double.parseDouble(textfield[5].getText()));
				boolean isOk=m.InitAccount(ipo);
				
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

		btn.setBounds(746, 631, 199, 52);
		btn.HideTheButton();
		content.add(btn);
	}
}

