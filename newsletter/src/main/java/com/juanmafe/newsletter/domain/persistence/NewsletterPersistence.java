package com.juanmafe.newsletter.domain.persistence;

import java.util.stream.Stream;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * Newsletter Persistence Layer.
 * @author juanmafe.
 */
public interface NewsletterPersistence {

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	Stream<NewsletterSubscription> getAllNewsletters();

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link String}.
	 */
	String save(NewsletterSubscription newsletterSubscription);

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	void delete(String id);

}