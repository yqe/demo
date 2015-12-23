package storage;

import image.ImageGet;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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

import com.eltima.components.ui.DatePicker;

import login.Tran;
import po.EmploeePO;
import po.InputStorageDocuPO;
import po.InputStorageList;
import po.StoragePO;
import storagebl.StorageBl;

public class instorage {
	private JPanel imagePanel;
	private ImageIcon Sbackground;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	  JPanel p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(Sbackground.getImage(), 0, 0, null);
			}
		};

	public instorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException{
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("instorage");
		Sbackground = new ImageIcon(bgp);

		final InputStorageList islt=new InputStorageList();
		p1.setBounds(0,0,988,756);
	    int b2size=16;
//	    JLabel l3=new JLabel("快递编号:");
//	    JLabel l4=new JLabel("入库日期:");
//	    JLabel l5=new JLabel("目的地:");
//	    JLabel l6=new JLabel("区号:");
//	    JLabel l7=new JLabel("排号:");
//	    JLabel l8=new JLabel("架号:");
//	    JLabel l9=new JLabel("位号:");
//	    
//	    JLabel l10=new JLabel("入库单列表:");
//	    
//        JLabel l11=new JLabel("中转中心编号:");
  
    
    final JTextField id=new JTextField();
    final JTextField qu=new JTextField();
    final JTextField pai=new JTextField();
    final JTextField jia=new JTextField();
    final JTextField wei=new JTextField();
    final JTextField zzzxid=new JTextField();
    
    
    id.setOpaque(false);
	id.setBorder(BorderFactory.createEmptyBorder());
	qu.setOpaque(false);
	qu.setBorder(BorderFactory.createEmptyBorder());
	pai.setOpaque(false);
	pai.setBorder(BorderFactory.createEmptyBorder());
	jia.setOpaque(false);
	jia.setBorder(BorderFactory.createEmptyBorder());
	wei.setOpaque(false);
	wei.setBorder(BorderFactory.createEmptyBorder());

    zzzxid.setText(emPO.getPosID());
    zzzxid.setOpaque(false);
    zzzxid.setBorder(BorderFactory.createEmptyBorder());
    zzzxid.setEditable(false);
 
    final JTextField time = new JTextField();
	final DatePicker datepick = new DatePicker(time);
	datepick.setLocale(Locale.CHINA);//设置显示语言
    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
    datepick.setEditorable(false);//设置是否可编辑
	datepick.setPreferredSize(new Dimension(100,30));//设置大小
   
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
	
    
    
    
	JButton b4=new JButton("");
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String date=datepick.getText();
			String place=(String) sitebox.getSelectedItem();
			InputStorageDocuPO insto=new InputStorageDocuPO(id.getText(), date, place, qu.getText(), pai.getText(), jia.getText(), wei.getText(), zzzxid.getText());
			islt.addInputStoragePO(insto);
//			Object[] add={id.getText(),date,place,qu.getText(),pai.getText(),jia.getText(),wei.getText(),zzzxid.getText()};
//			DefaultTableModel model = (DefaultTableModel) table.getModel();            
//			model.insertRow(model.getRowCount(), add);
//			System.out.println(model.getRowCount());
		}
	});
	
	
	
	
//	JButton b5=new JButton("删除");
//	b5.addActionListener(new ActionListener() {
//
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			//��ȡҪɾ�����,û��ѡ����-1
//			DefaultTableModel model = (DefaultTableModel) table.getModel();
//			int row=table.getSelectedRow();
////			System.out.println(row);
//			if(row== -1){
//				JOptionPane.showMessageDialog(null,"请选中要删除的行!");
//			}else{
//				model.removeRow(row);
//			}
//		}
//	});
	
	JButton b6=new JButton("");
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			StorageBl ido=new StorageBl(oos,ois);
			boolean isOk=ido.InStorageInput(islt);
			if (isOk)
			JOptionPane.showMessageDialog(null,"成功完成入库!");
			else
				JOptionPane.showMessageDialog(null,"无法完成入库!");
		}
		
	});

	p1.setOpaque(false);
	p1.setLayout(null);

	
	p1.add(id);
	p1.add(qu);
	p1.add(pai);
	p1.add(jia);
	p1.add(wei);
	
	p1.add(datepick);
	p1.add(sitebox);
	

	p1.add(b4);
//	p1.add(b5);
	p1.add(b6);
	
	p1.add(zzzxid);
	p1.add(jp);
	
	 
	

	
	int xloc=65,length=175,width=44;
	
//    jp.setBounds(xloc, b1yloc+250, 648, 400);
	
	datepick.setBounds(xloc, 408, length, width);

	sitebox.setBounds(xloc, 502, length, width);
	
	sitebox.setOpaque(false);
	
	id.setBounds(xloc, 312, length, width);
	
	int newxloc=302,newyloc=311,newlength=136,newwidth=30,interval=65;
	qu.setBounds(newxloc, newyloc, newlength, newwidth);
	pai.setBounds(newxloc, newyloc+interval, newlength, newwidth);
	jia.setBounds(newxloc, newyloc+interval*2, newlength, newwidth);
	wei.setBounds(newxloc, newyloc+interval*3-3, newlength, newwidth);
	zzzxid.setBounds(252, 621, 196, 42);
	

	b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
	b6.setContentAreaFilled(false);b6.setBorder(BorderFactory.createEmptyBorder());
	
	b4.setBounds(254, 549, 200, 54);
//	b5.setBounds(b4xloc, b4yloc+2*b4ysize, 100, 40);
	b6.setBounds(707, 648, 200, 54);
	return p1;
	
	 }
	}