package Api.SpeakerWyr;

import java.util.List;

public class Genre {
	
	private Long id;
	private String name;
	private List<Talk> talks;
	
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
