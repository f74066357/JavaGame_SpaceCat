package spaceCat;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Character {
	public BufferedImage img;
	public SpaceItem sining;
	
	public int x;
	public int y;
	float moveSize = 10.0f;
	private String animal;
	public Character() {
		
		try {
			img = (BufferedImage)ImageIO.read(new File("src/cat.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x=120;
		y=400;
		
		sining = new SpaceItem("src/shining.png",0);
		sining.y = 400 + img.getHeight() - 5;
		animal="cat";
		
	}
	public void move() {
		/*try {
			img = (BufferedImage)ImageIO.read(new File("src/SCAT.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(sining.y > 610)
			sining.y = 400 + img.getHeight() -5;
		
	}
	public void moveright() { 
		try {
			img = (BufferedImage)ImageIO.read(new File("src/"+animal+"R.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void moveleft() { 
		try {
			img = (BufferedImage)ImageIO.read(new File("src/"+animal+"L.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void changeAnimal(String A) {
		animal = A;
		System.out.println("class character animal = "+animal);
		try {
			img = (BufferedImage)ImageIO.read(new File("src/" + animal+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getAnimal() {
		return animal;
	}
	

}
