package pokreader.ol;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import lombok.Data;
import pokreader.ol.lecture.LecturePartie;
import pokreader.ol.manager.ConfigScreenManager;
import pokreader.ol.objects.screens.ScreenCarte;
import pokreader.ol.objects.screens.ScreenJoueur;
import pokreader.ol.objects.screens.ScreenPartie;
import pokreader.ol.utils.VariablesGlobales;

public class Tests {

	public static void main(String[] args) throws AWTException, IOException {
		test();

	}
	
	public static float compareImage(File fileA, File fileB) {

	    float percentage = 0;
	    try {
	        // take buffer data from both image files //
	        BufferedImage biA = ImageIO.read(fileA);
	        DataBuffer dbA = biA.getData().getDataBuffer();
	        int sizeA = dbA.getSize();
	        BufferedImage biB = ImageIO.read(fileB);
	        DataBuffer dbB = biB.getData().getDataBuffer();
	        int sizeB = dbB.getSize();
	        int count = 0;
	        // compare data-buffer objects //
	        if (sizeA >= sizeB) {

	            for (int i = 0; i < sizeB; i++) {

	                if (dbA.getElem(i) == dbB.getElem(i)) {
	                    count = count + 1;
	                }

	            }
	            percentage = (count * 100) / sizeB;
	        } else {
	            System.out.println("Both the images are not of same size");
	        }

	    } catch (Exception e) {
	        System.out.println("Failed to compare image files ...");
	    }
	    return percentage;
	}
	
	public static void test() throws AWTException, IOException
    {
        Point[] lesDeuxPointsDeDepart = ConfigScreenManager.configScreenController();
        double proportion = (double)(lesDeuxPointsDeDepart[1].x - lesDeuxPointsDeDepart[0].x)/1280;
		VariablesGlobales variablesGlobales = new VariablesGlobales(proportion,lesDeuxPointsDeDepart[0]);
        LecturePartie lecturePartie = new LecturePartie(lesDeuxPointsDeDepart[0],lesDeuxPointsDeDepart[1]);
        
        
        lecturePartie.getScreenPartie().getBufferedImage();
        
        for (ScreenCarte screenCarte : lecturePartie.getScreenPartie().getListeDeScreenCartes()) {
        	screenCarte.getBufferedImage();
		}
        
        for (ScreenJoueur screenJoueur : lecturePartie.getScreenPartie().getListeDeScreenJoueur()) {
        	screenJoueur.getBufferedImage();
        	screenJoueur.getScreenAction().getBufferedImage();
        	screenJoueur.getScreenName().getBufferedImage();
        	screenJoueur.getScreenStack().getBufferedImage();
		}
    }

}
