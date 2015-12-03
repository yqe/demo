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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class outstorage {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	public JPanel Panel() throws IOException{



		JPanel p1 = new JPanel();
		p1.setBounds(0,0,900,700);
		JLabel l1=new JLabel("快递物流系统");
		int b1size=30;
		l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
		JLabel l2=new JLabel("—>出库登记");
	    int b2size=16;
	    JLabel l3=new JLabel("快递编号:");
	    JLabel l4=new JLabel("出库日期:");
	    JLabel l5=new JLabel("目的地:");
	    JLabel l6=new JLabel("装运形式:");
	    JLabel l7=new JLabel("中转编号:");

	    
	    JLabel l8=new JLabel("入库单列表:");
  
    l2.setFont(new Font("",Font.PLAIN,b2size));
    l3.setFont(new Font("",Font.PLAIN,b2size));
    l4.setFont(new Font("",Font.PLAIN,b2size));
    l5.setFont(new Font("",Font.PLAIN,b2size));
    l6.setFont(new Font("",Font.PLAIN,b2size));
    l7.setFont(new Font("",Font.PLAIN,b2size));
    l8.setFont(new Font("",Font.PLAIN,b2size));

    
    final JTextField t1=new JTextField();
    final JTextField t2=new JTextField();

    String[] year = new String[201];
    for (int i = 2000; i < 2100; i++) {
        year[i-2000] = i+"年";
    
    }
   final JComboBox yearbox = new JComboBox(year);
    String[] month = new String[12];
    for (int i = 1; i <= 12; i++) {
        month[i-1] = i+"月";
    
    }
    final JComboBox monthbox = new JComboBox(month);
    String[] day = new String[31];
    for (int i = 1; i <= 31; i++) {
        day[i-1] = i+"日";
    
    }
  final  JComboBox daybox = new JComboBox(day);
   
   String[] site ={"南京","上海","北京","杭州","广州","苏州","成都","武汉"};
   final JComboBox sitebox = new JComboBox(site);
   
   String[] type={"汽车","火车","飞机"};
   final JComboBox typebox = new JComboBox(type);
    
	
	String[] columnnames = {"快递编号","出库日期","目的地","装运形式","中转编号"};
	Object[][] data =
		{
			{"000001","2015年9月27日","上海","火车","0000001"},
			     {"000002","2015年9月27日","南京","汽车","0000151"},
			       {"000003","2015年9月27日","北京","飞机","0000202"},
		        
		};
	
	DefaultTableModel model=new  DefaultTableModel(data,columnnames);
	final JTable table=new JTable(model);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	TableColumn dateColumn = table.getColumnModel().getColumn(1);
	dateColumn.setPreferredWidth(120);
	
	JScrollPane jp=new JScrollPane(table);    
    
    jp.setOpaque(false);
    jp.getViewport().setOpaque(false);
	
    
    
	JButton b4=new JButton("添加");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			final String date=(String) yearbox.getSelectedItem()+monthbox.getSelectedItem()+daybox.getSelectedItem();
			final String place=(String) sitebox.getSelectedItem();
			final String type=(String) typebox.getSelectedItem();
			Object[] add={t1.getText(),date,place,type,t2.getText()};
			DefaultTableModel model = (DefaultTableModel) table.getModel();            
			model.insertRow(model.getRowCount(), add);
//			System.out.println(model.getRowCount());
		}
	});
	
	JButton b5=new JButton("删除");
	b5.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//��ȡҪɾ�����,û��ѡ����-1
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int row=table.getSelectedRow();
//			System.out.println(row);
			if(row== -1){
				JOptionPane.showMessageDialog(null,"请选中要删除的行!");
			}else{
				model.removeRow(row);
			}
		}
	});
	
	JButton b6=new JButton("完成出库");
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		
			JOptionPane.showMessageDialog(null,"成功完成出库!");
		}
		
	});

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

	
	p1.add(t1);
	p1.add(t2);
	
	
	p1.add(yearbox);
	p1.add(monthbox);
	p1.add(daybox);
	p1.add(sitebox);
	p1.add(typebox);
	

	p1.add(b4);
	p1.add(b5);
	p1.add(b6);
	
	p1.add(jp);
	
	

	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*1/19;
	int b4xloc=p1.getWidth()*11/13;
	int b4yloc=p1.getHeight()*3/19+20,b4ysize=p1.getHeight()*1/5;
	
	l1.setBounds(350, -20, 180, 80);

	l2.setBounds(50, b1yloc, 180, 30);
	
	l3.setBounds(50, b1yloc+50, 100, 30);
	l4.setBounds(280, b1yloc+50, 100, 30);
	l5.setBounds(50, b1yloc+100, 100, 30);
	
	l6.setBounds(250, b1yloc+100, 100, 30);
	l7.setBounds(450, b1yloc+100, 100, 30);
	l8.setBounds(50, b1yloc+150, 100, 30);

	  jp.setBounds(50, b1yloc+200, 423, 400);
	
	yearbox.setBounds(350, b1yloc+50, 80, 30);
	monthbox.setBounds(440, b1yloc+50, 80, 30);
	daybox.setBounds(530, b1yloc+50, 80, 30);
	sitebox.setBounds(120, b1yloc+100, 80, 30);
	typebox.setBounds(330, b1yloc+100, 80, 30);
	
	t1.setBounds(120, b1yloc+50, 120, 30);
	t2.setBounds(530, b1yloc+100, 120, 30);

	
	b4.setBounds(b4xloc, b4yloc, 100, 40);
	b5.setBounds(b4xloc, b4yloc+2*b4ysize, 100, 40);
	b6.setBounds(b4xloc, b4yloc+3*b4ysize, 100, 40);
	return p1;
	
	 }
	}