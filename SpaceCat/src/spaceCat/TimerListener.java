package spaceCat;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;


public class TimerListener implements ActionListener{
	public List<EnergyButtle> listButtles;
	public List<Obstacle> listObstacles;
	public List<Integer> listEnergy;
	public Character me;
	public int countEnergyBut ;
	public int countObstacle = 0;
	public int[] xcoord;
	public int countIndex = 0;
	public TimerListener(List<EnergyButtle> list1, Character character,int number,List<Obstacle> list2,List<Integer> list3) {
		// TODO Auto-generated constructor stub
		 xcoord = new int[8];
		 randGenerate();
		 this.listButtles = list1;
		 this.listObstacles = list2;
		 this.listEnergy = list3;
		 this.me = character;
		 this.countEnergyBut = number;
		// xcoord = new int[8];
		// randGenerate();
	
	}
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 collapse(listButtles, me,listObstacles,listEnergy);
	
	}
	public void collapse(List<EnergyButtle> list,Character me,List<Obstacle> list3,List<Integer> energy) {
	    	 int blood = energy.get(0);
	    	 for (int i = 0; i < list.size(); i++) {           //iterate the energybuttlelist
	 			EnergyButtle a = list.get(i);
	 			Rectangle characterRectangle = new Rectangle(me.x,me.y,me.img.getWidth(),me.img.getHeight());
	 			Rectangle energyRectangle = new Rectangle(a.x, a.y,a.img.getWidth(), a.img.getHeight());
	 			if (characterRectangle .intersects(energyRectangle)) {
	 				System.out.println("get energy!");
	 				list.remove(i);                             //remove energybuttle from the frame
	 				countEnergyBut--;                           //subtract countnumber
	 				blood = blood +1;                                    //add blood
	 				energy.remove(0);                           //pass blood value to the game class
	 				energy.add(blood);
	 				break;
	  
	 			}
	 			if(a.y > 500)
	 			{
	 				list.remove(i); 
	 				countEnergyBut--;  
	 			}
	    	 }
	    	 
	    	 for (int i = 0; i < list3.size(); i++) {           //detect obstacle intersect
		 			Obstacle a = list3.get(i);
		 			Rectangle characterRectangle = new Rectangle(me.x,me.y,me.img.getWidth(),me.img.getHeight());
		 			Rectangle obstacleRectangle = new Rectangle(a.x, a.y,a.img.getWidth(), a.img.getHeight());
		 			if (characterRectangle .intersects(obstacleRectangle)) {
		 				System.out.println("no!!hit!");
		 				list3.remove(i);                             //remove this obstacle from list
		 				countObstacle--;
		 				blood--;
		 				energy.remove(0);
		 				energy.add(blood);
		 				break;
		  
		 			}
		 			if(a.y > 500)
		 			{
		 				list3.remove(i);  
		 				countObstacle--;
		 			}
		    	 }
	    	 
	    	 if(countIndex==7) {
	    		 countIndex = 0;
	    		 randGenerate();
	    	 } 
	    	 if(countEnergyBut < 1)
			  {
				  
				  SpaceItem item = new EnergyButtle("src/energy.png",xcoord[countIndex]);
				  this.countEnergyBut = this.countEnergyBut + 1;
				 
				  list.add((EnergyButtle)item);
				  countIndex++;
			  }	  
	    	 if(countIndex==7) {
	    		 countIndex = 0;
	    		 randGenerate();
	    	
	    	 } 
	    	 if(countObstacle <2)
			  {
				  Random rand = new Random();
				  String rockpath;
				  if(rand.nextInt(2) == 0)
					  rockpath = "src/comet.png";
				  else
					  rockpath = "src/rock.png";
				  SpaceItem item = new Obstacle(rockpath,xcoord[countIndex]);
				  this.countObstacle = this.countObstacle + 1;
				 
				  list3.add((Obstacle)item);
				  countIndex++;
			  }	  
	    	     
	       }
	   public void randGenerate() {
		   
		 //  int[] result = new int[8]; 
		    
			int count = 0; 
			while(count < 8) { 
			   int num = (int) (Math.random() * 336); 
			   boolean flag = true; 
			   for (int j = 0; j < 8; j++  ) { 
			       if(Math.abs(num - xcoord[j])<20){ 
			       flag = false; 
			       break; 
			      } 
			   } 
			   if(flag){ 
			       xcoord[count] = num; 
			     //  System.out.println(xcoord[count]);
			       count++  ; 
			
			   } 
			}
	   }   
}

