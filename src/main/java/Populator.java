import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Api.SpeakerWyr.SpeakerService;
import Api.SpeakerWyr.TalkService;
import Api.SpeakerWyr.models.Duration;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Talk;

@Component
public class Populator implements CommandLineRunner {
	
	@Autowired
	private TalkService talkService;
	@Autowired
	private SpeakerService speakerService;
	
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
		
		}

}

		