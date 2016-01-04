package storage;

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
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("changestorage");
		background = new ImageIcon(bgp);
		
		p1.setBounds(0, 0, 988, 756);
		
//		JLabel l3 = new JLabel("输入所需更改库存快递编号:");
//		JLabel l4 = new JLabel("现区号:");
//		JLabel l5 = new JLabel("现排号:");
//		JLabel l6 = new JLabel("现架号:");
//		JLabel l7 = new JLabel("现位号:");
//		JLabel l8 = new JLabel("更改后区号:");
//		JLabel l9 = new JLabel("更改后排号:");
//		JLabel l10 = new JLabel("更改后架号:");
//		JLabel l11 = new JLabel("更改后位号:");



		final MTextfield id = new MTextfield();
		final MTextfield qu = new MTextfield();
		final MTextfield pai = new MTextfield();
		final MTextfield jia = new MTextfield();
		final MTextfield wei = new MTextfield();
		
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

		final MTextfield chqu = new MTextfield();
		final MTextfield chpai = new MTextfield();
		final MTextfield chjia = new MTextfield();
		final MTextfield chwei = new MTextfield();
		
		chqu.setOpaque(false);
		chqu.setBorder(BorderFactory.createEmptyBorder());
		chpai.setOpaque(false);
		chpai.setBorder(BorderFactory.createEmptyBorder());
		chjia.setOpaque(false);
		chjia.setBorder(BorderFactory.createEmptyBorder());
		chwei.setOpaque(false);
		chwei.setBorder(BorderFactory.createEmptyBorder());

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean idisempty = id.getText().equals("");
				boolean isid = true;
				StorageBl storage=new StorageBl(oos, ois);
				if (!idisempty) {
					StorageCheckPO check=storage.IDStorageGet(id.getText());
					if(check.getGoodno().equals("不存在")){
						Mdialog.showMessageDialog( "仓库没有该快递编号货物!");
					}
					else{
				    qu.setText(check.getArea());
				    pai.setText(check.getRow());
				    jia.setText(check.getShelf());
				    wei.setText(check.getLocation());
				    Mdialog.showMessageDialog("已查到所查快递仓库位置!");
					}
				} else if (idisempty) {
					// System.out.println(id.getText().equals(""));
					Mdialog.showMessageDialog("请填写快递编号!");
				}

			}
		});

		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ischquempty = chqu.getText().equals("");
				boolean ischpaiempty = chpai.getText().equals("");
				boolean ischjiaempty = chjia.getText().equals("");
				boolean ischweiempty = chwei.getText().equals("");

				boolean isempty = ischquempty || ischpaiempty || ischjiaempty || ischweiempty;

				StorageBl storage=new StorageBl(oos, ois);
				if (!isempty) {
					StorageCheckPO check=storage.IDStorageGet(id.getText());
					StorageCheckPO change=new StorageCheckPO(check.getGoodsID(),check.getTime(),chqu.getText(),
							chpai.getText(),chjia.getText(),chwei.getText(),check.getTranscenterID(),check.getDestination());
					storage.StorageUpdate(change);
					Mdialog.showMessageDialog("成功修改!");
				} else if (isempty) {
					Mdialog.showMessageDialog("请填写完整更改信息!");
				}

			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);


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

		
	    int	xloc=113,length=176,wdith=43,interval=80;
	    int chxloc=483,chyloc=355,chinterval=80;

	    qu.settextFont();pai.settextFont();jia.settextFont();wei.settextFont();
	    
		qu.setBounds(xloc, chyloc, length, wdith);
		pai.setBounds(xloc, chyloc+chinterval-3, length, wdith);
		jia.setBounds(xloc, chyloc+2*chinterval-3, length, wdith);
		wei.setBounds(xloc, chyloc+3*chinterval+3, length, wdith);// 现

		chqu.settextFont();chpai.settextFont();chjia.settextFont();chwei.settextFont();
		
		chqu.setBounds(chxloc, chyloc, length, wdith);
		chpai.setBounds(chxloc, chyloc+chinterval-3, length, wdith);
		chjia.setBounds(chxloc, chyloc+2*chinterval-3, length, wdith);
		chwei.setBounds(chxloc, chyloc+3*chinterval+3, length, wdith);// 更改

		id.settextFont();
		id.setBounds(250, 199, 150, 41);

		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
		b4.setBounds(522, 195, 200, 53);
		b5.setBounds(747, 631, 200, 53);
		return p1;

	}

}