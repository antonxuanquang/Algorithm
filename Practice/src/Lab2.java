import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;


public class Lab2 extends JApplet {
	
	
	public void paint(Graphics g) {
		Image image = getImage(getCodeBase(), "../test.png");
		g.drawImage(image, 0, 0, this);
	}
	
}
