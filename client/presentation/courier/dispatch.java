package courier;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	public dispatch(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 800, 800);
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
		String[] year = new String[201];
		for (int i = 2000; i < 2100; i++) {
			year[i - 2000] = i + "年";

		}
		final JComboBox yearbox = new JComboBox(year);
		
		String[] month = new String[12];
		for (int i = 1; i <= 12; i++) {
			month[i - 1] = i + "月";

		}
		final JComboBox monthbox = new JComboBox(month);
		
		String[] day = new String[31];
		for (int i = 1; i <= 31; i++) {
			day[i - 1] = i + "日";

		}
		final JComboBox daybox = new JComboBox(day);
		
		JButton b4 = new JButton("生成派件单");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String time=(String)(yearbox.getSelectedItem())+(String)(monthbox.getSelectedItem())+(String)(daybox.getSelectedItem());
				
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
		p1.add(yearbox);
		p1.add(monthbox);
		p1.add(daybox);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 12 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		l1.setBounds(300, -20, 180, 80);
		l2.setBounds(50, b1yloc, 150, 30);
		l3.setBounds(100, 200, 150, 30);
		l4.setBounds(100, 300, 150, 30);
		yearbox.setBounds(275, 300, 80, 30);
		monthbox.setBounds(375, 300, 80, 30);
		daybox.setBounds(475, 300, 80, 30);

		l5.setBounds(100, 400, 150, 30);
		l6.setBounds(100, 500, 150, 30);

		id.setBounds(275, 200, 150, 30);
		name.setBounds(275, 400, 150, 30);
		courier.setBounds(275, 500, 150, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);
		return p1;

	}

}