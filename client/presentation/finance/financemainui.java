package finance;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import po.EmploeePO;

public class financemainui {

	JButton[] cmdbutton = new JButton[] { new JButton("账户管理"), new JButton("查看收款单"), new JButton("成本管理"),
			new JButton("成本收益表"), new JButton("经营情况表"), new JButton("期初建账"), new JButton("导出表单"), new JButton("退出") };
	JButton[] account = new JButton[] { new JButton("增加账户"), new JButton("删除账户"), new JButton("修改账户"),
			new JButton("查询账户") };
	JPanel cmdpanel = new JPanel();
	JPanel context = new JPanel();
	private ImageIcon background;
	int width = 980;
	int height = 700;
	int bottonnum = cmdbutton.length;
	int cmdsize = 180;
	int gapw = 30;
	int gaph = 25;
	int mgapw = gapw+10;
	int mgaph = 0;
	int bw = 120, bh = 30;
	int mbw = 100, mbh = 25;
	boolean cc = false;
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

	public JPanel financemainui() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/Fbackground.jpg"));
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
		this.CmdButtonShow(false);
		contain.add(cmdpanel);
		contain.add(context);
		new CheckBill(oos,ois,emPO).CheckBill(context);
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
				CmdButtonShow(cc);
				break;
			case "查看收款单":
				if (cc) {
					CmdButtonShow(false);
					cc = false;
				}
				new CheckBill(oos,ois,emPO).CheckBill(context);
				context.repaint();
				break;
			case "成本管理":
				if (cc) {
					CmdButtonShow(false);
					cc = false;
				}
				new CostMan(oos,ois,emPO).costMan(context);
				context.repaint();
				break;
			case "成本收益表":
				if (cc) {
					CmdButtonShow(false);
					cc = false;
				}

				new CostIncome(oos,ois,emPO).costincome(context);
				context.repaint();
				break;
			case "经营情况表":
				if (cc) {
					CmdButtonShow(false);
					cc = false;
				}
				OperateState();
				new StateOfRun(oos,ois,emPO).stateofrun(context);
				context.repaint();
				break;
			case "期初建账":
				if (cc) {
					CmdButtonShow(false);
					cc = false;
				}
				new BuildAccount(oos,ois,emPO).buildaccount(context);
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
				new AccountMan(oos,ois,emPO).AddAcc(context);
				context.repaint();
				break;
			case "删除账户":
				new AccountMan(oos,ois,emPO).DeleteAcc(context);
				context.repaint();
				break;
			case "修改账户":
				new AccountMan(oos,ois,emPO).ChangeAcc(context);
				context.repaint();
				break;
			case "查询账户":
				new AccountMan(oos,ois,emPO).CheckAcc(context);
				context.repaint();
				break;
			default:
				System.exit(1);
				break;
			}
		}
	}

	public void CmdButtonShow(boolean cc) {
		int temp = 0;
		if(cc){
			gaph=15;
			mgaph=5;
		}else{
			gaph=25;
			mgaph=0;
		}
		cmdpanel.removeAll();
		for (int i = 0; i < cmdbutton.length; i++) {
			if (i == 1 && mgaph != 0) {
				for (int j = 0; j < account.length; j++) {
					account[j].setBounds(mgapw, 200+gaph + mgaph * (j + 1) + mbh * j + bh, mbw, mbh);
					cmdpanel.add(account[j]);
					account[j].addActionListener(new AccountCmd());
				}
				temp = 5 * mgaph + (mbh << 2) - gaph;
			}
			cmdbutton[i].setBounds(gapw, 200+gaph * (i + 1) + bh * i + temp, bw, bh);
			cmdpanel.add(cmdbutton[i]);
			cmdbutton[i].addActionListener(new CmdActionListener());
		}
		cmdpanel.repaint();
	}
	
	public void OperateState() {

	}
}
