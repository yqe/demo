package manager;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import po.EmploeePO;
import po.StrategyPO;

public class Strategy {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel(){
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public Strategy(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/strategy.jpg"));
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 988, 756);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>修改薪水策略");
		int l2size = 16;
		l2.setFont(new Font("—", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("薪水策略:");
		JLabel l4 = new JLabel("职位");
		JLabel l5 = new JLabel("月薪");
		JLabel l6 = new JLabel("总经理:");
		JLabel l7 = new JLabel("中转中心业务员:");
		JLabel l8 = new JLabel("中转中心仓库管理员:");
		JLabel l9 = new JLabel("营业厅业务员:");
		JLabel l10 = new JLabel("快递员:");
		JLabel l11 = new JLabel("财务人员:");
		JLabel l12 = new JLabel("管理员:");

		JLabel l13 = new JLabel("快递价格策略:");
		JLabel l14 = new JLabel("单价:");
		JLabel l15 = new JLabel("元 /每公里/每公斤/1000");

		int lmain = 16;
		l3.setFont(new Font("", Font.PLAIN, lmain));
		l4.setFont(new Font("", Font.PLAIN, lmain));
		l5.setFont(new Font("", Font.PLAIN, lmain));
		l6.setFont(new Font("", Font.PLAIN, lmain));
		l7.setFont(new Font("", Font.PLAIN, lmain));
		l8.setFont(new Font("", Font.PLAIN, lmain));
		l9.setFont(new Font("", Font.PLAIN, lmain));
		l10.setFont(new Font("", Font.PLAIN, lmain));
		l11.setFont(new Font("", Font.PLAIN, lmain));
		l12.setFont(new Font("", Font.PLAIN, lmain));
		l13.setFont(new Font("", Font.PLAIN, lmain));
		l14.setFont(new Font("", Font.PLAIN, lmain));
		l15.setFont(new Font("", Font.PLAIN, lmain));

		final JTextField manager = new JTextField();
		final JTextField transitman = new JTextField();
		final JTextField storager = new JTextField();
		final JTextField boclerk = new JTextField();
		final JTextField courier = new JTextField();
		final JTextField financer = new JTextField();
		final JTextField controller = new JTextField();
		final JTextField price = new JTextField();
		
		manager.setOpaque(false);
		manager.setBorder(BorderFactory.createEmptyBorder());
		transitman.setOpaque(false);
		transitman.setBorder(BorderFactory.createEmptyBorder());
		storager.setOpaque(false);
		storager.setBorder(BorderFactory.createEmptyBorder());
		boclerk.setOpaque(false);
		boclerk.setBorder(BorderFactory.createEmptyBorder());
		courier.setOpaque(false);
		courier.setBorder(BorderFactory.createEmptyBorder());
		financer.setOpaque(false);
		financer.setBorder(BorderFactory.createEmptyBorder());
		controller.setOpaque(false);
		controller.setBorder(BorderFactory.createEmptyBorder());
		price.setOpaque(false);
		price.setBorder(BorderFactory.createEmptyBorder());
		

		strategybl.StrategyBl stra = new strategybl.StrategyBl(oos, ois);
		StrategyPO spo = stra.show();
		manager.setText(String.valueOf(spo.getTopsal()));
		transitman.setText(String.valueOf(spo.getStoragesal()));
		storager.setText(String.valueOf(spo.getStoragemanagersal()));
		boclerk.setText(String.valueOf(spo.getBusssal()));
		courier.setText(String.valueOf(spo.getDiliversal()));
		financer.setText(String.valueOf(spo.getFinancesal()));
		controller.setText(String.valueOf(spo.getManagersal()));
		price.setText(String.valueOf(spo.getConstance()));

		JButton b4 = new JButton("确认修改");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newmanager = manager.getText();
				String newtransitman = transitman.getText();
				String newstorager = storager.getText();
				String newboclerk = boclerk.getText();
				String newcourier = courier.getText();
				String newfinancer = financer.getText();
				String newcontroller = controller.getText();
				String newprice = price.getText(); // StrategyPO传入新的数据

				strategybl.StrategyBl stra = new strategybl.StrategyBl(oos, ois);
				StrategyPO spo = new StrategyPO(Integer.valueOf(newmanager), Integer.valueOf(newtransitman),
						Integer.valueOf(newstorager), Integer.valueOf(newboclerk), Integer.valueOf(newcourier),
						Integer.valueOf(newfinancer), Integer.valueOf(newcontroller), Double.valueOf(newprice));
        System.out.println(newmanager+"3#@@#####");
				if (stra.modify(spo))
					JOptionPane.showMessageDialog(null, "修改成功!");
				else
					JOptionPane.showMessageDialog(null, "修改失败!");

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
		p1.add(l12);
		p1.add(l13);
		p1.add(l14);
		p1.add(l15);

		p1.add(manager);
		p1.add(transitman);
		p1.add(storager);
		p1.add(boclerk);
		p1.add(courier);
		p1.add(financer);
		p1.add(controller);
		p1.add(price);

		p1.add(b4);

		p1.setOpaque(false);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 1 / 15;
		int b4xloc = p1.getWidth() * 2 / 5 - 30;
		int b4yloc = p1.getHeight() * 13 / 15, b4ysize = p1.getHeight() * 1 / 5 + 10;

		int l4xloc = 3 * p1.getWidth() / 10;
		int lysize = 50;
		l1.setBounds(220, -20, 180, 80);
		l2.setBounds(50, b1yloc, 200, 30);
		l3.setBounds(50, 100, 150, 30);
		l4.setBounds(l4xloc, 100, 150, 30); // 职位
		l5.setBounds(350, 100, 150, 30); // 薪水

		l6.setBounds(l4xloc, 100 + lysize, 150, 30);
		l7.setBounds(l4xloc, 100 + 2 * lysize, 150, 30);
		l8.setBounds(l4xloc, 100 + 3 * lysize, 150, 30);
		l9.setBounds(l4xloc, 100 + 4 * lysize, 150, 30);
		l10.setBounds(l4xloc, 100 + 5 * lysize, 150, 30);
		l11.setBounds(l4xloc, 100 + 6 * lysize, 150, 30);
		l12.setBounds(l4xloc, 100 + 7 * lysize, 100, 30);

		l13.setBounds(50, 100 + 8 * lysize, 150, 30);

		l14.setBounds(l4xloc, 100 + 8 * lysize, 150, 30);
		l15.setBounds(420, 100 + 8 * lysize, 200, 30);

		int t1xloc = 7 * p1.getWidth() / 12;
		int tysize = 50;
		manager.setBounds(t1xloc, 100 + tysize, 100, 30);
		transitman.setBounds(t1xloc, 100 + 2 * tysize, 100, 30);
		storager.setBounds(t1xloc, 100 + 3 * tysize, 100, 30);
		boclerk.setBounds(t1xloc, 100 + 4 * tysize, 100, 30);
		courier.setBounds(t1xloc, 100 + 5 * tysize, 100, 30);
		financer.setBounds(t1xloc, 100 + 6 * tysize, 100, 30);
		controller.setBounds(t1xloc, 100 + 7 * tysize, 100, 30);
		price.setBounds(t1xloc * 3 / 4, 100 + 8 * tysize, 80, 30);

		b4.setBounds(b4xloc, b4yloc, 180, 40);
		return p1;

	}

}