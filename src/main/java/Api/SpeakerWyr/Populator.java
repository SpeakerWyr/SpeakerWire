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

		Speaker speakerLindaLuikas = new Speaker("Linda-Luikas", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl");
		Speaker speakerDrEugeniaCheng = new Speaker("DrEugeniaCheng", "Dublin,Ohio", "I am a British mathematician, pianist, Scientist-in-Residence at the School of the Art Institute of Chicago", "SpeakerHeadshotUrl1");
		Speaker speakerBrianEgan = new Speaker("Brian-Egan", "Grove City,Ohio", "I am a front-end developer with a rad company.", "SpeakerHeadshotUrl1");

		speakerService.addSpeaker(speakerLindaLuikas);
		speakerService.addSpeaker(speakerDrEugeniaCheng);
		speakerService.addSpeaker(speakerBrianEgan);

		
		
		
		
		Talk talkAPIs = new Talk("APIs", "The basics to APIs", Duration.LONG, speakerLindaLuikas);
		Talk talkConveyingthePowerofAbstraction = new Talk("ConveyingthePowerofAbstraction ", "A look at our relationship with abstraction and its potential for dramatically improving how we think if it is incorporated in different ways within education systems.", Duration.LONG, speakerDrEugeniaCheng);
		Talk talkFlutterwithStreamsandRxDart = new Talk(" Flutter with Streams and RxDart", "Lets skip the poltical talks about Rx and dive into its practical uses",Duration.MID, speakerBrianEgan);
		
		
		talkService.addTalk(talkAPIs);
		talkService.addTalk(talkConveyingthePowerofAbstraction);
		talkService.addTalk(talkFlutterwithStreamsandRxDart);
		
		Host hostArtInstituteofChicago = new Host("ArtInstituteofChicago", "Art Campus", "private university associated with the Art Institute of Chicago in Chicago, Illinois.", "insert Headshot");
		Host hostWCCI = new Host("WCCI", "WCCI", "A bootcamp for full stack devolpers.", "insert Headshot");
		Host hostOhioStateUniversity = new Host("OhioStateUniversity","Woody Hays Center","A public research university in Columbus, Ohio. Founded in 1870 as a land-grant university and the ninth university in Ohio with the Morrill Act of 1862", "insert Headshot");
		
		hostService.addHost(hostArtInstituteofChicago);
		hostService.addHost(hostWCCI);
		hostService.addHost(hostOhioStateUniversity);
		
		Genre java = new Genre("Java");

		genreService.addGenre(java);
		
		Event eventCodeandCoffe = new Event("CodeandCoffe", hostWCCI, Duration.MID, java, "November 24th",Status.BOOKED, "WCCI");
		Event eventPowerofAbstraction = new Event("PowerofAbstraction", hostArtInstituteofChicago, Duration.LONG, java, "November 24th", Status.BOOKED, "ArtInstituteofChicago");
		Event eventFlutterwithStreamsandRxDart = new Event("Flutter with Streams and RxDart", hostWCCI, Duration.MID, java, "November 24th",Status.BOOKED, "WCCI Campus");

		eventService.addEvent(eventCodeandCoffe);
		eventService.addEvent(eventPowerofAbstraction);
		eventService.addEvent(eventFlutterwithStreamsandRxDart);

		}

}
