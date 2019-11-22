package Api.SpeakerWyr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
