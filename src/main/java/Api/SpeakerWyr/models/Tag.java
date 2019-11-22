package Api.SpeakerWyr.models;

import java.util.List;

public class Tag {
	
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
