package com.juanmafe.newsletter.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.ports.in.DeleteNewsletterService;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Delete Newsletter.
 * @author juanmafe.
 */
@Service
public class DeleteNewsletter implements DeleteNewsletterService {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	@Override
	public void execute(String id) {
		newsletterPersistence.delete(id);
	}

}