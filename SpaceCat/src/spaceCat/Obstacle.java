package spaceCat;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacle extends SpaceItem{

	
	public Obstacle(String imgpath,int nx) {
		super(imgpath, nx);
		// TODO Auto-generated constructor stub
		try {
			img=(BufferedImage)ImageIO.read(new File(imgpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
