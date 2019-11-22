package Api.SpeakerWyr.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
	
public class Tag {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private List<Talk> talks;
	
	public void Tag() {}
	
	public void Tag(String name) {
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
