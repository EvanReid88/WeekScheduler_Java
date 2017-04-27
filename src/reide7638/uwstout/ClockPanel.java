package reide7638.uwstout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * Class for the JPanel that displays time, date, and upcoming events
 * @author Student
 *
 */

public class ClockPanel extends JPanel {

	private JLabel clocklab;
	private JLabel clocklabtwo;
	private JLabel date, time;
	private JLabel alertPanel, alertPanelTwo;
	
	
	/**
	 * Constructs a panel that displays date, time (military format) 
	 * Alerts user if event is starting within 20 minutes
	 */
	

	public ClockPanel() {

		setLayout(new GridBagLayout());
		setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gt = new GridBagConstraints();

		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(200, 310));

		clocklab = new JLabel("Date");
		clocklabtwo = new JLabel("Time");

		alertPanel = new JLabel();
		alertPanel.setSize(50, 30);

		alertPanelTwo = new JLabel();
		alertPanelTwo.setSize(50, 30);

		date = new JLabel("Date");
		time = new JLabel("Time");

		DecimalFormat df = new DecimalFormat("00");

		Thread clock = new Thread() {
			public void run() {

				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
					

						int hour;

						if (cal.get(Calendar.HOUR_OF_DAY) == 0) {
							hour = 24;
						} else {
							hour = cal.get(Calendar.HOUR_OF_DAY);
						}

						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = (cal.get(Calendar.MONTH) + 1);
						int year = cal.get(Calendar.YEAR);

						int dayweek = cal.get(Calendar.DAY_OF_WEEK) - 1;

						clocklab.setText(month + "/" + day + "/" + year);
						clocklabtwo.setText(hour + ":" + df.format(minute) + ":" + second);

						for (int i = 0; i < WeekApp.week.get(dayweek).size(); i++) {
							if (WeekApp.week.get(dayweek).get(i).getSTimeH() == hour) {

								if ((minute >= (WeekApp.week.get(dayweek).get(i).getStimeM() - 20))
										&& (minute <= WeekApp.week.get(dayweek).get(i).getStimeM())) {

									alertPanel.setText(WeekApp.week.get(dayweek).get(i).getName() + " Starting in ");
									alertPanelTwo.setText(
											(String.valueOf(WeekApp.week.get(dayweek).get(i).getStimeM() - minute))
													+ " Minutes");

								} else {
									alertPanel.setText("");
									alertPanelTwo.setText("");
								}

							} else if ((WeekApp.week.get(dayweek).get(i).getSTimeH() == (hour + 1))
						|| (WeekApp.week.get(dayweek).get(i).getSTimeH() == (hour - 23))) {

								if ((minute >= (WeekApp.week.get(dayweek).get(i).getStimeM() + 60 - 20))
										&& (minute <= WeekApp.week.get(dayweek).get(i).getStimeM() + 60)) {

									alertPanel.setText(WeekApp.week.get(dayweek).get(i).getName() + " Starting in ");
									alertPanelTwo.setText((String
											.valueOf((WeekApp.week.get(dayweek).get(i).getStimeM() + 60) - minute))
											+ " Minutes");

								} else {
									alertPanel.setText("");
									alertPanelTwo.setText("");
								}

							}
						}

						sleep(1000);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();

		Font clockfont = new Font("Calibri", Font.PLAIN, 30);
		Font alertfont = new Font("Calibri", Font.BOLD, 20);

		alertPanel.setFont(alertfont);
		alertPanelTwo.setFont(alertfont);

		alertPanel.setForeground(Color.RED);
		alertPanelTwo.setForeground(Color.RED);

		clocklab.setFont(clockfont);
		clocklabtwo.setFont(clockfont);

		date.setText("Date");
		date.setFont(clockfont);

		time.setText("Time");
		time.setFont(clockfont);

		gt.gridx = 0;
		gt.gridy = 0;
		gt.anchor = GridBagConstraints.CENTER;

		add(date, gt);

		gt.gridy = 1;

		add(clocklab, gt);

		gt.gridy = 2;

		add(time, gt);

		gt.gridy = 3;

		add(clocklabtwo, gt);

		gt.gridy = 4;

		add(alertPanel, gt);

		gt.gridy = 5;

		add(alertPanelTwo, gt);

	}

}
