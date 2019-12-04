package Api.SpeakerWyr.models;


public enum Duration {
	
	LIGHTNING ("Less than 15 minutes"),
	SHORT ("15 to 30 minutes"),
	MID ("30 to 60 minutes"),
	LONG ("More than 60 minutes");
	
	private final String displayDuration;
	
	private Duration (String displayDuration) {
		this.displayDuration = displayDuration;
	}
	
	public String getDisplayDuration() {
		return displayDuration;
	}
}
