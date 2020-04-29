package pokreader.ol.manager;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class ConfigScreenManager {
	
	
	public void mouseClicked(MouseEvent e) {
	      e.getLocationOnScreen();
	   }
	
	public static Point[] configScreenController() {
		
		Point pointHautGauche = new Point();
		Point pointBasDroite = new Point();
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Pointez le haut à gauche de la fenetre");
 	     scan.nextLine();
 	    pointHautGauche = MouseInfo.getPointerInfo().getLocation();
		System.out.println("Point1 : " + pointHautGauche.toString());
		pointHautGauche = MouseInfo.getPointerInfo().getLocation();
		System.out.println("Point2 : " + pointHautGauche.toString());
		System.out.print("Pointez le bas à droite de la fenetre");
	     scan.nextLine();
	     pointBasDroite = MouseInfo.getPointerInfo().getLocation();
		System.out.println("Point3 : " + pointBasDroite.toString());
		
		Point[] tableauDeDeuxPoints = {pointHautGauche,pointBasDroite};
	        return tableauDeDeuxPoints;
	    }
	
	}
	
	class Listener implements AWTEventListener {
		
		private List<int[]> retour = new ArrayList<int[]>();
		
        public void eventDispatched(AWTEvent event) {
    		
        	int[] tabCoordonnees = {
        			MouseInfo.getPointerInfo().getLocation().x,
        			MouseInfo.getPointerInfo().getLocation().x
        			};
        	
        	this.retour.add(tabCoordonnees);
         
        }
        
        public List<int[]> getRetour() {
    		return retour;
    	}


    	public void setRetour(List<int[]> retour) {
    		this.retour = retour;
    	}

    }
	
	


