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

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.game.Carte;
import pokreader.ol.objects.game.Joueur;
import pokreader.ol.services.ScreenJoueurService;
import pokreader.ol.services.ScreenPartieService;
import pokreader.ol.utils.UtilsScreenOrPointToEnum;
import pokreader.ol.utils.UtilsScreenOrPointToObject;
import pokreader.ol.utils.VariablesCartes;
import pokreader.ol.utils.VariablesGlobales;
import pokreader.ol.utils.VariablesJoueurs;


@Data
@NoArgsConstructor
public class ScreenPartie extends ScreenEntite{
	
	
	List<ScreenJoueur> listeDeScreenJoueur ;
	List<ScreenCarte> listeDeScreenCartes ;
	List<Point> listeDePointPresenceJoueur;
	Point pointPresenceFlop;
	Point pointPresenceTurn;
	Point pointPresenceRiver;
	double proportion;
	static String url = "C:\\Users\\lasbleiso\\Travail\\DIGINAMIC\\POKER\\ScreenShot\\ok\\enAction\\";
	static int n =0;
	
	public ScreenPartie(Point pointHautGauche, Point pointBasDroite) throws AWTException, IOException, InterruptedException {
		super(pointHautGauche,pointBasDroite);

		this.listeDeScreenJoueur = new ArrayList<ScreenJoueur>();
		this.listeDePointPresenceJoueur = new ArrayList<Point>();
		System.out.println(this.listeDeScreenJoueur.size());
		while (this.listeDeScreenJoueur.size()==0) {
			Thread.sleep(10);
			makeScreenshot();
			if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(VariablesJoueurs.pointPresenceJoueur5)==Couleur.BLANC)
			{
					
				this.listeDeScreenJoueur.add(VariablesJoueurs.screenJoueur5);
				this.listeDePointPresenceJoueur.add(VariablesJoueurs.pointPresenceJoueur5);
				
				}
			if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(VariablesJoueurs.pointPresenceJoueur0)==Couleur.ROUGE)
			{
			this.listeDeScreenJoueur.add(VariablesJoueurs.screenJoueur0);
			this.listeDePointPresenceJoueur.add(VariablesJoueurs.pointPresenceJoueur0);
			}
			if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(VariablesJoueurs.pointPresenceJoueur1)==Couleur.ROUGE)
			{
			this.listeDeScreenJoueur.add(VariablesJoueurs.screenJoueur1);
			this.listeDePointPresenceJoueur.add(VariablesJoueurs.pointPresenceJoueur1);
			}
			if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(VariablesJoueurs.pointPresenceJoueur2)==Couleur.ROUGE)
			{
			this.listeDeScreenJoueur.add(VariablesJoueurs.screenJoueur2);
			this.listeDePointPresenceJoueur.add(VariablesJoueurs.pointPresenceJoueur2);
			}
			if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(VariablesJoueurs.pointPresenceJoueur3)==Couleur.ROUGE)
			{
			this.listeDeScreenJoueur.add(VariablesJoueurs.screenJoueur3);
			this.listeDePointPresenceJoueur.add(VariablesJoueurs.pointPresenceJoueur3);
			}
			if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(VariablesJoueurs.pointPresenceJoueur4)==Couleur.ROUGE)
			{
			this.listeDeScreenJoueur.add(VariablesJoueurs.screenJoueur4);
			this.listeDePointPresenceJoueur.add(VariablesJoueurs.pointPresenceJoueur4);
			}
			
			
		}
		

		this.listeDePointPresenceJoueur = ScreenPartieService.trierLaListeAvecBoutonEnPremier(listeDePointPresenceJoueur,listeDeScreenJoueur);
		this.listeDeScreenJoueur = ScreenPartieService.trierLaListeAvecBoutonEnPremier(listeDeScreenJoueur);
		
		this.listeDeScreenCartes = new ArrayList<ScreenCarte>();
		this.listeDeScreenCartes.add(VariablesCartes.screenCarteFlop0);
		this.listeDeScreenCartes.add(VariablesCartes.screenCarteFlop1);
		this.listeDeScreenCartes.add(VariablesCartes.screenCarteFlop2);
		this.listeDeScreenCartes.add(VariablesCartes.screenCarteFlop3);
		this.listeDeScreenCartes.add(VariablesCartes.screenCarteFlop4);
		
		this.pointPresenceFlop = VariablesCartes.pointPresenceFlop; 
		this.pointPresenceTurn = VariablesCartes.pointPresenceTurn;
		this.pointPresenceRiver = VariablesCartes.pointPresenceRiver;
		
		
	}
	
	public void makeScreenshot(Point point) throws AWTException, IOException {
		Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(point.x, point.y,50,50));
        File outputfile = new File(url + n++ + ".jpg");
        ImageIO.write(screenShot, "jpg", outputfile);
		
	}
	
	public void makeScreenshot() throws AWTException, IOException {
		Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(this.getRectangle());
        File outputfile = new File(url + n++ + ".jpg");
        ImageIO.write(screenShot, "jpg", outputfile);
		
	}

	public List<Joueur> instancierAllJoueur() throws TesseractException, AWTException, IOException{
		
		List<Joueur> listeDeJoueurs = new ArrayList<Joueur>();
		for (ScreenJoueur screenJoueur : this.listeDeScreenJoueur) {
			listeDeJoueurs.add(screenJoueur.instancierJoueur());
		}
		return listeDeJoueurs;
		
	}
	
	public List<Carte> instancierFlop() throws AWTException, IOException, TesseractException{
		List<Carte> listeDeCartes = new ArrayList<Carte>();
		for (int i = 0; i < 3 ; i++) {
			listeDeCartes.add(this.listeDeScreenCartes.get(i).instancierCarte());
		}
		return listeDeCartes;
	}
	
	public Carte instancierTurn() throws AWTException, IOException, TesseractException{
		return this.listeDeScreenCartes.get(3).instancierCarte();
	}
	
	public Carte instancierRiver() throws AWTException, IOException, TesseractException{
		return this.listeDeScreenCartes.get(4).instancierCarte();
	}
	
	public boolean getPresenceCarte(Point point) throws AWTException {
		if(UtilsScreenOrPointToEnum.getEnumCouleurPoint(point)==Couleur.BLANC) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean getPresenceFlop() throws AWTException {
		return getPresenceCarte(this.pointPresenceFlop);
	}
	
	public boolean getPresenceRiver() throws AWTException {
		return getPresenceCarte(this.pointPresenceRiver);
	}
	
	public boolean getPresenceTurn() throws AWTException {
		return getPresenceCarte(this.pointPresenceTurn);
	}
	
	
}
