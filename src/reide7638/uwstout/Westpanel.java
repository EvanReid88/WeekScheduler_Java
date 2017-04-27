package reide7638.uwstout;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * Class for JPanel that displays days of the week as well as names for events on a given day
 * @author Student
 *
 */

public class Westpanel extends JPanel {
	
	public JButton sun, mon, tues, wed, thurs, fri, sat;
	public static JTextArea suntext;
	public static JTextArea montext;
	public static JTextArea tuestext;
	public static JTextArea wedtext;
	public static JTextArea thurstext;
	public static JTextArea fritext;
	public static JTextArea sattext;
	private JScrollPane s, m, t, w, th, f, sa;
	
	public static Lowerpanel lowerpanel;
	public static InputPanel2 InputPanel2;
	
	/**
	 * Constructs the JPanel that displays days of the week as well as names for events on a given day
	 * 
	 */
	
	public Westpanel() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		setBackground(Color.GRAY);
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST; // left aligns everything
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		sun = new JButton("Sunday");
		
		sun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Sunday" + "\n");
				printEvents(0);
			}
		});
		
		mon = new JButton("Monday");
	
		mon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Monday" + "\n");
				printEvents(1);
			}
		});
		
		tues = new JButton("Tuesday");

		tues.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Tuesday" + "\n");
				printEvents(2);
			}
		});
		
		wed = new JButton("Wednesday");

		wed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Wednesday" + "\n");
				printEvents(3);
			}
		});
		
		thurs = new JButton("Thursday");

		thurs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Thursday" + "\n");
				printEvents(4);
			}
		});
		
		fri = new JButton("Friday");

		fri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Friday" + "\n");
				printEvents(5);
			}
		});
		
		sat = new JButton("Saturday");

		sat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lowerpanel.dailyEvents.setText("");
				Lowerpanel.dailyEvents.append("Saturday" + "\n");
				printEvents(6);
			}
		});
		
		// Create Text Areas
		suntext = new JTextArea(3, 15);
		suntext.setEditable(false);
		suntext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		suntext.setBackground(Color.lightGray);
		s = new JScrollPane(suntext);
		
		montext = new JTextArea(3, 15);
		montext.setEditable(false);
		montext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		montext.setBackground(Color.lightGray);
		m = new JScrollPane(montext);
		
		tuestext = new JTextArea(3, 15);
		tuestext.setEditable(false);
		tuestext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		tuestext.setBackground(Color.lightGray);
		t = new JScrollPane(tuestext);
		
		wedtext = new JTextArea(3, 15);
		wedtext.setEditable(false);
		wedtext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		wedtext.setBackground(Color.lightGray);
		w = new JScrollPane(wedtext);
		
		thurstext = new JTextArea(3, 15);
		thurstext.setEditable(false);
		thurstext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		thurstext.setBackground(Color.lightGray);
		th = new JScrollPane(thurstext);
		
		fritext = new JTextArea(3, 15);
		fritext.setEditable(false);
		fritext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		fritext.setBackground(Color.lightGray);
		f = new JScrollPane(fritext);
		
		sattext = new JTextArea(3, 15);
		sattext.setEditable(false);
		sattext.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		sattext.setBackground(Color.lightGray);
		sa = new JScrollPane(sattext);
		
		// Add buttons and text areas to west panel
		
		// gbc.gridy = 0
		add(sun, gbc);
		
		gbc.gridy = 1;
		add(s, gbc);
		
		gbc.gridy = 2;
		add(mon, gbc);
		
		gbc.gridy = 3;
		add(m, gbc);
		
		gbc.gridy = 4;
		add(tues, gbc);
		
		gbc.gridy = 5;
		add(t, gbc);
		
		gbc.gridy = 6;
		add(wed, gbc);
		
		gbc.gridy = 7;
		add(w, gbc);
		
		gbc.gridy = 8;
		add(thurs, gbc);
		
		gbc.gridy = 9;
		add(th, gbc);
		
		gbc.gridy = 10;
		add(fri, gbc);
		
		gbc.gridy = 11;
	    add(f, gbc);
		
		gbc.gridy = 12;
		add(sat, gbc);
		
		gbc.gridy = 13;
		add(sa, gbc);
		
	}
	
	/**
	 * Prints the events of a given day onto the lower panel of the WeekApp
	 * @param number representing the day of the week
	 */
	
	public void printEvents(int daynumber) {
		
		DecimalFormat df = new DecimalFormat("00");
		
		for (int i = 0; i < WeekApp.week.get(daynumber).size(); i++) {
			Lowerpanel.dailyEvents.append("\n" + "__________________________________________________________________________" + "\n");
			Lowerpanel.dailyEvents.append("Event Name: " + WeekApp.week.get(daynumber).get(i).getName() + "\n");
			Lowerpanel.dailyEvents.append("Event Description: " + WeekApp.week.get(daynumber).get(i).getDescription() + "\n");
			Lowerpanel.dailyEvents.append("Event Location: " + WeekApp.week.get(daynumber).get(i).getLocation() + "\n");
			Lowerpanel.dailyEvents.append("Start Time: " + WeekApp.week.get(daynumber).get(i).getSTimeH() + " : " + df.format(WeekApp.week.get(daynumber).get(i).getStimeM()));
			Lowerpanel.dailyEvents.append(" End Time: " + WeekApp.week.get(daynumber).get(i).getETimeH() + " : " + df.format(WeekApp.week.get(daynumber).get(i).getETimeM()));		
										
			
			
		}
		
		
	}

}
