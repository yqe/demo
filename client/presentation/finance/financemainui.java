package finance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import image.ImageGet;
import po.EmploeePO;

public class financemainui {

	private Image bgp;
	private Image cmdbgp;
	int width;
	int height;
	int cmdwidth;
	JButtonM[] cmdbutton = new JButtonM[] { new JButtonM("返回登录界面"), new JButtonM("账户管理"), new JButtonM("查看收款单"),
			new JButtonM("成本管理"), new JButtonM("成本收益表"), new JButtonM("经营情况表"), new JButtonM("期初建账"),
			new JButtonM("退出") };
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public financemainui(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	JPanel contain = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgp, 0, 0, null);
		}
	};
	JPanel cmdpanel = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(cmdbgp, 0, 0, null);
		}
	};

	JPanelContent content = new JPanelContent();

	public JPanel financemainui() throws IOException {

		bgp = new ImageGet().GetFinanceImage("FinanceBGP");
		cmdbgp = new ImageGet().GetFinanceImage("FinanceCMD");

		width = bgp.getWidth(null);
		height = bgp.getHeight(null);
		cmdwidth = cmdbgp.getWidth(null);

		contain.setOpaque(false);
		contain.setBounds(0, 0, width, height);
		contain.setLayout(null);

		cmdpanel.setOpaque(false);
		cmdpanel.setBounds(0, 0, cmdwidth, height);
		cmdpanel.setLayout(null);
		AddcmdComp();

		content.setOpaque(false);
		content.setBounds(cmdwidth, 0, width, height);
		content.setLayout(null);

		contain.add(cmdpanel);
		contain.add(content);

		new AccountMan(oos, ois, emPO).AccMan(content);
		ContentRepaint();
		return contain;
	}

	public void AddcmdComp() {
		int buttonw = 191;
		int buttonh = 40;
		int gapw = 90;
		cmdbutton[0].setBounds(86, 249, buttonw, buttonh);
		cmdbutton[1].setBounds(gapw, 326, buttonw, buttonh);
		cmdbutton[2].setBounds(gapw, 389, buttonw, buttonh);
		cmdbutton[3].setBounds(gapw, 451, buttonw, buttonh);
		cmdbutton[4].setBounds(gapw, 517, buttonw, buttonh);
		cmdbutton[5].setBounds(gapw, 577, buttonw, buttonh);
		cmdbutton[6].setBounds(gapw, 639, buttonw, buttonh);
		cmdbutton[7].setBounds(gapw, 692, buttonw, buttonh);
		for (int i = 0; i < cmdbutton.length; i++) {
			cmdpanel.add(cmdbutton[i]);
			cmdbutton[i].HideTheButton();
			cmdbutton[i].addActionListener(new CmdActionListener());
		}
		JLabel emname = new JLabel(emPO.getName());
		emname.setBounds(210, 115, buttonw, buttonh);
		emname.setFont(new Font("幼圆", Font.PLAIN, 25));
		emname.setForeground(Color.white);
		JLabel emid = new JLabel(emPO.getEmpID());
		emid.setBounds(85, 210, buttonw, buttonh);
		emid.setFont(new Font("幼圆", Font.PLAIN, 25));
		emid.setForeground(Color.white);
		JLabel emposid = new JLabel(emPO.getPosID());
		emposid.setBounds(210, 210, buttonw, buttonh);
		emposid.setFont(new Font("幼圆", Font.PLAIN, 25));
		emposid.setForeground(Color.white);
		cmdpanel.add(emname);
		cmdpanel.add(emid);
		cmdpanel.add(emposid);
	}

	public class CmdActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "账户管理":
				new AccountMan(oos, ois, emPO).AccMan(content);
				ContentRepaint();
				break;
			case "查看收款单":
				new CheckBill(oos, ois, emPO).CheckBill(content);
				ContentRepaint();
				break;
			case "成本管理":
				new CostMan(oos, ois, emPO).costMan(content);
				ContentRepaint();
				break;
			case "成本收益表":
				new CostIncome(oos, ois, emPO).costincome(content);
				ContentRepaint();
				break;
			case "经营情况表":
				new StateOfRun(oos, ois, emPO).stateofrun(content);
				ContentRepaint();
				break;
			case "期初建账":
				new BuildAccount(oos, ois, emPO).buildaccount(content);
				ContentRepaint();
				break;
			case "导出表单":
				ContentRepaint();
				break;
			default:
				System.exit(1);
				break;
			}
		}
	}

	public void ContentRepaint() {
		content.repaint();
		content.revalidate();
	}
}
