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


		Speaker speakerLindaLiukas = new Speaker("Linda Liukas", "Columbus, Ohio",
				"Linda is the author and illustrator of Hello Ruby, a children’s picture book about the whimsical world of computers, as well as the founder of Rails Girls, a global movement to teach young women programming in over 260 cities.",
				"https://upload.wikimedia.org/wikipedia/commons/3/35/Linda_Liukas_at_the_Data_of_Tomorrow_Conference_2017_%2823496747288%29_%28cropped%29.jpg");
		Speaker speakerDrEugeniaCheng = new Speaker("Dr. Eugenia Cheng", "Dublin, Ohio",
				"Dr. Cheng is a British mathematician, pianist, and Scientist-in-Residence at the School of the Art Institute of Chicago.",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/EugeniaCheng_PhiBetaKappa_EnLightningTalksChicago2016_%28cropped%29.jpg/440px-EugeniaCheng_PhiBetaKappa_EnLightningTalksChicago2016_%28cropped%29.jpg");
		Speaker speakerBrianEgan = new Speaker("Brian Egan", "Grove City, Ohio",
				"Brian is a front-end developer with a rad company.", "/images/BrianEgan.jpg");


		speakerService.addSpeaker(speakerLindaLiukas);
		speakerService.addSpeaker(speakerDrEugeniaCheng);
		speakerService.addSpeaker(speakerBrianEgan);

		Talk talkPoetryOfProgramming = new Talk("The Poetry of Programming",
				"Linda Liukas wants to create a more diverse and colourful world of technology, starting with the poetry of code.",
				Duration.LIGHTNING, speakerLindaLiukas);
		Talk talkConveyingthePowerofAbstraction = new Talk("Conveying the Power of Abstraction",
				"A look at our relationship with abstraction and its potential for dramatically improving how we think if it is incorporated into our educational systems.",
				Duration.MID, speakerDrEugeniaCheng);
		Talk talkDevelopNativeAppsWithFlutter = new Talk("Develop Native Apps with Flutter",
				"Brian discusses Flutter, an open-source UI software development kit created by Google, which runs in the Dart virtual machine featuring a just-in-time execution engine.",
				Duration.SHORT, speakerBrianEgan);

		talkService.addTalk(talkPoetryOfProgramming);
		talkService.addTalk(talkConveyingthePowerofAbstraction);
		talkService.addTalk(talkDevelopNativeAppsWithFlutter);

		Host hostArtInstituteofChicago = new Host("Art Institute of Chicago", "Chicago, IL",
				"A private university associated with the Art Institute of Chicago",
				"https://news.artnet.com/app/news-upload/2019/04/GettyImages-661869994-1024x683.jpg");
		Host hostWCCI = new Host("We Can Code IT", "Columbus, OH", "A bootcamp for full stack devolpers",
				"https://wecancodeit.org/wp-content/uploads/2018/07/hire-coding-bootcamp-students.jpg");
		Host hostTheOhioStateUniversity = new Host("The Ohio State University", "Columbus, OH",
				"A public research university in Columbus, OH, founded in 1870 as a land-grant university",
				"https://content.presspage.com/uploads/2170/1920_oval-aerial-1799-664882.jpg");

		hostService.addHost(hostArtInstituteofChicago);
		hostService.addHost(hostWCCI);
		hostService.addHost(hostTheOhioStateUniversity);

		Genre java = new Genre("Java");
		Genre technology = new Genre("Technology");
		Genre mobileApps = new Genre("Mobile Apps");
		Genre programming = new Genre("Programming");
		Genre art = new Genre("Art");
		Genre music = new Genre("Music");

		genreService.addGenre(java);
		genreService.addGenre(technology);
		genreService.addGenre(mobileApps);
		genreService.addGenre(programming);
		genreService.addGenre(art);
		genreService.addGenre(music);

		Event eventCodeAndCoffee = new Event("Code and Coffee", hostWCCI, Duration.MID, programming,
				"December 21, 2019", Status.BOOKED, "Columbus, OH");
		Event eventPowerOfAbstraction = new Event("Art, Mathematics, and Logic", hostArtInstituteofChicago,
				Duration.LONG, technology, "January 24, 2020", Status.BOOKED, "Chicago, IL");
		Event eventFlutterAndDart = new Event("Flutter and Dart: Developing Beautiful Mobile Apps",
				hostTheOhioStateUniversity, Duration.LONG, mobileApps, "March 22, 2020", Status.BOOKED, "Columbus, OH");

		eventService.addEvent(eventCodeAndCoffee);
		eventService.addEvent(eventPowerOfAbstraction);
		eventService.addEvent(eventFlutterAndDart);

	}

}
