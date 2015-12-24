package finance;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class JPanelContent extends JPanel{

	private Image conpanel;
	
	public void setConpanel(Image conpanel) {
		this.conpanel = conpanel;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(conpanel, 0, 0, null);
	}
}
