package Api.SpeakerWyr.models;

import java.util.List;

public class Genre {
	
	private Long id;
	private String name;
	private List<Talk> talks;
	private List<Event> events;
	
	public void Genre() {}
	
	public void Genre(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Talk> getTalks() {
		return talks;
	}
	
	

}
