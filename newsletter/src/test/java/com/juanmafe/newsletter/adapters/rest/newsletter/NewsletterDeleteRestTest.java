package com.juanmafe.newsletter.adapters.rest.newsletter;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.ports.in.DeleteNewsletterService;

/**
 * Newsletter Delete Rest Controller Test.
 * @author juanmafe.
 */
@WebMvcTest(NewsletterDeleteRest.class)
@AutoConfigureMockMvc(addFilters = false)
class NewsletterDeleteRestTest {

	/** URL */
	private static final String URL_NEWSLETTER = "/newsletter";

	/** {@link DeleteNewsletterService} deleteNewsletterService */
	@MockBean
	private DeleteNewsletterService deleteNewsletterService;

	/** {@link MockMvc} mockMvc */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		doNothing().when(deleteNewsletterService).execute(Mockito.anyString());
	}

	/**
	 * Checks the delete newsletter REST.
	 * @throws Exception.
	 */
	@Test
	void deleteNewsletterRestTest() throws Exception {
		mockMvc.perform(delete(URL_NEWSLETTER + "/1")).andExpect(status().isOk());
	}

}