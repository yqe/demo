package storage;

import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import image.ImageGet;
import login.MTextfield;
import login.Mdialog;
import po.EmploeePO;
import po.StorageAlarmPO;
import storagebl.StorageBl;

public class countstorage {
	private JPanel imagePanel;
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;
	JPanel p1 = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background.getImage(), 0, 0, null);
		}
	};

	public countstorage(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel() throws IOException {
		new ImageGet();
		Image bgp = ImageGet.getImageByState("countstorage");
		background = new ImageIcon(bgp);

		p1.setBounds(0, 0, 988, 756);
		p1.setLayout(null);

		String[] columnnames = { "", "", "", "", "", "", "" };
		Object[][] data = {};

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		JTable table = new JTable(model){
			   public Component prepareRenderer(TableCellRenderer renderer,
					     int row, int column) {
					    Component c = super.prepareRenderer(renderer, row, column);
					    if (c instanceof JComponent) {
					     ((JComponent) c).setOpaque(false);
					    }
					    return c;
					   }
					  };
	    table.setRowHeight(22);		  
	    
					  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		
		TableColumn Column0 = table.getColumnModel().getColumn(0); 
		Column0.setPreferredWidth(82);
		
		TableColumn Column1 = table.getColumnModel().getColumn(1);
		Column1.setPreferredWidth(108);
		
		TableColumn Column2 = table.getColumnModel().getColumn(2);
		Column2.setPreferredWidth(67);
		
		TableColumn Column3 = table.getColumnModel().getColumn(3);
		Column3.setPreferredWidth(55);
		
		TableColumn Column4 = table.getColumnModel().getColumn(4);
		Column4.setPreferredWidth(59);
		
		TableColumn Column5 = table.getColumnModel().getColumn(5);
		Column5.setPreferredWidth(57);
		
		TableColumn Column6 = table.getColumnModel().getColumn(6);
		Column6.setPreferredWidth(57);
		

		JScrollPane jp = new JScrollPane(table);
		

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		p1.setOpaque(false);
		p1.setLayout(null);

		p1.add(jp);

	
		jp.setBounds(164, 252, 489, 254);

		final MTextfield num = new MTextfield();
		final MTextfield alarm = new MTextfield();
		num.setBounds(302, 582, 152, 42);
		alarm.setBounds(302, 632, 152, 42);
		num.HideTheField();
		alarm.HideTheField();
		num.settextFont();
		alarm.settextFont();

		JButton okbtn = new JButton();
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alarmstr = alarm.getText();
				if (!Judgment.IsInt(num.getText()))
					Mdialog.showMessageDialog("请确定输入的库存量为整数");
				else if (!Judgment.IsPercent(alarmstr))
					Mdialog.showMessageDialog("请确定输入的库存量为百分数");
				else {
					StorageBl stobl = new StorageBl(oos, ois);
					double alarmnum = Double.parseDouble(alarmstr.substring(0, alarmstr.length() - 1));
					StorageAlarmPO alarmpo = new StorageAlarmPO(emPO.getPosID(), Integer.parseInt(num.getText()),
							alarmnum);
					if (stobl.SetStorage110(alarmpo))
						Mdialog.showMessageDialog("库存量和报警值设置成功");
				}
			}
		});
		okbtn.setBounds(475, 607, 166, 48);
		okbtn.setContentAreaFilled(false);
		okbtn.setBorder(BorderFactory.createEmptyBorder());
		p1.add(num);
		p1.add(alarm);
		p1.add(okbtn);
		return p1;
	}

	public class AlarmActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}
}