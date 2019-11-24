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

import Api.SpeakerWyr.TalkService;
import Api.SpeakerWyr.models.Talk;

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
}
