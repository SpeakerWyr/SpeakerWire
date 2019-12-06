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
	@Autowired
	GenreService genreService;
	@Autowired
	TagService tagService;

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
		for(Talk talk : allTalks) {
			if(talkMatchesFilter(filter, talk)) {
				filteredTalks.add(talk);
			}
		}
		return filteredTalks;
	}

	private boolean talkMatchesFilter(TalkFilter filter, Talk talk) {
		return (isAMatchingGenre(filter, talk)) && (isAMatchingTag(filter, talk)) && (isAMatchingDuration(filter, talk)) && (isAMatchingSpeakerName(filter, talk));
	}

	private boolean isAMatchingSpeakerName(TalkFilter filter, Talk talk) {
		return filter.getSpeakerName().equalsIgnoreCase("") || (talk.getSpeakerName().equalsIgnoreCase(filter.getSpeakerName()));
	}

	private boolean isAMatchingDuration(TalkFilter filter, Talk talk) {
		return filter.getDurationID().equalsIgnoreCase("") || (talk.getDurationString().equalsIgnoreCase(filter.getDurationID()));
	}

	private boolean isAMatchingTag(TalkFilter filter, Talk talk) {
		return (filter.getTagId()==0) || (talk.getTags().contains(tagService.fetchTag(filter.getTagId())));
	}

	private boolean isAMatchingGenre(TalkFilter filter, Talk talk) {
		return (filter.getGenreId()==0) || (talk.getGenres().contains(genreService.fetchGenre(filter.getGenreId())));
	}
}
