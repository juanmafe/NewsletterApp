package com.juanmafe.newsletter.adapters.rest.newsletter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;
import com.juanmafe.newsletter.ports.in.NewsletterService;

/**
 * Newsletter Get All Rest Controller Test.
 * @author juanmafe.
 */
@WebMvcTest(NewsletterGetAllRest.class)
class NewsletterGetAllRestTest {

	/** URL */
	private static final String URL_NEWSLETTER = "/newsletter";

	/** {@link NewsletterService} newsletterService */
	@MockBean
	private NewsletterService newsletterService;

	/** {@link MockMvc} mockMvc */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsletterService.getAll()).thenReturn(ObjectMotherNewsletter.getNewsletterSubscriptionStream());
	}

	/**
	 * Checks the get all newsletter REST.
	 * @throws Exception.
	 */
	@Test
	void getAllNewslettersRestTest() throws Exception {
		mockMvc.perform(get(URL_NEWSLETTER)).andExpect(status().isOk());
	}

}