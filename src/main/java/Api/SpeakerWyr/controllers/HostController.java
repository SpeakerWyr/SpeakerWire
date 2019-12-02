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
import Api.SpeakerWyr.models.Host;
import Api.SpeakerWyr.services.HostService;

@CrossOrigin
@Controller
@RequestMapping("/host")
public class HostController {

	@Autowired
	private HostService hostService;
	
	@GetMapping("")
	public String getHosts(Model model) {
		model.addAttribute("hosts", hostService.fetchHosts());
		return"host-page";
	}

	@GetMapping("/{id}")
	public String getHost(@PathVariable("id") long id, Model model) {
		List<Event> eventsHosting = hostService.getEventsHostIsHosting(id);
		model.addAttribute("host", hostService.fetchHost(id));
		model.addAttribute("eventsHosting", eventsHosting);
		return "host-page";
	}
	
	@PostMapping("/add-host")
	public Host addHost(@RequestBody Host host) {
		return hostService.addHost(host);
	}
	
	@DeleteMapping("/{id}/remove-host")
	public void removeHost(@PathVariable Long id) {
		Host host = hostService.fetchHost(id);
		hostService.removeHost(host);
	}
	
	@PatchMapping("/{id}/add-headshot")
	public Host addHeadShot(@PathVariable long id, @RequestBody String headshotUrl) {
		Host host = hostService.fetchHost(id);
		host.setHeadShotUrl(headshotUrl);
		return hostService.addHost(host);
	}
	
	@PatchMapping("/{id}/add-event")
	public Host addEvent(@PathVariable long id, @RequestBody Event event) {
		Host host = hostService.fetchHost(id);
		List<Event> existingEvents = host.getEvents();
		existingEvents.add(event);
		return hostService.addHost(host);
		
		
	}
}