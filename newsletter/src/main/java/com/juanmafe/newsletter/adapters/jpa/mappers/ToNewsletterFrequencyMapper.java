package com.juanmafe.newsletter.adapters.jpa.mappers;

import org.springframework.beans.BeanUtils;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterFrequencyEntity;
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
	 * Turns {@link NewsletterFrequencyEntity} into {@link NewsletterFrequency};
	 * @return {@link NewsletterFrequency} Object.
	 */
	public static NewsletterFrequency toNewsletterFrequency(NewsletterFrequencyEntity newsletterFrequencyEntity) {
		var newsletterFrequency = new NewsletterFrequency();
		BeanUtils.copyProperties(newsletterFrequencyEntity, newsletterFrequency);
		return newsletterFrequency;
	}

}