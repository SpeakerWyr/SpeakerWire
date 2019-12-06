package Api.SpeakerWyr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Tag;
import Api.SpeakerWyr.repos.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepo;
	@Autowired
	TagService tagService;
	
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public List<Tag> fetchTags() {
		List<Tag> tags = (List<Tag>) tagRepo.findAll();
		return tags;
	}
	
	public Tag fetchTag(long id) {
		Optional<Tag> retrievedTag = tagRepo.findById(id);
		return retrievedTag.get();
	}

	public void removeEvent(Tag tag) {
		tagRepo.delete(tag);
	}

	public Object findAllTags() {
		// TODO Auto-generated method stub
		return null;
	}
}

