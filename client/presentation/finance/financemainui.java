package finance;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class financemainui {

	JButton[] cmdbutton = new JButton[] { new JButton("账户管理"),
			new JButton("查看收款单"), new JButton("成本管理"), new JButton("成本收益表"),
			new JButton("经营情况表"), new JButton("期初建账"), new JButton("导出表单"),
			new JButton("退出") };
	JButton[] account = new JButton[] { new JButton("增加账户"),
			new JButton("删除账户"), new JButton("修改账户"), new JButton("查询账户") };
	JPanel cmdpanel = new JPanel();
	JPanel context = new JPanel();
	private ImageIcon background;
	int width = 980;
	int height = 700;
	int bottonnum = cmdbutton.length;
	int cmdsize = 180;
	int gapw = 30;
	int gaph = 40;
	int mgapw = gapw + 10;
	int mgaph = gaph - 20;
	int bw = 0, bh = 0;
	int mbw = 0, mbh = 0;
	boolean cc = false;

	// public static void main(String[] args) {
	// financemainui fui = new financemainui();
	// }
	
	public JPanel financemainui() throws IOException {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(null);
		// setVisible(true);
		// setBounds(40, 0, width, height);
		// this.add(contain);
		
		BufferedImage bgp=ImageIO.read(new File("D:/快递物流系统/demo/client/presentation/Fbackground.jpg"));
		background = new ImageIcon(bgp);
		
		JPanel contain = new JPanel() {
				public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
				}
				};
		contain.setOpaque(false);
		contain.setBounds(0, 0, width, height);
		contain.setLayout(null);
		cmdpanel.setOpaque(false);
		cmdpanel.setBounds(0, 0, cmdsize, height);
		cmdpanel.setLayout(null);
		context.setOpaque(false);
		context.setBounds(cmdsize, 0, width, height);
		context.setLayout(null);
		this.CmdButtonShow(bw, bh, mbw, mbh);
		contain.add(cmdpanel);
		contain.add(context);
		new CheckBill().CheckBill(context);
		context.repaint();
		return contain;
	}

	public void changepanel(JPanel p1) {
		context.removeAll();
		context.add(p1);
		context.repaint();
		context.setBounds(cmdsize, 0, width, height);
		context.setLayout(null);
		context.setOpaque(false);
	}

	public class CmdActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "账户管理":
				cc = true;
				AccountCmdShow();
				break;
			case "查看收款单":
				if (cc) {
					CmdButtonShow(bw, bh, 0, 0);
					cc = false;
				}
				new CheckBill().CheckBill(context);
				context.repaint();
				break;
			case "成本管理":
				if (cc) {
					CmdButtonShow(bw, bh, 0, 0);
					cc = false;
				}
				new CostMan().costMan(context);
				context.repaint();
				break;
			case "成本收益表":
				if (cc) {
					CmdButtonShow(bw, bh, 0, 0);
					cc = false;
				}
				new CostIncome().costincome(context);
				context.repaint();
				break;
			case "经营情况表":
				if (cc) {
					CmdButtonShow(bw, bh, 0, 0);
					cc = false;
				}
				new StateOfRun().stateofrun(context);
				context.repaint();
				break;
			case "期初建账":
				if (cc) {
					CmdButtonShow(bw, bh, 0, 0);
					cc = false;
				}
				new BuildAccount().buildaccount(context);
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

	public class AccountCmd implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "增加账户":
				new AccountMan().AddAcc(context);
				context.repaint();
				break;
			case "删除账户":
				new AccountMan().DeleteAcc(context);
				context.repaint();
				break;
			case "修改账户":
				new AccountMan().ChangeAcc(context);
				context.repaint();
				break;
			case "查询账户":
				new AccountMan().CheckAcc(context);
				context.repaint();
				break;
			default:
				System.exit(1);
				break;
			}
		}
	}

	public void CmdButtonShow(int bw, int bh, int mbw, int mbh) {
		int temp = 0;
		if (mbw == 0) {
			bw = cmdsize - (gapw << 1);
			bh = (height - gaph) / bottonnum - gaph;
		}
		cmdpanel.removeAll();
		for (int i = 0; i < cmdbutton.length; i++) {
			if (i == 1 && mbw != 0) {
				for (int j = 0; j < account.length; j++) {
					account[j].setBounds(mgapw, gaph + mgaph * (j + 1) + mbh
							* j + bh, mbw, mbh);
					cmdpanel.add(account[j]);
					account[j].addActionListener(new AccountCmd());
				}
				temp = 5 * mgaph + (mbh << 2) - gaph;
			}
			cmdbutton[i]
					.setBounds(gapw, gaph * (i + 1) + bh * i + temp, bw, bh);
			cmdpanel.add(cmdbutton[i]);
			cmdbutton[i].addActionListener(new CmdActionListener());
		}
		cmdpanel.repaint();
	}

	public void AccountCmdShow() {
		int mbw = cmdsize - (mgapw << 1);
		int mbh = (height - (gaph << 3) - mgaph * 5 - 40) / 12;
		int bw = cmdsize - (gapw << 1);
		int bh = mbh + 5;
		CmdButtonShow(bw, bh, mbw, mbh);
	}
}

