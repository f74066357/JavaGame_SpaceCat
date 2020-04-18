package spaceCat;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
	BackGround bkg;
	JPanel contentP;
	JButton btnStart;
	ImageIcon btnStartImg;
	JButton btnQ;
	ImageIcon btnQImg;
	
	public StartPanel() {
		bkg = new BackGround(0,0,"src/start.jpg");
		
		contentP = new JPanel();
		
		/*Start button*/
		btnStartImg = new ImageIcon("src/startbtn.png");
		btnStart = new JButton();
		btnStart.setOpaque(false);  
		btnStart.setContentAreaFilled(false);  
		btnStart.setFocusPainted(false);
		btnStart.setBorder(null); 
		btnStart.setIcon(btnStartImg);
		btnStart.setBounds(bkg.img.getWidth()/2 - btnStartImg.getIconWidth()/2, 440, btnStartImg.getIconWidth()+10, btnStartImg.getIconHeight());
		
		btnQImg = new ImageIcon("src/questionbtn.png");
		btnQ = new JButton();
		btnQ.setOpaque(false);  
		btnQ.setContentAreaFilled(false);  
		btnQ.setFocusPainted(false);
		btnQ.setBorder(null); 
		btnQ.setIcon(btnQImg);
		btnQ.setBounds(275, 460, btnQImg.getIconWidth(), btnQImg.getIconHeight());
		
		/*gif*/
		ImageIcon rocketGIF = new ImageIcon("src/rocket.gif");
		JLabel lbRocket = new JLabel(rocketGIF);
		lbRocket.setBounds(bkg.img.getWidth()/2 - rocketGIF.getIconWidth()/2,250, rocketGIF.getIconWidth(),  rocketGIF.getIconHeight());
		
		
		contentP.setLayout(null);
        contentP.setOpaque(false);
        contentP.add(btnStart);
        contentP.add(btnQ);
        contentP.add(lbRocket);
        
        this.setLayout(new java.awt.BorderLayout());
        this.add(contentP, BorderLayout.CENTER);
        
		
	}
	@Override
	public void paint(Graphics g) {		
		g.drawImage(bkg.img,0,0,null);

		super.paintComponents(g); 	
	}
}
