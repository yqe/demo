package manager;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import po.EmploeePO;
import emploeebl.EmploeeBl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import login.Mdialog;

public class staffchange extends JDialog implements ActionListener {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private int xx, yy;
	private boolean isDraging;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	staffchange(final EmploeePO empo,final ObjectOutputStream oos,final ObjectInputStream ois) throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("staffchange");
		background = new ImageIcon(bgp);

//		setTitle("人员调度");
		setBounds(500, 200, 800, 500);
		JPanel p1 = new JPanel() 
		{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};

		p1.setBounds(0, 0, 800, 500);
		p1.setLayout(null);
		p1.setOpaque(false);

		
		
		setUndecorated(true);
		setResizable(false);
		setLayout(null);

	

		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		JTextField t6 = new JTextField();
		JTextField t7 = new JTextField();
		JTextField t8 = new JTextField();
		
		t1.setText(empo.getEmpID());t2.setText(empo.getName());t3.setText(String.valueOf(empo.getSalary()));t4.setText(String.valueOf(empo.getAge()));
		t5.setText(empo.getIdendity());t6.setText(empo.getPhonenum());t7.setText(empo.getSex());t8.setText(empo.getAddress());			
		
		t1.setOpaque(false);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setForeground(Color.white);
		t2.setOpaque(false);
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setForeground(Color.white);
		t3.setOpaque(false);
		t3.setBorder(BorderFactory.createEmptyBorder());
		t3.setForeground(Color.white);
		t4.setOpaque(false);
		t4.setBorder(BorderFactory.createEmptyBorder());
		t4.setForeground(Color.white);
		t5.setOpaque(false);
		t5.setBorder(BorderFactory.createEmptyBorder());
		t5.setForeground(Color.white);
		t6.setOpaque(false);
		t6.setBorder(BorderFactory.createEmptyBorder());
		t6.setForeground(Color.white);
		t7.setOpaque(false);
		t7.setBorder(BorderFactory.createEmptyBorder());
		t7.setForeground(Color.white);
		t8.setOpaque(false);
		t8.setBorder(BorderFactory.createEmptyBorder());
		t8.setForeground(Color.white);

	

		

		String[] jobs = { "营业厅业务员", "快递员", "中转中心业务员", "中转中心库存管理人员", "总经理", "财务人员", "管理员" };
		final JComboBox job = new JComboBox(jobs);

		for (int i = 0; i < jobs.length; i++) {
			if (jobs[i].equals(empo.getPosition())) {
				job.setSelectedIndex(i);
				break;
			}
		}
		
		
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   setVisible(false);
			}

		});
		
		
		
		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmploeeBl embl=new EmploeeBl(oos, ois);
				EmploeePO newempo=new EmploeePO(job.getSelectedItem().toString(),empo.getEmpID(),
						empo.getName(),empo.getSalary(),empo.getSex(),empo.getAge(),
						empo.getPhonenum(),empo.getIdendity(),empo.getAddress(),empo.getArea(),empo.getPosID());
				embl.ModifyEmpInfo(newempo);
				Mdialog.showMessageDialog("修改成功!");
			}

		});

	

		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);

		add(job);

		add(b3);
		add(b4);
		add(p1);

	
	    int t1xloc=370,width=139,height=21;
//	    115 143 173 202 233 264 296  328 360
		t1.setBounds(t1xloc, 115 , width, height);
		t2.setBounds(t1xloc, 143, width, height);
		t3.setBounds(t1xloc, 202, width, height);
		t4.setBounds(t1xloc, 233, width, height);
		t5.setBounds(t1xloc, 264, width, height);
		t6.setBounds(t1xloc, 296, width, height);
		t7.setBounds(t1xloc, 328, width, height);
		t8.setBounds(t1xloc, 360, width, height);


	    t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		t8.setEditable(false);
		
		job.setBounds(t1xloc, 173, width, height);

		
		
		
		
		 b3.setContentAreaFilled(false);
		 b3.setBorder(BorderFactory.createEmptyBorder());
		 b3.setBounds(763, 0, 37, 31);
		 
	    b4.setContentAreaFilled(false);
	    b4.setBorder(BorderFactory.createEmptyBorder());
		b4.setBounds(617, 410, 134, 50);
		
		
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
					int top =getLocation().y;
				    setLocation(left + e.getX() - xx, top + e.getY() - yy);
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}