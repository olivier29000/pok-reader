package pokreader.ol.objects.game;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Joueur {

	private double stackJoueur;
	private String nomJoueur;
	
	public Joueur(String nomJoueur, double stackJoueur) {
		super();
		this.nomJoueur = nomJoueur;
		this.stackJoueur = stackJoueur;
	}

}
