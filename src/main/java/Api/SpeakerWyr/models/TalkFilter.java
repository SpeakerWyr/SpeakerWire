package Api.SpeakerWyr.models;

public class TalkFilter {

	private Long genreId;
	private Long tagId; 
	private String durationId;
	private String speakerName;
	
	public TalkFilter(Long genreId, Long tagId, String durationId, String speakerName) {
		this.genreId = genreId;
		this.tagId = tagId;
		this.durationId = durationId;
		this.speakerName = speakerName;
	}
	
	public Long getGenreId() {
		return genreId;
	}
	public Long getTagId() {
		return tagId;
	}
	public String getDurationID() {
		return durationId;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	
	
}
