package Api.SpeakerWyr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Host;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.repos.HostRepository;
@Service
public class HostService {
	
	@Autowired
	HostRepository hostRepo;
	@Autowired
	EventService eventService;
	@Autowired
	TalkService talkService;
	
	public Host addHost(Host host) {
		return hostRepo.save(host);
	}

	public List<Host> fetchHosts() {
		List<Host> hosts = (List<Host>) hostRepo.findAll();
		return hosts;
	}

	public Host fetchHost(long id) {
		Optional<Host> retrievedHost = hostRepo.findById(id);
		return retrievedHost.get();
	}

	public void removeHost(Host host) {
		hostRepo.delete(host);
		
	}

	public List<Event> getEventsHostIsHosting(long id) {
		List<Event> eventsHosting = new ArrayList<Event>();
		Host thisHost = fetchHost(id);
//		return thisHost.getEvents();
		List<Event> allEvents = eventService.fetchEvents();
		for(Event event : allEvents) {
//			Talk talkToAdd = talkService.fetchTalk(id);
			
			if(event.getHost() == thisHost) {
				eventsHosting.add(event);
			}
		}
		return eventsHosting;
	}


}
