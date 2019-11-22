package Api.SpeakerWyr.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Event {
	@Id
	@GeneratedValue
	private Long id;
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

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Host getHost() {
		return host;
	}

	public Duration getDuration() {
		return duration;
	}

	public Genre getGenre() {
		return genre;
	}

	public String getDate() {
		return date;
	}

	public Status getStatus() {
		return status;
	}

	public String getLocation() {
		return location;
	}

	public List<Talk> getTalks() {
		return talks;
	}
	
	
	
}
