package Api.SpeakerWyr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.repos.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepo;
	
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public List<Event> fetchEvents() {
		List<Event> events = (List<Event>) eventRepo.findAll();
		return events;
	}
	
	public Event fetchEvent(long id) {
		Optional<Event> retrievedEvent = eventRepo.findById(id);
		return retrievedEvent.get();
	}

	public void removeEvent(Event event) {
		eventRepo.delete(event);
		
	}
	
	public Event addTalkToEvent(long id, Talk talk) {
		Optional<Event> retrievedEvent = eventRepo.findById(id);
		retrievedEvent.get().addTalk(talk);
		this.addEvent(retrievedEvent.get());
		Optional<Event> retrievedEventAgain = eventRepo.findById(id);
		return retrievedEventAgain.get();
	}

}
