package admin;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changepasswordmain {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;	
	public  JPanel Panel() throws IOException{


	final JPanel p1 = new JPanel() ;
	
	p1.setBounds(0, 0, 600, 500);
	
	
	JLabel l1=new JLabel("快递物流系统");
	int b1size=30;
	l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
	JLabel l2=new JLabel("—>修改密码");
    int b2size=16;
    l2.setFont(new Font("",Font.PLAIN,b2size));
    JLabel l3=new JLabel("请输入ID：");
	JLabel l4=new JLabel("请输入新密码:");
	JLabel l5=new JLabel("请再次输入新密码:");
	
	l3.setFont(new Font("",Font.PLAIN,b2size));
	l4.setFont(new Font("",Font.PLAIN,b2size));
	l5.setFont(new Font("",Font.PLAIN,b2size));
	
	final JTextField id=new JTextField();
	final JPasswordField newpassword1=new JPasswordField();
	final JPasswordField newpassword2=new JPasswordField();

	JButton b4=new JButton("确认修改");
	b4.addActionListener(new ActionListener(){
 		public void actionPerformed(ActionEvent e) {
 			char[] pass1 = newpassword1.getPassword();
			String password1 = new String(pass1);
			char[] pass2 = newpassword2.getPassword();
			String password2 = new String(pass2);			
 			boolean equal=password1.equals(password2);
 			if(!id.getText().equals("")){
 			if(!password1.equals("")){
			    if(equal){
			    JOptionPane.showMessageDialog(null, "修改成功!");//将新密码传入所对应PO
		    	}
		     	else{
				JOptionPane.showMessageDialog(null, "两次所输入新密码不统一，请重新输入!");
				newpassword1.setText("");
				newpassword2.setText("");//清空
		     	} 
			  }else{				  
 			JOptionPane.showMessageDialog(null, "请输入新密码!");
 			}
 			}
 			else{
 				JOptionPane.showMessageDialog(null, "请先输入ID!");
 			}
 		}
		
	});


	p1.setOpaque(false);
	p1.setLayout(null);
	p1.add(l1);
	p1.add(l2);
	p1.add(l3);
	p1.add(l4);
	p1.add(l5);
	
	p1.add(id);
	p1.add(newpassword1);
	p1.add(newpassword2);

	p1.add(b4);



	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*2/15;
	int b4xloc=p1.getWidth()*3/7;
	int b4yloc=p1.getHeight()*13/15,b4ysize=p1.getHeight()*1/5+10;
	
	l1.setBounds(220, -20, 180, 80);

	l2.setBounds(50, b1yloc, 150, 30);
	
	l3.setBounds(150, 150, 150, 30);
	l4.setBounds(150, 250, 150, 30);
	l5.setBounds(150, 350, 150, 30);
	
	id.setBounds(300, 150, 150, 30);
	newpassword1.setBounds(300, 250, 150, 30);
    newpassword2.setBounds(300, 350, 150, 30);


	b4.setBounds(300, b4yloc, 150, 30);


	
	return p1;
	

	
	 }	
	}
