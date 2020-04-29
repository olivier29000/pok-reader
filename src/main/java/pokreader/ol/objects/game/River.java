package pokreader.ol.objects.game;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class River extends Jeu{

public River(List<Joueur> listeDeJoueurs ,List<GameJoueur> listeActionsDesJoueurs) {
		
		super(listeDeJoueurs,listeActionsDesJoueurs);
		
	}
}
