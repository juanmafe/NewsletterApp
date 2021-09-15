package com.juanmafe.newsletter.domain.services.newsletter;

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
import com.juanmafe.newsletter.ports.in.DeleteNewsletterService;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Newsletter Service Test.
 * @author juanmafe.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class DeleteNewsletterTest {

	/** {@link DeleteNewsletterService} deleteNewsletterService */
	@Autowired
	private DeleteNewsletterService deleteNewsletterService;

	/** {@link DeleteNewsletterService} deleteNewsletterServiceForVoids */
	@Mock
	private DeleteNewsletterService deleteNewsletterServiceForVoids;

	/** {@link NewsletterPersistence} newsletterPersistence */
	@MockBean
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		doNothing().when(newsletterPersistence).delete(Mockito.anyString());
	}

	/**
	 * Checks the delete newsletter service.
	 */
	@Test
	void deleteNewsletterSubscriptionTest() {
		String id = null;
		deleteNewsletterService.execute(id);
		assertNull(id);
		deleteNewsletterServiceForVoids.execute(id);
		verify(deleteNewsletterServiceForVoids, times(1)).execute(id);
	}

}