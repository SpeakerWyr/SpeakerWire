package Api.SpeakerWyr.models;

import java.util.List;

public class Speaker {
	
	private Long id;
	private String name;
	private String location;
	private String bio;
	private String headshotUrl;
	private List<Talk> talks;

	public void Speaker() {}
	
	public void Speaker(String name, String location, String bio, String headshotUrl) {
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

	public List<Talk> getTalks() {
		return talks;
	}
	
	
	
	

}
