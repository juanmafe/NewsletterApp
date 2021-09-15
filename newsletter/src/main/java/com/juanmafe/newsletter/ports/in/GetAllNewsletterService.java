package com.juanmafe.newsletter.ports.in;

import java.util.stream.Stream;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * Get all Newsletter Service.
 * @author juanmafe.
 */
public interface GetAllNewsletterService {

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	Stream<NewsletterSubscription> execute();

}