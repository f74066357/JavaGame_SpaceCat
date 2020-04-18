package spaceCat;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ShowScorePanel extends JPanel{
	BackGround bkg;
	JPanel contentP;
	JLabel [] lbscore;
	public ShowScorePanel() {
		bkg = new BackGround(0,0,"src/showscore.png");
		contentP = new JPanel();
		contentP.setLayout(null);
        contentP.setOpaque(false);
   
        
        lbscore = new JLabel[5];
		for(int i =0 ;i<=4;i++) {
			lbscore[i] = new JLabel(Integer.toString(i+1)+". ");
			lbscore[i].setFont(new java.awt.Font("Dialog", 1, 25));
			lbscore[i].setBounds(40, 180+i*40, 300, 100);
		    contentP.add(lbscore[i]);
		}
		 this.setLayout(new java.awt.BorderLayout());
	        this.add(contentP, BorderLayout.CENTER);
	}
	@Override
	public void paint(Graphics g) {		
		g.drawImage(bkg.img,0,0,null);

		super.paintComponents(g); 	
	}
}
