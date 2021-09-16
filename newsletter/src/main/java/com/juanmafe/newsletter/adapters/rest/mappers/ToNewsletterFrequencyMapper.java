package com.juanmafe.newsletter.adapters.rest.mappers;

import com.juanmafe.newsletter.domain.models.newsletter.NewsletterFrequency;

/**
 * To NewsletterFrequency Mapper.
 * @author juanmafe.
 */
public final class ToNewsletterFrequencyMapper {

	/**
	 * Private Constructor.
	 */
	private ToNewsletterFrequencyMapper() {}

	/**
	 * Gets a {@link NewsletterFrequency} from ID.
	 * @param id String.
	 * @return {@link NewsletterFrequency} Object.
	 */
	public static NewsletterFrequency toNewsletterFrequency(String id) {
		var newsletterFrequency = new NewsletterFrequency();
		newsletterFrequency.setId(id);
		return newsletterFrequency;
	}

}