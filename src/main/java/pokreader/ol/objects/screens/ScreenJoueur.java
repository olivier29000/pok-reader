package pokreader.ol.objects.screens;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.var;
import net.sourceforge.tess4j.TesseractException;
import pokreader.ol.objects.autre.ActionJoueur;
import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.autre.PositionJoueur;
import pokreader.ol.objects.game.Carte;
import pokreader.ol.objects.game.Joueur;
import pokreader.ol.utils.UtilsObjectToEnum;
import pokreader.ol.utils.UtilsScreenOrPointToEnum;
import pokreader.ol.utils.UtilsScreenOrPointToObject;
import pokreader.ol.utils.VariablesGlobales;


@Data
@NoArgsConstructor
public class ScreenJoueur extends ScreenEntite {

	private ScreenEntite screenName ;
	private ScreenEntite screenStack ;
	private ScreenAction screenAction ;
	private ScreenCarte screenCartes1 ;
	private ScreenCarte screenCartes2 ;
	private Point pointPresenceCarte;
	private Point pointPresenceBouton;
	private Point pointEnAction;
	private List<ScreenCarte> cartesJoueur;
	static String url = "C:\\Users\\lasbleiso\\Travail\\DIGINAMIC\\POKER\\ScreenShot\\ok\\enAction\\";
	
	
	
	public ScreenJoueur(ScreenEntite screenEntite) {
		
		super(screenEntite.getPointOrigine(),screenEntite.getRectangle());
		
		int xNomJoueur=0;
		int yNomJoueur=0;
		int xStackJoueur=0;
		int yStackJoueur=0;
		int xActionJoueur=0;
		int yActionJoueur=0;
		int xPresenceJoueur=0;
		int yPresenceJoueur=0;
		
			xNomJoueur = VariablesGlobales.xNomJoueur;
			yNomJoueur = VariablesGlobales.yNomJoueur;
			xStackJoueur = VariablesGlobales.xStackJoueur;
			yStackJoueur = VariablesGlobales.yStackJoueur;
			xActionJoueur = VariablesGlobales.xActionJoueur;
			yActionJoueur = VariablesGlobales.yActionJoueur;
			xPresenceJoueur = VariablesGlobales.xPresenceJoueur;
			yPresenceJoueur = VariablesGlobales.yPresenceJoueur;
		
		
		
		Point pointOrigine = new Point(screenEntite.getPointOrigine().x + xNomJoueur,
				screenEntite.getPointOrigine().y + yNomJoueur);
		Rectangle rectangle = new Rectangle(pointOrigine.x, pointOrigine.y,
				VariablesGlobales.widthNomJoueur,
				VariablesGlobales.heightNomJoueur);
		
		this.screenName = new ScreenEntite(
				pointOrigine,
				rectangle
				);
		
		this.pointEnAction = new Point(screenEntite.getPointOrigine().x + (int)(VariablesGlobales.widthNomJoueur * 0.90),
				screenEntite.getPointOrigine().y  + (int)(VariablesGlobales.heightJoueur * 0.90));
		
		pointOrigine = new Point(screenEntite.getPointOrigine().x + xStackJoueur,
				screenEntite.getPointOrigine().y + yStackJoueur);
		rectangle = new Rectangle(pointOrigine.x, pointOrigine.y,
				VariablesGlobales.widthStackJoueur,
				VariablesGlobales.heightStackJoueur);
		
		this.screenStack = new ScreenEntite(
				pointOrigine,
				rectangle
				);
		
		pointOrigine = new Point(
				screenEntite.getPointOrigine().x,
				screenEntite.getPointOrigine().y - VariablesGlobales.heightCarte);
		rectangle = new Rectangle(pointOrigine.x, pointOrigine.y,
				VariablesGlobales.widthCarte,
				VariablesGlobales.heightCarte);
		
		this.screenCartes1 = new ScreenCarte(
						pointOrigine,
						rectangle
						);
		
		pointOrigine = new Point(screenEntite.getPointOrigine().x + xActionJoueur,
				screenEntite.getPointOrigine().y + yActionJoueur);
		rectangle = new Rectangle(pointOrigine.x, pointOrigine.y,
				VariablesGlobales.widthActionJoueur,
				VariablesGlobales.heightActionJoueur);
		
		this.screenAction = new ScreenAction(
				pointOrigine,
				rectangle
				);
		
		this.pointPresenceCarte = new Point(screenEntite.getPointOrigine().x + xPresenceJoueur,
				screenEntite.getPointOrigine().y + yPresenceJoueur);
		
		
	}
	
	public Joueur instancierJoueur() throws TesseractException, AWTException, IOException {
		String nomJoueur = UtilsScreenOrPointToObject.getStringEntite(this.getScreenName());
		Double stack = 0.0;
		return new Joueur(nomJoueur
				, stack);
	}
	
	public boolean getPresenceJoueur() throws AWTException {
		if (UtilsScreenOrPointToEnum.getEnumCouleurPoint((this.pointPresenceCarte))==Couleur.ROUGE
				|| UtilsScreenOrPointToEnum.getEnumCouleurPoint((this.pointPresenceCarte))==Couleur.BLANC) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean getJoueurEnAction() throws AWTException {
		Couleur couleur = UtilsScreenOrPointToEnum.getEnumCouleurPoint(this.pointEnAction);
		if (couleur==Couleur.NOIRE) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public boolean getPresenceBouton() throws AWTException {
		if (UtilsScreenOrPointToEnum.getEnumCouleurPoint((this.pointPresenceBouton))==Couleur.JAUNE) {
			return true;
		}else {
			return false;
		}
	}
	
	public String instancierNom() throws TesseractException, AWTException, IOException {
		makeScreenshot(this.getScreenName().getRectangle());
		String result = UtilsScreenOrPointToObject.getStringEntite(this.getScreenName());
		
		return result;
	}
	
	public Double instancierStack() throws TesseractException, AWTException, IOException {
		return 0.0;//UtilsScreenOrPointToObject.getDoubleEntite(this.getScreenStack());
	}
	
	public ActionJoueur instancierAction() throws TesseractException, AWTException, IOException {
		return UtilsObjectToEnum.stringToActionJoueur(
				UtilsScreenOrPointToObject.getStringEntite(this.getScreenAction()));
		
	}
	
	public void makeScreenshot(Rectangle rect) throws AWTException, IOException {
		Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(rect);
        File outputfile = new File(url +  "joueurCourant.jpg");
        ImageIO.write(screenShot, "jpg", outputfile);
		
	}

	public Carte instancierCartes() throws AWTException, IOException, TesseractException {
		return this.screenCartes1.instancierCarte();
		
	}
	
	
	
}
