package com.juanmafe.newsletter.domain.services.newsletter;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.juanmafe.newsletter.domain.persistence.NewsletterPersistence;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;

/**
 * Newsletter Service Test.
 * @author juanmafe.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class GetAllNewsletterServiceTest {

	/** {@link GetAllNewsletterService} getAllNewsletterService */
	@Autowired
	private GetAllNewsletterService getAllNewsletterService;

	/** {@link NewsletterPersistence} newsletterPersistence */
	@MockBean
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsletterPersistence.getAllNewsletters()).thenReturn(ObjectMotherNewsletter.getNewsletterSubscriptionStream());
	}

	/**
	 * Checks the get all newsletter service.
	 */
	@Test
	void getAllNewsletterSubscriptionsTest() {
		assertThat(getAllNewsletterService.execute()).isNotEmpty().anyMatch(ns -> ns.getName().equals("Juan"));
	}

}