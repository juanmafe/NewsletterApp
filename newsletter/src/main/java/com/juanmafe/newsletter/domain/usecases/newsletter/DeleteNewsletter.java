package com.juanmafe.newsletter.domain.usecases.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

/**
 * Delete Newsletter.
 * @author juanmafe.
 */
@Service
public class DeleteNewsletter {

	/** {@link NewsletterPersistence} newsletterPersistence */
	@Autowired
	private NewsletterPersistence newsletterPersistence;

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	public void execute(String id) {
		newsletterPersistence.delete(id);
	}

}