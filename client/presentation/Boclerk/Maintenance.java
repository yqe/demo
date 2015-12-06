package Boclerk;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import transbl.TransBl;
import courier.infoDialog;


public class Maintenance {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	
	public JPanel Panel() throws IOException{
	

	
		JPanel p1 = new JPanel() ;
		p1.setBounds(0, 0, 600, 700);
		JLabel l1=new JLabel("快递物流系统");
		int l1size=30;
		l1.setFont(new Font("快递物流系统",Font.PLAIN,l1size));
		JLabel l2=new JLabel("—>车辆信息维护");
	    int l2size=16;
	    l2.setFont(new Font("",Font.PLAIN,l2size));
	    JLabel l3=new JLabel("车辆代号:");
	    JLabel l4=new JLabel("车牌号:");
	    JLabel l5=new JLabel("司机编号:");
	    JLabel l6=new JLabel("司机姓名:");
	    JLabel l7=new JLabel("出生日期:");
	    JLabel l8=new JLabel("身份证号:");
	    JLabel l9=new JLabel("手机:");
	    JLabel l10=new JLabel("性别:");
	    JLabel l11=new JLabel("行驶证期限:");
	    
	    JLabel l12=new JLabel("司机服役时间:");
    
    int lmain=16;
    l3.setFont(new Font("",Font.PLAIN,lmain));
    l4.setFont(new Font("",Font.PLAIN,lmain));
    l5.setFont(new Font("",Font.PLAIN,lmain));
    l6.setFont(new Font("",Font.PLAIN,lmain));
    l7.setFont(new Font("",Font.PLAIN,lmain));
    l8.setFont(new Font("",Font.PLAIN,lmain));
    l9.setFont(new Font("",Font.PLAIN,lmain));
    l10.setFont(new Font("",Font.PLAIN,lmain));
    l11.setFont(new Font("",Font.PLAIN,lmain));
    l12.setFont(new Font("",Font.PLAIN,lmain));
    
    final JTextField carid=new JTextField();
    final JTextField carnumber=new JTextField();
    final JTextField driverid=new JTextField();
    final JTextField drivername=new JTextField();
    final JTextField driversfz=new JTextField();
    final JTextField tel=new JTextField();

    
    carnumber.setOpaque(false);
    driverid.setOpaque(false);
    drivername.setOpaque(false);
    driversfz.setOpaque(false);
    tel.setOpaque(false);


    JButton b1=new JButton("查询车辆信息");
    b1.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent e) {	
  			TransBl trans=new TransBl();
  			trans.GetVehicleInfoPO(carid.getText());
  
  			}
  	});
    
    
    
    
    
    
    
    
    
    
    
    
  	JButton b4=new JButton("更新车辆信息");
  	b4.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent e) {	
  			boolean iscarid=true;
  			boolean iscarnumber=true;
  			boolean isdriverid=true;
  			
  			boolean caridisempty=carid.getText().equals("");
  			boolean carnumberisempty=carnumber.getText().equals("");
  			boolean driveridisempty=driverid.getText().equals("");
  			boolean drivernameisempty=drivername.getText().equals("");
  			boolean driversfzisempty=driversfz.getText().equals("");
  			boolean telisempty=tel.getText().equals("");
  			
  			boolean isempty=caridisempty||carnumberisempty||driveridisempty||drivernameisempty||driversfzisempty||telisempty;
  			
  	       if(carid.getText().length()==10&&iscarid&&iscarnumber&&isdriverid&&!isempty){
  			JOptionPane.showMessageDialog(null, "更新成功!");
//  			System.out.println(isempty+" 1");
//  			System.out.println(carnumberisempty+" 2");
//  			System.out.println(driveridisempty+" 3");
  			}
  	       else if(!iscarid&&!caridisempty){
  	    	   JOptionPane.showMessageDialog(null, "请输入正确的车辆代号!");
  	       }
  	     else if(!iscarnumber&&!carnumberisempty){
	    	   JOptionPane.showMessageDialog(null, "请输入正确的车牌号!");
	       }
  	     else if(!isdriverid&&!driveridisempty){
	    	   JOptionPane.showMessageDialog(null, "请输入正确的司机代号!");
	       }
  	     else if(isempty){
			JOptionPane.showMessageDialog(null, "请完整填写信息!");//123
	     	}
  	       
  	       
  			}
  	});
	
	JRadioButton jb1 = new JRadioButton("男");
	jb1.setSelected(true);
	jb1.setOpaque(false);
	JRadioButton jb2 = new JRadioButton("女");
	jb2.setOpaque(false);
	ButtonGroup bg = new ButtonGroup();
	  bg.add(jb1);
	  bg.add(jb2);
	
		String[] year = new String[201];
	    for (int i = 2000; i < 2100; i++) {
	        year[i-2000] = i+"年";
	    
	    }
	    JComboBox yearbox = new JComboBox(year);
	    String[] month = new String[12];
	    for (int i = 1; i <= 12; i++) {
	        month[i-1] = i+"月";
	    
	    }
	    JComboBox monthbox = new JComboBox(month);
	    String[] day = new String[31];
	    for (int i = 1; i <= 31; i++) {
	        day[i-1] = i+"日";
	    
	    }
	   JComboBox daybox = new JComboBox(day);
		
	   String[]time=new String[20];
	   for (int i = 1; i <= 20; i++) {
	       time[i-1] = i+"年"; 
	   }
	   JComboBox timebox1 = new JComboBox(time);
   
	   JComboBox timebox2 = new JComboBox(time);
   
	p1.setOpaque(false);
	p1.setLayout(null);
	p1.add(l1);
	p1.add(l2);
    p1.add(l3);
	p1.add(l4);
	p1.add(l5);
	p1.add(l6);
    p1.add(l7);
    p1.add(l8);
    p1.add(l9);
    p1.add(l10);
    p1.add(l11); 
    p1.add(l12); 
    
    p1.add(carid);
    p1.add(carnumber);
    p1.add(driverid);
    p1.add(drivername);
    p1.add(driversfz);
    p1.add(tel);

    
    
    p1.add(b1);
	p1.add(b4);
    p1.add(yearbox);
    p1.add(monthbox);
    p1.add(daybox);
    p1.add(timebox1);
    p1.add(timebox2);
    
    p1.add(jb1);
    p1.add(jb2);


    p1.setOpaque(false);
	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*1/15;
	int b4xloc=p1.getWidth()*2/5-30;
	int b4yloc=p1.getHeight()*13/15,b4ysize=p1.getHeight()*1/5+10;
	
	l1.setBounds(180, -20, 180, 80);
	l2.setBounds(50, b1yloc, 150, 30);
	l3.setBounds(100,100,150,30);	
	l4.setBounds(100, 150, 150, 30); 
	yearbox.setBounds(275, 300, 80, 30);
	monthbox.setBounds(375, 300, 80, 30);
	daybox.setBounds(475, 300, 80, 30);
	
	l5.setBounds(100, 200, 150, 30); 
	l6.setBounds(100, 250, 150, 30);
	l7.setBounds(100, 300, 150, 30);
	l8.setBounds(100, 350, 150, 30);
	l9.setBounds(100, 400, 150, 30);
	l10.setBounds(100, 450, 150, 30); 
	l11.setBounds(100, 500, 100, 30);
	l12.setBounds(100, 550, 150, 30);
	
	carid.setBounds(275, 100, 150, 30);
	carnumber.setBounds(275,200, 150, 30);	
	timebox1.setBounds(275, 500, 80,30);
	timebox2.setBounds(275, 550, 80,30);
	driverid.setBounds(275,350, 150, 30);
	drivername.setBounds(275,150, 150, 30);
	driversfz.setBounds(275,400, 150, 30);
	tel.setBounds(275,250, 150, 30);

	
	b1.setBounds(450,100,120,30);
	b4.setBounds(b4xloc, b4yloc, 180, 40);
	
	jb1.setBounds(275, 450, 50, 30);
	jb2.setBounds(325, 450, 50, 30);
	
	return p1;

	}
	

}