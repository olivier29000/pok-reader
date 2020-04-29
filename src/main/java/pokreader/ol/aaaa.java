package pokreader.ol;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.swing.plaf.SliderUI;

import pokreader.ol.objects.screens.ScreenEntite;
import pokreader.ol.objects.screens.ScreenJoueur;
import pokreader.ol.utils.UtilsScreenOrPointToEnum;
import pokreader.ol.utils.UtilsScreenOrPointToObject;
import pokreader.ol.utils.VariablesGlobales;

public class aaaa {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		URL url = new URL("https://poker.p.rapidapi.com/");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-rapidapi-host", "poker.p.rapidapi.com");
        connection.setRequestProperty("x-rapidapi-key", "82b9554940mshccba6c1de168eedp118503jsnddb7656075f0");
        connection.connect();

        int code = connection.getResponseCode();
        System.out.println("Response code of the object is "+code);
        if (code==200)
        {
            System.out.println("OK");
        }
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer html = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
		html.append(inputLine);
		}
		in.close();
		
		System.out.println("URL Content... \n" + html.toString());
		System.out.println("Done");
		
		
		
		
			
		
	}

}
