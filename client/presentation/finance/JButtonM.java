package finance;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class JButtonM extends JButton{
	
	public JButtonM(String name) {
		super(name);
	}
	public JButtonM() {
		super();
	}
	public void HideTheButton(){
		this.setFont(new Font("幼圆", Font.BOLD, 25));
		this.setForeground(Color.white);
		this.setEnabled(true);
		this.setContentAreaFilled(false);
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
