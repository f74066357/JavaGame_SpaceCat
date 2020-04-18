package spaceCat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	public BufferedImage img;
	
	public int x;
	public int y;
	public BackGround(int nx,int ny,String imgpath) {
		try {
			img = (BufferedImage)ImageIO.read(new File(imgpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = nx;
		y = ny;
	}
	public void scroll() {
		this.y++;		
		if(this.y>=600)
			this.y = -1200;
	}
}
