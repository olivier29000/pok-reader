package pokreader.ol.utils;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import pokreader.ol.objects.autre.ActionJoueur;
import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.autre.CouleurCarte;
import pokreader.ol.objects.autre.NumeroCarte;

public class UtilsObjectToEnum {

	
	public static Couleur colorToCouleur(Color mycolor) {
		if (mycolor.getRed() > 200 && mycolor.getGreen() > 200 && mycolor.getBlue() > 200) {
			return Couleur.BLANC;
		}else if (mycolor.getRed() > 150 && mycolor.getGreen() < 100 && mycolor.getBlue() < 100) {
			return Couleur.ROUGE;
		}else if (mycolor.getRed() > 200 && mycolor.getGreen() > 200 && mycolor.getBlue() < 100) {
			return Couleur.JAUNE;
		}else if (mycolor.getRed() < 100 && mycolor.getGreen() > 160 && mycolor.getBlue() < 150) {
			return Couleur.VERT;
		}else if (mycolor.getRed() < 100 && mycolor.getGreen() < 100 && mycolor.getBlue() < 100) {
			return Couleur.NOIRE;
		}else {
			return Couleur.INDETERMINE;
		}
		
		
	}
	
	public static  ActionJoueur stringToActionJoueur(String action) {
		
			List<String> listeActionPossibles = Arrays.asList("Fold", "Raise", "Bet", "Call", "Check","Gagne", "PetiteBlinde", "GrosseBlinde");
			List<ActionJoueur> listeEnumPossibles = Arrays.asList(ActionJoueur.FOLD, ActionJoueur.RAISE, ActionJoueur.BET,
					ActionJoueur.CALL, ActionJoueur.CHECK,ActionJoueur.GAGNE,ActionJoueur.PETITEBLINDE,ActionJoueur.GROSSEBLINDE, ActionJoueur.INDETERMINE);
			List<Double> listeScores = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.8);
			action = action.trim();
			double score;
			for (int i = 0; i < listeActionPossibles.size(); i++) {
				score = UtilsStringSimilarity.ckeckSimilarity(action, listeActionPossibles.get(i));
				listeScores.set(i, score);
			}
			return listeEnumPossibles.get(UtilsStringSimilarity.maxIndex(listeScores));
		}
		
	
	public static  NumeroCarte stringToNumeroCarte(String string) {
		List<String> listeCartesPossibles = Arrays.asList("A", "2", "3", "4","5", "6", "7","8", "9", "10", "V", "D","R");
		List<NumeroCarte> listeEnumPossibles = Arrays.asList(NumeroCarte.AS,
				NumeroCarte.DEUX, NumeroCarte.TROIS, NumeroCarte.QUATRE, NumeroCarte.CINQ, NumeroCarte.SIX, NumeroCarte.SEPT,
			 NumeroCarte.HUIT, NumeroCarte.NEUF, NumeroCarte.DIX, NumeroCarte.VALET, NumeroCarte.DAME, NumeroCarte.ROI);
		List<Double> listeScores = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		string = string.trim();
		double score;
		for (int i = 0; i < listeCartesPossibles.size(); i++) {
			score = UtilsStringSimilarity.ckeckSimilarity(string, listeCartesPossibles.get(i));
			listeScores.set(i, score);
		}
		return listeEnumPossibles.get(UtilsStringSimilarity.maxIndex(listeScores));
		
	}

	public static CouleurCarte colorToCouleurCarte(Color colorCenterEntite) {
		// TODO Auto-generated method stub
		return CouleurCarte.CARREAU;
	}

}
