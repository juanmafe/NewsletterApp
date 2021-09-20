package com.juanmafe.newsletter.domain.usecases.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Create Newsletter.
 * @author juanmafe.
 */
@Service
public class CreateNewsletter {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link String}.
	 */
	public String execute(NewsletterSubscription newsletterSubscription) {
		return newsletterPersistence.save(newsletterSubscription);
	}

}