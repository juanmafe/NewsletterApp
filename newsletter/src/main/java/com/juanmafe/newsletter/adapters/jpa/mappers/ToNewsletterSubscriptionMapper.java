package com.juanmafe.newsletter.adapters.jpa.mappers;

import org.springframework.util.ObjectUtils;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterSubscriptionEntity;
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
	 * Turns {@link NewsletterSubscriptionEntity} into {@link NewsletterSubscription};
	 * @return {@link NewsletterSubscription} Object.
	 */
	public static NewsletterSubscription toNewsletterSubscription(NewsletterSubscriptionEntity newsletterSubscriptionEntity) {
		var newsletterSubscription = new NewsletterSubscription();
		newsletterSubscription.setId(ObjectUtils.nullSafeToString(newsletterSubscriptionEntity.getId()));
		newsletterSubscription.setName(newsletterSubscriptionEntity.getName());
		newsletterSubscription.setSurname(newsletterSubscriptionEntity.getSurname());
		newsletterSubscription.setBirthday(newsletterSubscriptionEntity.getBirthday());
		newsletterSubscription.setFrequency(ToNewsletterFrequencyMapper.toNewsletterFrequency(newsletterSubscriptionEntity.getFrequency()));
		newsletterSubscription.setTechnologies(ToNewsletterTechnologiesMapper.toNewsletterTechnologiesFromEntity(newsletterSubscriptionEntity.getTechnologies()));
		return newsletterSubscription;
	}

}