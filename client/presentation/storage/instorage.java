package storage;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class instorage {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	
	public JPanel Panel() throws IOException{
	


	    JPanel p1 = new JPanel() ;
		p1.setBounds(0,0,900,700);
		JLabel l1=new JLabel("快递物流系统");
		int b1size=30;
		l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
		JLabel l2=new JLabel("—>入库登记");
	    int b2size=16;
	    JLabel l3=new JLabel("快递编号:");
	    JLabel l4=new JLabel("入库日期:");
	    JLabel l5=new JLabel("目的地:");
	    JLabel l6=new JLabel("区号:");
	    JLabel l7=new JLabel("排号:");
	    JLabel l8=new JLabel("架号:");
	    JLabel l9=new JLabel("位号:");
	    
	    JLabel l10=new JLabel("入库单列表:");
	    
        JLabel l11=new JLabel("中转中心编号:");
  
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
    
    final JTextField id=new JTextField();
    final JTextField qu=new JTextField();
    final JTextField pai=new JTextField();
    final JTextField jia=new JTextField();
    final JTextField wei=new JTextField();
    final JTextField zzzxid=new JTextField();
    
    String[] year = new String[201];
    for (int i = 2000; i < 2100; i++) {
        year[i-2000] = i+"年";
    
    }
   final   JComboBox yearbox = new JComboBox(year);
    String[] month = new String[12];
    for (int i = 1; i <= 12; i++) {
        month[i-1] = i+"月";
    
    }
    final JComboBox monthbox = new JComboBox(month);
    String[] day = new String[31];
    for (int i = 1; i <= 31; i++) {
        day[i-1] = i+"日";
    
    }
   final JComboBox daybox = new JComboBox(day);
   
   String[] site ={"南京","上海","北京","杭州","广州","苏州","成都","武汉"};
   final JComboBox sitebox = new JComboBox(site);
    
//	final String date=(String) yearbox.getSelectedItem()+monthbox.getSelectedItem()+daybox.getSelectedItem();
   
//	final String place=(String) sitebox.getSelectedItem();
   
   String[] columnnames = {"快递编号","入库日期","目的地","区号","排号","架号","位号","中转中心编号"};

	
	final DefaultTableModel model=new  DefaultTableModel(null,columnnames);
	final JTable table=new JTable(model);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//    table.setEnabled(false);
	TableColumn dateColumn = table.getColumnModel().getColumn(1);
	dateColumn.setPreferredWidth(100);
	
	TableColumn zzzxColumn = table.getColumnModel().getColumn(7);
	dateColumn.setPreferredWidth(120);
	
	
	JScrollPane jp=new JScrollPane(table);    
    
    jp.setOpaque(false);
    jp.getViewport().setOpaque(false);
	
    
    
    
	JButton b4=new JButton("添加");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			final String date=(String) yearbox.getSelectedItem()+monthbox.getSelectedItem()+daybox.getSelectedItem();
			final String place=(String) sitebox.getSelectedItem();
			Object[] add={id.getText(),date,place,qu.getText(),pai.getText(),jia.getText(),wei.getText(),zzzxid.getText()};
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
	
	JButton b6=new JButton("完成入库");
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		
			JOptionPane.showMessageDialog(null,"成功完成入库!");
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
	p1.add(l9);
	p1.add(l10);
	p1.add(l11);
	
	p1.add(id);
	p1.add(qu);
	p1.add(pai);
	p1.add(jia);
	p1.add(wei);
	
	p1.add(yearbox);
	p1.add(monthbox);
	p1.add(daybox);
	p1.add(sitebox);
	

	p1.add(b4);
	p1.add(b5);
	p1.add(b6);
	
	p1.add(zzzxid);
	p1.add(jp);
	
	 
	

	int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
	int b1yloc=p1.getHeight()*1/19;
	int b4xloc=p1.getWidth()*11/13;
	int b4yloc=p1.getHeight()*4/19,b4ysize=p1.getHeight()*1/5;
	
	l1.setBounds(350, -20, 180, 80);

	l2.setBounds(50, b1yloc, 180, 30);
	
	l3.setBounds(50, b1yloc+50, 100, 30);
	l4.setBounds(250, b1yloc+50, 100, 30);
	l5.setBounds(600, b1yloc+50, 100, 30);
	
	l6.setBounds(50, b1yloc+100, 100, 30);
	l7.setBounds(200, b1yloc+100, 100, 30);
	l8.setBounds(350, b1yloc+100, 100, 30);
	l9.setBounds(500, b1yloc+100, 100, 30);
	
	l10.setBounds(50, b1yloc+200, 150, 30);
	
	l11.setBounds(50, b1yloc+150, 150, 30);
	
    jp.setBounds(50, b1yloc+250, 648, 400);
	
	yearbox.setBounds(320, b1yloc+50, 80, 30);
	monthbox.setBounds(410, b1yloc+50, 80, 30);
	daybox.setBounds(500, b1yloc+50, 80, 30);
	sitebox.setBounds(660, b1yloc+50, 80, 30);
	
	id.setBounds(120, b1yloc+50, 120, 30);
	qu.setBounds(90, b1yloc+100, 80, 30);
	pai.setBounds(250, b1yloc+100, 80, 30);
	jia.setBounds(400, b1yloc+100, 80, 30);
	wei.setBounds(550, b1yloc+100, 80, 30);
	zzzxid.setBounds(200, b1yloc+150, 150, 30);
	

	b4.setBounds(b4xloc, b4yloc, 100, 40);
	b5.setBounds(b4xloc, b4yloc+2*b4ysize, 100, 40);
	b6.setBounds(b4xloc, b4yloc+3*b4ysize, 100, 40);
	return p1;
	
	 }
	}