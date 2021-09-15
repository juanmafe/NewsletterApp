package com.juanmafe.newsletter.adapters.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.adapters.rest.news.NewsGetAllRest;
import com.juanmafe.newsletter.domain.services.news.GetAllNewsService;
import com.juanmafe.newsletter.objectmother.ObjectMotherNews;

/**
 * News Get All Rest Controller Test.
 * @author juanmafe.
 */
@WebMvcTest(NewsGetAllRest.class)
class NewsGetAllRestTest {

	/** URL */
	private static final String URL_NEWS= "/news";

	/** {@link GetAllNewsService} getAllNewsService */
	@MockBean
	private GetAllNewsService getAllNewsService;

	/** {@link MockMvc} mockMvc */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(getAllNewsService.execute()).thenReturn(ObjectMotherNews.getNewsStream());
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