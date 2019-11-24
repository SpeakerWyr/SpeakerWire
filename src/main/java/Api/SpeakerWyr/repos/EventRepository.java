package Api.SpeakerWyr.repos;

import org.springframework.data.repository.CrudRepository;

import Api.SpeakerWyr.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
