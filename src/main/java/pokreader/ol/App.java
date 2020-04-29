package pokreader.ol;

import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.tess4j.TesseractException;
import pokreader.ol.lecture.LecturePartie;
import pokreader.ol.manager.ConfigScreenManager;
import pokreader.ol.objects.autre.Etape;
import pokreader.ol.objects.game.JoueurPost;
import pokreader.ol.objects.screens.ScreenCarte;
import pokreader.ol.objects.screens.ScreenJoueur;
import pokreader.ol.objects.screens.ScreenPartie;
import pokreader.ol.services.ScreenPartieService;
import pokreader.ol.utils.UtilsScreenOrPointToObject;
import pokreader.ol.utils.VariablesGlobales;
import pokreader.ol.utils.VariablesJoueurs;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private int indexBouton ;
	
	public App() throws AWTException {
		this.indexBouton = ScreenPartieService.trouverIndexDuBoutonListPoint(VariablesJoueurs.listeDePointPresenceBoutonSixJoueurs);
		
		
	}
	
    public static void main( String[] args ) throws AWTException, IOException, TesseractException, InterruptedException
    {
    	
        Point[] lesDeuxPointsDeDepart = ConfigScreenManager.configScreenController();
        Point pointHautGauche = lesDeuxPointsDeDepart[0];
        Point pointBasDroite = lesDeuxPointsDeDepart[1];
        
        double proportion = (double)(pointBasDroite.x - pointHautGauche.x)/1280;
		VariablesGlobales variablesGlobales = new VariablesGlobales(proportion,pointHautGauche);
        App app = new App();
        
        LecturePartie lecturePartie = new LecturePartie(pointHautGauche,pointBasDroite);
        List<JoueurPost> listeJoueursPost = new ArrayList<JoueurPost>();
        
		
        while (app.verifierSiNouvellePartie() == false) {
        	
        	for (ScreenJoueur screenJoueur : lecturePartie.getScreenPartie().getListeDeScreenJoueur()) {
    			if (screenJoueur.getPresenceJoueur() == false) {
    				listeJoueursPost.add(new JoueurPost(screenJoueur.instancierNom(), app.determinerEtape(lecturePartie)));
    			}
    		}
        	
		}
    }
    
    
		
		
	
	
	
	private Etape determinerEtape(LecturePartie lecturePartie) throws AWTException {
		Etape etape = null;
		if (lecturePartie.getScreenPartie().getPresenceRiver() == true) {
		 	etape = Etape.RIVER;
		}else if (lecturePartie.getScreenPartie().getPresenceTurn() == true) {
		 	etape = Etape.TURN;
		}else if (lecturePartie.getScreenPartie().getPresenceFlop() == true) {
			 	etape = Etape.FLOP;
		}else {
			etape = Etape.PREFLOP;
		}
		
		return etape;
	}
    
    public boolean verifierSiNouvellePartie() throws AWTException {
    	if(this.indexBouton != ScreenPartieService.trouverIndexDuBoutonListPoint(VariablesJoueurs.listeDePointPresenceBoutonSixJoueurs)) {
    		return true;
    	}else {
        	return false;
    	}
    	
    }
}
