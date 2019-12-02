package Api.SpeakerWyr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import Api.SpeakerWyr.services.HostService;

@CrossOrigin
@Controller
@RequestMapping("/host")
public class HostController {

	@Autowired
	private HostService hostService;

	@GetMapping("/{id}")
	public String getHost(@PathVariable("id") long id, Model model) {
		model.addAttribute("host", hostService.fetchHost(id));
		return "host-page";
	}
}