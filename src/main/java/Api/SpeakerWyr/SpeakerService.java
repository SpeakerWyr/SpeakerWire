package Api.SpeakerWyr;

import org.springframework.beans.factory.annotation.Autowired;

import Api.SpeakerWyr.models.Speaker;

public class SpeakerService {

	@Autowired
	SpeakerRepository speakerRepo;
	
	public Speaker addSpeaker(Speaker speaker) {
		
		return speakerRepo.save(speaker);
	}

}
