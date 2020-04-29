package pokreader.ol.objects.game;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Flop extends Jeu{

	public Flop(List<Joueur> listeDeJoueurs ,List<GameJoueur> listeActionsDesJoueurs) {
		
		super(listeDeJoueurs,listeActionsDesJoueurs);
		
	}
	
	public Flop(List<Joueur> listeDeJoueurs) {
		super(listeDeJoueurs);
		
		
	}
}
