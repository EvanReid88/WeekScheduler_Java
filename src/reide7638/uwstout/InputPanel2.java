package reide7638.uwstout;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Class for the JPanel where user enters event information
 * @Author student
 */

public class InputPanel2 extends JPanel {

	public JButton add;
	private JLabel name, description, location, stime, etime, dates;
	public JTextField namef, descriptionf, locationf, stime2h, stime2m, etime2h, etime2m;
	public JRadioButton sunbutton, monbutton, tuesbutton, wedbutton, thursbutton, fributton, satbutton;
	
	/**
	 * Creates the panel where user enters event information
	 */

	public InputPanel2() {

		setBorder(BorderFactory.createTitledBorder("Add Event"));
		setLayout(new GridBagLayout());
		setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gb = new GridBagConstraints();

		gb.insets = new Insets(0, 0, 0, 0);
		// Create and add labels
		gb.gridx = 0;
		gb.gridy = 0;

		// JLabel title = new JLabel("Add Event");
		name = new JLabel("Event Name");
		description = new JLabel("Description");
		location = new JLabel("Location");
		stime = new JLabel("Start Time (HH:MM)");
		etime = new JLabel("End Time (HH:MM)");
		dates = new JLabel("Days");

		gb.anchor = GridBagConstraints.WEST;

		gb.gridy = 0;
		add(name, gb);

		gb.gridy = 1;
		add(description, gb);

		gb.gridy = 2;
		add(location, gb);

		gb.gridy = 3;
		add(stime, gb);

		gb.gridy = 4;
		add(etime, gb);

		gb.gridy = 5;
		add(dates, gb);

		// Create and add text areas, then buttons
		namef = new JTextField(30);
		descriptionf = new JTextField(30);
		locationf = new JTextField(30);

		try {
			stime2h = new JFormattedTextField(new MaskFormatter(("##")));

		} catch (Exception e) {

		}
		stime2h.setColumns(14);

		try {
			stime2m = new JFormattedTextField(new MaskFormatter(("##")));

		} catch (Exception e) {

		}
		stime2m.setColumns(14);

		try {
			etime2h = new JFormattedTextField(new MaskFormatter(("##")));

		} catch (Exception e) {

		}
		etime2h.setColumns(14);

		try {
			etime2m = new JFormattedTextField(new MaskFormatter(("##")));

		} catch (Exception e) {

		}
		etime2m.setColumns(14);

		gb.gridx = 1;
		gb.gridy = 0;
		add(namef, gb);

		gb.gridy = 1;
		add(descriptionf, gb);

		gb.gridy = 2;
		add(locationf, gb);

		JPanel time1 = new JPanel();
		time1.setBackground(Color.LIGHT_GRAY);

		JPanel time2 = new JPanel();
		time2.setBackground(Color.LIGHT_GRAY);

		gb.gridy = 3;
		time1.add(stime2h);
		time1.add(stime2m);

		add(time1, gb);

		gb.gridy = 4;
		time2.add(etime2h);
		time2.add(etime2m);

		add(time2, gb);

		// Create and add radial button panel
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.LIGHT_GRAY);
		JPanel radioPanel2 = new JPanel();
		radioPanel2.setBackground(Color.LIGHT_GRAY);

		gb.anchor = GridBagConstraints.CENTER;
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 5;
		gb.gridwidth = 2;

		sunbutton = new JRadioButton("Sunday", false);
		monbutton = new JRadioButton("Monday", false);
		tuesbutton = new JRadioButton("Tuesday", false);
		wedbutton = new JRadioButton("Wednesday", false);
		thursbutton = new JRadioButton("Thursday", false);
		fributton = new JRadioButton("Friday", false);
		satbutton = new JRadioButton("Saturday", false);

		sunbutton.setBackground(Color.LIGHT_GRAY);
		monbutton.setBackground(Color.LIGHT_GRAY);
		tuesbutton.setBackground(Color.LIGHT_GRAY);
		wedbutton.setBackground(Color.LIGHT_GRAY);
		thursbutton.setBackground(Color.LIGHT_GRAY);
		fributton.setBackground(Color.LIGHT_GRAY);
		satbutton.setBackground(Color.LIGHT_GRAY);

		radioPanel.add(sunbutton);
		radioPanel.add(monbutton);
		radioPanel.add(tuesbutton);
		radioPanel.add(wedbutton);

		radioPanel2.add(thursbutton);
		radioPanel2.add(fributton);
		radioPanel2.add(satbutton);

		add(radioPanel, gb);
		gb.gridy = 6;
		add(radioPanel2, gb);

		// Create and add jbutton inside a panel
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBackground(Color.LIGHT_GRAY);

		add = new JButton("Add Event");

		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEvent();
			}
		});

		buttonpanel.add(add);

		gb.gridy = 7;
		gb.gridx = 0;
		add(buttonpanel, gb);

	}
	
	/**
	 * Adds the entered event to given days of the week 
	 */

	public void addEvent() {

		if ((namef.getText().equals("")) || (stime2h.getText().equals("")) || (stime2m.getText().equals(""))
				|| (etime2h.getText().equals("")) || (etime2m.getText().equals(""))
				|| (descriptionf.getText().equals("")) || (locationf.getText().equals(""))) {

			Lowerpanel.dailyEvents.setText("");
			Lowerpanel.dailyEvents.append("Invalid Input: Must Enter All Information" + "\n");

		} else if ((Integer.parseInt(stime2h.getText()) <= 0) || (Integer.parseInt(stime2h.getText()) > 24) 
					|| (Integer.parseInt(etime2h.getText()) <= 0) || (Integer.parseInt(etime2h.getText()) > 24) 
					|| ((Integer.parseInt(stime2m.getText()) < 0) || (Integer.parseInt(stime2m.getText()) >= 60))
					|| ((Integer.parseInt(etime2m.getText()) < 0) || (Integer.parseInt(etime2m.getText()) >= 60))) {
			
			Lowerpanel.dailyEvents.setText("");
			Lowerpanel.dailyEvents.append("Invalid Input: Must Enter Valid Times (Military Time)" + "\n");
			
			
		} else {
			
				Event newEvent = new Event(namef.getText(), descriptionf.getText(), locationf.getText(),
						Integer.parseInt(stime2h.getText()), Integer.parseInt(stime2m.getText()),
						Integer.parseInt(etime2h.getText()), Integer.parseInt(etime2m.getText()));

				if (monbutton.isSelected() == true) {
					WeekApp.monday.add(newEvent);
					Westpanel.montext.append(newEvent.getName() + "\n");
				}
				if (tuesbutton.isSelected() == true) {
					WeekApp.tuesday.add(newEvent);
					Westpanel.tuestext.append(newEvent.getName() + "\n");
				}
				if (wedbutton.isSelected() == true) {
					WeekApp.wednesday.add(newEvent);
					Westpanel.wedtext.append(newEvent.getName() + "\n");
				}
				if (thursbutton.isSelected() == true) {
					WeekApp.thursday.add(newEvent);
					Westpanel.thurstext.append(newEvent.getName() + "\n");
				}
				if (fributton.isSelected() == true) {
					WeekApp.friday.add(newEvent);
					Westpanel.fritext.append(newEvent.getName() + "\n");
				}
				if (satbutton.isSelected() == true) {
					WeekApp.saturday.add(newEvent);
					Westpanel.sattext.append(newEvent.getName() + "\n");
				}
				if (sunbutton.isSelected() == true) {
					WeekApp.sunday.add(newEvent);
					Westpanel.suntext.append(newEvent.getName() + "\n");
				} else {
					
				}

			} 

			
		namef.setText("");
		stime2h.setText("");
		stime2m.setText("");
		etime2h.setText("");
		etime2m.setText("");
		descriptionf.setText("");
		locationf.setText("");

		monbutton.setSelected(false);
		tuesbutton.setSelected(false);
		wedbutton.setSelected(false);
		thursbutton.setSelected(false);
		fributton.setSelected(false);
		satbutton.setSelected(false);
		sunbutton.setSelected(false);

	}
	
}


