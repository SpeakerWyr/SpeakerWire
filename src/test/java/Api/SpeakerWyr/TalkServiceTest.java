package Api.SpeakerWyr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import Api.SpeakerWyr.models.Duration;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Talk;
import Api.SpeakerWyr.repos.TalkRepository;
import Api.SpeakerWyr.services.SpeakerService;
import Api.SpeakerWyr.services.TalkService;

public class TalkServiceTest {

	@InjectMocks
	TalkService underTest;
	@Mock
	TalkRepository talkRepo;
	@Mock
	SpeakerService speakerService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void talkServiceShouldBeAbleToAddTalkToRepo2() throws Exception {
		Speaker speaker1 = new Speaker("SpeakerName", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl");
		Talk talk1 = new Talk("TalkTitle1", "TalkDescription1", Duration.MID, speaker1);
		when(underTest.fetchTalks()).thenReturn(Collections.singletonList(talk1));
		List<Talk> retrievedTalks = underTest.fetchTalks();
		assertThat(retrievedTalks, contains(talk1));
	}
	
}

	
