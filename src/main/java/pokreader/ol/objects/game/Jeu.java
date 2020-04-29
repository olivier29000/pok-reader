package pokreader.ol.objects.game;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

public class Jeu {
	

	private List<Joueur> listeDeJoueurs;
	private List<GameJoueur> listeActionsDesJoueurs;
	
	public Jeu(List<Joueur> listeDeJoueurs ,List<GameJoueur> listeActionsDesJoueurs) {
		super();
		this.listeDeJoueurs = listeDeJoueurs;
		this.listeActionsDesJoueurs = listeActionsDesJoueurs;
	}
	
	public Jeu(List<Joueur> listeDeJoueurs ) {
		super();
		List<GameJoueur> listeActionsDesJoueurs = new ArrayList<GameJoueur>();
		this.listeDeJoueurs = listeDeJoueurs;
		this.listeActionsDesJoueurs = listeActionsDesJoueurs;
	}
	
	public Jeu() {
		super();
		this.listeDeJoueurs = new ArrayList<Joueur>();
		this.listeActionsDesJoueurs = new ArrayList<GameJoueur>();
	}
	
	public List<Joueur> getListeDeJoueurs() {
		return listeDeJoueurs;
	}
	
	public void setListeDeJoueurs(List<Joueur> listeDeJoueurs) {
		this.listeDeJoueurs = listeDeJoueurs;
	}
	
	public List<GameJoueur> getListeActionsDesJoueurs() {
		return listeActionsDesJoueurs;
	}
	
	public void setListeActionsDesJoueurs(List<GameJoueur> listeActionsDesJoueurs) {
		this.listeActionsDesJoueurs = listeActionsDesJoueurs;
	}

}
