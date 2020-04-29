package pokreader.ol.objects.game;


import java.time.ZonedDateTime;

import pokreader.ol.objects.autre.ActionJoueur;


public class GameJoueur {
	
	
	private Joueur joueur;
	private ActionJoueur actionJoueur;
	
	
	
	public GameJoueur(Joueur joueur, ActionJoueur actionJoueur) {
		super();
		this.joueur = joueur;
		this.actionJoueur = actionJoueur;
	}

	public GameJoueur() {
		super();
	}

	
	public ActionJoueur getActionJoueur() {
		return actionJoueur;
	}
	public void setActionJoueur(ActionJoueur actionJoueur) {
		this.actionJoueur = actionJoueur;
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
