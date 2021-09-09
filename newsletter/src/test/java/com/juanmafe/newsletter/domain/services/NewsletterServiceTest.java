package com.juanmafe.newsletter.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.persistence.NewsletterPersistence;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;

/**
 * Newsletter Service Test.
 * @author juanmafe
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class NewsletterServiceTest {

	/** {@link NewsletterService} newsletterService */
	@Autowired
	private NewsletterService newsletterService;

	/** {@link NewsletterService} newsletterServiceForVoids */
	@Mock
	private NewsletterService newsletterServiceForVoids;

	/** {@link NewsletterPersistence} newsletterPersistence */
	@MockBean
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsletterPersistence.getAllNewsletters()).thenReturn(ObjectMotherNewsletter.getNewsletterSubscriptionStream());
		Mockito.when(newsletterPersistence.save(Mockito.any(NewsletterSubscription.class))).thenReturn("1");
		doNothing().when(newsletterPersistence).delete(Mockito.anyString());
	}

	/**
	 * Checks the get all newsletter service.
	 */
	@Test
	void getAllNewsletterSubscriptionsTest() {
		assertThat(newsletterService.getAllNewsletters()).isNotEmpty().anyMatch(ns -> ns.getName().equals("Juan"));
	}

	/**
	 * Checks the create newsletter service.
	 */
	@Test
	void createNewsletterSubscriptionTest() {
		assertThat(newsletterService.create(ObjectMotherNewsletter.getNewsletterSubscription())).isEqualTo("1");
		assertThatIllegalArgumentException().isThrownBy(() -> newsletterService.create(null));
		assertThatIllegalArgumentException().isThrownBy(() -> newsletterService.create(ObjectMotherNewsletter.getEmptyNewsletterSubscription()));
		assertThatIllegalArgumentException().isThrownBy(() -> newsletterService.create(ObjectMotherNewsletter.getNewsletterSubscriptionName()));
		assertThatIllegalArgumentException().isThrownBy(() -> newsletterService.create(ObjectMotherNewsletter.getNewsletterSubscriptionNameSurname()));
		assertThatIllegalArgumentException().isThrownBy(() -> newsletterService.create(ObjectMotherNewsletter.getNewsletterSubscriptionNameSurnameFrecuency()));
		assertThatIllegalArgumentException().isThrownBy(() -> newsletterService.create(ObjectMotherNewsletter.getNewsletterSubscriptionNameSurnameFrecuencyEmptyTech()));
	}

	/**
	 * Checks the delete newsletter service.
	 */
	@Test
	void deleteNewsletterSubscriptionTest() {
		String id = null;
		newsletterService.delete(id);
		assertNull(id);
		newsletterServiceForVoids.delete(id);
		verify(newsletterServiceForVoids, times(1)).delete(id);
	}

}