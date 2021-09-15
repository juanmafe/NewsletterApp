package com.juanmafe.newsletter.ports.mappers;

import org.springframework.util.ObjectUtils;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterSubscriptionEntity;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.ports.dto.NewsletterConsumedDto;

/**
 * To NewsletterSubscription Mapper.
 * @author juanmafe.
 */
public interface ToNewsletterSubscriptionMapper extends ToNewsletterFrequencyMapper, ToNewsletterTechnologiesMapper {

	/**
	 * Turns {@link NewsletterConsumedDto} into {@link NewsletterSubscription};
	 * @param newsletterConsumedDto {@link NewsletterConsumedDto} Object.
	 * @return {@link NewsletterSubscription} Object.
	 */
	default NewsletterSubscription toNewsletterSubscription(NewsletterConsumedDto newsletterConsumedDto) {
		var newsletterSubscription = new NewsletterSubscription();
		newsletterSubscription.setName(newsletterConsumedDto.getName());
		newsletterSubscription.setSurname(newsletterConsumedDto.getSurname());
		newsletterSubscription.setFrequency(toNewsletterFrequency(newsletterConsumedDto.getFrequency()));
		newsletterSubscription.setTechnologies(toNewsletterTechnologiesFromIDs(newsletterConsumedDto.getTechnologies()));
		return newsletterSubscription;
	}

	/**
	 * Turns {@link NewsletterSubscriptionEntity} into {@link NewsletterSubscription};
	 * @return {@link NewsletterSubscription} Object.
	 */
	default NewsletterSubscription toNewsletterSubscription(NewsletterSubscriptionEntity newsletterSubscriptionEntity) {
		var newsletterSubscription = new NewsletterSubscription();
		newsletterSubscription.setId(ObjectUtils.nullSafeToString(newsletterSubscriptionEntity.getId()));
		newsletterSubscription.setName(newsletterSubscriptionEntity.getName());
		newsletterSubscription.setSurname(newsletterSubscriptionEntity.getSurname());
		newsletterSubscription.setBirthday(newsletterSubscriptionEntity.getBirthday());
		newsletterSubscription.setFrequency(toNewsletterFrequency(newsletterSubscriptionEntity.getFrequency()));
		newsletterSubscription.setTechnologies(toNewsletterTechnologiesFromEntity(newsletterSubscriptionEntity.getTechnologies()));
		return newsletterSubscription;
	}

}