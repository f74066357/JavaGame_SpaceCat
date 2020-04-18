package spaceCat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnergyButtle extends SpaceItem{

	

	public EnergyButtle(String imgpath,int nx) {
		
		super(imgpath,nx);
		try {
			img=(BufferedImage)ImageIO.read(new File(imgpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

}
