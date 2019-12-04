package Api.SpeakerWyr.repos;

import org.springframework.data.repository.CrudRepository;

import Api.SpeakerWyr.models.Speaker;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

}
