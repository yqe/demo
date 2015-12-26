package storage;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

		String[] columnnames = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		Object[][] data = {};

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		JTable table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);

		JScrollPane jp = new JScrollPane(table);

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		p1.setOpaque(false);
		p1.setLayout(null);

		p1.add(jp);

		int b1xloc = p1.getWidth() * 7 / 12 + 20, b1xsize = p1.getWidth() * 4 / 25 - 15;
		int b1yloc = p1.getHeight() * 2 / 23;
		int b4xloc = p1.getWidth() * 1 / 3;
		int b4yloc = p1.getHeight() * 4 / 15 + 20, b4ysize = p1.getHeight() * 1 / 5 + 10;

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