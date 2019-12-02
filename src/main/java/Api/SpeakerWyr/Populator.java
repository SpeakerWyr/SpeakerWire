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
		System.out.println("running populator");
		Speaker speakerLindaLuikas = new Speaker("Linda-Luikas", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl");
		Speaker speakerDrEugeniaCheng = new Speaker("DrEugeniaCheng", "Dublin,Ohio", "I am a British mathematician, pianist, Scientist-in-Residence at the School of the Art Institute of Chicago and an honorary fellow of pure mathematics at the University of Sheffield.My mathematical interests include higher-dimensional category theory, and as a pianist I specialises in lieder and art song. She is also passionate about explaining mathematics to non-mathematicians to rid the world of math phobia, often using entertaining analogies with food and baking.", "SpeakerHeadshotUrl1");
		Speaker speakerBrianEgan = new Speaker("Brian-Egan", "Grove City,Ohio", "I am a front-end developer with a rad company. I've designed a bunch of sites using a combination of sketching, mockup tools, and Photoshop (occasionally Fireworks), and personally converted every one to well-written HTML & CSS that works across all browsers. I also write JavaScript like Jagger (well, hopefully a bit better), and love geeking out about unit testing.", "SpeakerHeadshotUrl1");

		speakerService.addSpeaker(speakerLindaLuikas);
		speakerService.addSpeaker(speakerDrEugeniaCheng);
		speakerService.addSpeaker(speakerBrianEgan);

		
		
		
		
		Talk testTalk1 = new Talk("APIs", "The basics to APIs", Duration.LONG, speakerLindaLuikas);
		Talk testTalk2 = new Talk("Conveying the Power of Abstraction ", "A look at our relationship with abstraction and its potential for dramatically improving how we think if it is incorporated in different ways within education systems.", Duration.LONG, speakerDrEugeniaCheng);
		Talk testTalk3 = new Talk(" Flutter with Streams and RxDart", "Lets skip the poltical talks about Rx and dive into its practical uses",Duration.MID, speakerBrianEgan);

		talkService.addTalk(testTalk1);
		talkService.addTalk(testTalk2);
		talkService.addTalk(testTalk3);

		
		
		
		
		
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
