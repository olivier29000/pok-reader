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
import pokreader.ol.services.ScreenPartieService;
import pokreader.ol.utils.VariablesGlobales;
import pokreader.ol.utils.VariablesJoueurs;

public class Testtest {
	
private int indexBouton ;
	
	public Testtest() throws AWTException {
		this.indexBouton = ScreenPartieService.trouverIndexDuBoutonListPoint(VariablesJoueurs.listeDePointPresenceBoutonSixJoueurs);
		
		
	}

	public static void main(String[] args) throws AWTException, IOException {
		
		Point[] lesDeuxPointsDeDepart = ConfigScreenManager.configScreenController();
        Point pointHautGauche = lesDeuxPointsDeDepart[0];
        Point pointBasDroite = lesDeuxPointsDeDepart[1];
        
        double proportion = (double)(pointBasDroite.x - pointHautGauche.x)/1280;
		VariablesGlobales variablesGlobales = new VariablesGlobales(proportion,pointHautGauche);
        App app = new App();
        
        
        
        while (app.verifierSiNouvellePartie() == false) {
			System.out.println("En attente d'une nouvelle partie");
		}
        LecturePartie lecturePartie = new LecturePartie(pointHautGauche,pointBasDroite);
        
        
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



	
	public boolean verifierSiNouvellePartie() throws AWTException {
    	if(this.indexBouton != ScreenPartieService.trouverIndexDuBoutonListPoint(VariablesJoueurs.listeDePointPresenceBoutonSixJoueurs)) {
    		return true;
    	}else {
        	return false;
    	}
    	
    }

}

