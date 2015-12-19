package courier;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class infoDialog extends JDialog implements ActionListener {
	private ImageIcon background;
	JLabel namel = new JLabel("收件人姓名:");
	JLabel homesitel = new JLabel("住址:");
	JLabel worksitel = new JLabel("单位:");
	JLabel tell = new JLabel("手机:");

	JTextField namet = new JTextField();
	JTextField homesitet = new JTextField();
	JTextField worksitet = new JTextField();
	JTextField telt = new JTextField();
	
	
	

	// JButton ok=new JButton("ȷ��");
	infoDialog(String name,String home,String workspace,String tel) throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/Cbackground.jpg"));
		background = new ImageIcon(bgp);
		JPanel back = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};
		back.setBounds(0, 0, 350, 300);
		back.setLayout(null);
		back.setOpaque(false);
    	namet.setOpaque(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		homesitet.setOpaque(false);
		homesitet.setBorder(BorderFactory.createEmptyBorder());
		worksitet.setOpaque(false);
		worksitet.setBorder(BorderFactory.createEmptyBorder());
		telt.setOpaque(false);
		telt.setBorder(BorderFactory.createEmptyBorder());
		
		
		setTitle("订单信息");
		setBounds(800, 200, 350, 300);
		setResizable(false);
		setLayout(null);
		add(namel);
		add(homesitel);
		add(worksitel);
		add(tell);

		namel.setBounds(50, 30, 80, 30);
		homesitel.setBounds(50, 80, 80, 30);
		worksitel.setBounds(50, 130, 80, 30);
		tell.setBounds(50, 180, 80, 30);

		add(namet);
		add(homesitet);
		add(worksitet);
		add(telt);

		add(back);

		namet.setOpaque(false);
		homesitet.setOpaque(false);
		worksitet.setOpaque(false);
		telt.setOpaque(false);

		namet.setEditable(false);
		homesitet.setEditable(false);
		worksitet.setEditable(false);
		telt.setEditable(false);
		
		namet.setText(name);
		homesitet.setText(home);
		worksitet.setText(workspace);
		telt.setText(tel);
		

		namet.setBounds(150, 30, 100, 30);
		homesitet.setBounds(150, 80, 100, 30);
		worksitet.setBounds(150, 130, 100, 30);
		telt.setBounds(150, 180, 100, 30);

		// add(ok);
		// ok.setBounds(150, 250, 100, 30);
	}

	public void actionPerformed(ActionEvent e) {
     
	}

}
