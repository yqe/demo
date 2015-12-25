package login;

import image.ImageGet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Mdialog extends JDialog{
	private ImageIcon background;
	MTextfield output=new MTextfield();
	private int xx, yy;
	private boolean isDraging;
	JButton exit=new JButton();
	
	public Mdialog(String input){
		super();
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("error");
		background = new ImageIcon(bgp);
		JPanel back = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};
		back.setBounds(0, 0, 300, 150);
		back.setLayout(null);
		back.setOpaque(false);
		
		exit.setContentAreaFilled(false);
		exit.setBorder(BorderFactory.createEmptyBorder());
		exit.setBounds(265, 0, 35, 28);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		output.HideTheField();
//		output.settextFont();
		output.setForeground(Color.white);
		output.setFont(new Font("幼圆",Font.BOLD,20));
		
		output.setBounds(50,50,200,30);
		output.setText(input);
		output.setEditable(false);
		
		this.add(output);
		this.add(exit);
		this.add(back);
		
		
		setBounds(800, 300, 300, 150);
		setUndecorated(true);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
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
		
	};
	
	public static void showMessageDialog(String input){
		Mdialog m=new Mdialog(input);
	}
	
	
}
