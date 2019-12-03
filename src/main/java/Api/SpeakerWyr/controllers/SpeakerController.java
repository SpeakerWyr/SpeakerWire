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
	
	@PostMapping("/add-speaker")
	public Speaker addSpeaker(@RequestBody Speaker speaker) {
		return speakerService.addSpeaker(speaker);
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
