package pokreader.ol.objects.game;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Turn extends Jeu{
	
public Turn(List<Joueur> listeDeJoueurs ,List<GameJoueur> listeActionsDesJoueurs) {
		
		super(listeDeJoueurs,listeActionsDesJoueurs);
		
	}

}
