package pokreader.ol.utils;

import java.awt.Point;
import java.awt.Rectangle;

import pokreader.ol.objects.screens.ScreenCarte;
import pokreader.ol.objects.screens.ScreenEntite;

public class VariablesCartes {

	public static ScreenCarte screenCarteFlop0;
	public static  ScreenCarte screenCarteFlop1;
	public static  ScreenCarte screenCarteFlop2;
	public static  ScreenCarte screenCarteFlop3;
	public static  ScreenCarte screenCarteFlop4;
	public static  ScreenCarte screenCarteFlop5;
	
	public static  Point pointPresenceFlop;
	public static  Point pointPresenceTurn ;
	public static  Point pointPresenceRiver ;
	
	public VariablesCartes(){
		
		Point pointOrigineScreenEntiteCarte = new Point(
				VariablesGlobales.xCarteFlop0 , VariablesGlobales.yCarteFlop0);
		Rectangle rectangleScreenEntiteCarte = new Rectangle(
				pointOrigineScreenEntiteCarte.x,
				pointOrigineScreenEntiteCarte.y,
				VariablesGlobales.widthCarte, 
				VariablesGlobales.heightCarte);
		this.screenCarteFlop0 = new ScreenCarte(
				new ScreenEntite(pointOrigineScreenEntiteCarte,
						rectangleScreenEntiteCarte));
		
		this.pointPresenceFlop = new Point (
				pointOrigineScreenEntiteCarte.x+VariablesGlobales.widthCarte,
				pointOrigineScreenEntiteCarte.y - 5);
				
		pointOrigineScreenEntiteCarte = new Point(
				VariablesGlobales.xCarteFlop1 , VariablesGlobales.yCarteFlop1);
		rectangleScreenEntiteCarte = new Rectangle(
				pointOrigineScreenEntiteCarte.x,
				pointOrigineScreenEntiteCarte.y,
				VariablesGlobales.widthCarte, 
				VariablesGlobales.heightCarte);
		this.screenCarteFlop1 = new ScreenCarte(
				new ScreenEntite(pointOrigineScreenEntiteCarte,
						rectangleScreenEntiteCarte));

		pointOrigineScreenEntiteCarte = new Point(
				VariablesGlobales.xCarteFlop2 , VariablesGlobales.yCarteFlop2);
		rectangleScreenEntiteCarte = new Rectangle(
				pointOrigineScreenEntiteCarte.x,
				pointOrigineScreenEntiteCarte.y,
				VariablesGlobales.widthCarte, 
				VariablesGlobales.heightCarte);
		this.screenCarteFlop2 = new ScreenCarte(
				new ScreenEntite(pointOrigineScreenEntiteCarte,
						rectangleScreenEntiteCarte));
		
		pointOrigineScreenEntiteCarte = new Point(
				VariablesGlobales.xCarteFlop3 , VariablesGlobales.yCarteFlop3);
		rectangleScreenEntiteCarte = new Rectangle(
				pointOrigineScreenEntiteCarte.x,
				pointOrigineScreenEntiteCarte.y,
				VariablesGlobales.widthCarte, 
				VariablesGlobales.heightCarte);
		this.screenCarteFlop3 = new ScreenCarte(
				new ScreenEntite(pointOrigineScreenEntiteCarte,
						rectangleScreenEntiteCarte));
		
		this.pointPresenceTurn = new Point (
				pointOrigineScreenEntiteCarte.x+VariablesGlobales.widthCarte,
				pointOrigineScreenEntiteCarte.y - 5);
		
		pointOrigineScreenEntiteCarte = new Point(
				VariablesGlobales.xCarteFlop4 , VariablesGlobales.yCarteFlop4);
		rectangleScreenEntiteCarte = new Rectangle(
				pointOrigineScreenEntiteCarte.x,
				pointOrigineScreenEntiteCarte.y,
				VariablesGlobales.widthCarte, 
				VariablesGlobales.heightCarte);
		this.screenCarteFlop4 = new ScreenCarte(
				new ScreenEntite(pointOrigineScreenEntiteCarte,
						rectangleScreenEntiteCarte));
		
		this.pointPresenceRiver = new Point (
				pointOrigineScreenEntiteCarte.x+VariablesGlobales.widthCarte,
				pointOrigineScreenEntiteCarte.y - 5);
				
	}
	

}
