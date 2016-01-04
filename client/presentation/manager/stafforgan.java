package manager;

import image.ImageGet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class stafforgan extends JDialog implements ActionListener {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private int xx, yy;
	private boolean isDraging;

	stafforgan() throws IOException {
		 new ImageGet();
	        Image bgp=ImageGet.getImageByState("stafforgan");
		background = new ImageIcon(bgp);

		setTitle("人员机构调度");
		setBounds(500, 300, 800, 500);
		setResizable(false);
		setLayout(null);

		JPanel back = new JPanel() 
				{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};
		back.setBounds(0, 0, 800, 500);
		back.setLayout(null);
		back.setOpaque(false);

		setUndecorated(true);
		setResizable(false);
		
		
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}

		});

		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffchange sfc = null;
				try {
					sfc = new staffchange();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sfc.setVisible(true);
				stafforgan.this.setVisible(false);
			}

		});
		String[] columnnames = { "员工ID", "员工姓名", "职位" };
		Object[][] data = { { "000001", "安德罗妮", "营业厅业务员" }, { "000002", "蒙太奇", "营业厅业务员" },
				{ "000003", "囚徒", "营业厅业务员" } };
		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		final JTable table = new JTable(model){
			   public Component prepareRenderer(TableCellRenderer renderer,
					     int row, int column) {
					    Component c = super.prepareRenderer(renderer, row, column);
					    if (c instanceof JComponent) {
					     ((JComponent) c).setOpaque(false);
					    }
					    return c;
					   }
					  };
		
		table.getTableHeader().setFont(new Font("幼圆",Font.BOLD,20) );
		table.setForeground(Color.white);
	
		
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(151);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(2).setPreferredWidth(152);

		table.setOpaque(false);

		JScrollPane jp = new JScrollPane(table);
		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		setLayout(null);
	
		
		add(b3);
		add(b4);
		add(jp);
		add(back);

	
		 b3.setContentAreaFilled(false);
		 b3.setBorder(BorderFactory.createEmptyBorder());
		 b3.setBounds(763, 0, 37, 31);
		 
	    b4.setContentAreaFilled(false);
	    b4.setBorder(BorderFactory.createEmptyBorder());
		b4.setBounds(617, 410, 134, 50);

		jp.setBounds(197,119,459,270);
		
		
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