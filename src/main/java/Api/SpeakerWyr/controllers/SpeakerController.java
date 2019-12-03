package Api.SpeakerWyr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.services.GenreService;
import Api.SpeakerWyr.services.SpeakerService;
import Api.SpeakerWyr.services.TagService;

@CrossOrigin
@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	private SpeakerService speakerService;
	@Autowired
	private TagService tagService; 
	@Autowired
	private GenreService genreService;
	
	
	@GetMapping("")
	public String getSpeakers(Model model) {
		model.addAttribute("speakers", speakerService.fetchSpeakers());
		return "speaker-page";
	}
	
	@GetMapping("/{id}")
	public String getSingleSpeaker(@PathVariable ("id") Long id, Model model) {
		Speaker speaker = speakerService.fetchSpeaker(id);
		List<Event> eventsSpeaking = speakerService.getEventsSpeakerIsBooked(id);
		model.addAttribute("speaker", speaker);
		model.addAttribute("events", eventsSpeaking);
		model.addAttribute("genres", genreService.fetchGenres());
		model.addAttribute("tags", tagService.fetchTags());
		return "speaker-page";

			
	}
	
	@PostMapping("/add-speaker") //add to host 
	public Speaker addSpeaker(String name, String location, String bio, String headshotUrl) {
		Speaker newSpeaker = new Speaker(name, location, bio, headshotUrl);
		return speakerService.addSpeaker(newSpeaker);
	}
	
	@PatchMapping("/{id}/edit-speaker") //add to host  
	public Speaker editSpeaker(@PathVariable Long id, String name, String location, String bio, String headshotUrl) {
		Speaker thisSpeaker = speakerService.fetchSpeaker(id);
		thisSpeaker.setName(name);
		thisSpeaker.setLocation(location);
		thisSpeaker.setBio(bio);
		thisSpeaker.setHeadShotUrl(headshotUrl);
//		this needs to be a redirect to the speaker-page with id
		return speakerService.addSpeaker(thisSpeaker);
	}
	
	@DeleteMapping("/{id}/remove-speaker")
	public void removeSpeaker(@PathVariable Long id) {
		Speaker speaker = speakerService.fetchSpeaker(id);
		speakerService.removeSpeaker(speaker);
	}
	
	@PatchMapping("/{id}/add-headshot")
	public Speaker addHeadShot(@PathVariable long id, @RequestBody String headshotUrl) {
		Speaker speaker = speakerService.fetchSpeaker(id);
		speaker.setHeadShotUrl(headshotUrl);
		return speakerService.addSpeaker(speaker);
	}
	
	@PatchMapping("/{id}/add-talk")
	public Speaker addTalk(@PathVariable long id, @RequestBody Talk talk) {
		Speaker speaker = speakerService.fetchSpeaker(id);
		List<Talk> existingTalks = speaker.getTalks();
		existingTalks.add(talk);
		return speakerService.addSpeaker(speaker);
	}
	
	
}
