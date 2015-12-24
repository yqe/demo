package login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class MTextfield extends JTextField{

	public MTextfield(){
		super();
	}
	
	public void settextFont(){
		this.setFont(new Font("幼圆",Font.BOLD,24));
		this.setForeground(Color.white);
	}
	
}
