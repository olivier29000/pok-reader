package pokreader.ol.utils;

import java.awt.Point;

public class VariablesGlobales {


	public static int xJoueur0 = 185;
	public static int yJoueur0 = 649;
	public static int xPresenceBoutonJoueur0 = 407;
	public static int yPresenceBoutonJoueur0 = 609;
	
	public static int xJoueur1 = 92;
	public static int yJoueur1 = 272;
	public static int xPresenceBoutonJoueur1 = 228;
	public static int yPresenceBoutonJoueur1 = 342;
	
	public static int xJoueur2 = 559;
	public static int yJoueur2 = 175;
	public static int xPresenceBoutonJoueur2 = 517;
	public static int yPresenceBoutonJoueur2 = 228;
	
	public static int xJoueur3 = 1022;
	public static int yJoueur3 = 272;
	public static int xPresenceBoutonJoueur3 = 1024;
	public static int yPresenceBoutonJoueur3 = 345;
	
	public static int xJoueur4 = 931;
	public static int yJoueur4 = 648;
	public static int xPresenceBoutonJoueur4 = 849;
	public static int yPresenceBoutonJoueur4 = 608;
	
	public static int xJoueur5 = 558;
	public static int yJoueur5 = 713;
	public static int xPresenceBoutonJoueur5 = 518;
	public static int yPresenceBoutonJoueur5 = 623;
	

	public static int widthCarte = 80;
	public static int heightCarte = 107;
	
	public static int xCarte1Joueur = 0;
	public static int yCarte1Joueur = - heightCarte;
	public static int xCarte2Joueur = xCarte1Joueur + widthCarte + 2;
	public static int yCarte2Joueur = - heightCarte;
	public static int widthJoueur = 168;
	public static int heightJoueur = 56;
	
	
	public static int widthNomJoueur = widthJoueur;
	public static int heightNomJoueur = heightJoueur/2;
	public static int widthActionJoueur = 100;
	public static int heightActionJoueur = 40;
	
	public static int xNomJoueur = 0;
	public static int yNomJoueur = 0;
	
	
	public static int xStackJoueur = 0;
	public static int yStackJoueur = heightJoueur/2;
	public static int widthStackJoueur = widthNomJoueur;
	public static int heightStackJoueur = heightNomJoueur;
	public static int widthNumeroCarte = 25;
	public static int heightNumeroCarte = 25;
	
	public static int xActionJoueur = 40;
	public static int yActionJoueur = - 75;
	
	public static int xPresenceJoueur = 132;
	public static int yPresenceJoueur = -15;
	
	public static int xCarteFlop0 = 420;
	public static int yCarteFlop0 = 350;
	public static int xCarteFlop1 = xCarteFlop0 + widthCarte + 6;
	public static int yCarteFlop1 = yCarteFlop0;
	public static int xCarteFlop2 = xCarteFlop1 + widthCarte + 6;
	public static int yCarteFlop2 = yCarteFlop1;
	public static int xCarteFlop3 = xCarteFlop2 + widthCarte + 6;
	public static int yCarteFlop3  = yCarteFlop2;
	public static int xCarteFlop4 = xCarteFlop3 + widthCarte + 6;
	public static int yCarteFlop4  = yCarteFlop3;
	public static int xPresenceVertJoueurHumain = 715;
	public static int yPresenceVertJoueurHumain = 760;
	
	
	
	
	public VariablesGlobales(double proportion, Point pointOrigine) {

		int xpointOrigine = pointOrigine.x;
		int ypointOrigine = pointOrigine.y;
		
		this.xJoueur0 =  (int) (xJoueur0 * proportion) + xpointOrigine;
		this.yJoueur0 =  (int) (yJoueur0 * proportion) + ypointOrigine;
		this.xPresenceBoutonJoueur0 =  (int) (xPresenceBoutonJoueur0 * proportion) + xpointOrigine;
		this.yPresenceBoutonJoueur0 = (int) (yPresenceBoutonJoueur0 * proportion) + ypointOrigine;
		
		this.xJoueur1 = (int) (xJoueur1 * proportion)  + xpointOrigine;
		this.yJoueur1 =  (int) (yJoueur1 * proportion) + ypointOrigine;
		this.xPresenceBoutonJoueur1 =  (int) (xPresenceBoutonJoueur1 * proportion)  + xpointOrigine;
		this.yPresenceBoutonJoueur1 =  (int) (yPresenceBoutonJoueur1 * proportion) + ypointOrigine;
		
		this.xJoueur2 =  (int) (xJoueur2 * proportion)  + xpointOrigine;
		this.yJoueur2 =  (int) (yJoueur2 * proportion) + ypointOrigine;
		this.xPresenceBoutonJoueur2 =  (int) (xPresenceBoutonJoueur2 * proportion) + xpointOrigine;
		this.yPresenceBoutonJoueur2 =  (int) (yPresenceBoutonJoueur2 * proportion) + ypointOrigine;
		
		this.xJoueur3 =  (int) (xJoueur3 * proportion) + xpointOrigine;
		this.yJoueur3 =  (int) (yJoueur3 * proportion) + ypointOrigine;
		this.xPresenceBoutonJoueur3 =  (int) (xPresenceBoutonJoueur3 * proportion) + xpointOrigine;
		this.yPresenceBoutonJoueur3 =  (int) (yPresenceBoutonJoueur3 * proportion) + ypointOrigine;
		
		this.xJoueur4 =  (int) (xJoueur4 * proportion) + xpointOrigine;
		this.yJoueur4 =  (int) (yJoueur4 * proportion) + ypointOrigine;
		this.xPresenceBoutonJoueur4 =  (int) (xPresenceBoutonJoueur4 * proportion) + xpointOrigine;
		this.yPresenceBoutonJoueur4 =  (int) (yPresenceBoutonJoueur4 * proportion) + ypointOrigine;
		
		this.xJoueur5 =  (int) (xJoueur5 * proportion) + xpointOrigine;
		this.yJoueur5 =  (int) (yJoueur5 * proportion) + ypointOrigine;
		this.xPresenceBoutonJoueur5 = (int) (xPresenceBoutonJoueur5 * proportion) + xpointOrigine;
		this.yPresenceBoutonJoueur5 =  (int) (yPresenceBoutonJoueur5 * proportion) + ypointOrigine;
		

		this.widthCarte =  (int) (widthCarte * proportion);
		this.heightCarte =  (int) (heightCarte * proportion);
		
		this.xCarte1Joueur =  (int) (xCarte1Joueur * proportion) + xpointOrigine;
		this.yCarte1Joueur =  (int) (yCarte1Joueur * proportion) + ypointOrigine;
		this.xCarte2Joueur =  (int) (xCarte2Joueur * proportion) + xpointOrigine;
		this.yCarte2Joueur =  (int) (yCarte2Joueur * proportion) + ypointOrigine;
		this.widthJoueur =  (int) (widthJoueur * proportion);
		this.heightJoueur =  (int) (heightJoueur * proportion);
		
		
		this.widthNomJoueur =  (int) (widthNomJoueur * proportion);
		this.heightNomJoueur =  (int) (heightNomJoueur * proportion);
		this.widthActionJoueur =  (int) (widthActionJoueur * proportion);
		this.heightActionJoueur =  (int) (heightActionJoueur * proportion);
		this.widthNumeroCarte =  (int) (widthNumeroCarte * proportion);
		this.heightNumeroCarte =  (int) (heightNumeroCarte * proportion);
		
		this.xNomJoueur =  (int) (xNomJoueur * proportion);
		this.yNomJoueur =  (int) (yNomJoueur * proportion);
		
		
		this.xStackJoueur =  (int) (xStackJoueur * proportion);
		this.yStackJoueur =  (int) (yStackJoueur * proportion);
		this.widthStackJoueur =  (int) (widthStackJoueur * proportion);
		this.heightStackJoueur =  (int) (heightStackJoueur * proportion);
		
		this.xActionJoueur =  (int) (xActionJoueur * proportion);
		this.yActionJoueur =  (int) (yActionJoueur * proportion);
		
		
		this.xPresenceJoueur =  (int) (xPresenceJoueur * proportion);
		this.yPresenceJoueur =  (int) (yPresenceJoueur * proportion);
		
		this.xCarteFlop0 =  (int) (xCarteFlop0 * proportion) + xpointOrigine;
		this.yCarteFlop0 =  (int) (yCarteFlop0 * proportion) + ypointOrigine;
		this.xCarteFlop1 =  (int) (xCarteFlop1 * proportion) + xpointOrigine;
		this.yCarteFlop1 =  (int) (yCarteFlop1 * proportion) + ypointOrigine;
		this.xCarteFlop2 =  (int) (xCarteFlop2 * proportion) + xpointOrigine;
		this.yCarteFlop2 =  (int) (yCarteFlop2 * proportion) + ypointOrigine;
		this.xCarteFlop3 =  (int) (xCarteFlop3 * proportion) + xpointOrigine;
		this.yCarteFlop3  =  (int) (yCarteFlop3 * proportion) + ypointOrigine;
		this.xCarteFlop4 =  (int) (xCarteFlop4 * proportion) + xpointOrigine;
		this.yCarteFlop4  =  (int) (yCarteFlop4 * proportion) + ypointOrigine;
		
		this.xPresenceVertJoueurHumain =  (int) (xPresenceVertJoueurHumain * proportion) + xpointOrigine; 
		this.yPresenceVertJoueurHumain = (int) (yPresenceVertJoueurHumain * proportion) + ypointOrigine; 
		
		
		VariablesJoueurs variablesJoueurs =  new VariablesJoueurs();
		VariablesCartes variablesCartes = new VariablesCartes();
	}
	
	

}
