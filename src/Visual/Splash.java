/**
 * 
 */
package Visual;

import java.awt.Color;

import com.thehowtotutorial.splashscreen.JSplash;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class Splash {
	
	public static void main(String args[]) throws InterruptedException{

	JSplash pantalla = new JSplash(Splash.class.getResource("din.jpg"), true, true, false, "BETA 1.0", null, Color.WHITE, Color.blue);
	
	pantalla.splashOn();
	
	pantalla.setProgress(20, "Initializing...");
	Thread.sleep(2000); 
	pantalla.setProgress(40, "Loading...");
	Thread.sleep(2000);
	pantalla.setProgress(60, "Configuring...");
	Thread.sleep(2000);
	pantalla.setProgress(80, "Launching App...");
	Thread.sleep(2000);
	pantalla.splashOff();
	
	new principal().setVisible(true);
	}
}
