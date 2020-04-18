package spaceCat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*main game interface*/
public class Game extends JPanel{
	
	
	//something in Game
	public Character character;
	public BackGround startBGR;
	public BackGround background1;
	public BackGround background2;
	public BackGround gameoverimg;

	public BufferedImage cry;
	public BufferedImage angry;
	public BufferedImage wink;
	public BufferedImage happy;
	public BufferedImage wow;
	
	public BufferedImage allemoji;
	
	
	public SpaceItem bad;
	ProgressBar p1;
	ProgressBar2 p2;
	
	////
	int countEnergyBut = 0;
	public List<EnergyButtle> list;
	public List<Obstacle> list2;
	public List<Integer> energyList;
	/////

	public JLabel finalscore;
	

	long emojiTime ;
	
	private String state; //1.start, 2.gaming, 3.pause, 4.gameover
	private String emoji;

	//Initialize Game
	public Game() {
		super();
        this.setOpaque(false);
		character = new Character();
		energyList = new ArrayList<>();
		energyList.add(100);
		background1 = new BackGround(0,0,"src/bg_uchu_space2.jpg");
		background2 = new BackGround(0,-1200,"src/bg_uchu_space2.jpg");
		gameoverimg = new BackGround(0,300,"src/gameover.png");
		
		startBGR = new BackGround(0,0,"src/start.jpg");
		
		try {
			cry = (BufferedImage)ImageIO.read(new File("src/unhappy.png"));
			angry = (BufferedImage)ImageIO.read(new File("src/angry.png"));
			happy = (BufferedImage)ImageIO.read(new File("src/happy.png"));
			wink = (BufferedImage)ImageIO.read(new File("src/wink.png"));
			wow = (BufferedImage)ImageIO.read(new File("src/surprised.png"));
			allemoji = (BufferedImage)ImageIO.read(new File("src/allemoji.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state = "start";
		emoji ="";
		/////
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		energyList = new ArrayList<>();
		energyList.add(100);
		////

		ActionListener timeListener = new TimerListener(this.list,this.character,this.countEnergyBut,this.list2,this.energyList);//initialize timerlistener
		Timer timer = new Timer(200, timeListener);     
		timer.start();  
		/////
		//bad = new Obstacle("src/comet.png");
		

		
	}
	@Override
	public void paint(Graphics g) {
		if(state == "gaming" || state == "gameover") {
			/*scrolling backgroundimg*/
			if(background1.y > background2.y) {
				g.drawImage(background2.img, background2.x,background2.y ,null);
				g.drawImage(background1.img, background1.x,background1.y ,null);
			}
			else {
				g.drawImage(background1.img, background1.x,background1.y ,null);
				g.drawImage(background2.img, background2.x,background2.y ,null);
			}
			
			g.drawImage(character.sining.img, character.x + character.img.getWidth()/2 - character.sining.img.getWidth()/2, character.sining.y , null);
			g.drawImage(character.sining.img, character.x + character.img.getWidth()/2 - character.sining.img.getWidth()/2, character.sining.y - 30 , null);
			g.drawImage(character.sining.img, character.x + character.img.getWidth()/2 - character.sining.img.getWidth()/2, character.sining.y - 60 , null);
			g.drawImage(character.sining.img, character.x + character.img.getWidth()/2 - character.sining.img.getWidth()/2, character.sining.y - 90 , null);
			g.drawImage(character.img, character.x, character.y, null);
			
			
			if(emoji=="happy") {
				g.drawImage(happy,character.x+35,character.y-50, null);
				if(System.currentTimeMillis()-emojiTime >=2000)
					emoji="";
			}
			else if(emoji=="wow") {
				g.drawImage(wow,character.x+35,character.y-50, null);
				if(System.currentTimeMillis()-emojiTime >=2000)
					emoji="";
			}
			else if(emoji=="cry") {
				g.drawImage(cry,character.x+35,character.y-50, null);
				if(System.currentTimeMillis()-emojiTime >=2000)
					emoji="";
			}
			else if(emoji=="wink") {
				g.drawImage(wink,character.x+35,character.y-50, null);
				if(System.currentTimeMillis()-emojiTime >=2000)
					emoji="";
			}
			else if(emoji=="angry") {
				g.drawImage(angry,character.x+35,character.y-50, null);
				if(System.currentTimeMillis()-emojiTime >=2000)
					emoji="";
			}

			
			/////}
			 for (int i = 0; i < list.size(); i++) {
		 		EnergyButtle a = list.get(i);
	
	            g.drawImage(a.img, a.x, a.y, a.img.getWidth(),a.img.getHeight(),null);
	            //System.out.println(list.size());
			 }
			 for (int i = 0; i < list2.size(); i++) {
			 	Obstacle a = list2.get(i);
			 
		        g.drawImage(a.img, a.x, a.y, a.img.getWidth(),a.img.getHeight(),null);
			   //System.out.println(list.size());
			 }
			 /////
			 g.drawImage(allemoji, 4, 525, null);
			 if (state=="gameover") {
					g.drawImage(gameoverimg.img, 30,150 ,null);
				}


		}
		
		super.paintComponents(g); 
		
	}
	
	public void setEmoji(String n) {
		emoji = n;
		System.out.println("emoji "+n);
		emojiTime = System.currentTimeMillis();
	}
	public String getState() {
		return state;
	}
	public void setState(String newState) {
		state = newState;
		System.out.println("state is "+state+" now.");
	}
	
}
	


