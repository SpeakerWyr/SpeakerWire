package Api.SpeakerWyr.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
	

public class Genre {
	
	@Id
	@GeneratedValue
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
