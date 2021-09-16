package com.juanmafe.newsletter.adapters.rest.mappers;

import com.juanmafe.newsletter.adapters.rest.dto.NewsletterConsumedDto;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * To NewsletterSubscription Mapper.
 * @author juanmafe.
 */
public final class ToNewsletterSubscriptionMapper {

	/**
	 * Private Constructor.
	 */
	private ToNewsletterSubscriptionMapper() {}

	/**
	 * Turns {@link NewsletterConsumedDto} into {@link NewsletterSubscription};
	 * @param newsletterConsumedDto {@link NewsletterConsumedDto} Object.
	 * @return {@link NewsletterSubscription} Object.
	 */
	public static NewsletterSubscription toNewsletterSubscription(NewsletterConsumedDto newsletterConsumedDto) {
		var newsletterSubscription = new NewsletterSubscription();
		newsletterSubscription.setName(newsletterConsumedDto.getName());
		newsletterSubscription.setSurname(newsletterConsumedDto.getSurname());
		newsletterSubscription.setFrequency(ToNewsletterFrequencyMapper.toNewsletterFrequency(newsletterConsumedDto.getFrequency()));
		newsletterSubscription.setTechnologies(ToNewsletterTechnologiesMapper.toNewsletterTechnologiesFromIDs(newsletterConsumedDto.getTechnologies()));
		return newsletterSubscription;
	}

}