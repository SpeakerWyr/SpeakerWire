package Api.SpeakerWyr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Api.SpeakerWyr.models.Duration;
import Api.SpeakerWyr.models.Event;
import Api.SpeakerWyr.models.Genre;
import Api.SpeakerWyr.models.Host;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Status;
import Api.SpeakerWyr.models.Tag;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.services.EventService;
import Api.SpeakerWyr.services.GenreService;
import Api.SpeakerWyr.services.HostService;
import Api.SpeakerWyr.services.SpeakerService;
import Api.SpeakerWyr.services.TagService;
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
	@Autowired
	private TagService tagService;

	@Override
	public void run(String... args) throws Exception {
		
		Genre java = new Genre("Java");
		Genre technology = new Genre("Technology");
		Genre mobileApps = new Genre("Mobile Apps");
		Genre coding = new Genre("Coding");
		Genre art = new Genre("Art");
		Genre music = new Genre("Music");
		Genre literature = new Genre("Literature");
		Genre diet = new Genre("Diet");
		Genre math = new Genre("Math");
		Genre philosophy = new Genre("Philosophy");
		
		genreService.addGenre(java);
		genreService.addGenre(technology);
		genreService.addGenre(mobileApps);
		genreService.addGenre(coding);
		genreService.addGenre(art);
		genreService.addGenre(music);
		genreService.addGenre(literature);
		genreService.addGenre(diet);
		genreService.addGenre(math);
		genreService.addGenre(philosophy);

		List<Genre> genreList1 = new ArrayList<Genre>();
		List<Genre> genreList2 = new ArrayList<Genre>();
		List<Genre> genreList3 = new ArrayList<Genre>();
		List<Genre> genreList4 = new ArrayList<Genre>();
		List<Genre> genreList5 = new ArrayList<Genre>();
		List<Genre> genreList6 = new ArrayList<Genre>();
		List<Genre> genreList7 = new ArrayList<Genre>();
		List<Genre> genreList8 = new ArrayList<Genre>();
		List<Genre> genreList9 = new ArrayList<Genre>();		
		
		Tag funny = new Tag("funny");
		Tag persuasive = new Tag("persuasive");
		Tag local = new Tag("local");
		Tag spiritual = new Tag("spiritual");
		Tag selfhelp = new Tag("self-help");
		Tag educational = new Tag("educational");
		Tag informative = new Tag("informative");
		Tag uptodate = new Tag("up-to-date");
		
		tagService.addTag(funny);
		tagService.addTag(persuasive);
		tagService.addTag(local);
		tagService.addTag(spiritual);
		tagService.addTag(selfhelp);
		tagService.addTag(educational);
		tagService.addTag(informative);
		tagService.addTag(uptodate);
		
		List<Tag> tagList1 = new ArrayList<Tag>();
		List<Tag> tagList2 = new ArrayList<Tag>();
		List<Tag> tagList3 = new ArrayList<Tag>();
		List<Tag> tagList4 = new ArrayList<Tag>();
		List<Tag> tagList5 = new ArrayList<Tag>();
		List<Tag> tagList6 = new ArrayList<Tag>();
		List<Tag> tagList7 = new ArrayList<Tag>();
		List<Tag> tagList8 = new ArrayList<Tag>();
		List<Tag> tagList9 = new ArrayList<Tag>();

		Speaker speakerLindaLiukas = new Speaker("Linda Liukas", "Columbus, Ohio",
				"Linda is the author and illustrator of Hello Ruby, a children's picture book about the whimsical world of computers",
				"https://upload.wikimedia.org/wikipedia/commons/3/35/Linda_Liukas_at_the_Data_of_Tomorrow_Conference_2017_%2823496747288%29_%28cropped%29.jpg");
		Speaker speakerDrEugeniaCheng = new Speaker("Dr. Eugenia Cheng", "Dublin, Ohio",
				"Dr. Cheng is a British mathematician, pianist, and Scientist-in-Residence at the School of the Art Institute of Chicago",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/EugeniaCheng_PhiBetaKappa_EnLightningTalksChicago2016_%28cropped%29.jpg/440px-EugeniaCheng_PhiBetaKappa_EnLightningTalksChicago2016_%28cropped%29.jpg");
		Speaker speakerBrianEgan = new Speaker("Brian Egan", "Grove City, Ohio",
				"Brian is a front-end developer with a rad company", "/images/BrianEgan.jpg");
		
		speakerService.addSpeaker(speakerLindaLiukas);
		speakerService.addSpeaker(speakerDrEugeniaCheng);
		speakerService.addSpeaker(speakerBrianEgan);

		Talk talkPoetryOfProgramming = new Talk("The Poetry of Programming",
				"Linda Liukas wants to create a more diverse and colourful world of technology, starting with the poetry of code.",
				Duration.LIGHTNING, speakerLindaLiukas);
		
		Talk talkSoftwareAndStorytelling = new Talk("Software & Storytelling, One Nordic Childhood", 
				"Linda Liukas, Founder of Rails Girls and Hello Ruby: Software & Storytelling: One Nordic Childhood at Slush 2014.",
				Duration.SHORT, speakerLindaLiukas);
		
		Talk talkADelightfulWayToTeachKids = new Talk("A Delightful Way To Teach Kids About Computers", "Imagine a world where the Ada Lovelaces of tomorrow grow up to be optimistic and brave about technology and use it to create a new world that is wonderful, whimsical and a tiny bit weird.", 
				Duration.LIGHTNING, speakerLindaLiukas);
		
		Talk talkConveyingthePowerofAbstraction = new Talk("Conveying the Power of Abstraction",
				"A look at our relationship with abstraction and its potential for dramatically improving how we think.",
				Duration.MID, speakerDrEugeniaCheng);
		
		Talk talkTheArtOfLogic = new Talk("The Art of Logic: How to Make Sense in a World that Doesn't", " Eugenia has set out to show how mathematical logic can help us see things more clearly - and know when politicians and companies are trying to mislead us.",
				Duration.LONG, speakerDrEugeniaCheng);
		
		Talk talkWhatIfMathematicsIsTheAnswer = new Talk("What if mathematics is the answer for progress?", "Mathematics is easy and fun to understand. Wait, what? Experience how playing the piano can help you understand the complexity of mathematics.",
				Duration.SHORT, speakerDrEugeniaCheng);
		
		Talk talkWhyUseFlutter = new Talk("Why use Flutter?", "Brian Egan takes you through the actual benefits of Flutter in development.",
				Duration.MID, speakerBrianEgan);
		
		Talk talkKeepItSimple = new Talk("Keep it Simple, State: Architecture for Flutter Apps", "Let's go on a journey! In this video, we'll start with a basic Counter Widget, building up to a complex app with shared state across multiple screens.", 
				Duration.MID, speakerBrianEgan);
		
		Talk talkDevelopNativeAppsWithFlutter = new Talk("Develop Native Apps with Flutter",
				"Brian discusses Flutter, an open-source UI software development kit created by Google, which runs in the Dart virtual machine featuring a just-in-time execution engine.",
				Duration.LIGHTNING, speakerBrianEgan);
		
		talkPoetryOfProgramming.setIFrame("https://www.youtube.com/embed/-jRREn6ifEQ");
		talkSoftwareAndStorytelling.setIFrame("https://www.youtube.com/embed/-AcT34zDGVw");
		talkADelightfulWayToTeachKids.setIFrame("https://www.youtube.com/embed/vcxwcWuq7KQ");
		talkConveyingthePowerofAbstraction.setIFrame("https://www.youtube.com/embed/PvSpyhm6TUU");
		talkTheArtOfLogic.setIFrame("https://www.youtube.com/embed/YHZKX0H6cUE");
		talkWhatIfMathematicsIsTheAnswer.setIFrame("https://www.youtube.com/embed/CfdFw3hXkf0");
		talkDevelopNativeAppsWithFlutter.setIFrame("https://www.youtube.com/embed/e7GWuWjBrm0");
		talkKeepItSimple.setIFrame("https://www.youtube.com/embed/zKXz3pUkw9A");
		talkWhyUseFlutter.setIFrame("https://www.youtube.com/embed/UD5uF5-w_fw");
		
		genreList1.add(coding);
		genreList1.add(literature);
		genreList1.add(art);
		talkPoetryOfProgramming.setGenres(genreList1);
		genreList2.add(technology);
		genreList2.add(literature);
		genreList2.add(philosophy);
		talkSoftwareAndStorytelling.setGenres(genreList2);
		genreList3.add(technology);
		genreList3.add(mobileApps);
		genreList3.add(philosophy);
		talkADelightfulWayToTeachKids.setGenres(genreList3);
		genreList4.add(technology);
		genreList4.add(philosophy);
		talkConveyingthePowerofAbstraction.setGenres(genreList4);
		genreList5.add(art);
		genreList5.add(philosophy);
		talkTheArtOfLogic.setGenres(genreList5);
		genreList6.add(music);
		genreList6.add(math);
		talkWhatIfMathematicsIsTheAnswer.setGenres(genreList6);
		genreList7.add(mobileApps);
		genreList7.add(coding);
		talkDevelopNativeAppsWithFlutter.setGenres(genreList7);
		genreList8.add(technology);
		genreList8.add(mobileApps);
		talkKeepItSimple.setGenres(genreList8);
		genreList9.add(mobileApps);
		talkWhyUseFlutter.setGenres(genreList9);
		
		tagList1.add(funny);
		tagList1.add(persuasive);
		tagList1.add(local);
		tagList1.add(educational);
		talkPoetryOfProgramming.setTags(tagList1);
		tagList2.add(funny);
		tagList2.add(informative);
		tagList2.add(spiritual);
		talkSoftwareAndStorytelling.setTags(tagList2);
		tagList3.add(uptodate);
		tagList3.add(educational);
		talkADelightfulWayToTeachKids.setTags(tagList3);
		tagList4.add(informative);
		tagList4.add(educational);
		tagList4.add(funny);
		talkConveyingthePowerofAbstraction.setTags(tagList4);
		tagList5.add(educational);
		tagList5.add(spiritual);
		tagList5.add(funny);
		talkTheArtOfLogic.setTags(tagList5);
		tagList6.add(educational);
		tagList6.add(uptodate);
		tagList6.add(local);
		talkWhatIfMathematicsIsTheAnswer.setTags(tagList6);
		tagList7.add(selfhelp);
		tagList7.add(educational);
		tagList7.add(persuasive);
		talkDevelopNativeAppsWithFlutter.setTags(tagList7);
		tagList8.add(funny);
		tagList8.add(informative);
		tagList8.add(persuasive);
		talkKeepItSimple.setTags(tagList8);
		tagList9.add(uptodate);
		tagList9.add(educational);
		tagList9.add(funny);
		talkWhyUseFlutter.setTags(tagList9);
		
		talkService.addTalk(talkPoetryOfProgramming);
		talkService.addTalk(talkSoftwareAndStorytelling);
		talkService.addTalk(talkADelightfulWayToTeachKids);
		talkService.addTalk(talkConveyingthePowerofAbstraction);
		talkService.addTalk(talkTheArtOfLogic);
		talkService.addTalk(talkWhatIfMathematicsIsTheAnswer);
		talkService.addTalk(talkDevelopNativeAppsWithFlutter);
		talkService.addTalk(talkKeepItSimple);
		talkService.addTalk(talkWhyUseFlutter);
		
		Host hostArtInstituteOfChicago = new Host("Art Institute of Chicago", "Chicago, IL",
				"A private university associated with the Art Institute of Chicago",
				"https://news.artnet.com/app/news-upload/2019/04/GettyImages-661869994-1024x683.jpg");
		Host hostWCCI = new Host("We Can Code IT", "Columbus, OH", "A bootcamp for full stack devolpers",
				"https://wecancodeit.org/wp-content/uploads/2018/07/hire-coding-bootcamp-students.jpg");
		Host hostTheOhioStateUniversity = new Host("The Ohio State University", "Columbus, OH",
				"A public research university in Columbus, OH, founded in 1870 as a land-grant university",
				"https://content.presspage.com/uploads/2170/1920_oval-aerial-1799-664882.jpg");

		hostService.addHost(hostArtInstituteOfChicago);
		hostService.addHost(hostWCCI);
		hostService.addHost(hostTheOhioStateUniversity);

		Event eventCodeAndCoffee = new Event("Code and Coffee", hostWCCI, "2 hours", coding,
				"December 21, 2019", Status.BOOKED, "Columbus, OH");
		Event eventCodeJam = new Event("Code Jam", hostWCCI, "3 hours", coding, 
				"January 10, 2020", Status.PENDING, "Columbus, OH");  
		Event eventHackerX = new Event("Hacker X - Nexient", hostWCCI, "2 hours", technology, 
				"January 9, 2020", Status.BOOKED, "Columbus, OH");
		Event eventPowerOfAbstraction = new Event("Art, Mathematics, and Logic", hostArtInstituteOfChicago,
				"3 hours", technology, "January 24, 2020", Status.BOOKED, "Chicago, IL");
		Event eventChicagoTechMeetup = new Event("Chicago Tech", hostArtInstituteOfChicago, "3 hours", philosophy,
				"February 1, 2020", Status.PENDING, "Chicago, IL");
		Event eventChicagoMathEnthusiasts = new Event("Chicago Math Enthusiasts", hostArtInstituteOfChicago, "2 hours", math, 
				"January 20, 2020", Status.BOOKED, "Chicago, IL");
		Event eventOhioTechConference = new Event("Ohio Tech Conference", hostTheOhioStateUniversity, "2 hours", technology,
				"January 21, 2020", Status.BOOKED, "Columbus, OH");
		Event eventOhioFlutterGroup = new Event("Ohio Flutter Group", hostTheOhioStateUniversity, "3 hours", coding, 
				"February 5, 2020", Status.PENDING, "Columbus, OH");
		Event eventFlutterAndDart = new Event("Flutter and Dart: Developing Beautiful Mobile Apps",
				hostTheOhioStateUniversity, "2 hours", mobileApps, "March 22, 2020", Status.BOOKED, "Columbus, OH");
		
		eventService.addEvent(eventCodeAndCoffee);
		eventService.addEvent(eventPowerOfAbstraction);
		eventService.addEvent(eventFlutterAndDart);
		eventService.addEvent(eventCodeJam);
		eventService.addEvent(eventHackerX);
		eventService.addEvent(eventChicagoTechMeetup);
		eventService.addEvent(eventChicagoMathEnthusiasts);
		eventService.addEvent(eventOhioFlutterGroup);
		eventService.addEvent(eventOhioTechConference);
		
		eventService.addTalkToEvent(eventCodeAndCoffee.getId(), talkSoftwareAndStorytelling);
		eventService.addTalkToEvent(eventPowerOfAbstraction.getId(), talkPoetryOfProgramming);
		eventService.addTalkToEvent(eventFlutterAndDart.getId(),talkWhyUseFlutter);
		eventService.addTalkToEvent(eventCodeJam.getId(),talkWhatIfMathematicsIsTheAnswer);
		eventService.addTalkToEvent(eventHackerX.getId(), talkTheArtOfLogic);
		eventService.addTalkToEvent(eventChicagoTechMeetup.getId(), talkADelightfulWayToTeachKids);
		eventService.addTalkToEvent(eventChicagoMathEnthusiasts.getId(), talkConveyingthePowerofAbstraction);
		eventService.addTalkToEvent(eventOhioFlutterGroup.getId(),talkDevelopNativeAppsWithFlutter);
		eventService.addTalkToEvent(eventOhioTechConference.getId(),talkKeepItSimple);
	}
}
