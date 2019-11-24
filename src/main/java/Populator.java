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

		
		}

}

//		Talk testTalk1 = new Talk("TalkTitle1", "TalkDescription1", Duration.MID, speaker1);
//		Talk testTalk2 = new Talk("TalkTitle2", "TalkDescription2", Duration.MID, speaker1);
//		Talk testTalk3 = new Talk("TalkTitle3", "TalkDescription3", Duration.MID, speaker1);
//		