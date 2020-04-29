package pokreader.ol.utils;

import java.awt.AWTException;
import java.awt.Point;

import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.game.Carte;
import pokreader.ol.objects.screens.ScreenEntite;

public class UtilsScreenOrPointToEnum {
	
	public static Couleur getEnumCouleurPoint(Point point) throws AWTException {
		
		
		return UtilsObjectToEnum.colorToCouleur(UtilsScreenOrPointToObject.getColor(point));
		
	}


}
