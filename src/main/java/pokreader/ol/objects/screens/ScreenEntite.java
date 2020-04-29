package pokreader.ol.objects.screens;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pokreader.ol.utils.UtilsScreenOrPointToObject;


@Data
@NoArgsConstructor
public class ScreenEntite {
	
	
	private Point pointOrigine;
	private Rectangle rectangle;
	
	static String url = "C:\\Users\\lasbleiso\\Travail\\DIGINAMIC\\POKER\\ScreenShot\\ok\\enAction\\";
	static int n =0;
	
	public ScreenEntite(Point pointOrigine, Rectangle rectangle) {
		super();
		this.pointOrigine = pointOrigine;
		this.rectangle = rectangle;
	}
	
	
	public BufferedImage getBufferedImage() throws AWTException, IOException {
		return UtilsScreenOrPointToObject.getBufferedImage(this.rectangle);
	}


	public ScreenEntite(Point pointHautGauche, Point pointBasDroite) {
		this.pointOrigine = pointHautGauche;
		this.rectangle = new Rectangle(this.pointOrigine.x, this.pointOrigine.y,
				pointBasDroite.x - pointHautGauche.x, pointBasDroite.y - pointHautGauche.y);
		
	}
	
	public void makeScreenshot() throws AWTException, IOException {
		Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(this.getRectangle());
        File outputfile = new File(url + n++ + ".jpg");
        ImageIO.write(screenShot, "jpg", outputfile);
		
	}
}
