package com.juanmafe.newsletter.domain.services;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.persistence.NewsletterPersistence;
import com.juanmafe.newsletter.domain.utils.NewsletterUtils;

/**
 * Newsletter Service.
 * @author juanmafe.
 */
@Service
public class NewsletterService {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	public Stream<NewsletterSubscription> getAllNewsletters() {
		return newsletterPersistence.getAllNewsletters();
	}

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link String}.
	 */
	public String create(NewsletterSubscription newsletterSubscription) {
		if (NewsletterUtils.checkNewsletterEmptyFields(newsletterSubscription)) {
			return newsletterPersistence.save(newsletterSubscription);
		}
		throw new IllegalArgumentException("Some parameters are invalid");
	}

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	public void delete(String id) {
		newsletterPersistence.delete(id);
	}

}