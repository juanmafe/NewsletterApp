package com.juanmafe.newsletter.adapters.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.NewsletterApplication;
import com.juanmafe.newsletter.domain.services.NewsService;
import com.juanmafe.newsletter.objectmother.ObjectMotherNews;

/**
 * News Controller Test.
 * @author juanmafe
 */
@WebMvcTest(NewsController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = NewsletterApplication.class)
class NewsControllerTest {

	/** URL */
	private static final String URL_NEWS= "/news";

	/** {@link NewsService} newsService */
	@MockBean
	private NewsService newsService;

	/** {@link MockMvc} mockMvc */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsService.getAllNews()).thenReturn(ObjectMotherNews.getNewsStream());
	}

	/**
	 * Checks the get all news REST.
	 * @throws Exception
	 */
	@Test
	void getAllNewsTest() throws Exception {
		mockMvc.perform(get(URL_NEWS)).andExpect(status().isOk());
	}

}