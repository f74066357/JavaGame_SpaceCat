package spaceCat;
import static javax.swing.SwingConstants.RIGHT;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar; 
import javax.swing.Timer; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 


public class ProgressBar implements ActionListener,ChangeListener { 
	JFrame frame=null; 
	static JProgressBar progressbar; 
	JLabel label;
	Timer timer; 
	JButton b; 
	Boolean gameover=false;
	List<Integer> energyList;
	JPanel panel;
	int score =0;
	int energy=100;
	public ProgressBar(List<Integer>energy){ 
		energyList = energy;
		progressbar = new JProgressBar(); 
		progressbar.setOrientation(JProgressBar.HORIZONTAL); 
		progressbar.setFont(new java.awt.Font("Dialog", 1, 10));
		progressbar.setMinimum(0); 
		progressbar.setMaximum(100); 
		progressbar.setValue(100); 
		progressbar.setStringPainted(true); 
		progressbar.addChangeListener(this); 
		progressbar.setBorderPainted(true); 
		progressbar.setForeground(Color.green);	
		progressbar.setSize(180,9);
		//panel=new JPanel();
		//panel.setSize(600, 60);
 
		
		//JLabel label = new JLabel("",label.LEFT);
		label = new JLabel("",label.LEFT);
	    label.setOpaque(false);
	    label.setFont(new java.awt.Font("Dialog", 1, 16));
	    label.setForeground(Color.WHITE);
	    //panel.add(labelp1);
	    //panel.add(progressbar);
	    //panel.add(label);
	    timer=new Timer(100,this);
 
	} 
	int c=0;

	public void actionPerformed(ActionEvent e) { 
		
		if(e.getSource()==timer){ 
			c=c+1;
			if(c==10) {
				c=0;
				energy = energyList.get(0);
				energyList.remove(0);
				if(energy>100) {
					energy=100;
				}
				energy=energy-5;
				energyList.add(energy);
				System.out.println("energy:"+energy);
				System.out.println("score:"+score);
				if(energy>0) {
					progressbar.setValue(energy); 
					score=score+1000;
					label.setText("score:"+score);
				}
				else{ 
					progressbar.setValue(energy); 
					timer.stop(); 
					gameover=true;
				} 
			}
			
		} 
	} 

	public void stateChanged(ChangeEvent e1) { 
		int value=progressbar.getValue(); 
		if(e1.getSource()==progressbar){ 
			if(value>80) {
				progressbar.setForeground(Color.green);
				
			}
			else if(value>30&&value<80) {
				progressbar.setForeground(Color.blue);
			}			
			else if(value>0&&value<30) {
				progressbar.setForeground(Color.red);
			}		
		} 
	} 
	
} 