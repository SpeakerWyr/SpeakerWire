package Api.SpeakerWyr.models;


public enum Duration {
	
	LIGHTNING ("15 minutes or less"),
	SHORT ("15 to 30 minutes"),
	MID ("30 to 60 minutes"),
	LONG ("60 minutes or more");
	
	private final String displayDuration;
	
	private Duration (String displayDuration) {
		this.displayDuration = displayDuration;
	}
	
	public String getDisplayDuration() {
		return displayDuration;
	}
}
