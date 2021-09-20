package com.juanmafe.newsletter.ports.in;

import java.util.stream.Stream;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * Newsletter Service.
 * @author juanmafe.
 */
public interface NewsletterService {

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	Stream<NewsletterSubscription> getAll();

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link String}.
	 */
	String create(NewsletterSubscription newsletterSubscription);

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	void deleteById(String id);

}