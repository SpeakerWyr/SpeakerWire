package Api.SpeakerWyr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Api.SpeakerWyr.models.Duration;
import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Genre;
import Api.SpeakerWyr.models.Host;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Status;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.services.EventService;
import Api.SpeakerWyr.services.GenreService;
import Api.SpeakerWyr.services.HostService;
import Api.SpeakerWyr.services.SpeakerService;
import Api.SpeakerWyr.services.TalkService;

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
	@Autowired
	private GenreService genreService;

	@Override
	public void run(String... args) throws Exception {
		
		Speaker speakerLindaLiukas = new Speaker("Linda-Liukas", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl");
		Speaker speakerJimmyJohn = new Speaker("Jimmy-John", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl1");
		Speaker speakerTalksAlot = new Speaker("Talks-Alot", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl1");

		speakerService.addSpeaker(speakerLindaLiukas);
		speakerService.addSpeaker(speakerJimmyJohn);
		speakerService.addSpeaker(speakerTalksAlot);

		Talk testTalk1 = new Talk("APIs", "The basics to APIs", Duration.LONG, speakerLindaLiukas);
		Talk testTalk2 = new Talk("Java", "Its like rosetta stone", Duration.SHORT, speakerJimmyJohn);
		Talk testTalk3 = new Talk("Speaking with confidence", "Let your voice be heard, speak with confidence",
				Duration.LIGHTNING, speakerTalksAlot);

		talkService.addTalk(testTalk1);
		talkService.addTalk(testTalk2);
		talkService.addTalk(testTalk3);

		Host hostWCCI = new Host("WCCI", "WCCI Campus", "Bootcamp for full-stack devolpers", "insert Headshot");

		hostService.addHost(hostWCCI);

		Genre java = new Genre("Java");

		genreService.addGenre(java);

		Event eventCodeandCoffe = new Event("CodeandCoffe", hostWCCI, Duration.MID, java, "November 24th",
				Status.BOOKED, "WCCI");
		Event eventCodeJam = new Event("CodeJam", hostWCCI, Duration.MID, java, "November 24th", Status.BOOKED, "WCCI");
		Event eventPairingWithPride = new Event("Pairing With Pride", hostWCCI, Duration.MID, java, "November 24th",
				Status.BOOKED, "WCCI");
		Event eventWCCICoffeAndCode = new Event("WCCICoffeAndCode", hostWCCI, Duration.MID, java, "November 24th",
				Status.BOOKED, "WCCI Campus");

		eventService.addEvent(eventCodeandCoffe);
		eventService.addEvent(eventCodeJam);
		eventService.addEvent(eventPairingWithPride);

	}

}
