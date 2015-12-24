package storage;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import po.EmploeePO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class countstorage {
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

	public countstorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("countstorage");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 988, 756);
		p1.setLayout(null);
		

		String[] columnnames = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		Object[][] data = {

		};

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		JTable table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);

		JScrollPane jp = new JScrollPane(table);

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		p1.setOpaque(false);
		p1.setLayout(null);
	

		p1.add(jp);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 23;
		int b4xloc = p1.getWidth() * 1 / 3;
		int b4yloc = p1.getHeight() * 4 / 15 + 20, b4ysize = p1.getHeight() * 1 / 5 + 10;

		

		jp.setBounds(50, b1yloc + 75, 528, 400);

		return p1;

	}
}