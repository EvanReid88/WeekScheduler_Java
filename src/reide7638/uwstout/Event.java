package reide7638.uwstout;

/**
 * Class that stores information of for an event in an object
 * @author Student
 *
 */

public class Event {

	private String className;
	private String description;
	private String location;
	
	private int hoursone, minutesone, hourstwo, minutestwo;
	
	/**
	 * Creates an event 
	 * @param className The name of the event
	 * @param description Description of the event
	 * @param location Location of the event
	 * @param hoursone Hour that event starts
	 * @param minutesone Minute that event starts
	 * @param hourstwo Hour that event ends
	 * @param minutestwo Minute that event ends
	 */

	public Event(String className, String description, String location,
					int hoursone, int minutesone, int hourstwo, int minutestwo) {
		
		this.className = className;
		this.description = description;
		this.location = location;
		
		this.hoursone = hoursone;
		this.minutesone = minutesone;
		this.hourstwo = hourstwo;
		this.minutestwo = minutestwo;
		
		

	}
	
	/**
	 * Method for getting the event name.
	 * @return Name of the event
	 */
	
	public String getName() {
		return className;
	}
	
	/**
	 * Method for getting the event description.
	 * @return Description of the event
	 */

	public String getDescription() {
		return description;
	}
	
	/**
	 * Method for getting the location of an event
	 * @return Location of the event
	 */
	
	public String getLocation() {
		return location;
	}
	
	/**
	 * Method for getting the starting time hour of an event
	 * @return Starting hour of the event (Military Time)
	 */
	
	public int getSTimeH() {
		return hoursone;
	}
	
	/**
	 * Method for getting the starting time minute of an event
	 * @return Starting minute of the event
	 */
	
	public int getStimeM() {
		return minutesone;
	}
	
	/**
	 * Method for getting the ending time hour of an event
	 * @return Ending hour of the event (Military Time)
	 */
	
	public int getETimeH() {
		return hourstwo;
	}
	
	/**
	 * Method for getting the sending time minute of an event
	 * @return Ending minute of the event
	 */
	
	public int getETimeM() {
		return minutestwo;
	}

}
