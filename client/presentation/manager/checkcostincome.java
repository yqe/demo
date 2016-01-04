package manager;

import image.ImageGet;

import java.awt.Graphics;
import java.awt.Image;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import login.MTextfield;
import po.EmploeePO;
import finance.JPanelContent;
import financebl.FinanceBl;

public class checkcostincome {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	private ImageIcon background;

	public checkcostincome(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}
	JPanel p1 = new JPanel()
	{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public JPanel checkcostincome() {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("checkcostincome");
		background = new ImageIcon(bgp);
		
		int Gapw = 420;
		int textw = 175;
		int texth = 42;

		p1.setBounds(0, 0, 1029, 840);
		p1.setOpaque(false);
		p1.setLayout(null);
		
		MTextfield[] textfield = new MTextfield[] { new MTextfield(), new MTextfield(), new MTextfield() };
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].settextFont();
			textfield[i].HideTheField();
			textfield[i].setEditable(false);
			p1.add(textfield[i]);
		}
		
		textfield[0].setBounds(Gapw, 358, textw, texth);
		textfield[1].setBounds(Gapw, 436, textw, texth);
		textfield[2].setBounds(Gapw, 554, textw, texth);
	
		FinanceBl finance = new FinanceBl(oos, ois);
		String s[] = finance.GetCostInfo();
		textfield[0].setText(s[0]);
		textfield[1].setText(s[1]);
		textfield[2].setText(s[2]);// 得到支出收入利润
		return p1;
	}

}
