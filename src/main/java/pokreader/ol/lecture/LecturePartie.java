package pokreader.ol.lecture;

import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import net.sourceforge.tess4j.TesseractException;
import pokreader.ol.objects.autre.ActionJoueur;
import pokreader.ol.objects.autre.Couleur;
import pokreader.ol.objects.autre.Etape;
import pokreader.ol.objects.game.Flop;
import pokreader.ol.objects.game.GameJoueur;
import pokreader.ol.objects.game.Jeu;
import pokreader.ol.objects.game.Joueur;
import pokreader.ol.objects.game.JoueurPost;
import pokreader.ol.objects.game.Partie;
import pokreader.ol.objects.game.PreFlop;
import pokreader.ol.objects.screens.ScreenJoueur;
import pokreader.ol.objects.screens.ScreenPartie;
import pokreader.ol.services.ScreenPartieService;
import pokreader.ol.utils.UtilsScreenOrPointToEnum;
import pokreader.ol.utils.UtilsScreenOrPointToObject;
import pokreader.ol.utils.VariablesGlobales;
import pokreader.ol.utils.VariablesJoueurs;

@Data
public class LecturePartie {
	
	Partie partieEnCours;
	int indexJoueurCourant;
	int indexBouton;
	ScreenPartie screenPartie;
	List<Point> listeDePointPresenceBoutonSixJoueurs;
	private boolean lePreflopACommence=false;
	private boolean leFlopACommence=false;
	private boolean laTurnACommence=false;
	private boolean laRiverACommence=false;
	
	public LecturePartie(Point pointHautGache, Point pointBasDroite) throws AWTException, IOException, InterruptedException {
		
		this.listeDePointPresenceBoutonSixJoueurs=VariablesJoueurs.listeDePointPresenceBoutonSixJoueurs;
		
		this.indexBouton = 6;
		
		while (this.indexBouton == 6) {
			this.indexBouton = ScreenPartieService.trouverIndexDuBoutonListPoint(listeDePointPresenceBoutonSixJoueurs);
			System.out.println("indexBouton :" + this.indexBouton);
		}
		this.screenPartie = new ScreenPartie(pointHautGache,pointBasDroite);
        this.partieEnCours = new Partie();
        
	}
	
	public boolean verifierSiLePreflopEstFini() throws AWTException, TesseractException, IOException {
		if (this.screenPartie.getPresenceFlop() || 
				ScreenPartieService.trouverIndexDuBoutonListPoint(listeDePointPresenceBoutonSixJoueurs) != this.indexBouton) {		
			return true;
		}else {
			return false;
		}
		
	}
	
	public void lectureDeTousLesJoueurs() throws TesseractException, AWTException, IOException {
		int n = 0;
		for (ScreenJoueur screenJoueur : this.screenPartie.getListeDeScreenJoueur()) {
			if (screenJoueur.getJoueurEnAction() && screenJoueur.getPresenceJoueur()) {
				if (screenJoueur.equals(VariablesJoueurs.screenJoueur5)) {
					screenJoueur.getScreenCartes1().makeScreenshot();
					screenJoueur.getScreenCartes1().getNumeroCarte().makeScreenshot();
					screenJoueur.getScreenCartes1().getSigneCarte().makeScreenshot();
					System.out.println(screenJoueur.instancierCartes().toString());
				}else{	
				while (screenJoueur.getJoueurEnAction()) {
					}
					lectureActionJoueur(screenJoueur);
				}	
			}
			n++;
			}
		}
	
	

	public void lectureActionJoueur(ScreenJoueur screenJoueurCourant) throws TesseractException, AWTException, IOException {
		ActionJoueur actionJoueur = ActionJoueur.INDETERMINE;
		int n =0;
		while (actionJoueur == ActionJoueur.INDETERMINE) {
			if (screenJoueurCourant.equals(VariablesJoueurs.screenJoueur5)) {
				if (!screenJoueurCourant.getPresenceJoueur()) {
					actionJoueur = ActionJoueur.FOLD;
				} else {
					actionJoueur = ActionJoueur.NOFOLD;
				}
			}else {
				actionJoueur =  screenJoueurCourant.instancierAction();
			}
			n++;
			if (n == 4) {
				if (!screenJoueurCourant.getPresenceJoueur()) {
					actionJoueur = ActionJoueur.FOLD;
				} else {
					actionJoueur = ActionJoueur.NOFOLD;
				}
			}
			
		}
		if (actionJoueur != ActionJoueur.INDETERMINE) {
			Joueur joueur = screenJoueurCourant.instancierJoueur();
			addActionJoueurToPartie(actionJoueur, joueur);
		}
		
	}
	
	public void addActionJoueurToPartie(ActionJoueur actionJoueur, Joueur joueur) throws AWTException {
		if (actionJoueur != ActionJoueur.INDETERMINE) {
			
			if (verifierSiLaRiverACommence ()) {
				this.partieEnCours.getRiver().getListeActionsDesJoueurs().add(
						new GameJoueur(
								joueur,
								actionJoueur));
				System.out.print("River : ");
			}else if(verifierSiLaTurnACommence()){
				this.partieEnCours.getTurn().getListeActionsDesJoueurs().add(
						new GameJoueur(
								joueur,
								actionJoueur));
				System.out.print("Turn : ");
			}
			else if(verifierSiLeFlopACommence()){
				this.partieEnCours.getFlop().getListeActionsDesJoueurs().add(
						new GameJoueur(
								joueur,
								actionJoueur));
				System.out.print("Flop : ");
			}else{
				this.partieEnCours.getPreflop().getListeActionsDesJoueurs().add(
						new GameJoueur(
								joueur,
								actionJoueur));
				System.out.print("Preflop : ");
			}
			System.out.println(actionJoueur + " -- " + joueur);
		}
	}
	
	public Jeu lectureJeu() throws TesseractException, AWTException, IOException {
		
		if (!verifierSiLePreflopEstFini()) {
			PreFlop preflop = this.partieEnCours.getPreflop();
			this.indexJoueurCourant = 0;
			incrementerIndexJoueurCourant();
			incrementerIndexJoueurCourant();
			ScreenJoueur screenJoueurCourant  = this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);
			ActionJoueur actionJoueur =  ActionJoueur.INDETERMINE;
			
			while (!verifierSiLePreflopEstFini()) {
				screenJoueurCourant  = this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);
				actionJoueur = lectureActionJoueur();
				preflop.getListeActionsDesJoueurs().add(
						new GameJoueur(
								screenJoueurCourant.instancierJoueur(),
								actionJoueur));
			}
			
			
		}
		if (!verifierSiLeFlopACommence()) {
			Flop flop =  this.partieEnCours.getFlop();
			this.indexJoueurCourant = 0;
			ScreenJoueur screenJoueurCourant  = this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);

			while (!verifierSiLaTurnACommence()) {
				ActionJoueur actionJoueur = lectureActionJoueur();
				screenJoueurCourant  = this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);
				flop.getListeActionsDesJoueurs().add(
						new GameJoueur(screenJoueurCourant.instancierJoueur(),actionJoueur));
				
			}
			
		}
		
		return null;
	}
	
	public ActionJoueur lectureActionJoueur() throws AWTException, TesseractException, IOException {
		ActionJoueur actionJoueur = ActionJoueur.INDETERMINE;
		ScreenJoueur screenJoueurCourant  = this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);
		if (screenJoueurCourant.equals(VariablesJoueurs.screenJoueur5)) {
			Point pointPresenceJoueurHumain = new Point(VariablesGlobales.xPresenceVertJoueurHumain,
														VariablesGlobales.yPresenceVertJoueurHumain);
			while (UtilsScreenOrPointToEnum.getEnumCouleurPoint(pointPresenceJoueurHumain)==Couleur.VERT
					 && !verifierSiLePreflopEstFini()) {
				System.out.println("humain en cours");
			}
			if (!screenJoueurCourant.getPresenceJoueur()) {
				actionJoueur = ActionJoueur.FOLD;
				this.screenPartie.getListeDeScreenJoueur().remove(this.indexJoueurCourant);
			} else {
				actionJoueur = ActionJoueur.NOFOLD;
				incrementerIndexJoueurCourant();
			}
			System.out.println(actionJoueur.toString());
			}else {
			while (actionJoueur == ActionJoueur.INDETERMINE && !verifierSiLePreflopEstFini()) {
				actionJoueur =  screenJoueurCourant.instancierAction();	
			}
			System.out.println(actionJoueur.toString());
			if (actionJoueur == ActionJoueur.FOLD) {
				this.screenPartie.getListeDeScreenJoueur().remove(this.indexJoueurCourant);
			} else {
				incrementerIndexJoueurCourant();
			}
		}
		return actionJoueur;
	}
	
	public PreFlop lecturePreflop() throws TesseractException, AWTException, IOException {
		
		PreFlop preflop = new PreFlop(this.screenPartie.instancierAllJoueur());
		this.indexJoueurCourant = 0;
		incrementerIndexJoueurCourant();
		incrementerIndexJoueurCourant();
		while (!verifierSiLePreflopEstFini()) {
			ActionJoueur actionJoueur =  ActionJoueur.INDETERMINE;
			ScreenJoueur screenJoueurCourant  = this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);
			if (screenJoueurCourant.equals(VariablesJoueurs.screenJoueur5)) {
				Point pointPresenceJoueurHumain = new Point(VariablesGlobales.xPresenceVertJoueurHumain,
															VariablesGlobales.yPresenceVertJoueurHumain);
				while (UtilsScreenOrPointToEnum.getEnumCouleurPoint(pointPresenceJoueurHumain)==Couleur.VERT) {
					System.out.println("humain en cours");
				}
				if (!screenJoueurCourant.getPresenceJoueur()) {
					actionJoueur = ActionJoueur.FOLD;
					this.screenPartie.getListeDeScreenJoueur().remove(this.indexJoueurCourant);
				} else {
					actionJoueur = ActionJoueur.NOFOLD;
					incrementerIndexJoueurCourant();
				}
				System.out.println(actionJoueur.toString());
				preflop.getListeActionsDesJoueurs().add(
						new GameJoueur(screenJoueurCourant.instancierJoueur(),actionJoueur));
				
			}else {
				while (actionJoueur == ActionJoueur.INDETERMINE && !verifierSiLePreflopEstFini()) {
					actionJoueur =  screenJoueurCourant.instancierAction();	
				}
				System.out.println(actionJoueur.toString());
				if (actionJoueur == ActionJoueur.FOLD) {
					this.screenPartie.getListeDeScreenJoueur().remove(this.indexJoueurCourant);
				} else {
					incrementerIndexJoueurCourant();
				}
				preflop.getListeActionsDesJoueurs().add(new GameJoueur(screenJoueurCourant.instancierJoueur(),actionJoueur));
			}
		}
		return preflop;
	}
	
	public boolean verifierSiLeFlopACommence() throws AWTException {
		return this.screenPartie.getPresenceFlop();
	}
	
	public void lectureFlop() {
		
	}
	
	public boolean verifierSiLaTurnACommence() throws AWTException {
		return this.screenPartie.getPresenceTurn();
	}
	
	public boolean verifierSiLaRiverACommence() throws AWTException {
		return this.screenPartie.getPresenceRiver();
	}
	
	public void incrementerIndexJoueurCourant() {
		try {
			this.indexJoueurCourant++;
			this.screenPartie.getListeDeScreenJoueur().get(this.indexJoueurCourant);
		} catch (IndexOutOfBoundsException  e) {
			this.indexJoueurCourant = 0;
		}
	}
	
}
