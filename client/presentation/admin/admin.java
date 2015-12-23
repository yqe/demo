package admin;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.loginframe;
import po.EmploeePO;
import courier.Send;
import courier.check;
import courier.dispatch;

public class admin {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	int size = 356;
	JPanel content = new JPanel();
	final JPanel control = new JPanel(){public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
	};
	public Socket socket;
	public ObjectOutputStream oos;
	public ObjectInputStream ois;
	public EmploeePO empPO;
	JPanel admin = new JPanel() ;

	public admin(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, EmploeePO emPO) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
		this.empPO = emPO;
	}

	public JPanel Panel() throws IOException {
		BufferedImage bgp = ImageIO.read(getClass().getResource("/presentation/admincontrol.jpg"));
		background = new ImageIcon(bgp);
		int b2size=16;
		admin.setBounds(0, 0, 1344, 756);

		admin.setOpaque(false);
		admin.setLayout(null);

		final changepasswordmain change = new changepasswordmain(oos,ois,empPO);

		control.setBounds(0, 0, size,756);
		content.setBounds(size, 0, 988, 756);

		JButton b3 = new JButton("退出");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					oos.close();
					ois.close();
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		JButton b4 = new JButton("修改账户密码");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changepanel(change.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		JButton b5 = new JButton("注销账户");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final logoff logoff = new logoff(oos,ois,empPO);
					changepanel(logoff.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton b6 = new JButton("修改权限");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final authority au = new authority(oos,ois,empPO);
					changepanel(au.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JButton b7 = new JButton("增加用户");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					final adduser add = new adduser(oos,ois,empPO);
					changepanel(add.Panel());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		control.setLayout(null);
		control.setOpaque(false);
		JLabel employid=new JLabel("工号 :");
		JLabel employjob=new JLabel("职位 :");
		employid.setFont(new Font("", Font.PLAIN, b2size));
		employjob.setFont(new Font("", Font.PLAIN, b2size));
		
		JTextField idt=new JTextField();
		idt.setFont(new Font("", Font.PLAIN, b2size));
		JTextField namet=new JTextField();
		namet.setFont(new Font("", Font.PLAIN, b2size));
		JTextField jobt=new JTextField();
		jobt.setFont(new Font("", Font.PLAIN, b2size));
		
		idt.setOpaque(false);
		idt.setEditable(false);
		idt.setBorder(BorderFactory.createEmptyBorder());
		namet.setOpaque(false);
		namet.setEditable(false);
		namet.setBorder(BorderFactory.createEmptyBorder());
		jobt.setOpaque(false);
		jobt.setEditable(false);
		jobt.setBorder(BorderFactory.createEmptyBorder());	
		employid.setBounds(40, 210, 60, 30);
		employjob.setBounds(40, 250,60, 30);		
		namet.setBounds(40, 170, 80, 30);
		idt.setBounds(100, 210, 80, 30);
		jobt.setBounds(100, 250, 80, 30);
	
		idt.setText(empPO.getEmpID());
		namet.setText(empPO.getName());
		jobt.setText(empPO.getPosition());

		
		control.add(employid);
		control.add(employjob);
		control.add(idt);
		control.add(namet);
		control.add(jobt);
	
		control.add(b3);
		control.add(b4);
		control.add(b5);
		control.add(b6);
		control.add(b7);

		int b4xloc = size / 6, b4yloc = 3*control.getHeight() / 7, b4ysize = control.getHeight() / 9;
		b4.setBounds(b4xloc, b4yloc, 120, 30);
		b5.setBounds(b4xloc, b4yloc + b4ysize, 120, 30);
		b6.setBounds(b4xloc, b4yloc + 2 * b4ysize, 120, 30);
		b3.setBounds(b4xloc, b4yloc + 4 * b4ysize, 120, 30);
		b7.setBounds(b4xloc, b4yloc + 3 * b4ysize, 120, 30);

		content.add(change.Panel());
		content.setLayout(null);
		content.setOpaque(false);

		admin.add(control);
		admin.add(content);

		return admin;

	}

	public void changepanel(JPanel p1) {
		admin.remove(content);
		content=p1;
		content.setBounds(size, 0, content.getWidth(), content.getHeight());
		admin.add(content);
		admin.repaint();
	}

}