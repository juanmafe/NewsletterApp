package com.juanmafe.newsletter.domain.usecases;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.ports.in.GetAllNewsletterService;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Get All Newsletter Service.
 * @author juanmafe.
 */
@Service
public class GetAllNewsletter implements GetAllNewsletterService {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	@Override
	public Stream<NewsletterSubscription> execute() {
		return newsletterPersistence.getAllNewsletters();
	}

}