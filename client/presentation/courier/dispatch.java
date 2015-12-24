package courier;

import image.ImageGet;

import java.awt.Color;
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

import login.MTextfield;

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
		   new ImageGet();
	        Image bgp=ImageGet.getImageByState("dispatch");
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 942, 815);
	

	

		final MTextfield id = new MTextfield();
		final MTextfield name = new MTextfield();
		final MTextfield courier = new MTextfield();
		
		id.settextFont();name.settextFont();courier.settextFont();
		
		final JTextField time = new JTextField();
		Calendar c=Calendar.getInstance();

		Date d=c.getTime();
		final DatePicker datepick = new DatePicker(time,d);
		datepick.setOpaque(false);
		datepick.setLocale(Locale.CHINA);//设置显示语言
	    datepick.setPattern("yyyy-MM-dd");//设置日期格式化字符串
	    datepick.setEditorable(false);//设置是否可编辑
		datepick.setPreferredSize(new Dimension(100,30));//设置大小
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());
		name.setOpaque(false);
		name.setBorder(BorderFactory.createEmptyBorder());
		courier.setOpaque(false);
		courier.setBorder(BorderFactory.createEmptyBorder());
		
		
		JButton b4 = new JButton();
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
	

		p1.add(id);
		p1.add(name);
		p1.add(courier);

		p1.add(b4);
		
		p1.add(datepick);

		p1.setOpaque(false);

	

		
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());

	
		id.setBounds(811-402, 262, 232, 47);
		datepick.setBounds(811-402, 333, 232, 47);
		name.setBounds(811-402, 408, 232, 47);
		courier.setBounds(811-402,475, 232, 47);

		b4.setBounds(694-402, 598, 311, 88);
		return p1;

	}

}