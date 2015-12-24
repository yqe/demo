package transit;

import image.ImageGet;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

import login.MTextfield;

import com.eltima.components.ui.DatePicker;

import documentbl.Zzzxarrivaldocu;
import po.EmploeePO;
import po.ZzzxArrivalDocuPO;

/**
 * 中转中心到达单
 * 
 * @author jjlb
 *
 */
public class transit {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	final JPanel p1 = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public transit(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos=oos;
		this.ois=ois;
		this.emPO=emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("transit");
		background = new ImageIcon(bgp);
	
		p1.setBounds(0, 0, 942, 821);
	
//		JLabel l3 = new JLabel("中转中心编号:");
//		JLabel l4 = new JLabel("到达日期:");
//		JLabel l5 = new JLabel("出发地:");
//		JLabel l6 = new JLabel("货物到达状态:");
//		JLabel l7 = new JLabel("中转单编号:");
		// JLabel l8 = new JLabel("中转中心到达单列表:");


		// l8.setFont(new Font("", Font.PLAIN, wordsize));

		final MTextfield t1 = new MTextfield();
		final MTextfield t2 = new MTextfield();

		t1.settextFont();
		t2.settextFont();
		
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());
		final JTextField time = new JTextField();
		final DatePicker datepick = new DatePicker(time);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小

		String[] site = { "南京", "上海", "北京", "杭州", "广州", "苏州", "成都", "武汉" };
		final JComboBox sitebox = new JComboBox(site);

		String[] state = { "损坏", "完整", "丢失" };
		final JComboBox statebox = new JComboBox(state);

		// String[] columnnames = {"中转中心编号","到达日期","出发地","货物到达状态","中转单编号"};
		// Object[][] data =
		// {
		// {"000001","2015年9月27日","上海","完整","0000001"},
		// {"000002","2015年9月27日","南京","完整","0000151"},
		// {"000003","2015年9月27日","北京","完整","0000202"},
		//
		// };
		// DefaultTableModel model=new DefaultTableModel(data,columnnames);
		// final JTable table=new JTable(model);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// TableColumn dateColumn = table.getColumnModel().getColumn(1);
		// dateColumn.setPreferredWidth(110);
		//
		// JScrollPane jp=new JScrollPane(table);
		//
		// jp.setOpaque(false);
		// jp.getViewport().setOpaque(false);
		//

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = datepick.getText();
				String place = (String) sitebox.getSelectedItem();
				String state = (String) statebox.getSelectedItem();
				Zzzxarrivaldocu transferaridocu = new Zzzxarrivaldocu(oos,ois);
				boolean IsOk = transferaridocu
						.BuildZzzxarrivalDocu(new ZzzxArrivalDocuPO(t1.getText(), date, t2.getText(), place, state));
				if (IsOk)
					JOptionPane.showMessageDialog(null, "中转接受完成!");
				else
					JOptionPane.showMessageDialog(null, "抱歉，中转接受失败!");
				// Object[] add={t1.getText(),date,place,state,t2.getText()};
				// DefaultTableModel model = (DefaultTableModel)
				// table.getModel();
				// model.insertRow(model.getRowCount(), add);
				// }else{
				//
				// }
				//// System.out.println(model.getRowCount());
			}
		});

	

		p1.setOpaque(false);
		p1.setLayout(null);
	
		// p1.add(l8);

		p1.add(t1);
		p1.add(t2);

		p1.add(datepick);
		p1.add(sitebox);
		p1.add(statebox);

		p1.add(b4);
		// p1.add(b5);
		// p1.add(b6);
		// p1.add(jp);

		int xloc=268,yloc=152,length=230,width=46,interval=77;
		datepick.setBounds(xloc, yloc+interval, length, width);
//
		sitebox.setBounds(xloc, yloc+interval*2, length, width);
		statebox.setBounds(xloc, yloc+interval*3, length, width);
//
		t1.setBounds(xloc, yloc, length, width);
		t2.setBounds(xloc, yloc+interval*4, length, width);

		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		
		 b4.setBounds(333, 592, 263, 116);
	
		return p1;
	}
}