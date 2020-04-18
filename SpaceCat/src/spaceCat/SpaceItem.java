package spaceCat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpaceItem {
	public BufferedImage img;
	public int x;
	public int y;
	
	public SpaceItem(String imgpath,int nx) {
		try {
			img = (BufferedImage)ImageIO.read(new File(imgpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x=nx;
		y=0;
	}
	
	public void move() {
		y+=2;
	}
}
