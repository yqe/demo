package transit;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
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
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.MTextfield;
import login.loginframe;
import po.EmploeePO;

public class transitmain {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 402;
	JPanel content = new JPanel();
	final JPanel control = new JPanel();
	private EmploeePO emPO;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	JPanel tspanel;
	JPanel tslpanel;
	
	JPanel transitmain = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public transitmain(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("transitmaincontrol");
		background = new ImageIcon(bgp);

		transitmain.setBounds(0, 0, 1344, 821);

		transitmain.setOpaque(false);
		transitmain.setLayout(null);

		final transit ts = new transit(oos, ois, emPO);
		tspanel=ts.Panel();
		final transitload tsl = new transitload(oos, ois, emPO);
        tslpanel=tsl.Panel();
		
		control.setBounds(0, 0, size, 821);
		content.setBounds(size, 0, 942, 821);

		

		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ois.close();
					oos.close();
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(tspanel);
			}

		});
		JButton b5 = new JButton();
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepanel(tslpanel);
			}

		});

		int b2size=20;
		control.setLayout(null);
		control.setOpaque(false);
		
		MTextfield idt=new MTextfield();
		idt.setFont(new Font("", Font.PLAIN, b2size));
		MTextfield namet=new MTextfield();
		namet.setFont(new Font("", Font.PLAIN, b2size));
		MTextfield jobt=new MTextfield();
		
		idt.settextFont();namet.settextFont();jobt.settextFont();
		jobt.setFont(new Font("", Font.PLAIN, b2size));	
		idt.setOpaque(false);
		idt.setEditable(false);
		idt.setBorder(BorderFactory.createEmptyBorder());
		namet.setOpaque(false);
		namet.setEditable(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		jobt.setOpaque(false);
		jobt.setEditable(false);
		jobt.setBorder(BorderFactory.createEmptyBorder());	
		
		
		namet.setBounds(120, 90, 150, 35);
		jobt.setBounds(120, 140, 200, 35);		
		idt.setBounds(82, 225, 150, 30);
		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText(emPO.getPosition());
	
	
		control.add(idt);
		control.add(namet);
		control.add(jobt);
		control.add(b3);
		control.add(b4);
		control.add(b5);

		
		b3.setContentAreaFilled(false);b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setContentAreaFilled(false);b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);b5.setBorder(BorderFactory.createEmptyBorder());
		
		int length=251,width=66;
		b4.setBounds(48, 418, length, width);
		b5.setBounds(48, 418 + 114, length, width-2);
		b3.setBounds(48, 642, 251, 98);

		content.add(tspanel);
		content.setLayout(null);
		content.setOpaque(false);

		transitmain.add(control);
		transitmain.add(content);

		return transitmain;

	}

	public void changepanel(JPanel p1) {
		transitmain.remove(content);
		content = p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		transitmain.add(content);
		content.repaint();
		transitmain.repaint();
		transitmain.revalidate();
	}

}