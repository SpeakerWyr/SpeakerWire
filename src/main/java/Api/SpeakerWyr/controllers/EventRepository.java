package Api.SpeakerWyr.controllers;

import org.springframework.data.repository.CrudRepository;

import Api.SpeakerWyr.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
