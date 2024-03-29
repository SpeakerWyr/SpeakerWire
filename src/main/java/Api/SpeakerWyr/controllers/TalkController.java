package Api.SpeakerWyr.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
import Api.SpeakerWyr.models.Genre;
import Api.SpeakerWyr.models.Tag;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.services.TalkService;

@CrossOrigin
@RestController
@RequestMapping("/api/talks")
public class TalkController {

	@Autowired
	private TalkService talkService;

	@GetMapping("")
	public List<Talk> getTalks() {
		return talkService.fetchTalks();
	}
	
	@GetMapping("/{id}")
	public Talk getSingleTalk(@PathVariable Long id) {
		return talkService.fetchTalk(id);
	}
	@PostMapping("/add-talk")
	public Talk addTalk(@RequestBody Talk talk) {
		return talkService.addTalk(talk);
	}
	
	@DeleteMapping("/{id}/remove-talk")
	public void removeTalk(@PathVariable Long id) {
		Talk talk = talkService.fetchTalk(id);
		talkService.removeTalk(talk);
	}
	
	@PatchMapping("/{id}/add-video")
	public Talk addVideo(@PathVariable long id, @RequestBody String iframe) {
		Talk talk = talkService.fetchTalk(id);
		talk.setIFrame(iframe);
		return talkService.addTalk(talk);
	}
	
	@PatchMapping("/{id}/add-event")
	public Talk addEvent(@PathVariable long id, @RequestBody Event event) {
		Talk talk = talkService.fetchTalk(id);
		talk.setEvent(event);
		return talkService.addTalk(talk);
	}
	

	@PatchMapping("/{id}/add-tag")
	public void addTag(@PathVariable long id,@RequestBody Tag tag) {
		Talk thisTalk = talkService.fetchTalk(id);
		List<Tag> thisTalkTag = new ArrayList<>(thisTalk.getTags());
		thisTalkTag.add(tag);
		talkService.addTalk(thisTalk);
	}
		
	@PatchMapping("/{id}/add-genre")
	public void addGenre(@PathVariable long id, @RequestBody Genre genre) {
		Talk thisTalk = talkService.fetchTalk(id);
		List<Genre> thisTalkGenre = new ArrayList <>(thisTalk.getGenres());
		thisTalkGenre.add(genre);
		talkService.addTalk(thisTalk);
	}
	
	@GetMapping("/{id}/get-genres")
	public List<Genre> getGenresForOneTalk(@PathVariable long id, Model model) {
		List<Genre> talkGenres = new ArrayList<>();
		Talk retrievedTalk = talkService.fetchTalk(id);
		talkGenres = retrievedTalk.getGenres();
		model.addAttribute("genres", talkGenres);
		return talkGenres;
	}
	
	@GetMapping("/{id}/get-tags")
	public List<Tag> getTagsForOneTalk(@PathVariable long id, Model model) {
		List<Tag> talkTags = new ArrayList<>();
		Talk retrievedTalk = talkService.fetchTalk(id);
		talkTags = retrievedTalk.getTags();
		model.addAttribute("tags", talkTags);
		return talkTags;
	}
	
}
		
	
	
	

