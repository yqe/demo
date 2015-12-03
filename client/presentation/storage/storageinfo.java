package storage;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class storageinfo {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	
	public JPanel Panel() throws IOException{
	
	JPanel p1 = new JPanel() ;
	p1.setBounds(0, 0, 900, 700);
	JLabel l1=new JLabel("快递物流系统");
	int b1size=30;
	l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
	JLabel l2=new JLabel("—>库存信息管理");
    int b2size=16;
    l2.setFont(new Font("—> 主页",Font.PLAIN,b2size));
	

	JButton b4=new JButton("库存查看");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			checkstorage check=new checkstorage();
		}
		
	});
	JButton b5=new JButton("库存盘点");
	b5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			countstorage count=new countstorage();
		}
		
	});
	
	JButton b6=new JButton("库存更改");
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			changestorage change=new changestorage();
		}
		
	});
	
	

	p1.setOpaque(false);
	p1.setLayout(null);
	p1.add(l1);
	p1.add(l2);


	p1.add(b4);
	p1.add(b5);
	p1.add(b6);

	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*2/15;
	int b4xloc=p1.getWidth()*2/5;
	int b4yloc=p1.getHeight()*4/15+20,b4ysize=p1.getHeight()*1/5+10;
	
	l1.setBounds(350, -20, 180, 80);

	l2.setBounds(50, b1yloc, 180, 30);


	b4.setBounds(b4xloc, b4yloc, 180, 40);
	b5.setBounds(b4xloc, b4yloc+b4ysize, 180, 40);
	b6.setBounds(b4xloc, b4yloc+2*b4ysize, 180, 40);
	return p1;
	
	 }
	}
