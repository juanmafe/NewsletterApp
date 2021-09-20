package com.juanmafe.newsletter.domain.usecases.newsletter;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Get All Newsletter.
 * @author juanmafe.
 */
@Service
public class GetAllNewsletter {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	public Stream<NewsletterSubscription> execute() {
		return newsletterPersistence.getAllNewsletters();
	}

}