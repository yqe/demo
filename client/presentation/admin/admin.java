package admin;

import java.awt.Font;
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
import javax.swing.JPanel;

import login.loginframe;
import courier.Send;
import courier.check;
import courier.dispatch;


public class admin {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size=180; 
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	public JPanel Panel() throws IOException{
	
	BufferedImage bgp=ImageIO.read(new File("presentation/Abackground.jpg"));
	background = new ImageIcon(bgp);
	JPanel admin = new JPanel() {
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
		}
		};
		admin.setBounds(0, 0, 780, 500);
	

    admin.setOpaque(false);
    admin.setLayout(null);
   
    
	final changepasswordmain change=new changepasswordmain();
	final logoff logoff=new logoff();
	final authority au=new authority();
	
	control.setBounds(0, 0, size, 500);
	content.setBounds(size,0,600,500);
	


	JButton b3=new JButton("退出");
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}		
	});


	JButton b4=new JButton("修改账户密码");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			try {
				changepanel(change.Panel());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	JButton b5=new JButton("注销账户");
	b5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
			try {
				changepanel(logoff.Panel());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	
	JButton b6=new JButton("修改权限");
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
			try {
				changepanel(au.Panel());
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
	
	int b4xloc=size/6,b4yloc=control.getHeight()/5,b4ysize=control.getHeight()/5;
	b4.setBounds(b4xloc, b4yloc, 120, 30);
	b5.setBounds(b4xloc, b4yloc+b4ysize, 120, 30);
	b6.setBounds(b4xloc, b4yloc+2*b4ysize, 120, 30);
	b3.setBounds(b4xloc, b4yloc+3*b4ysize, 120, 30);

    

	content.add(change.Panel());
	content.setLayout(null);
	content.setOpaque(false);


	admin.add(control);
	admin.add(content);	
	
	
	return admin;
	
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