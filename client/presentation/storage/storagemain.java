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

import login.loginframe;

public class storagemain {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	int size=180; 
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	public JPanel Panel() throws IOException{
	BufferedImage bgp=ImageIO.read(new File("D:/test_eclipse/workspace/demo/client/presentation/Sbackground.jpg"));
	Sbackground = new ImageIcon(bgp);

	JPanel storagemain = new JPanel() {
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Sbackground.getImage(), 0, 0, null);
		}
		};
		storagemain.setBounds(0, 0, 1080, 700);
	

		storagemain.setOpaque(false);
		storagemain.setLayout(null);
		final instorage ins=new instorage();
		final outstorage ous=new outstorage();
		final storageinfo sinfo=new storageinfo();
		final checkstorage chs=new checkstorage();
		final countstorage cos=new countstorage();
		final changestorage cas=new changestorage();
		
		control.setBounds(0, 0, size, 700);
		content.setBounds(size,0,900,700);
	
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

		JButton b4=new JButton("入库登记");
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
				try {	
					changepanel(ins.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton b5=new JButton("出库登记");
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
				try {	
					changepanel(ous.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton b6=new JButton("库存查看");
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {	
			     changepanel(chs.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton b7=new JButton("库存盘点");
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {	
			     changepanel(cos.Panel());
		
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton b8=new JButton("库存更改");
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {	
			     changepanel(cas.Panel());
		
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	
	

	
	control.setLayout(null);
	control.setOpaque(false);
	control.add(b3);
	control.add(b4);
	control.add(b5);
	control.add(b6);
	control.add(b7);
	control.add(b8);
	
   
	
	int b4xloc=size/6,b4yloc=control.getHeight()/5,b4ysize=control.getHeight()/8;
	b4.setBounds(b4xloc, b4yloc, 120, 30);
	b5.setBounds(b4xloc, b4yloc+b4ysize, 120, 30);
	b6.setBounds(b4xloc, b4yloc+2*b4ysize, 120, 30);
	b7.setBounds(b4xloc, b4yloc+3*b4ysize, 120, 30);
	b8.setBounds(b4xloc, b4yloc+4*b4ysize, 120, 30);
	b3.setBounds(b4xloc, b4yloc+5*b4ysize, 120, 30);

    

	content.add(ins.Panel());
	content.setLayout(null);
	content.setOpaque(false);
	
	storagemain.add(control);
	storagemain.add(content);	
	
	return storagemain;
	
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