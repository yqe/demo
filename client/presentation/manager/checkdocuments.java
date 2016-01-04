package manager;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import finance.CostIncome;
import finance.JPanelContent;
import finance.StateOfRun;
import po.EmploeePO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkdocuments {
	private ImageIcon background;
	private ImageIcon button1;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private EmploeePO emPO;

	public checkdocuments(ObjectOutputStream oos, ObjectInputStream ois, EmploeePO emPO) {
		this.oos = oos;
		this.ois = ois;
		this.emPO = emPO;
	}

	public JPanel Panel(final JPanel p1) throws IOException {
		p1.removeAll();
		p1.setBounds(0, 0, 1029, 840);

		JLabel l3 = new JLabel("已选表单列表");

		final StateOfRun sr = new StateOfRun(oos, ois, emPO);
		final CostIncome cic = new CostIncome(oos, ois, emPO);
		final JPanel contain = new JPanel();
		contain.setBounds(0, 0, 720, 700);

		JButton b4 = new JButton();
		JButton b5 = new JButton();

		String[] columnnames = { "", "" };
		Object[][] data = { { "2015-11-25", "成本收益表" }, { "2015-11-20", "成本收益表" }, { "2015-09-21", "经营情况表" } };

		DefaultTableModel model = new DefaultTableModel(data, columnnames);
		JTable table = new JTable(model) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		table.setOpaque(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(328);// 设置宽度
		table.getColumnModel().getColumn(1).setPreferredWidth(352);

		JScrollPane jp = new JScrollPane(table);

		jp.setOpaque(false);
		jp.getViewport().setOpaque(false);

		p1.setOpaque(false);
		p1.setLayout(null);

		p1.add(l3);

		p1.add(b4);
		p1.add(b5);
		p1.add(jp);

		p1.setOpaque(false);

		b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setContentAreaFilled(false);
		b5.setBorder(BorderFactory.createEmptyBorder());

		b4.setBounds(500 - 315, 256, 247, 43);
		b5.setBounds(903 - 315, 256, 247, 43);
		jp.setBounds(491 - 315, 387, 328 + 357, 421);

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new StateOfRun(oos, ois, emPO).stateofrun(p1);
				p1.repaint();
				p1.revalidate();
			}
		});

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CostIncome(oos, ois, emPO).costincome(p1);
				p1.repaint();
				p1.revalidate();
			}
		});

		return p1;

	}
}