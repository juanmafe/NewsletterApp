package com.juanmafe.newsletter.adapters.rest;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.juanmafe.newsletter.NewsletterApplication;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.services.NewsletterService;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;

/**
 * Newsletter Controller Test.
 * @author juanmafe
 */
@WebMvcTest(NewsletterController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = NewsletterApplication.class)
class NewsletterControllerTest {

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
		Mockito.when(newsletterService.getAllNewsletters()).thenReturn(ObjectMotherNewsletter.getNewsletterSubscriptionStream());
		Mockito.when(newsletterService.create(Mockito.any(NewsletterSubscription.class))).thenReturn("1");
		doNothing().when(newsletterService).delete(Mockito.anyString());
	}

	/**
	 * Checks the get all newsletter REST.
	 * @throws Exception
	 */
	@Test
	void getAllNewslettersTest() throws Exception {
		mockMvc.perform(get(URL_NEWSLETTER)).andExpect(status().isOk());
	}

	/**
	 * Checks the create newsletter REST.
	 * @throws Exception
	 */
	@Test
	void createNewsletterTest() throws Exception {
		mockMvc.perform(post(URL_NEWSLETTER).contentType(MediaType.APPLICATION_JSON)
		.content(ObjectMotherNewsletter.NEWSLETTER_JSON)).andExpect(status().isCreated());
	}

	/**
	 * Checks the delete newsletter REST.
	 * @throws Exception
	 */
	@Test
	void deleteNewsletterTest() throws Exception {
		mockMvc.perform(delete(URL_NEWSLETTER + "/1")).andExpect(status().isOk());
	}

}