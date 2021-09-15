package com.juanmafe.newsletter.domain.services.newsletter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.usecases.CreateNewsletter;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;
import com.juanmafe.newsletter.ports.in.CreateNewsletterService;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Newsletter Service Test.
 * @author juanmafe.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class CreateNewsletterTest {

	/** {@link CreateNewsletter} createNewsletterService */
	@Autowired
	private CreateNewsletterService createNewsletterService;

	/** {@link NewsletterPersistence} newsletterPersistence */
	@MockBean
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsletterPersistence.save(Mockito.any(NewsletterSubscription.class))).thenReturn("1");
	}

	/**
	 * Checks the create newsletter service.
	 */
	@Test
	void createNewsletterSubscriptionTest() {
		assertEquals("1", createNewsletterService.execute(ObjectMotherNewsletter.getNewsletterSubscription()));
	}

}