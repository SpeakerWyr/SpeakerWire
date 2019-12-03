package Api.SpeakerWyr.repos;

import org.springframework.data.repository.CrudRepository;

import Api.SpeakerWyr.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	
	
}
