package Api.SpeakerWyr.repos;

import org.springframework.data.repository.CrudRepository;

import Api.SpeakerWyr.models.Talk;

public interface TalkRepository extends CrudRepository<Talk, Long> {

}
