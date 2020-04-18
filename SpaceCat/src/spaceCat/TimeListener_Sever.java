package spaceCat;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class TimeListener_Sever implements ActionListener{
	public List<EnergyButtle> listButtles;
	public List<Obstacle> listObstacles;
	public List<Integer> listEnergy;
	public List<Integer> listEnergy2;
	public Character me;
	public Character other;

	public TimeListener_Sever(List<EnergyButtle> list1, Character character, int number, List<Obstacle> list2,
			List<Integer> list3,Character otherCharacter,List<Integer>list4) {
		 this.listButtles = list1;
		 this.listObstacles = list2;
		 this.listEnergy = list3;
		 this.me = character;
		 this.listEnergy2 = list4;
		 this.other = otherCharacter;
		// TODO Auto-generated constructor stub
		
	}
	
	public void collapse(List<EnergyButtle> list,Character me,List<Obstacle> list3,List<Integer> energy, Character other,List<Integer> energy2) {
		 int blood = energy.get(0);
		 int blood2 = energy2.get(0);
		 //Random rand = new Random();
    	 for (int i = 0; i < list.size(); i++) {           //iterate the energybuttlelist
 			EnergyButtle a = list.get(i);
 			Rectangle characterRectangle = new Rectangle(me.x,me.y,me.img.getWidth(),me.img.getHeight());
 			Rectangle energyRectangle = new Rectangle(a.x, a.y,a.img.getWidth(), a.img.getHeight());
 			Rectangle otheRectangle = new Rectangle(other.x, other.y, other.img.getWidth(), other.img.getHeight());
 			if (characterRectangle .intersects(energyRectangle)) {
 				Random rand = new Random();
 				  if(rand.nextInt(2) == 0)
 					 list.get(i).y = -200;  
 				  else
 					 list.get(i).y = -140;        
 				                     //remove energybuttle from the frame
 	                                                             //subtract countnumber
 				blood = blood +1;                                    //add blood
 				energy.remove(0);                           //pass blood value to the game class
 				energy.add(blood);
 				break;
  
 			}
	        if (otheRectangle.intersects(energyRectangle)) {
	        	Random rand = new Random();
	        	 if(rand.nextInt(2) == 0)
 					 list.get(i).y = -200;  
 				  else
 					 list.get(i).y = -140;                    //remove energybuttle from the frame
 	                                                             //subtract countnumber
 				blood2 = blood2 +1;                                    //add blood
 				energy2.remove(0);                           //pass blood value to the game class
 				energy2.add(blood2);
 				break;
  
 			}
 			if(a.y > 500)
 			{
 				Random rand = new Random();
	        	 if(rand.nextInt(2) == 0)
					 list.get(i).y = -200;  
				  else
					 list.get(i).y = -140;      
 			
 			}
    	 }
    	 
    	 for (int i = 0; i < list3.size(); i++) {           //detect obstacle intersect
	 			Obstacle a = list3.get(i);
	 			Rectangle characterRectangle = new Rectangle(me.x,me.y,me.img.getWidth(),me.img.getHeight());
	 			Rectangle obstacleRectangle = new Rectangle(a.x, a.y,a.img.getWidth(), a.img.getHeight());
	 			Rectangle otheRectangle = new Rectangle(other.x, other.y, other.img.getWidth(), other.img.getHeight());
	 			if (characterRectangle .intersects(obstacleRectangle)) {
	 				Random rand = new Random();
		        	 if(rand.nextInt(2) == 0)
	 					 list3.get(i).y = -200;  
	 				  else
	 					 list3.get(i).y = -140;                            //remove this obstacle from list
	 				blood--;
	 				energy.remove(0);
	 				energy.add(blood);
	 				break;
	  
	 			}
	 			if (otheRectangle.intersects(obstacleRectangle)) {
	 				Random rand = new Random();
		        	 if(rand.nextInt(2) == 0)
	 					 list3.get(i).y = -200;  
	 				  else
	 					 list3.get(i).y = -140;                                     //remove this obstacle from list
	 				blood2--;
	 				energy2.remove(0);
	 				energy2.add(blood2);
	 				break;
	  
	 			}

	 			if(a.y > 500)
	 			{
	 				Random rand = new Random();
		        	 if(rand.nextInt(2) == 0)
	 					 list3.get(i).y = -100;  
	 				  else
	 					 list3.get(i).y = -40;           
	 			}
	    	 }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		collapse(listButtles, this.me, listObstacles, listEnergy, this.other,listEnergy2);
	}}
