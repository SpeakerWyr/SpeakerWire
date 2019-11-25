import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Api.SpeakerWyr.HostService;
import Api.SpeakerWyr.SpeakerService;
import Api.SpeakerWyr.TalkService;
import Api.SpeakerWyr.models.Duration;
import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Genre;
import Api.SpeakerWyr.models.Host;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Status;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.services.EventService;

@Component
public class Populator implements CommandLineRunner {
	
	@Autowired
	private TalkService talkService;
	@Autowired
	private SpeakerService speakerService;
	@Autowired
	private EventService eventService;
	@Autowired
	private HostService hostService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Speaker speakerLindaLuikas = new Speaker("Linda-Luikas", "SpeakerLocation","SpeakerBio", "SpeakerHeadshotUrl");
		Speaker speakerJimmyJohn = new Speaker("Jimmy-John", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl1");
		Speaker speakerTalksAlot = new Speaker ("Talks-Alot", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl1");
		
		speakerService.addSpeaker(speakerLindaLuikas);
		speakerService.addSpeaker(speakerJimmyJohn);
		speakerService.addSpeaker(speakerTalksAlot);

		
		Talk testTalk1 = new Talk("APIs", "The basics to APIs", Duration.LONG, speakerLindaLuikas);
		Talk testTalk2 = new Talk("Java", "Its like rosetta stone", Duration.SHORT, speakerJimmyJohn);
		Talk testTalk3 = new Talk("Speaking with confidence", "Let your voice be heard, speak with confidence", Duration.LIGHTNING, speakerTalksAlot);
		
		talkService.addTalk(testTalk1);
		talkService.addTalk(testTalk2);
		talkService.addTalk(testTalk3);
		
		Host hostWCCI = new Host("WCCI", "WCCI Campus", "Bootcamp for full-stack devolpers", "insert Headshot");
		
		hostService.addHost(hostWCCI);
		
		Genre java = new Genre("Java");
		
		
		Event eventCodeandCoffe = new Event("CodeandCoffe", hostWCCI ,Duration.MID, java, "November 24th", Status.BOOKED, "WCCI");
		Event eventCodeJam = new Event("CodeJam", hostWCCI, Duration.MID, java, "November 24th", Status.BOOKED, "WCCI" );
		Event eventPairingWithPride = new Event("Pairing With Pride", hostWCCI, Duration.MID, java, "November 24th", Status.BOOKED, "WCCI");
		Event eventWCCICoffeAndCode = new Event("WCCICoffeAndCode", hostWCCI,  Duration.MID, java, "November 24th", Status.BOOKED, "WCCI Campus");
		
		eventService.addEvent(eventCodeandCoffe);
		eventService.addEvent(eventCodeJam);
		eventService.addEvent(eventPairingWithPride);
		
			
		}

}

