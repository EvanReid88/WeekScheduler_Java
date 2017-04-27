package reide7638.uwstout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * Class for the lower JPanel of the WeekApp
 * @author Student
 *
 */

public class Lowerpanel extends JPanel {
	
	public static JTextArea dailyEvents;

	/** 
	 * Constructs the lower panel for the WeekApp
	 * Displays errors and event information for a given day
	 */
	
	public Lowerpanel() {
		setBorder(BorderFactory.createTitledBorder("Events"));
		setBackground(new Color(119, 150, 225));
		setLayout(new BorderLayout());

	
		
	
		dailyEvents = new JTextArea();

		dailyEvents.setEditable(false);
		dailyEvents.setBackground(new Color(192, 192, 192));
		dailyEvents.setFont(new Font("Calibri", Font.PLAIN, 18));
		dailyEvents.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		JScrollPane scroll = new JScrollPane(dailyEvents);
		
		add(scroll, BorderLayout.CENTER);
		
		
		
	}
	
	
	
	
}

