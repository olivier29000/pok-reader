package pokreader.ol.objects.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pokreader.ol.objects.autre.Etape;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoueurPost {
	
	private String nomjoueur;
	private Etape etape;

}
