package pokreader.ol.utils;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.autre.CouleurCarte;
import pokreader.ol.objects.autre.NumeroCarte;
import pokreader.ol.objects.game.Carte;
import pokreader.ol.objects.screens.ScreenCarte;
import pokreader.ol.objects.screens.ScreenEntite;

public abstract class UtilsScreenOrPointToObject {
	
	static int n = 0;
	static String url = "C:\\Users\\lasbleiso\\Travail\\DIGINAMIC\\POKER\\ScreenShot\\ok\\enAction\\";
	static int compteurGetStringEntite = 0;
	public static Color getColor(Point point) throws AWTException {
				
		Rectangle rectangle = new Rectangle(point.x,point.y,2,2);
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(rectangle);
		Color mycolor = new Color(screenShot.getRGB(1, 1));
		return mycolor;
	}
	
	public static String getStringEntite(ScreenEntite entite) throws TesseractException, AWTException, IOException {
		
		final Tesseract tesseract = new Tesseract();
		BufferedImage screenShot;
        if (entite.getClass().getName() == "pokreader.ol.objects.screens.ScreenAction" ) {
        	if (compteurGetStringEntite==0) {
        	screenShot = transFormBufferedImage(entite.getBufferedImage());
        	
        	compteurGetStringEntite = 1;
        	}else {
        		screenShot = entite.getBufferedImage();
        		compteurGetStringEntite = 0;
        	}
        	 
    		   
        }else {
        	   screenShot = transFormBufferedImageForName(entite.getBufferedImage());
        	  
		}
      File outputfile = new File(url + "screenShot.jpg");
       ImageIO.write(screenShot, "jpg", outputfile);
        tesseract.setTessVariable("tessedit_char_whitelist",
				"/.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,€:");
		String result = tesseract.doOCR(screenShot);
		return result.trim();
		
	}
	
	public static BufferedImage transFormBufferedImageForName(BufferedImage bufferedImage) {
		Color myWhite = new Color(255, 255, 255); // Color white
		Color myBlack = new Color(0, 0, 0);
		    for (int y = 0; y < bufferedImage.getHeight(); y++) {
		        for (int x = 0; x < bufferedImage.getWidth(); x++) {
		              Color  color   = new Color(bufferedImage.getRGB(x, y)); 
		              if (color.getRed()>100 && color.getGreen()>100 && color.getBlue()>100) {
		            	  bufferedImage.setRGB(x, y,myWhite.getRGB());
					}else {
						bufferedImage.setRGB(x, y,myBlack.getRGB());
					}
		        }   
		    }
		    
		return bufferedImage;
		
	}
	
	public static BufferedImage transFormBufferedImage(BufferedImage bufferedImage) {
		Color myWhite = new Color(255, 255, 255); // Color white
		Color myBlack = new Color(0, 0, 0);
		    for (int y = 0; y < bufferedImage.getHeight(); y++) {
		        for (int x = 0; x < bufferedImage.getWidth(); x++) {
		              Color  color   = new Color(bufferedImage.getRGB(x, y)); 
		              if ((color.getRed()>160 && color.getRed()<200 
		            	&& color.getGreen()>160 && color.getGreen()<200
		            	&& color.getBlue()>160 && color.getBlue()<200)
		            	|| 
		            	(color.getRed()>250 && color.getGreen()>250 && color.getBlue()>250)) {
		            	  bufferedImage.setRGB(x, y,myWhite.getRGB());
					}else {
						bufferedImage.setRGB(x, y,myBlack.getRGB());
					}
		        }   
		    }
		    
		return bufferedImage;
		
	}
	
	public static Color getColorCenterEntite(ScreenEntite entite) throws AWTException {
		Point point = new Point(entite.getPointOrigine().x + entite.getRectangle().width/2,
				entite.getPointOrigine().y + entite.getRectangle().height/2);
				
		return getColor(point) ;
		
	}

	public static double getDoubleEntite(ScreenEntite screenDouble) throws TesseractException, AWTException, IOException {
		final Tesseract tesseract = new Tesseract();
        BufferedImage screenShot = screenDouble.getBufferedImage();
        //File outputfile = new File(url + "image.jpg");
        //ImageIO.write(screenShot, "jpg", outputfile);
        tesseract.setTessVariable("tessedit_char_whitelist",
				"/.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,€:");
		String result = tesseract.doOCR(screenShot).replaceAll(",", ".");
		return 0.0;//Double.parseDouble(result.trim());
	}

	public static BufferedImage getBufferedImage(Rectangle rectangle) throws AWTException, IOException {
		Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(rectangle);
        //File outputfile = new File(url + n++ + ".jpg");
        //ImageIO.write(screenShot, "jpg", outputfile);
		return screenShot;
	}

	public static Carte getCarte(ScreenCarte screenCarte) throws AWTException, IOException, TesseractException {
		return new Carte(
				getEnumNumeroCarte(screenCarte.getNumeroCarte()),
				getEnumCouleurCarte(screenCarte.getSigneCarte())		);
	}

	private static CouleurCarte getEnumCouleurCarte(ScreenEntite screenCarte) throws AWTException {
		return UtilsObjectToEnum.colorToCouleurCarte(getColorCenterEntite(screenCarte));
	}
	
	public static NumeroCarte getEnumNumeroCarte(ScreenEntite screenCarte) throws AWTException, IOException, TesseractException {
		return UtilsObjectToEnum.stringToNumeroCarte(getNumeroCarte(screenCarte));
	}

	public static String getNumeroCarte(ScreenEntite screenCarte) throws AWTException, IOException, TesseractException {
		final Tesseract tesseract = new Tesseract();
		BufferedImage screenShot;
		screenShot = transFormBufferedImageNumeroCarte(screenCarte.getBufferedImage());
        tesseract.setTessVariable("tessedit_char_whitelist",
				"A2345678910VDR");
		String result = tesseract.doOCR(screenShot);
		return result.trim();
	}
	
	public static BufferedImage transFormBufferedImageNumeroCarte(BufferedImage bufferedImage){
		Color myBlack = new Color(0, 0, 0);
		    for (int y = 0; y < bufferedImage.getHeight(); y++) {
		        for (int x = 0; x < bufferedImage.getWidth(); x++) {
		              Color  color   = new Color(bufferedImage.getRGB(x, y)); 
		              if (UtilsObjectToEnum.colorToCouleur(color) != Couleur.BLANC) {
		            	  bufferedImage.setRGB(x, y,myBlack.getRGB());
					}
		        }   
		    }
		    
		return bufferedImage;
	}

}
