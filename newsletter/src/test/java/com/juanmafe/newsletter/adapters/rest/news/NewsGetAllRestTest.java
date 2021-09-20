package com.juanmafe.newsletter.adapters.rest.news;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.objectmother.ObjectMotherNews;
import com.juanmafe.newsletter.ports.in.NewsService;

/**
 * News Get All Rest Controller Test.
 * @author juanmafe.
 */
@WebMvcTest(NewsGetAllRest.class)
class NewsGetAllRestTest {

	/** URL */
	private static final String URL_NEWS= "/news";

	/** {@link NewsService} mewsService */
	@MockBean
	private NewsService mewsService;

	/** {@link MockMvc} mockMvc */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(mewsService.getAll()).thenReturn(ObjectMotherNews.getNewsStream());
	}

	/**
	 * Checks the get all news REST.
	 * @throws Exception.
	 */
	@Test
	void getAllNewsRestTest() throws Exception {
		mockMvc.perform(get(URL_NEWS)).andExpect(status().isOk());
	}

}