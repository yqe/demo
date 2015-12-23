package transit;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/transit.jpg"));
		background = new ImageIcon(bgp);
	
		p1.setBounds(0, 0, 942, 821);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>中转接收");
		int wordsize = 18;
		JLabel l3 = new JLabel("中转中心编号:");
		JLabel l4 = new JLabel("到达日期:");
		JLabel l5 = new JLabel("出发地:");
		JLabel l6 = new JLabel("货物到达状态:");
		JLabel l7 = new JLabel("中转单编号:");
		// JLabel l8 = new JLabel("中转中心到达单列表:");

		l2.setFont(new Font("", Font.PLAIN, wordsize));
		l3.setFont(new Font("", Font.PLAIN, wordsize));
		l4.setFont(new Font("", Font.PLAIN, wordsize));
		l5.setFont(new Font("", Font.PLAIN, wordsize));
		l6.setFont(new Font("", Font.PLAIN, wordsize));
		l7.setFont(new Font("", Font.PLAIN, wordsize));
		// l8.setFont(new Font("", Font.PLAIN, wordsize));

		final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();

		
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

		JButton b4 = new JButton("添加");
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

		// JButton b5=new JButton("删除");
		// b5.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// //��ȡҪɾ�����,û��ѡ����-1
		// DefaultTableModel model = (DefaultTableModel) table.getModel();
		// int row=table.getSelectedRow();
		// System.out.println(row);
		// if(row== -1){
		// JOptionPane.showMessageDialog(null,"请选中要删除的行!");
		// }else{
		// model.removeRow(row);
		// }
		// }
		// });
		//
		// JButton b6=new JButton("完成中转");
		// b6.addActionListener(new ActionListener(){
		// public void actionPerformed(ActionEvent e) {
		//
		// JOptionPane.showMessageDialog(null,"成功完成中转!");
		// }
		//
		// });
		//

		p1.setOpaque(false);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(l2);

		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
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

		// int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4
		// / 25 - 15;
		// int b1yloc = p1.getHeight() * 1 / 19;
		// int b4xloc = p1.getWidth() * 11 / 13;
		// int b4yloc = p1.getHeight() * 3 / 19 + 20, b4ysize = p1.getHeight() *
		// 1 / 5;

		int labelgw = 100;
		int gaph = 50;
		int labelw = 125;
		int labelgh = 30;
		l1.setBounds(300, -20, 180, 80);
		l2.setBounds(50, gaph, 180, 30);

		l3.setBounds(labelw, gaph * 2 + labelgh * 1, labelw, labelgh);
		l4.setBounds(labelw, gaph * 3 + labelgh * 2, labelw, labelgh);
		l5.setBounds(labelw, gaph * 4 + labelgh * 3, labelw, labelgh);
		l6.setBounds(labelw, gaph * 5 + labelgh * 4, labelw, labelgh);
		l7.setBounds(labelw, gaph * 6 + labelgh * 5, labelw, labelgh);
		// l8.setBounds(50, b1yloc + 150, 200, 30);
		// jp.setBounds(50,b1yloc+200, 413, 400);
		int ltgapw = 30;
		int boxw = 80;
		datepick.setBounds(labelw * 2 + ltgapw, gaph * 3 + labelgh * 2, 150, 30);

		sitebox.setBounds(labelw * 2 + ltgapw, gaph * 4 + labelgh * 3, 80, 30);
		statebox.setBounds(labelw * 2 + ltgapw, gaph * 5 + labelgh * 4, 80, 30);

		t1.setBounds(labelw * 2 + ltgapw, gaph * 2 + labelgh * 1, 120, 30);
		t2.setBounds(labelw * 2 + ltgapw, gaph * 6 + labelgh * 5, 120, 30);

		 b4.setBounds(500, 600, 100, 40);
		// b5.setBounds(b4xloc, b4yloc+2*b4ysize, 100, 40);
		// b6.setBounds(b4xloc, b4yloc+3*b4ysize, 100, 40);
		return p1;
	}
}