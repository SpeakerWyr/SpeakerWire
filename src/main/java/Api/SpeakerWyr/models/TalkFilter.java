package Api.SpeakerWyr.models;

public class TalkFilter {

	private Long genreId;
	private Long tagId; //called filterId in html...
	private String durationID;
	private String speakerName;
	
	
	public Long getGenreId() {
		return genreId;
	}
	public Long getTagId() {
		return tagId;
	}
	public String getDurationID() {
		return durationID;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	
	
}
