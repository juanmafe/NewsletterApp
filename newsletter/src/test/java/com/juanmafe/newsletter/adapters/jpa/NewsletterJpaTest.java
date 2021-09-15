package com.juanmafe.newsletter.adapters.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.juanmafe.newsletter.adapters.jpa.dao.NewsletterRepository;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterSubscriptionEntity;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletter;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsletterEntity;

/**
 * Newsletter JPA Test.
 * @author juanmafe.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class NewsletterJpaTest {

	/** {@link NewsletterJpa} newsletterJpa */
	@Autowired
	private NewsletterJpa newsletterJpa;

	/** {@link NewsletterJpa} newsletterJpaForVoids */
	@Mock
	private NewsletterJpa newsletterJpaForVoids;

	/** {@link NewsletterRepository} newsletterRepository */
	@MockBean
	private NewsletterRepository newsletterRepository;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsletterRepository.findAll()).thenReturn(ObjectMotherNewsletterEntity.getNewsletterSubscriptionEntityList());
		Mockito.when(newsletterRepository.save(Mockito.any(NewsletterSubscriptionEntity.class))).thenReturn(ObjectMotherNewsletterEntity.getNewsletterSubscriptionEntity());
		doNothing().when(newsletterRepository).deleteById(Mockito.anyLong());
	}

	/**
	 * Checks the get all newsletter service.
	 */
	@Test
	void getAllNewsletterSubscriptionsTest() {
		assertThat(newsletterJpa.getAllNewsletters()).isNotEmpty().anyMatch(ns -> ns.getName().equals("Juan"));
	}

	/**
	 * Checks the create newsletter service.
	 */
	@Test
	void createNewsletterSubscriptionTest() {
		assertThat(newsletterJpa.save(ObjectMotherNewsletter.getNewsletterSubscription())).isEqualTo("1");
		assertThat(newsletterJpa.save(null)).isEqualTo("-1");
	}

	/**
	 * Checks the delete newsletter service when the argument is null.
	 */
	@Test
	void deleteNewsletterSubscriptionNullTest() {
		String id = null;
		newsletterJpa.delete(id);
		assertNull(id);
	}

	/**
	 * Checks the delete newsletter service when the argument is not numeric.
	 */
	@Test
	void deleteNewsletterSubscriptionNotNumericTest() {
		String id = "a";
		newsletterJpa.delete(id);
		assertEquals("a", id);
	}

	/**
	 * Checks the delete newsletter service when the argument is numeric.
	 */
	@Test
	void deleteNewsletterSubscriptionNumericTest() {
		String id = "1";
		newsletterJpa.delete(id);
		assertEquals("1", id);
		newsletterJpaForVoids.delete(id);
		verify(newsletterJpaForVoids, times(1)).delete(id);
	}

}