package transit;
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

public class transitmain {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size=180; 
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	public JPanel Panel() throws IOException{
	BufferedImage bgp=ImageIO.read(getClass().getResource("/presentation/tbackground.jpg"));
	background = new ImageIcon(bgp);

	JPanel transitmain = new JPanel() {
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
		}
		};
		transitmain.setBounds(0, 0, 980, 700);
	

		transitmain.setOpaque(false);
		transitmain.setLayout(null);
		
	   final transit ts=new transit();
		final transitload tsl=new transitload();

		
		control.setBounds(0, 0, size, 700);
		content.setBounds(size,0,800,700);
	
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

		JButton b4=new JButton("中转接收");
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
				try {
					changepanel(ts.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JButton b5=new JButton("装运管理");
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		
				try {
					changepanel(tsl.Panel());
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

	
	int b4xloc=size/6,b4yloc=control.getHeight()/4,b4ysize=control.getHeight()/5;
	b4.setBounds(b4xloc, b4yloc, 120, 30);
	b5.setBounds(b4xloc, b4yloc+b4ysize, 120, 30);
	b3.setBounds(b4xloc, b4yloc+2*b4ysize, 120, 30);

    

	content.add(ts.Panel());
	content.setLayout(null);
	content.setOpaque(false);
	
	transitmain.add(control);
	transitmain.add(content);	
	
	return transitmain;

	
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