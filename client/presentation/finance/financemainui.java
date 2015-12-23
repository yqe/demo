package finance;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import image.ImageGet;
import po.EmploeePO;

public class financemainui {

	JPanel context = new JPanel();
	private Image bgp;
	private Image cmdbgp;
	int width;
	int height;
	int cmdwidth;
	JButton[] cmdbutton = new JButton[] { new JButton("返回登录界面"),new JButton("账户管理"), new JButton("查看收款单"), new JButton("成本管理"),
			new JButton("成本收益表"), new JButton("经营情况表"), new JButton("期初建账"), new JButton("退出") };
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

	public JPanel financemainui() throws IOException {

		bgp = new ImageGet().getImageByState("StorageBGP");
		cmdbgp = new ImageGet().getImageByState("StorageCMD");

		width = bgp.getWidth(null);
		height = bgp.getHeight(null);
		cmdwidth = cmdbgp.getWidth(null);

		contain.setOpaque(false);
		contain.setBounds(0, 0, width, height);
		contain.setLayout(null);

		cmdpanel.setOpaque(false);
		cmdpanel.setBounds(0, 0, cmdwidth, height);
		cmdpanel.setLayout(null);
		AddcmdButton();

		context.setOpaque(false);
		context.setBounds(cmdwidth, 0, width, height);
		context.setLayout(null);

		contain.add(cmdpanel);
		contain.add(context);
		new CheckBill(oos, ois, emPO).CheckBill(context);
		context.repaint();
		return contain;
	}

	public void AddcmdButton() {
		int buttonw=191;
		int buttonh=40;
		int gapw=88;;
		cmdbutton[0].setBounds(gapw, 249, buttonw, 33);
		cmdbutton[1].setBounds(gapw, 327, buttonw, buttonh);
		cmdbutton[2].setBounds(gapw, 390, buttonw, buttonh);
		cmdbutton[3].setBounds(gapw, 453, buttonw, buttonh);
		cmdbutton[4].setBounds(gapw, 519, buttonw, buttonh);
		cmdbutton[5].setBounds(gapw, 579, buttonw, buttonh);
		cmdbutton[6].setBounds(gapw, 639, buttonw, buttonh);
		cmdbutton[7].setBounds(gapw, 693, buttonw, buttonh);
		for (int i = 0; i < cmdbutton.length; i++) {
			cmdpanel.add(cmdbutton[i]);
		}
	}

	public void changepanel(JPanel p1) {
		contain.remove(context);
		context = p1;
		context.setBounds(cmdwidth, 0, context.getWidth(), context.getHeight());
		contain.add(context);
		context.repaint();
		contain.repaint();
		contain.revalidate();
	}

	public class CmdActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "账户管理":
				new AccountMan(oos, ois, emPO);
				break;
			case "查看收款单":
				new CheckBill(oos, ois, emPO).CheckBill(context);
				context.repaint();
				break;
			case "成本管理":
				new CostMan(oos, ois, emPO).costMan(context);
				context.repaint();
				break;
			case "成本收益表":
				new CostIncome(oos, ois, emPO).costincome(context);
				context.repaint();
				break;
			case "经营情况表":
				OperateState();
				new StateOfRun(oos, ois, emPO).stateofrun(context);
				context.repaint();
				break;
			case "期初建账":
				new BuildAccount(oos, ois, emPO).buildaccount(context);
				context.repaint();
				break;
			case "导出表单":

				break;
			default:
				System.exit(1);
				break;
			}
		}
	}

	private void ShowEmpInfo() {
		int b2size = 16;
		JLabel employid = new JLabel("工号 :");
		JLabel employjob = new JLabel("职位 :");
		employid.setFont(new Font("", Font.PLAIN, b2size));
		employjob.setFont(new Font("", Font.PLAIN, b2size));
		JTextField idt = new JTextField();
		idt.setFont(new Font("", Font.PLAIN, b2size));
		JTextField namet = new JTextField();
		namet.setFont(new Font("", Font.PLAIN, b2size));
		JTextField jobt = new JTextField();
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
		employid.setBounds(40, 150, 60, 30);
		employjob.setBounds(40, 180, 60, 30);
		namet.setBounds(40, 120, 80, 30);
		idt.setBounds(100, 150, 80, 30);
		jobt.setBounds(100, 180, 80, 30);
		idt.setText(emPO.getEmpID());
		namet.setText(emPO.getName());
		jobt.setText(emPO.getPosition());

		cmdpanel.add(employid);
		cmdpanel.add(employjob);
		cmdpanel.add(idt);
		cmdpanel.add(namet);
		cmdpanel.add(jobt);
	}

	public void OperateState() {

	}
}
