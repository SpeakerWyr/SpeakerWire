package Api.SpeakerWyr.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@ManyToOne
	private Host host;
	private Duration duration;
	@ManyToOne
	private Genre genre;
	private String date;
	private Status status;
	private String location;
	@JsonIgnore
	@OneToMany(mappedBy = "event")
	private List<Talk> talks;

	public Event() {
	}

	public Event(String title, Host host, Duration duration, Genre genre, 
			String date, Status status, String location) {
		this.title = title;
		this.host = host;
		this.duration = duration;
		this.genre = genre;
		this.date = date;
		this.status = status;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Host getHost() {
		return host;
	}

	public Duration getDuration() {
		return duration;
	}

	public Genre getGenre() {
		return genre;
	}

	public String getDate() {
		return date;
	}

	public Status getStatus() {
		return status;
	}

	public String getLocation() {
		return location;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void addTalk(Talk talk) {
		talks.add(talk);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((talks == null) ? 0 : talks.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (duration != other.duration)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
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
		if (status != other.status)
			return false;
		if (talks == null) {
			if (other.talks != null)
				return false;
		} else if (!talks.equals(other.talks))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", host=" + host + ", duration=" + duration + ", genre=" + genre
				+ ", date=" + date + ", status=" + status + ", location=" + location + ", talks=" + talks + "]";
	}
	
	

}
