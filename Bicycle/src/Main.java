import javax.swing.*;

public class Main extends JApplet {
	private static int WIDTH = 650;
	private static int HEIGHT = 340;

	public void init() {
		ControlPanel panel = new ControlPanel(WIDTH, HEIGHT);
		getContentPane().add(panel);
		setSize(WIDTH, HEIGHT);
	}
}
