package manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class approve {
	public JPanel Panel() throws IOException{



		JPanel p1 = new JPanel();
		p1.setBounds(0,0,650,700);
		JLabel l1=new JLabel("快递物流系统");
		int b1size=30;
		l1.setFont(new Font("快递物流系统",Font.PLAIN,b1size));
		JLabel l2=new JLabel("—>批量审批");
	    int b2size=16;
	    l2.setFont(new Font("",Font.PLAIN,b2size));
		
		
		
		String[] columnnames ={ "单据名称","编号"};
		Object[][] data =
	{
		{"装车单","123456"},
			{"收款单","654321"},
			     {"寄件单","132456"},
			         {"派件单","546132"}		        
			};
		
		DefaultTableModel model=new  DefaultTableModel(data,columnnames);
		final JTable table=new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);//设置宽度
		table.getColumnModel().getColumn(1).setPreferredWidth(200);

		JScrollPane jp=new JScrollPane(table);    
        jp.setBounds(100, p1.getHeight()*2/15+50, 403, 400);
        
        jp.setOpaque(false);
        jp.getViewport().setOpaque(false);
        
        
    	JButton b4=new JButton("确认通过");
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡҪɾ�����,û��ѡ����-1
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row=table.getSelectedRow();
//				System.out.println(row);
				if(row== -1){
					JOptionPane.showMessageDialog(null,"请选中通过审批的单据!");
				}else{
					model.removeRow(row);
				}
			}
		});


        
		p1.setOpaque(false);
		p1.setLayout(null);
		
		p1.add(jp);
		p1.add(l1);
		p1.add(l2);



		p1.add(b4);
		
	   
	    p1.setOpaque(false);

		int b1xloc=p1.getWidth()*7/12+20,b1xsize=p1.getWidth()*4/25-15;
		int b1yloc=p1.getHeight()*2/15;
		int b4xloc=p1.getWidth()*3/7;
		int b4yloc=p1.getHeight()*14/17,b4ysize=p1.getHeight()*1/6;
		
		l1.setBounds(220, -20, 180, 80);

		l2.setBounds(50, b1yloc, 150, 30);


		b4.setBounds(b4xloc, b4yloc, 120, 30);
		
		
		return p1;
	
	}

}
