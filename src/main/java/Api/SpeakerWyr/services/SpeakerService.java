package Api.SpeakerWyr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.repos.SpeakerRepository;

@Service
public class SpeakerService {

	@Autowired
	SpeakerRepository speakerRepo;
	@Autowired
	EventService eventService;
	
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
			eventsSpeaking.add(talk.getEvent());
		}
		return eventsSpeaking;
	}

	public List<Talk> getTalksSpeakerHasListed(long id) {
//		List<Talk> listOfTalks = new ArrayList<Talk>();
		Speaker thisSpeaker = fetchSpeaker(id);
		List<Talk> theseTalks = thisSpeaker.getTalks();
		return theseTalks;
	}
}
