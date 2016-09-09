
import javax.swing.*;
import java.awt.*;

public class Lab1 extends JApplet {

	public JButton btnStop = new JButton("Stop");
	public JButton btnGo = new JButton("GO");
	public JLabel lblPress = new JLabel("Press This");
	
	public void init() {
		setLayout(new FlowLayout());
		add(btnStop);

		function();
		add(btnGo);
		
	}
	public void function() {
		add(lblPress);
	}
}
