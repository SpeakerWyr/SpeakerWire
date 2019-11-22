package Api.SpeakerWyr;

import org.springframework.data.repository.CrudRepository;

import Api.SpeakerWyr.models.Speaker;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

}
