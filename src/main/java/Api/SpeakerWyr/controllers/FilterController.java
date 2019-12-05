package Api.SpeakerWyr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String filterTalks(@RequestParam Long genreId, @RequestParam Long tagId, @RequestParam String durationId,
			@RequestParam String speakerName, Model model) {
		TalkFilter filter = new TalkFilter(genreId, tagId, durationId, speakerName);
		List<Talk> filteredTalks = talkService.filterTalks(filter);
		model.addAttribute("filteredTalks", filteredTalks);

		return "partial-filteredTalks";
	}

}
