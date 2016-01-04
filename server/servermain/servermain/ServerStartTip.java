package servermain;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ServerStartTip {

	public static void show() {
		JFrame tipframe=new JFrame("ServerTip");
		tipframe.setBounds(200, 300, 200, 100);
		JLabel tip=new JLabel("服务器开启成功");
		tip.setFont(new Font("幼圆",Font.BOLD,18));
		tipframe.add(tip);
		tipframe.setVisible(true);
	}
}
