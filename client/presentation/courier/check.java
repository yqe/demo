package courier;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import goodsbl.GoodsBl;
import po.EmploeePO;

public class check {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public check(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 800, 800);
		JLabel l1 = new JLabel("快递物流系统");
		int b1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, b1size));
		JLabel l2 = new JLabel("—>查询订单信息");
		int b2size = 16;
		l2.setFont(new Font("", Font.PLAIN, b2size));
		JLabel l3 = new JLabel("订单条形码号:");
		l3.setFont(new Font("订单条形码号:", Font.PLAIN, b2size));

		final JTextField id = new JTextField();
		
		id.setOpaque(false);
		id.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton("查询");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoDialog info = null;
				if (id.getText().length() == 10) {
					try {
						GoodsBl goodsbl = new GoodsBl(oos,ois);
						String[] infoma = goodsbl.Goodsgetinfo(id.getText());
						if(infoma[0].equals("不存在")){
						JOptionPane.showMessageDialog(null, "该订单条形码号不存在!");
						}
						else{
							System.out.println(infoma[0]+"&&&");
						info = new infoDialog(infoma[0], infoma[1], infoma[2], infoma[3]);
						info.setVisible(true);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "您所输入的订单条形码号不是10位，请再次确认！");
				}

			}

		});

		p1.setOpaque(false);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);

		p1.add(id);

		p1.add(b4);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 40;
		int b4yloc = p1.getHeight() * 1 / 3;

		l1.setBounds(300, -20, 180, 80);

		l2.setBounds(50, b1yloc, 150, 30);

		l3.setBounds(100, 200, 150, 30);

		id.setBounds(275, 200, 200, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);
		return p1;

	}
}