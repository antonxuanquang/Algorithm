import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FrameDemo extends JApplet {
	
	JPanel top, center, bottom;
	
	public void init() {
		setLayout(new BorderLayout());
		top = top();
		add(top, BorderLayout.NORTH);
		center();
		bottom();
	}

	private void bottom() {
		// TODO Auto-generated method stub
		bottom = new JPanel(new BorderLayout());
		bottom.add(new JTextField("At bottom method"));
		add(bottom, BorderLayout.SOUTH);
	}

	private void center() {
		// TODO Auto-generated method stub
		center = new JPanel(new BorderLayout());
		
		// do center top
		
		JLabel topLabel = new JLabel("Select to show pictures or not");
		JCheckBox cbSound = new JCheckBox("Sound On");
		
		// do center center
		
		JButton bt1 = new JButton ("Button 1");
		JButton bt2 = new JButton ("Button 2");
		
		
		// do center bottom
		
		JTextField tf = new JTextField("at center method");
		
		
		// add stuffs
		JPanel centerTop = new JPanel(new FlowLayout());
		centerTop.add(topLabel);
		centerTop.add(cbSound);
			center.add(centerTop, BorderLayout.NORTH);
		
		JPanel centerMiddle = new JPanel(new GridLayout(2,1));
		centerMiddle.add(bt1);
		centerMiddle.add(bt2);
			center.add(centerMiddle, BorderLayout.CENTER);
		
		JPanel centerSouth = new JPanel(new FlowLayout());
		centerSouth.add(tf);
			center.add(centerSouth, BorderLayout.SOUTH);
			
		// add the whole center panel to base panels
		add(center, BorderLayout.CENTER);
	}

	private JPanel top() {
		JPanel top = new JPanel(new FlowLayout());
		top.add(new JLabel("nice top"));
		return top;
	}
	
	
	
}
