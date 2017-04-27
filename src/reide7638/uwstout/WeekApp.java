package reide7638.uwstout;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;

/**
 * 
 * @author Student
 * A week scheduler application that allows the user to plan their week
 */

public class WeekApp {

	private JPanel centralpanel, upperpanel;
	private JPanel inputpanel1;

	
	
	private JFrame frame;
	public Westpanel westpanel;
	public InputPanel2 InputPanel2;
	public ClockPanel clockpanel;
	public Lowerpanel lowerpanel;
	
	
	
	
	public static ArrayList<Event> monday = new ArrayList<>();
	public static ArrayList<Event> tuesday = new ArrayList<>();
	public static ArrayList<Event> wednesday = new ArrayList<>();
	public static ArrayList<Event> thursday = new ArrayList<>();
	public static ArrayList<Event> friday = new ArrayList<>();
	public static ArrayList<Event> saturday = new ArrayList<>();
	public static ArrayList<Event> sunday = new ArrayList<>();
	
	public static ArrayList<ArrayList<Event>> week = new ArrayList<ArrayList<Event>>() {{
		add(sunday);
		add(monday);
		add(tuesday);
		add(wednesday);
		add(thursday);
		add(friday);
		add(saturday);
	}};
	
	/**
	 * Constructs the main JFrame for the application
	 */

	public WeekApp() {
		
		
		
		frame = new JFrame("Week Schedule");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		westpanel = new Westpanel();

		// Create the central panel

		centralpanel = new JPanel();
		centralpanel.setLayout(new BorderLayout());

		// Create an upper panel for the central panel
		upperpanel = new JPanel();
		upperpanel.setLayout(new GridBagLayout());
		upperpanel.setBackground(new Color(119, 150, 225));

		// Create a lower panel for the central panel
		lowerpanel = new Lowerpanel();
		

		GridBagConstraints gg = new GridBagConstraints();
		gg.anchor = GridBagConstraints.WEST;
		gg.insets = new Insets(5, 5, 5, 5);
		gg.fill = GridBagConstraints.HORIZONTAL;
		gg.gridx = 0;
		gg.gridy = 0;

		// Create the panel for user input
		inputpanel1 = new JPanel();
		inputpanel1.setBackground(Color.LIGHT_GRAY);
		inputpanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		inputpanel1.setPreferredSize(new Dimension(490, 310));
		
		InputPanel2 = new InputPanel2();
		
		inputpanel1.add(InputPanel2);
		
		// Create the panel for displaying date and time
		clockpanel = new ClockPanel();

		// Add the two panels to the upper-central panel
		upperpanel.add(inputpanel1, gg);
		gg.gridx = 1;
		upperpanel.add(clockpanel, gg);

		// Add panes to central pane
		centralpanel.add(upperpanel, BorderLayout.NORTH);
		centralpanel.add(lowerpanel, BorderLayout.CENTER);
		

		// Add all panels to frame
		frame.add(westpanel, BorderLayout.WEST);
		frame.add(centralpanel, BorderLayout.CENTER);
		
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(new File("Resources/Notebook.png"));
		} catch (IOException e) {
			System.out.println("Icon Error");
			System.exit(0);
		}
		
		frame.setIconImage(icon);

		frame.pack();
		frame.setVisible(true);

	}
	
	/**
	 * Runs the program with Nimbus look and feel
	 * @param args
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							UIManager.getLookAndFeelDefaults().put("Button.background",new Color(46,89,114));
			                UIManager.getLookAndFeelDefaults().put("Button.textForeground", Color.BLACK);
							break;
						} 
					}
				} catch (Exception e) {
					System.out.println("Error loading look and feel.");
				}
				new WeekApp();
			}
		});
	}

}

