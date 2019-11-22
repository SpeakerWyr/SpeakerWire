package Api.SpeakerWyr;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Api.SpeakerWyr.models.Duration;
import Api.SpeakerWyr.models.Speaker;
import Api.SpeakerWyr.models.Talk;







public class TalkControllerTest {

	@InjectMocks
	private TalkController underTest; 
	
	@Mock
	private TalkService talkService; 
	
	private MockMvc mockMvc;
	
	Speaker speaker1 = new Speaker("SpeakerName", "SpeakerLocation", "SpeakerBio", "SpeakerHeadshotUrl");
	Talk testTalk = new Talk("TalkTitle1", "TalkDescription1", Duration.MID, speaker1);
	
	@Before 
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	
	@Test
	public void fecthTalksIsMappedCorrectlyAndReturnsJsonList() throws Exception {
		when(talkService.fetchTalks()). thenReturn(Collections.singletonList(testTalk));
		mockMvc.perform(get("/api/talks")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$",hasSize(1)))
			.andExpect(jsonPath("$[0].title", is(equalTo("TalkTitle1"))));
	}
	
	@Test
	public void fetchByIdIsMappedCorrectlyAndReturnsAJsonTalk() throws Exception {
		when(talkService.fetchTalk(1L)).thenReturn(testTalk);
		mockMvc.perform(get("/api/talks/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.title", is(equalTo("TalkTitle1"))));
	}
	
	
}
