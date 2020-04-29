package pokreader.ol.utils;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import pokreader.ol.objects.screens.ScreenEntite;
import pokreader.ol.objects.screens.ScreenJoueur;

public class VariablesJoueurs {
	
	public static  ScreenJoueur screenJoueur0 ;
	public static ScreenJoueur screenJoueur1 ;
	public static  ScreenJoueur screenJoueur2 ;
	public static  ScreenJoueur screenJoueur3 ;
	public static  ScreenJoueur screenJoueur4 ;
	public static  ScreenJoueur screenJoueur5 ;

	public static  Point pointPresenceJoueur0 ;
	public static  Point pointPresenceJoueur1 ;
	public static  Point pointPresenceJoueur2 ;
	public static  Point pointPresenceJoueur3 ;
	public static  Point pointPresenceJoueur4 ;
	public static  Point pointPresenceJoueur5 ;
	public static  List<Point> listeDePointPresenceBoutonSixJoueurs;
	
	public VariablesJoueurs() {
		
	
	this.screenJoueur0 = new ScreenJoueur(
			new ScreenEntite(
					new Point(VariablesGlobales.xJoueur0,
							VariablesGlobales.yJoueur0),
					new Rectangle(VariablesGlobales.xJoueur0,
							VariablesGlobales.yJoueur0,
							VariablesGlobales.widthJoueur,
							VariablesGlobales.heightJoueur
							)));
	this.pointPresenceJoueur0 = this.screenJoueur0.getPointPresenceCarte();
	this.screenJoueur0.setPointPresenceBouton(
			new Point(
			VariablesGlobales.xPresenceBoutonJoueur0,
			VariablesGlobales.yPresenceBoutonJoueur0));
	
	this.screenJoueur1 = new ScreenJoueur(
			new ScreenEntite(
					new Point(VariablesGlobales.xJoueur1,
							VariablesGlobales.yJoueur1),
					new Rectangle(VariablesGlobales.xJoueur1,
							VariablesGlobales.yJoueur1,
							VariablesGlobales.widthJoueur,
							VariablesGlobales.heightJoueur
							)));
	this.pointPresenceJoueur1 = this.screenJoueur1.getPointPresenceCarte();
	this.screenJoueur1.setPointPresenceBouton(
			new Point(
					VariablesGlobales.xPresenceBoutonJoueur1,
					VariablesGlobales.yPresenceBoutonJoueur1));
	
	this.screenJoueur2 = new ScreenJoueur(
			new ScreenEntite(
					new Point(VariablesGlobales.xJoueur2,
							VariablesGlobales.yJoueur2),
					new Rectangle(VariablesGlobales.xJoueur2,
							VariablesGlobales.yJoueur2,
							VariablesGlobales.widthJoueur,
							VariablesGlobales.heightJoueur
							)));
	this.pointPresenceJoueur2 = this.screenJoueur2.getPointPresenceCarte();
	this.screenJoueur2.setPointPresenceBouton(
			new Point(VariablesGlobales.xPresenceBoutonJoueur2,
					VariablesGlobales.yPresenceBoutonJoueur2));
	
	this.screenJoueur3 = new ScreenJoueur(
			new ScreenEntite(
					new Point(VariablesGlobales.xJoueur3,
							VariablesGlobales.yJoueur3),
					new Rectangle(VariablesGlobales.xJoueur3,
							VariablesGlobales.yJoueur3,
							VariablesGlobales.widthJoueur,
							VariablesGlobales.heightJoueur
							)));
	this.pointPresenceJoueur3 = this.screenJoueur3.getPointPresenceCarte();
	this.screenJoueur3.setPointPresenceBouton(
			new Point(
					VariablesGlobales.xPresenceBoutonJoueur3,
					VariablesGlobales.yPresenceBoutonJoueur3));
	
	this.screenJoueur4 = new ScreenJoueur(
			new ScreenEntite(
					new Point(VariablesGlobales.xJoueur4,
							VariablesGlobales.yJoueur4),
					new Rectangle(VariablesGlobales.xJoueur4,
							VariablesGlobales.yJoueur4,
							VariablesGlobales.widthJoueur,
							VariablesGlobales.heightJoueur
							)));
	this.pointPresenceJoueur4 = this.screenJoueur4.getPointPresenceCarte();
	this.screenJoueur4.setPointPresenceBouton(
			new Point(
					VariablesGlobales.xPresenceBoutonJoueur4,
					VariablesGlobales.yPresenceBoutonJoueur4));
	
	this.screenJoueur5 = new ScreenJoueur(
			new ScreenEntite(
					new Point(VariablesGlobales.xJoueur5,
							VariablesGlobales.yJoueur5),
					new Rectangle(VariablesGlobales.xJoueur5,
							VariablesGlobales.yJoueur5,
							VariablesGlobales.widthJoueur,
							VariablesGlobales.heightJoueur
							)));
	this.pointPresenceJoueur5 = this.screenJoueur5.getPointPresenceCarte();
	this.screenJoueur5.setPointPresenceBouton(
			new Point(VariablesGlobales.xPresenceBoutonJoueur5,
					VariablesGlobales.yPresenceBoutonJoueur5));
	
	this.listeDePointPresenceBoutonSixJoueurs= new ArrayList<Point>();
	this.listeDePointPresenceBoutonSixJoueurs.add(this.screenJoueur0.getPointPresenceBouton());
	this.listeDePointPresenceBoutonSixJoueurs.add(this.screenJoueur1.getPointPresenceBouton());
	this.listeDePointPresenceBoutonSixJoueurs.add(this.screenJoueur2.getPointPresenceBouton());
	this.listeDePointPresenceBoutonSixJoueurs.add(this.screenJoueur3.getPointPresenceBouton());
	this.listeDePointPresenceBoutonSixJoueurs.add(this.screenJoueur4.getPointPresenceBouton());
	this.listeDePointPresenceBoutonSixJoueurs.add(this.screenJoueur5.getPointPresenceBouton());

	}
}
