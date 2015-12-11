package manager;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staffchange extends JDialog implements ActionListener {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	    staffchange() throws IOException{
	BufferedImage bgp=ImageIO.read(getClass().getResource("/presentation/Mbackground.jpg"));
	background = new ImageIcon(bgp);

	setTitle("人员调度"); 
	setBounds(500,200,500,600);
	JPanel p1 = new JPanel() {
 		public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		g.drawImage(background.getImage(), 0, 0, null);
 		}
 		};
 		
 		p1.setBounds(0, 0, 500, 600);
 		p1.setLayout(null);
 		p1.setOpaque(false);
 		
 		setLayout(null);
 		
 		JLabel l1=new JLabel("快递物流系统");
 		int b1size=30;
 		JLabel l2=new JLabel("—>人员调度");
 	    int b2size=16;
 	    JLabel l3=new JLabel("员工ID:");
 	    JLabel l4=new JLabel("员工姓名:");
 	    JLabel l5=new JLabel("职位:");
 	    JLabel l6=new JLabel("薪水:");
 	    JLabel l7=new JLabel("年龄:");
 	    JLabel l8=new JLabel("身份证号:");
 	    JLabel l9=new JLabel("手机:");
 	    JLabel l10=new JLabel("性别:");
 	    JLabel l11=new JLabel("家庭住址:");
 	    
 	    JTextField t1=new JTextField();
 	    JTextField t2=new JTextField();
 	    JTextField t3=new JTextField();
 	    JTextField t4=new JTextField();
 	    JTextField t5=new JTextField();
 	    JTextField t6=new JTextField();
 	    JTextField t7=new JTextField();
 	    JTextField t8=new JTextField();
 		
    l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
    l2.setFont(new Font("",Font.PLAIN,b2size));
    l3.setFont(new Font("",Font.PLAIN,b2size));
    l4.setFont(new Font("",Font.PLAIN,b2size));
    l5.setFont(new Font("",Font.PLAIN,b2size));
    l6.setFont(new Font("",Font.PLAIN,b2size));
    l7.setFont(new Font("",Font.PLAIN,b2size));
    l8.setFont(new Font("",Font.PLAIN,b2size));
    l9.setFont(new Font("",Font.PLAIN,b2size));
    l10.setFont(new Font("",Font.PLAIN,b2size));
    l11.setFont(new Font("",Font.PLAIN,b2size));
    
    
    String[] jobs={
			   "营业厅业务员","快递员",
			   "中转中心业务员","中转中心库存管理人员",
			   "总经理","财务人员","管理员"
	};
	JComboBox job = new JComboBox(jobs);
    

	JButton b4=new JButton("确认修改");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {		
			JOptionPane.showMessageDialog(null, "修改成功!");
		}
		
	});
	

	add(l1);
	add(l2);
	add(l3);
	add(l4);
    add(l5);
	add(l6);
	add(l7);
	add(l8);
	add(l9);
	add(l10);
	add(l11);
	
	add(t1);
	add(t2);
	add(t3);
	add(t4);
	add(t5);
	add(t6);
	add(t7);
	add(t8);
	
	add(job);

	add(b4);
	add(p1);


	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*1/15;
	l1.setBounds(180, -20, 180, 80);

	l2.setBounds(50, b1yloc, 180, 30);

	int l3xloc=p1.getWidth()/5,l3yloc=p1.getHeight()/9;
	int lysize=40;
	int t1xloc=2*p1.getWidth()/5;
	l3.setBounds(l3xloc, l3yloc+lysize, 100, 30);
	l4.setBounds(l3xloc, l3yloc+2*lysize, 100, 30);
	l5.setBounds(l3xloc, l3yloc+3*lysize, 100, 30);
	l6.setBounds(l3xloc, l3yloc+4*lysize, 100, 30);
	l7.setBounds(l3xloc, l3yloc+5*lysize, 100, 30);
	l8.setBounds(l3xloc, l3yloc+6*lysize, 100, 30);
	l9.setBounds(l3xloc, l3yloc+7*lysize, 100, 30);
	l10.setBounds(l3xloc, l3yloc+8*lysize, 100, 30);
	l11.setBounds(l3xloc, l3yloc+9*lysize, 100, 30);
	
	
	t1.setBounds(t1xloc, l3yloc+lysize, 180, 30);
	t2.setBounds(t1xloc, l3yloc+2*lysize, 180, 30);
	t3.setBounds(t1xloc, l3yloc+4*lysize, 180, 30);
	t4.setBounds(t1xloc, l3yloc+5*lysize, 180, 30);
	t5.setBounds(t1xloc, l3yloc+6*lysize, 180, 30);
	t6.setBounds(t1xloc, l3yloc+7*lysize, 180, 30);
	t7.setBounds(t1xloc, l3yloc+8*lysize, 180, 30);
	t8.setBounds(t1xloc, l3yloc+9*lysize, 250, 30);
	
	
	t1.setOpaque(false);
	t1.setEditable(false);
	
	t2.setOpaque(false);
	t2.setEditable(false);
	
	t3.setOpaque(false);
	t3.setEditable(false);
	
	t3.setOpaque(false);
	t3.setEditable(false);
	
	t4.setOpaque(false);
	t4.setEditable(false);
	
	t5.setOpaque(false);
	t5.setEditable(false);
	
	t6.setOpaque(false);
	t6.setEditable(false);
	
	t7.setOpaque(false);
	t7.setEditable(false);
	
	t8.setOpaque(false);
	t8.setEditable(false);
	job.setBounds(t1xloc, l3yloc+3*lysize, 180, 30);
	
	int b4xloc=t1xloc;
	int b4yloc=p1.getHeight()*12/15;

	b4.setBounds(b4xloc, b4yloc, 100, 40);
	
	
	

	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	}