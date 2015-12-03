package courier;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class infoDialog extends JDialog implements ActionListener
{   private ImageIcon background;
JLabel namel = new JLabel("收件人姓名:");
JLabel homesitel = new JLabel("住址:");
JLabel worksitel = new JLabel("单位:");
JLabel tell = new JLabel("手机:");

JTextField namet = new JTextField("姚朋");
JTextField homesitet = new JTextField("南京大学");
JTextField worksitet = new JTextField("南京大学");
JTextField telt = new JTextField("1380000578");

//   JButton ok=new JButton("ȷ��");
       infoDialog(String ID) throws IOException{    
     BufferedImage bgp=ImageIO.read(new File("D:/快递物流系统/demo/client/presentation/Cbackground.jpg"));
     background = new ImageIcon(bgp);
     JPanel back = new JPanel() {
 		public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		g.drawImage(background.getImage(), 0, 0, null);
 		}
 		};
 		back.setBounds(0, 0, 350, 300);
 		back.setLayout(null);
 		back.setOpaque(false);
 		
 		 setTitle("订单信息");
       setBounds(800,200,350,300);
       setResizable(false);
       setLayout(null);
       add(namel);
       add(homesitel);
       add(worksitel);
       add(tell);
       
       namel.setBounds(50, 30, 80, 30);
       homesitel.setBounds(50, 80, 80, 30);
       worksitel.setBounds(50, 130, 80, 30);
       tell.setBounds(50, 180, 80, 30);
       
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
       
       namet.setBounds(150, 30, 100, 30);
       homesitet.setBounds(150, 80, 100, 30);
       worksitet.setBounds(150, 130, 100, 30);
       telt.setBounds(150, 180, 100, 30);
       
//       add(ok);
//       ok.setBounds(150, 250, 100, 30);
   }
  
   public void actionPerformed(ActionEvent e)
   {
      
   }


}

