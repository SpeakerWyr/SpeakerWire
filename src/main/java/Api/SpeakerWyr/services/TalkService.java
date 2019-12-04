package Api.SpeakerWyr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.models.TalkFilter;
import Api.SpeakerWyr.repos.TalkRepository;

@Service
public class TalkService {
	
	@Autowired
	TalkRepository talkRepo;

	public Talk addTalk(Talk talk) {
		return talkRepo.save(talk);
	}

	public List<Talk> fetchTalks() {
		List<Talk> talks = (List<Talk>) talkRepo.findAll();
		return talks;
	}

	public Talk fetchTalk(long id) {
		Optional<Talk> retrievedTalk = talkRepo.findById(id);
		return retrievedTalk.get();
	}

	public void removeTalk(Talk talk) {
		talkRepo.delete(talk);
		
	}

	public List<Talk> filterTalks(TalkFilter filter){
		List<Talk> filteredTalks = new ArrayList<>();
		List<Talk> allTalks = fetchTalks();
		return filteredTalks;
	}
}
