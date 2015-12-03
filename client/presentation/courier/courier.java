package courier;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.loginframe;

public class courier {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size=180;
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	public JPanel Panel() throws IOException{
	BufferedImage bgp=ImageIO.read(new File("D:/test_eclipse/workspace/demo/client/presentation/Cbackground.jpg"));
	background = new ImageIcon(bgp);

	JPanel courier = new JPanel() {
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
		}
		};
		courier.setBounds(0, 0, 980, 800);
		
		courier.setOpaque(false);
	    courier.setLayout(null);
		final Send send=new Send();
		final dispatch dispatch=new dispatch();
		final 	check check=new check();
		
		control.setBounds(0, 0, size, 800);
		content.setBounds(size,0,980,800);
		
		
		JLabel l1=new JLabel("快递物流系统");
		int b1size=30;
		l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
		JLabel l2=new JLabel("—> 主页");
	    int b2size=16;
	    l2.setFont(new Font("—> 主页",Font.PLAIN,b2size));
	
	    JButton b3=new JButton("退出");
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}		
		});

		JButton b4=new JButton("生成寄件单");
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
				try { 
					changepanel(send.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton b5=new JButton("生成派件单");
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					changepanel(dispatch.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton b6=new JButton("查询订单信息");
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
				try { 
					changepanel(check.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	
	

	control.setOpaque(false);
	control.setLayout(null);


	control.add(b3);
	control.add(b4);
	control.add(b5);
	control.add(b6);
	
	
  
	int b4xloc=size/6,b4yloc=control.getHeight()/5,b4ysize=control.getHeight()/5;
	
	
	b3.setBounds(b4xloc, b4yloc+3*b4ysize, 120, 40);
	b4.setBounds(b4xloc, b4yloc, 120, 40);
	b5.setBounds(b4xloc, b4yloc+b4ysize, 120, 40);
	b6.setBounds(b4xloc, b4yloc+2*b4ysize, 120, 40);

	content.add(send.Panel());
	content.setLayout(null);
	content.setOpaque(false);


	courier.add(control);
	courier.add(content);	
	
	return courier;
	
	 }
	public void changepanel(JPanel p1){
		content.removeAll();
		content.add(p1);
		content.repaint();
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		content.setLayout(null);
		content.setOpaque(false);
	}
	}