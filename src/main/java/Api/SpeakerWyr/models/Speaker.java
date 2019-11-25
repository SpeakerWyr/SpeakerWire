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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((headshotUrl == null) ? 0 : headshotUrl.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((talks == null) ? 0 : talks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speaker other = (Speaker) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (headshotUrl == null) {
			if (other.headshotUrl != null)
				return false;
		} else if (!headshotUrl.equals(other.headshotUrl))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (talks == null) {
			if (other.talks != null)
				return false;
		} else if (!talks.equals(other.talks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", name=" + name + ", location=" + location + ", bio=" + bio + ", headshotUrl="
				+ headshotUrl + ", talks=" + talks + "]";
	}
	
}
