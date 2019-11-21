package Api.SpeakerWyr;

import java.util.List;

public class Event {
	
	private String title;
	private Host host; 
	private Duration duration; 
	private Genre genre;
	private String date;
	private Status status;
	private String location;
	private List<Talk> talks;
	
	public Event() {}
	
	
	public Event(String title, Host host, Duration duration, Genre genre, String date, Status status, String location) {
    this.title = title; 
    this.host  = host;
    this.duration = duration; 
    this.genre = genre; 
    this.date  = date; 
    this.status = status;
    this.location = location; 
	
	}
	
}
