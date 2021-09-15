package com.juanmafe.newsletter.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.ports.in.CreateNewsletterService;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Create Newsletter.
 * @author juanmafe.
 */
@Service
public class CreateNewsletter implements CreateNewsletterService {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	@Override
	public String execute(NewsletterSubscription newsletterSubscription) {
		return newsletterPersistence.save(newsletterSubscription);
	}

}