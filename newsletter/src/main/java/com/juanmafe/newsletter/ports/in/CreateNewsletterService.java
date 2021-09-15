package com.juanmafe.newsletter.ports.in;

import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * Create Newsletter Service.
 * @author juanamfe.
 */
public interface CreateNewsletterService {

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link String}.
	 */
	String execute(NewsletterSubscription newsletterSubscription);

}