package Api.SpeakerWyr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Status;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.services.EventService;

@CrossOrigin
@RestController
@RequestMapping("/api/events")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("")
	public List<Event> getEvents() {
		return eventService.fetchEvents();
	}
	
	@GetMapping("/{id}")
	public Event getSingleEvent(@PathVariable Long id) {
		return eventService.fetchEvent(id);
	}
	@PostMapping("/add-event")
	public Event addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
	}
	
	@DeleteMapping("/{id}/remove-event")
	public void removeEvent(@PathVariable Long id) {
		Event event = eventService.fetchEvent(id);
		eventService.removeEvent(event);
	}
	
	@PatchMapping("/{id}/update-status")
	public Event updateStatus(@PathVariable long id, @RequestBody Status status) {
		Event event = eventService.fetchEvent(id);
		event.setStatus(status);
		return eventService.addEvent(event);
	}
	
	//added this patch mapping to connect talk to event
	@PatchMapping("/{id}/add-talk")
	public Event addTalk(@PathVariable long id, @RequestBody Talk talk) {
		//Event event = eventService.fetchEvent(id);
		return eventService.addTalkToEvent(id, talk);
		//event.addTalk(talk);
		//System.out.println("controller - add-talk");
		//return eventService.addEvent(event);
	}
}
