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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stafforgan extends JDialog implements ActionListener {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	
      stafforgan() throws IOException{
	BufferedImage bgp=ImageIO.read(new File("presentation/Mbackground.jpg"));
	background = new ImageIcon(bgp);

	setTitle("人员机构调度");
	setBounds(500,300,650,450);
	setResizable(false);
    setLayout(null);
	
	 JPanel back = new JPanel() {
	 		public void paintComponent(Graphics g) {
	 		super.paintComponent(g);
	 		g.drawImage(background.getImage(), 0, 0, null);
	 		}
	 		};
	 		back.setBounds(0, 0, 650, 500);
	 		back.setLayout(null);
	 		back.setOpaque(false);
	 		
	JLabel l1=new JLabel("快递物流系统");
	int b1size=30;
	l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
	JLabel l2=new JLabel("—>机构");
    int b2size=16;
    JLabel l3=new JLabel("员工列表");
    l2.setFont(new Font("",Font.PLAIN,b2size));
    l3.setFont(new Font("",Font.PLAIN,b2size));

	JButton b4=new JButton("确认选择");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			staffchange sfc=null;
			try {
                 sfc=new staffchange();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			sfc.setVisible(true);
		     stafforgan.this.setVisible(false);
		}
		
	});
	String[] columnnames = {"员工ID","员工姓名","职位"};
	Object[][] data =
		{
		{"000001","安德罗妮","营业厅业务员"},
		     {"000002","蒙太奇","营业厅业务员"},
		         {"000003","囚徒","营业厅业务员"}	        
		};	
      DefaultTableModel model=new  DefaultTableModel(data,columnnames);
		final JTable table=new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
	
     table.setOpaque(false);	
	
     JScrollPane jp=new JScrollPane(table);    
    jp.setOpaque(false);
     jp.getViewport().setOpaque(false);
     
	
	setLayout(null);
	add(l1);
	add(l2);
	add(l3);


	add(b4);
    add(jp);
    add(back);
	
	
	int b4xloc=this.getWidth()*4/5;
	int b4yloc=this.getHeight()*12/15,b4ysize=this.getHeight()*1/6;
	
	l1.setBounds(220, -20, 180, 80);

	l2.setBounds(50, this.getHeight()*2/15, 80, 30);

	l3.setBounds(50, 100, 100, 30);
	

	b4.setBounds(b4xloc, b4yloc, 100, 40);
	
	jp.setBounds(150, 150, 300, 300);
	

	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	}