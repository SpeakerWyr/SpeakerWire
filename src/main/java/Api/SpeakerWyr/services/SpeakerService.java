package Api.SpeakerWyr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Speaker;
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

	
}
