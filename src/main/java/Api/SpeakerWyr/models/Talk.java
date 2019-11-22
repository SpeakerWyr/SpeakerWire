package Api.SpeakerWyr.models;

import java.util.List;

public class Talk {
	
	private Long id;
	private String title;
	private String description;
	private Duration duration;
	private Speaker speaker;
	private List<Genre> genres;
	private List<Tag> tags;
	private String iFrame;
	
	public Talk() {}
	
	public Talk(String title, String description, Duration duration, Speaker speaker) {	
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.speaker = speaker;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public List<Tag> getTags() {
		return tags;
	}
	
	public String getiFrame() {
		return iFrame;
	}
	
	public String getTitle() {
		return title;
	}
	
}

