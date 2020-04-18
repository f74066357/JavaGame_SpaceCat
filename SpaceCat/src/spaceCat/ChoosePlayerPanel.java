package spaceCat;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ChoosePlayerPanel extends JPanel{
	BackGround bkg;
	JPanel contentP;
	JButton btnOne;
	ImageIcon btnOneImg;
	JButton btnTwo;
	ImageIcon btnTwoImg;

	
	public ChoosePlayerPanel() {
		bkg = new BackGround(0,0,"src/ChoosePlayer.jpg");
		contentP = new JPanel();
		
		/*Start button*/
		btnOneImg = new ImageIcon("src/btnOnePlayer.png");
		btnOne = new JButton();
		btnOne.setOpaque(false);  
		btnOne.setContentAreaFilled(false);  
		btnOne.setFocusPainted(false);
		btnOne.setBorder(null); 
		btnOne.setIcon(btnOneImg);
		btnOne.setBounds(bkg.img.getWidth()/2 - btnOneImg.getIconWidth()/2, 200, btnOneImg.getIconWidth()+10, btnOneImg.getIconHeight());
		
		btnTwoImg = new ImageIcon("src/btnTwoPlayer.png");
		btnTwo = new JButton();
		btnTwo.setOpaque(false);  
		btnTwo.setContentAreaFilled(false);  
		btnTwo.setFocusPainted(false);
		btnTwo.setBorder(null); 
		btnTwo.setIcon(btnTwoImg);
		btnTwo.setBounds(bkg.img.getWidth()/2 - btnTwoImg.getIconWidth()/2, 400, btnTwoImg.getIconWidth()+10, btnTwoImg.getIconHeight());
		
		
		/*gif*/
		ImageIcon rocketGIF = new ImageIcon("src/Srocket.gif");
		JLabel lbRocket = new JLabel(rocketGIF);
		lbRocket.setBounds(bkg.img.getWidth()/2 - rocketGIF.getIconWidth()/2,100, rocketGIF.getIconWidth()-4,  rocketGIF.getIconHeight());
		
		ImageIcon rocketGIF1 = new ImageIcon("src/Srocket.gif");
		JLabel lbRocket1 = new JLabel(rocketGIF1);
		lbRocket1.setBounds(bkg.img.getWidth()/2 - rocketGIF1.getIconWidth()/2-30,300, rocketGIF1.getIconWidth() -4,  rocketGIF1.getIconHeight());
		
		ImageIcon rocketGIF2 = new ImageIcon("src/Brocket.gif");
		JLabel lbRocket2 = new JLabel(rocketGIF2);
		lbRocket2.setBounds(bkg.img.getWidth()/2 - rocketGIF2.getIconWidth()/2+30,300, rocketGIF2.getIconWidth()-4,  rocketGIF2.getIconHeight());
		
		
		contentP.setLayout(null);
        contentP.setOpaque(false);
        contentP.add(btnOne);
        contentP.add(btnTwo);
        contentP.add(lbRocket);
        contentP.add(lbRocket1);
        contentP.add(lbRocket2);
        
        this.setLayout(new java.awt.BorderLayout());
        this.add(contentP, BorderLayout.CENTER);
	}
	@Override
	public void paint(Graphics g) {		
		g.drawImage(bkg.img,0,0,null);

		super.paintComponents(g); 	
	}
}
