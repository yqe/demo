package storage;

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
import po.StorageCheckPO;
import storagebl.StorageBl;

public class changestorage {
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

	public changestorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/changestorage.jpg"));
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 988, 756);
		JLabel l1 = new JLabel("快递物流系统");
		int l1size = 30;
		l1.setFont(new Font("快递物流系统", Font.PLAIN, l1size));
		JLabel l2 = new JLabel("—>库存更改");
		int l2size = 16;
		l2.setFont(new Font("", Font.PLAIN, l2size));
		JLabel l3 = new JLabel("输入所需更改库存快递编号:");
		JLabel l4 = new JLabel("现区号:");
		JLabel l5 = new JLabel("现排号:");
		JLabel l6 = new JLabel("现架号:");
		JLabel l7 = new JLabel("现位号:");
		JLabel l8 = new JLabel("更改后区号:");
		JLabel l9 = new JLabel("更改后排号:");
		JLabel l10 = new JLabel("更改后架号:");
		JLabel l11 = new JLabel("更改后位号:");

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

		final JTextField id = new JTextField();
		final JTextField qu = new JTextField();
		final JTextField pai = new JTextField();
		final JTextField jia = new JTextField();
		final JTextField wei = new JTextField();
		
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
		
		qu.setEnabled(false);
		pai.setEnabled(false);
		jia.setEnabled(false);
		wei.setEnabled(false);

		final JTextField chqu = new JTextField();
		final JTextField chpai = new JTextField();
		final JTextField chjia = new JTextField();
		final JTextField chwei = new JTextField();
		
		chqu.setOpaque(false);
		chqu.setBorder(BorderFactory.createEmptyBorder());
		chpai.setOpaque(false);
		chpai.setBorder(BorderFactory.createEmptyBorder());
		chjia.setOpaque(false);
		chjia.setBorder(BorderFactory.createEmptyBorder());
		chwei.setOpaque(false);
		chwei.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton("确定");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean idisempty = id.getText().equals("");
				boolean isid = true;
				StorageBl storage=new StorageBl(oos, ois);
				if (!idisempty) {
					StorageCheckPO check=storage.IDStorageGet(id.getText());
					if(check.getGoodno().equals("不存在")){
					JOptionPane.showMessageDialog(null, "仓库没有该快递编号货物!");
					}
					else{
				    qu.setText(check.getArea());
				    pai.setText(check.getRow());
				    jia.setText(check.getShelf());
				    wei.setText(check.getLocation());
					JOptionPane.showMessageDialog(null, "已查到所查快递仓库位置!");
					}
				} else if (idisempty) {
					// System.out.println(id.getText().equals(""));
					JOptionPane.showMessageDialog(null, "请填写快递编号!");
				}

			}
		});

		JButton b5 = new JButton("确认修改");
		b5.addActionListener(new ActionListener() {
			boolean ischquempty = chqu.getText().equals("");
			boolean ischpaiempty = chpai.getText().equals("");
			boolean ischjiaempty = chjia.getText().equals("");
			boolean ischweiempty = chwei.getText().equals("");

			boolean isempty = ischquempty || ischpaiempty || ischjiaempty || ischweiempty;

			public void actionPerformed(ActionEvent e) {
				StorageBl storage=new StorageBl(oos, ois);
				if (!isempty) {
					StorageCheckPO check=storage.IDStorageGet(id.getText());
					StorageCheckPO change=new StorageCheckPO(check.getGoodsID(),check.getTime(),chqu.getText(),
							chpai.getText(),chjia.getText(),chwei.getText(),check.getTranscenterID());
					storage.StorageUpdate(change);
					JOptionPane.showMessageDialog(null, "成功修改!");
				} else if (isempty) {
					JOptionPane.showMessageDialog(null, "请填写完整更改信息!");
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
		p1.add(chqu);
		p1.add(chpai);
		p1.add(chjia);
		p1.add(chwei);

		p1.add(b4);
		p1.add(b5);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 23;

		l1.setBounds(260, -20, 180, 80);
		l2.setBounds(50, b1yloc, 300, 30);

		l3.setBounds(100, 175, 200, 30);

		l4.setBounds(100, 250, 100, 30);
		l5.setBounds(100, 300, 100, 30);
		l6.setBounds(100, 350, 100, 30);
		l7.setBounds(100, 400, 100, 30);

		l8.setBounds(400, 250, 100, 30);
		l9.setBounds(400, 300, 100, 30);
		l10.setBounds(400, 350, 100, 30);
		l11.setBounds(400, 400, 100, 30);

		qu.setBounds(225, 250, 150, 30);
		pai.setBounds(225, 300, 150, 30);
		jia.setBounds(225, 350, 150, 30);
		wei.setBounds(225, 400, 150, 30);// 现

		chqu.setBounds(500, 250, 150, 30);
		chpai.setBounds(500, 300, 150, 30);
		chjia.setBounds(500, 350, 150, 30);
		chwei.setBounds(500, 400, 150, 30);// 更改

		id.setBounds(325, 175, 200, 30);

		b4.setBounds(550, 175, 80, 30);
		b5.setBounds(400, 500, 180, 40);
		return p1;

	}

}