package spaceCat;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class IntoPanel extends JPanel{
	BackGround bkg;
	JPanel contentP;
	JButton btnOK;
	ImageIcon btnOKImg;
	public IntoPanel(){
		bkg = new BackGround(0,0,"src/intro.png");
		contentP = new JPanel();
		btnOKImg = new ImageIcon("src/okbtn.png");
		btnOK = new JButton();
		btnOK.setOpaque(false);  
		btnOK.setContentAreaFilled(false);  
		btnOK.setFocusPainted(false);
		btnOK.setBorder(null); 
		btnOK.setIcon(btnOKImg);
		btnOK.setBounds(bkg.img.getWidth()/2 - btnOKImg.getIconWidth()/2 , 430, btnOKImg.getIconWidth(), btnOKImg.getIconHeight());
		contentP.setLayout(null);
        contentP.setOpaque(false);
        contentP.add(btnOK);

        
        this.setLayout(new java.awt.BorderLayout());
        this.add(contentP, BorderLayout.CENTER);
		
	}
	@Override
	public void paint(Graphics g) {		
		g.drawImage(bkg.img,0,0,null);

		super.paintComponents(g); 	
	}
}
