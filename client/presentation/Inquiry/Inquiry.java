package Inquiry;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.loginframe;


public class Inquiry {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	public JPanel Panel() throws IOException{
	BufferedImage bgp=ImageIO.read(new File("presentation/background.png"));
	background = new ImageIcon(bgp);

	final JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
		}
		};
	p1.setBounds(0, 0, 636, 388);

	JLabel l1=new JLabel("快递物流系统");
	int b1size=30;
	l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
	JLabel l2=new JLabel("—> 物流信息查询");
    int b2size=16;
    l2.setFont(new Font("—> 主页",Font.PLAIN,b2size));
    JLabel l3=new JLabel("订单条形码号:");
    l3.setFont(new Font("订单条形码号:",Font.PLAIN,b2size));
    JLabel l4=new JLabel("货运轨迹:");
    l4.setFont(new Font("货运轨迹:",Font.PLAIN,b2size));
    
    
    final JTextField t1=new JTextField();
    final JTextField t2=new JTextField();
    
    
	
	JButton b3=new JButton("退出");
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}		
	});

	JButton b4=new JButton("查询");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			boolean isid=true;
		    if(!t1.getText().equals("")){
		    	if(isid){
		    	t2.setText("查询成功！");//到时候具体传货物的状态
		    	}else{
		    		JOptionPane.showMessageDialog(null, "所输入订单条形码号不合法!");
		    	}
		    }else{
		    	JOptionPane.showMessageDialog(null, "请输入订单条形码号!");
		    }
		}		
	});
	
	
	p1.setOpaque(false);
	p1.setLayout(null);
	p1.add(l1);
	p1.add(l2);
	p1.add(l3);
    p1.add(l4);
	
	p1.add(t1);
	p1.add(t2);
	

	p1.add(b3);
	p1.add(b4);


	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*2/21;
	int b4xloc=p1.getWidth()*2/5;
	int b4yloc=p1.getHeight()*2/5;
	
	l1.setBounds(220, -20, 180, 80);
	l2.setBounds(50, b1yloc, 150, 30);
	
	l3.setBounds(100, 2*b4yloc/3-20, 150, 30);
	
	l4.setBounds(100, 7*b4yloc/5-20, 150, 30);
	
	
	t1.setBounds(275, 2*b4yloc/3-20, 200, 30);
	t2.setBounds(275, 7*b4yloc/5-20, 280, 150);


	b3.setBounds(b1xloc+2*b1xsize, b1yloc, 60, 30);
	b4.setBounds(275, b4yloc-20, 180, 40);
	
	return p1;

	
	 }
	}