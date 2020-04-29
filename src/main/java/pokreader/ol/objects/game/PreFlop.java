package pokreader.ol.objects.game;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;
import pokreader.ol.objects.screens.ScreenJoueur;


@NoArgsConstructor
public class PreFlop extends Jeu{
	
	public PreFlop(List<Joueur> listeDeJoueurs ,List<GameJoueur> listeActionsDesJoueurs) {
		
		super(listeDeJoueurs,listeActionsDesJoueurs);
		
	}

	public PreFlop(List<Joueur> listeDeJoueurs) {
		super(listeDeJoueurs);
		
		
	}
	
	

}
