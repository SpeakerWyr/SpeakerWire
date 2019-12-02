package Api.SpeakerWyr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.repos.SpeakerRepository;

@Service
public class SpeakerService {

	@Autowired
	SpeakerRepository speakerRepo;
	
	public Speaker addSpeaker(Speaker speaker) {
		return speakerRepo.save(speaker);
	}
	
	public List<Speaker> fetchSpeakers() {
		List<Speaker> speakers = (List<Speaker>) speakerRepo.findAll();
		return speakers;
	}
	
	public Speaker fetchSpeaker(long id) {
		Optional<Speaker> retrievedSpeaker = speakerRepo.findById(id);
		return retrievedSpeaker.get();
	}

	public void removeSpeaker(Speaker speaker) {
		speakerRepo.delete(speaker);
		
	}
	
	public List<Event> getEventsSpeakerIsBooked(long id) {
		List<Event> eventsSpeaking = new ArrayList<Event>();
		Speaker thisSpeaker = fetchSpeaker(id);
		List<Talk> theseTalks = thisSpeaker.getTalks();
		for(Talk talk : theseTalks) {
			if(!talk.getEvent().equals(null)) {
				eventsSpeaking.add(talk.getEvent());
			}
		}
		return eventsSpeaking;
	}

	
}