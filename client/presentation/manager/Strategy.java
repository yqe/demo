package manager;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
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

import login.MTextfield;
import login.Mdialog;
import po.EmploeePO;
import po.StrategyPO;

public class Strategy {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel()
	{
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
		new ImageGet();
		Image bgp = ImageGet.getImageByState("strategy");
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0,1029, 840);
		
//		JLabel l3 = new JLabel("薪水策略:");
//		JLabel l4 = new JLabel("职位");
//		JLabel l5 = new JLabel("月薪");
//		JLabel l6 = new JLabel("总经理:");
//		JLabel l7 = new JLabel("中转中心业务员:");
//		JLabel l8 = new JLabel("中转中心仓库管理员:");
//		JLabel l9 = new JLabel("营业厅业务员:");
//		JLabel l10 = new JLabel("快递员:");
//		JLabel l11 = new JLabel("财务人员:");
//		JLabel l12 = new JLabel("管理员:");
//
//		JLabel l13 = new JLabel("快递价格策略:");
//		JLabel l14 = new JLabel("单价:");
//		JLabel l15 = new JLabel("元 /每公里/每公斤/1000");

		int lmain = 16;
	

		final MTextfield manager = new MTextfield();
		final MTextfield transitman = new MTextfield();
		final MTextfield storager = new MTextfield();
		final MTextfield boclerk = new MTextfield();
		final MTextfield courier = new MTextfield();
		final MTextfield financer = new MTextfield();
		final MTextfield controller = new MTextfield();
		final MTextfield price = new MTextfield();
		
		manager.settextFont();transitman.settextFont();storager.settextFont();boclerk.settextFont();
		courier.settextFont();financer.settextFont();controller.settextFont();price.settextFont();

		
		
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

		JButton b4 = new JButton();
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
//        System.out.println(newmanager+"3#@@#####");
				if (stra.modify(spo))
					Mdialog.showMessageDialog("修改成功!");
				else
					Mdialog.showMessageDialog( "修改失败!");

			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);


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


	    b4.setContentAreaFilled(false);
	    b4.setBorder(BorderFactory.createEmptyBorder());
	    
	    

		int t1xloc=967-315,tyloc=297,txsize=85,interval=48;
		manager.setBounds(t1xloc, tyloc, 100, 30);
		transitman.setBounds(t1xloc, tyloc+interval, 100, 30);
		storager.setBounds(t1xloc, tyloc+interval*2-1, 100, 30);
		boclerk.setBounds(t1xloc, tyloc+interval*3-3, 100, 30);
		courier.setBounds(t1xloc, tyloc+interval*4-2, 100, 30);
		financer.setBounds(t1xloc, tyloc+interval*5, 100, 30);
		controller.setBounds(t1xloc, tyloc+interval*6, 100, 30);
		price.setBounds(t1xloc , tyloc+interval*8-15, 80, 30);

		b4.setBounds(968-315, 744, 228, 54);
		return p1;

	}

}