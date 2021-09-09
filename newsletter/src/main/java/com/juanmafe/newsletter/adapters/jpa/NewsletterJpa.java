package com.juanmafe.newsletter.adapters.jpa;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.juanmafe.newsletter.adapters.jpa.dao.NewsletterRepository;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterSubscriptionEntity;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.persistence.NewsletterPersistence;
import com.juanmafe.newsletter.domain.utils.NewsletterUtils;

/**
 * Newsletter JPA Persistence Layer.
 * @author juanmafe.
 */
@Repository
public class NewsletterJpa implements NewsletterPersistence {

	/** {@link NewsletterRepository} newsletterRepository */
	@Autowired
	private NewsletterRepository newsletterRepository;

	@Override
	public Stream<NewsletterSubscription> getAllNewsletters() {
		return newsletterRepository.findAll().stream().map(NewsletterSubscriptionEntity::toNewsletterSubscription);
	}

	@Override
	public String save(NewsletterSubscription newsletterSubscription) {
		return newsletterSubscription != null ? newsletterRepository.save(new NewsletterSubscriptionEntity(newsletterSubscription)).getId().toString() : "-1";
	}

	@Override
	public void delete(String id) {
		if (NewsletterUtils.isNumeric(id)) newsletterRepository.deleteById(Long.valueOf(id));
	}

}