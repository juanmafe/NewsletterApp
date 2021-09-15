package com.juanmafe.newsletter.ports.mappers;

import org.springframework.beans.BeanUtils;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterFrequencyEntity;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterFrequency;

/**
 * To NewsletterFrequency Mapper.
 * @author juanmafe.
 */
public interface ToNewsletterFrequencyMapper {

	/**
	 * Gets a {@link NewsletterFrequency} from ID.
	 * @param id String.
	 * @return {@link NewsletterFrequency} Object.
	 */
	default NewsletterFrequency toNewsletterFrequency(String id) {
		var newsletterFrequency = new NewsletterFrequency();
		newsletterFrequency.setId(id);
		return newsletterFrequency;
	}

	/**
	 * Turns {@link NewsletterFrequencyEntity} into {@link NewsletterFrequency};
	 * @return {@link NewsletterFrequency} Object.
	 */
	default NewsletterFrequency toNewsletterFrequency(NewsletterFrequencyEntity newsletterFrequencyEntity) {
		var newsletterFrequency = new NewsletterFrequency();
		BeanUtils.copyProperties(newsletterFrequencyEntity, newsletterFrequency);
		return newsletterFrequency;
	}

}