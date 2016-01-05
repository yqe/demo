package manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import login.Mdialog;
import documentbl.DocumentBl;
import image.ImageGet;
import po.CondemnList;
import po.EmploeePO;

public class approve {

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ImageIcon background;
	private EmploeePO emPO;
	JPanel p1 = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public approve(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("approve");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 1029, 840);

		String[] columnnames = { "单据类型", "编号" };
		Object[][] data = { { "aq", "123" }, { "21", "21" } };
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
					  
	    DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
					  
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();	
		tcr.setHorizontalAlignment(JLabel.CENTER);
	    table.setOpaque(false);
	    table.setForeground(Color.white);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(31);		
		table.getTableHeader().setForeground(Color.black);
		table.getTableHeader().setFont(new Font("幼圆",Font.BOLD,20) );
		table.getColumnModel().getColumn(0).setPreferredWidth(332);// 设置宽度
		table.getColumnModel().getColumn(1).setPreferredWidth(332);
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(515 - 315, 257, 1178-507, 648-253);
		jp.setOpaque(false);
		
		jp.getViewport().setOpaque(false);

		DocumentBl dbl = new DocumentBl(oos, ois);
		CondemnList alist = dbl.GetUnapproveBill();
		int item = alist.GetSize();
		for (int i = 0; i < item; i++) {
			// System.out.println(i);
			Object[] add = { alist.GetIndexOf(i).getType(), alist.GetIndexOf(i).getID() };

			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			model1.insertRow(model1.getRowCount(), add);
		}

		JButton b4 = new JButton("");
		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ��ȡҪɾ�����,û��ѡ����-1
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				// System.out.println(row);
				if (row == -1) {
					Mdialog.showMessageDialog( "请选中通过审批的单据!");
				} else {
					model.removeRow(row);
				}
			}
		});

		p1.setOpaque(false);
		p1.setLayout(null);

		p1.add(jp);

		p1.add(b4);

		p1.setOpaque(false);

		b4.setBounds(1037 - 315, 687, 1291 - 1037, 782 - 687);

		return p1;

	}

}
