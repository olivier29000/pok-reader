package pokreader.ol.objects.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carte {
	
	private Enum NumeroCarte;
	private Enum CouleurCarte;

}
