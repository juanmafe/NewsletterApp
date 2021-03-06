package com.juanmafe.newsletter.adapters.rest.newsletter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;
import com.juanmafe.newsletter.ports.in.NewsletterService;

/**
 * Newsletter Create Rest Controller Test.
 * @author juanmafe.
 */
@WebMvcTest(NewsletterCreateRest.class)
@AutoConfigureMockMvc(addFilters = false)
class NewsletterCreateRestTest {

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
		Mockito.when(newsletterService.create(Mockito.any(NewsletterSubscription.class))).thenReturn("1");
	}

	/**
	 * Checks the create newsletter REST.
	 * @throws Exception.
	 */
	@Test
	void createNewsletterRestTest() throws Exception {
		mockMvc.perform(post(URL_NEWSLETTER).contentType(MediaType.APPLICATION_JSON)
			.content(ObjectMotherNewsletter.NEWSLETTER_JSON)).andExpect(status().isCreated());
	}

	/**
	 * Checks the create newsletter REST with a wrong JSON.
	 * @throws Exception.
	 */
	@Test
	void createNewsletterRestWrongJsonTest() throws Exception {
		mockMvc.perform(post(URL_NEWSLETTER).contentType(MediaType.APPLICATION_JSON)
			.content(ObjectMotherNewsletter.WRONG_NEWSLETTER_JSON)).andExpect(status().is4xxClientError());
	}

}