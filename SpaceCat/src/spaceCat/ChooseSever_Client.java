package spaceCat;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseSever_Client extends JPanel{
	BackGround bkg;
	JPanel contentP;
	JButton btnClientButton;
	JButton btnStart;
	ImageIcon btnStartImg;
	ImageIcon btnClientImg;
	public ChooseSever_Client() {
		bkg = new BackGround(0,0,"src/ChoosePlayer.jpg");
		
		contentP = new JPanel();
		
		/*choose sever or client button*/
		btnStartImg = new ImageIcon("src/btnserver.png");
		btnStart = new JButton();//SEVER BUTTON
		btnStart.setOpaque(false);  
		btnStart.setContentAreaFilled(false);  
		btnStart.setFocusPainted(false);
		btnStart.setBorder(null); 
		btnStart.setIcon(btnStartImg);
		btnStart.setBounds(bkg.img.getWidth()/2 - btnStartImg.getIconWidth()/2, 200, btnStartImg.getIconWidth()+10, btnStartImg.getIconHeight());
		
		btnClientImg = new ImageIcon("src/btnclient.png");
		btnClientButton = new JButton();//CLIENT BUTTON
		btnClientButton.setOpaque(false);  
		btnClientButton.setContentAreaFilled(false);  
		btnClientButton.setFocusPainted(false);
		btnClientButton.setBorder(null); 
		btnClientButton.setIcon(btnClientImg);
		btnClientButton.setBounds(bkg.img.getWidth()/2 - btnClientImg.getIconWidth()/2, 300, btnClientImg.getIconWidth()+10, btnClientImg.getIconHeight());
		
		
		contentP.setLayout(null);
        contentP.setOpaque(false);
        contentP.add(btnStart);
        contentP.add(btnClientButton);
        this.setLayout(new java.awt.BorderLayout());
        this.add(contentP, BorderLayout.CENTER);
        
	}
	@Override
	public void paint(Graphics g) {		
		g.drawImage(bkg.img,0,0,null);

		super.paintComponents(g); 	
	}
}