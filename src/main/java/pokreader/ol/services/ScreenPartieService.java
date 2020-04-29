package pokreader.ol.services;

import java.awt.AWTException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.screens.ScreenJoueur;
import pokreader.ol.utils.UtilsScreenOrPointToEnum;

public class ScreenPartieService {

	
	public static List<ScreenJoueur> trierLaListeAvecBoutonEnPremier(List<ScreenJoueur> listeDeScreenJoueur) throws AWTException {

		List<ScreenJoueur>  listeDeScreenJoueurOrdonnes = new ArrayList<ScreenJoueur>();
		
		int indexProvisoireBouton=trouverIndexDuBoutonListScreen(listeDeScreenJoueur) + 1;
		
		for (int i = indexProvisoireBouton; i < listeDeScreenJoueur.size(); i++) {
			listeDeScreenJoueurOrdonnes.add(listeDeScreenJoueur.get(i));
		}
		for (int i = 0; i < indexProvisoireBouton; i++) {
			listeDeScreenJoueurOrdonnes.add(listeDeScreenJoueur.get(i));
		}
		
		return listeDeScreenJoueurOrdonnes;
	}

	public static List<Point> trierLaListeAvecBoutonEnPremier(List<Point> listeDePointPresenceJoueur,
			List<ScreenJoueur> listeDeScreenJoueur) throws AWTException {
		
		List<Point>  listeDePointPresenceJoueurOrdonnes = new ArrayList<Point>();

		
		int indexProvisoireBouton=trouverIndexDuBoutonListScreen(listeDeScreenJoueur) + 1;
		
		for (int i = indexProvisoireBouton; i < listeDeScreenJoueur.size(); i++) {
			listeDePointPresenceJoueurOrdonnes.add(listeDePointPresenceJoueur.get(i));
		}
		for (int i = 0; i < indexProvisoireBouton; i++) {
			listeDePointPresenceJoueurOrdonnes.add(listeDePointPresenceJoueur.get(i));
		}
		
		return listeDePointPresenceJoueurOrdonnes;
		
	}
	
	public static int trouverIndexDuBoutonListScreen(List<ScreenJoueur> listeDeScreenJoueur) throws AWTException {
		int indexProvisoireBouton=0;
		for (ScreenJoueur screenJoueur : listeDeScreenJoueur) {
			if (screenJoueur.getPresenceBouton()) {
				break;
			}
			indexProvisoireBouton++;
		}
		return indexProvisoireBouton;
	}

	public static int trouverIndexDuBoutonListPoint(List<Point> listeDePointPresenceBoutonSixJoueurs) throws AWTException {
		int indexProvisoireBouton=0;
		for (Point pointPresenceBouton : listeDePointPresenceBoutonSixJoueurs) {
			if (UtilsScreenOrPointToEnum.getEnumCouleurPoint(pointPresenceBouton)==Couleur.JAUNE) {
				break;
			}
			indexProvisoireBouton++;
		}
		return indexProvisoireBouton;
		
	}
	
}
