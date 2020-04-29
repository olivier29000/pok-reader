package pokreader.ol.objects.screens;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import pokreader.ol.objects.game.Carte;
import pokreader.ol.utils.UtilsScreenOrPointToObject;
import pokreader.ol.utils.VariablesGlobales;


@Data
@NoArgsConstructor
public class ScreenCarte extends ScreenEntite{
	
	
	public ScreenCarte(ScreenEntite screenEntite) {
		super(screenEntite.getPointOrigine(),screenEntite.getRectangle());
	}
	ScreenEntite numeroCarte;
	ScreenEntite signeCarte ;
	
	
	public Carte instancierCarte() throws AWTException, IOException, TesseractException {
		return UtilsScreenOrPointToObject.getCarte(this);
	}


	public ScreenCarte(Point pointOrigine, Rectangle rectangle) {
		super(pointOrigine,rectangle);
		this.numeroCarte = new ScreenEntite(pointOrigine,
				new Rectangle(pointOrigine.x,
						pointOrigine.y,
						VariablesGlobales.widthNumeroCarte,
						VariablesGlobales.heightNumeroCarte));
		this.signeCarte = new ScreenEntite(pointOrigine,
				new Rectangle(pointOrigine.x,
						pointOrigine.y  + VariablesGlobales.heightNumeroCarte,
						VariablesGlobales.widthNumeroCarte,
						VariablesGlobales.heightNumeroCarte));
	};
	
	
	
	
}
