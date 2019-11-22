package Api.SpeakerWyr.models;

import java.util.List;

public class Host {
	
	private Long id;
	private String name;
	private String location;
	private String bio;
	private String headshotUrl;
	private List<Event> events;
	
	public void Host() {}
	
	public void Host(String name, String location, String bio, String headshotUrl) {
		this.name = name;
		this.location = location;
		this.bio = bio;
		this.headshotUrl = headshotUrl;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getBio() {
		return bio;
	}

	public String getHeadshotUrl() {
		return headshotUrl;
	}

	public List<Event> getEvents() {
		return events;
	}
	
	

}
