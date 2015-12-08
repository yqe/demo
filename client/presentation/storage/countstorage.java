package storage;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class countstorage {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	
	public JPanel Panel() throws IOException{
	BufferedImage bgp=ImageIO.read(new File("presentation/background.png"));
	background = new ImageIcon(bgp);

	JPanel p1 = new JPanel();
	p1.setBounds(0, 0, 900, 700);
	p1.setLayout(null);
	JLabel l1=new JLabel("快递物流系统");
	int b1size=30;
	JLabel l2=new JLabel("—>库存盘点");
    int b2size=16;
    JLabel l3=new JLabel("库存列表:");
    l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
    l2.setFont(new Font("",Font.PLAIN,b2size));
    l3.setFont(new Font("",Font.PLAIN,b2size));


	String[] columnnames = {"快递编号","入库日期","目的地","区号","排号","架号","位号"};
	Object[][] data =
		{
	{"快递编号","入库日期","目的地","区号","排号","架号","位号"},
		{"000001","2015-9-27","上海","001","001","001","001"},
		     {"000002","2015-9-27","南京","001","001","001","002"},
		       {"000003","2015-9-27","北京","001","002","001","001"},
		        
		};
	
	DefaultTableModel model=new  DefaultTableModel(data,columnnames);
	JTable table=new JTable(model);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table.setEnabled(false);


	JScrollPane jp=new JScrollPane(table);    
    
    jp.setOpaque(false);
    jp.getViewport().setOpaque(false);
	
	
	p1.setOpaque(false);
	p1.setLayout(null);
	p1.add(l1);
	p1.add(l2);
	p1.add(l3);



	p1.add(jp);
	

	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*2/23;
	int b4xloc=p1.getWidth()*1/3;
	int b4yloc=p1.getHeight()*4/15+20,b4ysize=p1.getHeight()*1/5+10;
	
	l1.setBounds(220, -20, 180, 80);

	l2.setBounds(50, b1yloc, 300, 30);
	
	l3.setBounds(50, b1yloc+50, 150, 30);

	  jp.setBounds(50, b1yloc+75, 528, 400);
	
	return p1; 
	
	 }
	}