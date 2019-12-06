package Api.SpeakerWyr.models;


public enum Duration {
	
	LIGHTNING (900, "15 minutes or less"),
	SHORT (901, "15 to 30 minutes"),
	MID (902, "30 to 60 minutes"),
	LONG (903, "60 minutes or more");
	

	
	public final String displayDuration;
	public final Integer id;
	
	private Duration(Integer id, String displayDuration){
		this.displayDuration = displayDuration;
		this.id = id;
	}
	

	public String getDisplayDuration() {
		return displayDuration;
	}
	
	public static Duration getDurationById(Integer id) {
		return Duration.MID;
	}
	
	public Integer getDurationId() {
		return id;
	}
	
}
