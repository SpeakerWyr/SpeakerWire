package Api.SpeakerWyr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.models.TalkFilter;
import Api.SpeakerWyr.services.TalkService;

@CrossOrigin
@Controller
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private TalkService talkService;
	
	@GetMapping("")
	public String filterTalks(@RequestBody Long genreId, Long tagId, String durationId, String speakerName) {
		TalkFilter filter = new TalkFilter(genreId, tagId, durationId, speakerName);
		List<Talk> filteredTalks = talkService.filterTalks(filter);
		
//		somehow, we need to take this list and make it into an HTML element to pass back and render...
		
		return "html element";
	}

}
