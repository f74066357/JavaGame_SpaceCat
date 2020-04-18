package spaceCat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.Timer;
public class ServerThreadCode extends Thread implements ActionListener{
public multiGame game;  
Boolean firstBoolean = true;
private ServerSocket m_serverSocket;//�蝞賂蕭�����蕭�ocket����蕭��lient���蕭��蕭嚙質嚙�
private Socket m_socket;//Server嚙踝蕭�lient��嚙踐嚙踝�蕭嚙質謍湛蕭謍湛蕭嚙�
public String getMessageString;  

	    public ServerThreadCode(int port)
	    {
	        try
	        {
	            m_serverSocket = new ServerSocket(port);//�蝞蕭��嚙踝蕭�����蕭�ocket������澈�謕緻rt
	        }
	        catch (IOException e)
	        {
	            System.out.println(e.getMessage());//嚙踝嚙踐���蕭謘踝蕭蹇ｇ蕭�嚙踐�蕭��������蕭謘選蕭����
	        }
	    }
	    
	    @Override
	    public void run()//����hread嚙踝嚙踝蕭��n()嚙踐��蕭
	    {
	        try
	        {
	             System.out.println("蝑���蝺�......");
	             m_socket = m_serverSocket.accept();
	             System.out.println("��蝺���");
	             m_serverSocket.close();
	             //game.setState("gaming");
	             game.severCheck = true;
	             game.timer.start();
       			 Timer timer2 = new Timer(100, this);
       			 timer2.start();
       			//timer.start();                                  
       			
	        }
	        catch (IOException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    @Override
		public void actionPerformed(ActionEvent e) {
		  try {
			  if(m_socket!=null) {
				    PrintStream writer = new PrintStream(m_socket.getOutputStream());  
				    BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
				    String[] messageStrings = new String[4];
				    String sendString = String.valueOf(game.character.x) +" "+game.character.getAnimal()+" "+game.energyList.get(0)+" "+game.emoji; 
				    //send character x coordinate and imagename
				    System.out.println(sendString);
				    writer.println(sendString); 
	                writer.flush();	//send to client
	                String string = reader.readLine();//read from client once a line
	                messageStrings = string.split(" ");
	                if(firstBoolean) {
		                game.character2.changeAnimal(messageStrings[1]);
		                firstBoolean = false;
	                }
	                if(messageStrings[3]!=null)
		            game.p2emoji=messageStrings[3];
		                
	                
	                 game.energyList2.remove(0);
	                 game.energyList2.add(Integer.valueOf(messageStrings[2]));
				     game.character2.x = Integer.valueOf(messageStrings[0]);
	               // game.repaint();              
			  }
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}	
	     	 
      }
	
}