package spaceCat;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ChooseAnimalPanel extends JPanel{
	BackGround bkg;
	JPanel contentP;
	
	JButton btnRight;
	JButton btnLeft;
	ImageIcon [] animalImg;
	ImageIcon mainImg;
	JLabel lbimg;
	ImageIcon btnRImg;
	ImageIcon btnLImg;
	JButton btnOK;
	ImageIcon btnOKImg;
	
	JTextField input = new JTextField(15);
	LeaderBoard lea;
	
	private int whichAnimal;
	
	public ChooseAnimalPanel() {
		bkg = new BackGround(0,0,"src/chooseanimal.png");
		contentP = new JPanel();
		
		/*btn*/
		btnRImg = new ImageIcon("src/btnright.png");
		btnRight = new JButton();
		btnRight.setOpaque(false);  
		btnRight.setContentAreaFilled(false);  
		btnRight.setFocusPainted(false);
		btnRight.setBorder(null); 
		btnRight.setIcon(btnRImg);
		btnRight.setBounds(bkg.img.getWidth()-50, 260, btnRImg.getIconWidth(), btnRImg.getIconHeight());
		
		btnLImg = new ImageIcon("src/btnleft.png");
		btnLeft = new JButton();
		btnLeft.setOpaque(false);  
		btnLeft.setContentAreaFilled(false);  
		btnLeft.setFocusPainted(false);
		btnLeft.setBorder(null); 
		btnLeft.setIcon(btnLImg);
		btnLeft.setBounds(5, 260, btnLImg.getIconWidth(), btnLImg.getIconHeight());
		
		btnOKImg = new ImageIcon("src/okbtn.png");
		btnOK = new JButton();
		btnOK.setOpaque(false);  
		btnOK.setContentAreaFilled(false);  
		btnOK.setFocusPainted(false);
		btnOK.setBorder(null); 
		btnOK.setIcon(btnOKImg);
		btnOK.setBounds(bkg.img.getWidth()/2 - btnOKImg.getIconWidth()/2 , 360, btnOKImg.getIconWidth(), btnOKImg.getIconHeight());
		
		animalImg = new ImageIcon[6];
		animalImg[0] = new ImageIcon("src/cat.png");
		animalImg[0].setDescription("cat");
		animalImg[1] = new ImageIcon("src/dog.png");
		animalImg[1].setDescription("dog");
		animalImg[2] = new ImageIcon("src/lion.png");
		animalImg[2].setDescription("lion");
		animalImg[3] = new ImageIcon("src/pig.png");
		animalImg[3].setDescription("pig");
		animalImg[4] = new ImageIcon("src/pingu.png");
		animalImg[4].setDescription("pingu");
		animalImg[5] = new ImageIcon("src/bear.png");
		animalImg[5].setDescription("bear");
		whichAnimal = 0;
		
		mainImg = new ImageIcon();
		mainImg = animalImg[whichAnimal];
		
		lbimg = new JLabel(mainImg);
		lbimg.setBounds(bkg.img.getWidth()/2 - mainImg.getIconWidth()/2,200, mainImg.getIconWidth()-4,  mainImg.getIconHeight());
		
        
		input.setBounds(90,125,70,20);
		input.setSize(input.getPreferredSize());
		input.setText("Your Name");
		input.selectAll();
		
		
		contentP.setLayout(null);
        contentP.setOpaque(false);
        contentP.add(btnRight);
        contentP.add(btnLeft);
        contentP.add(btnOK);
        contentP.add(lbimg);
        contentP.add(input);
        
        this.setLayout(new java.awt.BorderLayout());
        this.add(contentP, BorderLayout.CENTER);
		
	}
	public int getwhichAnimal() {
		return whichAnimal;
	}
	public void chagewhichAnimal(int newn) {
		if(newn<=5 && newn>=0) {
			whichAnimal = newn;
			System.out.println("choose "+animalImg[whichAnimal].toString() + " now.");
			mainImg = animalImg[whichAnimal];
		}
		
	}
	@Override
	public void paint(Graphics g) {		
		g.drawImage(bkg.img,0,0,null);
		
		super.paintComponents(g); 	
	}
}
