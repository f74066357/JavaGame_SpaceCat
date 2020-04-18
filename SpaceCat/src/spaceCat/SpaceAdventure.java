package spaceCat;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.event.*; 

public class SpaceAdventure extends JFrame implements ActionListener{
	StartPanel startP;
	IntoPanel intoP;
	ChoosePlayerPanel chooseP;
	ChooseAnimalPanel animalP;
	Game game;
	multiGame mGame;
	ShowScorePanel scoreP;
	
	ChooseSever_Client chooseSC;
	Timer timer;
	ProgressBar p_1;
	ProgressBar2 p_2;
	ProgressBar3 p;//one game
	String name;
	ClientThreadCode cThreadCode;
	Container cp;
	CardLayout cardlayout;
	ActionListener timeListener;
	ServerThreadCode sCode;
	boolean multi  = false;
    boolean sever = false;
    boolean client = false;
	int c;
    public SpaceAdventure(){

    	startP = new StartPanel();
    	intoP = new IntoPanel();
    	chooseP = new ChoosePlayerPanel();
    	animalP = new ChooseAnimalPanel();
    	chooseSC = new ChooseSever_Client();
    	game = new Game();
    	mGame = new multiGame();
    	scoreP = new ShowScorePanel();
    	p=new ProgressBar3(game.energyList);
    	p_1= new ProgressBar(mGame.energyList);
    	p_2 = new ProgressBar2(mGame.energyList2);
    	this.setTitle("Space Adventure");
        this.setLayout(new java.awt.BorderLayout());
      //  timeListener = new TimeListener_Sever(mGame.list,mGame.character,mGame.countEnergyBut,mGame.list2,mGame.energyList,mGame.character2,mGame.energyList2);
        
        timer=new Timer(100,this);
        timer.start();
   
        
        cp = this.getContentPane();
        cardlayout = new CardLayout();
        cp.setLayout(cardlayout);
        
        cp.add(startP,"start");
        cp.add(chooseP,"choose");
        cp.add(animalP,"animal");
        cp.add(game,"oneGame");
        cp.add(mGame,"multiGame");
        cp.add(scoreP,"score");
        cp.add(intoP,"intro");
        cp.add(chooseSC,"chooseSC");
        
        /*Start Panel*/
        startP.btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click start button");
                cardlayout.show(cp,"choose");
            }
        });
        startP.btnQ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click ? button");
                cardlayout.show(cp,"intro");

            }
        });
        
        
        /*Introduce Panel*/
        intoP.btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click OK button");
                cardlayout.show(cp,"start");

            }
        });
        
        /*Choose Player Panel*/
        chooseP.btnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click OnePlayer button");
               
                
                cardlayout.show(cp,"animal");
                
                //game.setState("gaming");
                //game.setFocusable(true);
            }
        });
        chooseP.btnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click TwoPlayer button");
                cardlayout.show(cp, "chooseSC");
                multi = true;
                animalP.input.setVisible(false);
                //cardlayout.next(cp);
            }
        });
        /*choose sever*/
        chooseSC.btnStart.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardlayout.show(cp,"animal");
				sever = true;
				
			}
		});
        /*choose client*/
        chooseSC.btnClientButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(cp,"animal");
				client = true;
			}
		});
        /*Choose Animal Panel*/
        animalP.btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	animalP.chagewhichAnimal(animalP.getwhichAnimal()+1);
            	game.character.changeAnimal(animalP.animalImg[animalP.getwhichAnimal()].toString());
                if(multi) {
                	mGame.character.changeAnimal(animalP.animalImg[animalP.getwhichAnimal()].toString());
                	
                }
            	animalP.lbimg.setIcon(animalP.mainImg);
            	
            	
            	
            	animalP.repaint();
            	
            }
        });
        animalP.btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	animalP.chagewhichAnimal(animalP.getwhichAnimal()-1);
            	game.character.changeAnimal(animalP.animalImg[animalP.getwhichAnimal()].toString());
                if(multi) {
                	mGame.character.changeAnimal(animalP.animalImg[animalP.getwhichAnimal()].toString());
                }
            	animalP.lbimg.setIcon(animalP.mainImg);
            	animalP.repaint();
            }
        });
        animalP.btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click OK button");
                
                
                /*record*/
                name = animalP.input.getText();

        		
                /*for multi*/
                if(multi) {
                	if(sever) {
                	 
                	 sCode = new ServerThreadCode(8000);
                     sCode.game = mGame;
                     sCode.start();
                     mGame.setState("gaming");
                     cardlayout.show(cp, "multiGame");
                    // p_1.timer.start();
                    // p_2.timer.start();
                     mGame.setFocusable(true);
                	}
                	else {
                     cThreadCode = new ClientThreadCode("127.0.0.1", 8000);
                     cThreadCode.game = mGame;
                     cThreadCode.start();
                     //mGame.setState("gaming");
                     cardlayout.show(cp, "multiGame");
                 	  p_1.timer.start();
                      p_2.timer.start();
						
					}
                	
                }
                else {/* for onegame*/
					
				
                    cardlayout.show(cp,"oneGame");
                
                    game.setState("gaming");
                    p.timer.start();
                    game.setFocusable(true);
                 }
            }
        });
        
		

		
        mGame.add(p_1.progressbar);	
		mGame.add(p_2.progressbar);
		mGame.add(p_1.label);
		mGame.add(p_2.label);
        
        /*One player Game*/
		game.add(p.label);		
		game.add(p.progressbar);
        this.setSize(new java.awt.Dimension(startP.bkg.img.getWidth()+10,startP.bkg.img.getHeight()));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); 		
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener());  
        this.setFocusable(true);
        
    }
    
    class MyKeyListener extends KeyAdapter{  
        public void keyPressed(KeyEvent e){   
            //System.out.println("KeyCode = "+e.getKeyCode());  
        	
            float moveSize = 10.0f;
            
			//key right
	        if(game.getState() == "gaming" && e.getKeyCode() == 39 && game.character.x + game.character.img.getWidth() + 10<= game.background1.img.getWidth()) { 
	            game.character.x+=moveSize;
	            game.character.moveright();
	            //System.out.println("move right");
	        }	        
	        //key left
	        if(game.getState() == "gaming" && e.getKeyCode() == 37 && game.character.x -10 >= 0) { //right
	        	game.character.x-=moveSize;
	        	game.character.moveleft();
	        	//System.out.println("move left");
	        }
	        
	        if(game.getState() == "gaming" && e.getKeyCode() == 65) { //A
	        	game.setEmoji("happy");

	        }
	        if(game.getState() == "gaming" && e.getKeyCode() == 83) { //s
	        	game.setEmoji("wow");

	        }
	        if(game.getState() == "gaming" && e.getKeyCode() == 68) { //d
	        	game.setEmoji("cry");

	        }
	        if(game.getState() == "gaming" && e.getKeyCode() == 70) { //F
	        	game.setEmoji("angry");

	        }
	        if(game.getState() == "gaming" && e.getKeyCode() == 71) { //G
	        	game.setEmoji("wink");

	        }
			/*for multigame */
	      //key right
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 39 && mGame.character.x + mGame.character.img.getWidth() + 10<= game.background1.img.getWidth()) { 
	        	mGame.character.x+=moveSize;
	        	mGame.character.moveright();
	            //System.out.println("move right");
	        }	        
	        //key left
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 37 && mGame.character.x -10 >= 0) { //right
	        	mGame.character.x-=moveSize;
	        	mGame.character.moveleft();
	        	//System.out.println("move left");
	        }
	        
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 65) { //A
	        	mGame.setEmoji("happy");

	        }
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 83) { //s
	        	mGame.setEmoji("wow");

	        }
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 68) { //d
	        	mGame.setEmoji("cry");

	        }
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 70) { //F
	        	mGame.setEmoji("angry");

	        }
	        if(mGame.getState() == "gaming" && e.getKeyCode() == 71) { //G
	        	mGame.setEmoji("wink");

	        }
	        
	        /*important!*/
	        repaint();
        }  
    }  
	@Override
	public void actionPerformed(ActionEvent e) { //update score
		// TODO Auto-generated method stub
		c=c+1;
		//p.progressbar.setValue(p.energy);
		p.label.setText("score:"+p.score);
		p_1.label.setText("p1_score:"+p_1.score);
		p_2.label.setText("p2_score:"+p_2.score);
		
		//System.out.println("here");

	}

    public static void main(String[] args) throws Exception {
    	
        SpaceAdventure S = new SpaceAdventure();

        S.update();
        if(S.multi == false) {
        	try {
                Thread.sleep(3000);
                S.cardlayout.show(S.cp,"score");
                FileReader fr;
    			try {
    				int i =0;
    				fr = new FileReader("record.txt");
    				BufferedReader br = new BufferedReader(fr);
                    while (br.ready()) {
                    	S.scoreP.lbscore[i].setText(Integer.toString(i+1)+".  "+br.readLine());
                    	i++;
                    }
                    S.scoreP.repaint();
                    fr.close();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
        
   
        
    }
    public void update() throws Exception {
		while(true) {
			
			
			
			if(game.getState() == "gaming") {			
				//game.list2.clear();
				game.background1.scroll();
				game.background2.scroll();
				//game.bad.move();
				game.character.sining.move();
				game.character.move();
				
				for(int i=0;i<game.list.size();i++) {
					EnergyButtle a = game.list.get(i);
					a.move();
				}
				for(int i=0;i<game.list2.size();i++) {
					Obstacle a = game.list2.get(i);
					a.move();
				}
				
			}
			if(mGame.getState()=="gaming"&&mGame.severCheck==true) {
				p_1.timer.start();
                p_2.timer.start();
                mGame.severCheck = false;
			}
			/* for multigame */
			if(mGame.getState() == "gaming") {			
				//game.list2.clear();
				mGame.background1.scroll();
				mGame.background2.scroll();
				//game.bad.move();
				mGame.character.sining.move();
				mGame.character.move();
				
				for(int i=0;i<mGame.list.size();i++) {
					EnergyButtle a =mGame.list.get(i);
					a.move();
				}
				for(int i=0;i<mGame.list2.size();i++) {
					Obstacle a = mGame.list2.get(i);
					a.move();
				}
				
			}
			
			
			
			if(p.progressbar.getValue()<=0) {
    			game.setState("gameover");
    			System.out.println("over");
    			game.repaint();
    			
    			animalP.lea.readFile();
                animalP.lea.recordScore(name,p.score);
                animalP.lea.writeFile();
        		LeaderBoard.showBoard();
        		
        		 
    			break;
    		}
			if(p_1.progressbar.getValue()<=0) {
				mGame.setState("gameover");// multigame lose
				mGame.gameoverimg = mGame.lose;
				mGame.repaint();
				break;
			}
			if(p_2.progressbar.getValue()<=0) {
				mGame.setState("gameover");// multigame win
				mGame.gameoverimg = mGame.win;
				mGame.repaint();
				break;
			}

			
            
			
			
			repaint();
			Thread.sleep(500/30);
		}
    }
   


}
