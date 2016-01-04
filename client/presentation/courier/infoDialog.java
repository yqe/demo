package courier;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

import image.ImageGet;
import login.MTextfield;

public class infoDialog extends JDialog implements ActionListener {
	private ImageIcon background;
	private int xx, yy;
	private boolean isDraging;


	MTextfield namet = new MTextfield();
	MTextfield homesitet = new MTextfield();
	MTextfield worksitet = new MTextfield();
	MTextfield telt = new MTextfield();
	
	


	 JButton ok=new JButton();
	infoDialog(String name,String home,String workspace,String tel) throws IOException {
		new ImageGet();
        Image bgp=ImageGet.getImageByState("infodialog");
		background = new ImageIcon(bgp);
		JPanel back = new JPanel()
		{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};
		back.setBounds(0, 0, 350, 323);
		back.setLayout(null);
		back.setOpaque(false);
		
		namet.settextFont();
    	namet.setOpaque(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		namet.setEditable(false);
		homesitet.settextFont();
		homesitet.setOpaque(false);
		homesitet.setBorder(BorderFactory.createEmptyBorder());
		homesitet.setEditable(false);
		worksitet.settextFont();
		worksitet.setOpaque(false);
		worksitet.setEditable(false);
		worksitet.setBorder(BorderFactory.createEmptyBorder());
		telt.setOpaque(false);
		telt.settextFont();
		telt.setBorder(BorderFactory.createEmptyBorder());
		telt.setEditable(false);
		
		
		setBounds(800, 200, 350, 323);
		setResizable(false);
		setLayout(null);
	
		

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
		

		
		namet.setBounds(108, 30+46, 120, 28);
		homesitet.setBounds(108, 80+45, 204, 28);
		worksitet.setBounds(108, 130+45, 204, 28);
		telt.setBounds(108, 180+40, 120, 28);
		
		setUndecorated(true);
		setResizable(false);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				xx = e.getX();
				yy = e.getY();
			}

			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) {
					int left = getLocation().x;
					int top = getLocation().y;
					setLocation(left + e.getX() - xx, top + e.getY() - yy);
				}
			}
		});

		 add(ok);
		 ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		 ok.setOpaque(false);
		 ok.setBounds(316, 0, 34, 23);
	}

	public void actionPerformed(ActionEvent e) {
     
	}

}
