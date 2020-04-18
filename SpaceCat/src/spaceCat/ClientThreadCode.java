package spaceCat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ClientThreadCode extends Thread implements ActionListener{
	  private Socket m_socket;
	  
	  public multiGame game;  
	  Boolean firstBoolean = true;
	    public ClientThreadCode(String ip, int port)
	    {
	        try
	        {
	            m_socket = new Socket(ip, port);
	        }
	        catch (IOException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    @Override
	    public void run()
	    {
	        try
	        {
	            if (m_socket != null)
	            {
	                game.timer.start();    
	       	    	//ActionListener timeListener = new TimerListener(game.list,game.character,game.countEnergyBut,game.list2,game.energyList);//initialize timerlistener
	       			//Timer timer = new Timer(1000, timeListener);    
	                game.setState("gaming");
	       			Timer timer2 = new Timer(100, this);
	       			timer2.start();
	       			                                //timer start
	       	     
	       			}
	       			
	              
	                PrintStream writer = new PrintStream(m_socket.getOutputStream());
	                BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
	           
	               // System.out.println("Server:" + reader.readLine());
	            
	               // m_socket.close();

	            }
	        catch (IOException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	     public void sendMessage() {
	    	 
	    	 
	    	 
	     }

		@Override
		public void actionPerformed(ActionEvent e) {
		  try {
			  if(m_socket!=null) {
				    String[] messageStrings = new String[4]; 
				    PrintStream writer = new PrintStream(m_socket.getOutputStream());
	                BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
	                String sendString = String.valueOf(game.character.x) +" "+game.character.getAnimal()+" "+game.energyList.get(0)+" "+game.emoji;  //send character x coordinate and imagename
	                writer.println(sendString);
	                writer.flush();	 
	                String string = reader.readLine();
	                messageStrings = string.split(" ");
	                if(firstBoolean) {
		                game.character2.changeAnimal(messageStrings[1]);
		                System.out.println(messageStrings[1]);
		                firstBoolean = false;
	                }
	                if(messageStrings.length>3)
	                	game.p2emoji=messageStrings[3];
	                
	                
	                 game.energyList2.remove(0);
	                 game.energyList2.add(Integer.valueOf(messageStrings[2]));
				     game.character2.x = Integer.valueOf(messageStrings[0]);
	                
			  }
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}	
	     	 
      }
}