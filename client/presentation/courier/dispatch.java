package courier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;

import documentbl.Diliverdocu;
import po.DiliverDocuPO;
import po.EmploeePO;

public class dispatch {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	JPanel p1 = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}};

	public dispatch(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource(
				"/presentation/dispatch.jpg"));
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 942, 815);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>生成派件单");
		int l2size = 16;
		l2.setFont(new Font("", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("订单条形码号:");
		JLabel l4 = new JLabel("到达日期:");
		JLabel l5 = new JLabel("收件人姓名:");
		JLabel l6 = new JLabel("派送员:");

		int lmain = 16;
		l3.setFont(new Font("订单条形码号:", Font.PLAIN, lmain));
		l4.setFont(new Font("到达日期:", Font.PLAIN, lmain));
		l5.setFont(new Font("收件人姓名:", Font.PLAIN, lmain));
		l6.setFont(new Font("派送员:", Font.PLAIN, lmain));

		final JTextField id = new JTextField();
		final JTextField name = new JTextField();
		final JTextField courier = new JTextField();
		
		final JTextField time = new JTextField();
		Calendar c=Calendar.getInstance();
//		c.set(2015, 12, 30, 0, 0);
		Date d=c.getTime();
		final DatePicker datepick = new DatePicker(time,d);
		datepick.setOpaque(false);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.gray));
		name.setOpaque(false);
		name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		courier.setOpaque(false);
		courier.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		JButton b4 = new JButton("生成派件单");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String time=datepick.getText();			
				boolean isid = (id.getText().length() == 10);
				boolean idisempty = id.getText().equals("");
				boolean nameisempty = name.getText().equals("");
				boolean courierisempty = courier.getText().equals("");

				boolean isempty = idisempty || nameisempty || courierisempty;
				if (isid && !isempty) {
					Diliverdocu dili=new Diliverdocu(oos,ois);
					boolean IsOk=dili.BuildDiliverDocu(new DiliverDocuPO(id.getText(), time, name.getText(), courier.getText()));
					if(IsOk){
						JOptionPane.showMessageDialog(null, "生成派件单成功!");
					}
				} else if (!isid && !idisempty) {
					JOptionPane.showMessageDialog(null, "所输入订单条形码号非法!");
				} else {
					JOptionPane.showMessageDialog(null, "请完整填写信息!");
				}
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

		p1.add(id);
		p1.add(name);
		p1.add(courier);

		p1.add(b4);
		
		p1.add(datepick);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 12 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(300, -20, 180, 80);
		l2.setBounds(50, b1yloc, 150, 30);
		l3.setBounds(100, 200, 150, 30);
		l4.setBounds(100, 300, 150, 30);
		datepick.setBounds(275, 300, 150, 30);
		

		l5.setBounds(100, 400, 150, 30);
		l6.setBounds(100, 500, 150, 30);

		id.setBounds(275, 200, 150, 30);
		name.setBounds(275, 400, 150, 30);
		courier.setBounds(275, 500, 150, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);
		return p1;

	}

}