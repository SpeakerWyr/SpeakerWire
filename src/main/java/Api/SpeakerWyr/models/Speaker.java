package Api.SpeakerWyr.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Speaker {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String location;
	private String bio;
	private String headshotUrl;
	@JsonIgnore
	@OneToMany(mappedBy = "speaker")
	private List<Talk> talks;

	public Speaker() {}
	
	public Speaker(String name, String location, String bio, String headshotUrl) {
		this.name = name;
		this.location = location;
		this.bio = bio;
		this.headshotUrl = headshotUrl;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getBio() {
		return bio;
	}

	public String getHeadshotUrl() {
		return headshotUrl;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setHeadShotUrl(String headshotUrl) {
		this.headshotUrl = headshotUrl;
	}
	
	
	
	

}
