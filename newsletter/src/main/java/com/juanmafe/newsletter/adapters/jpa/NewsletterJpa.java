package com.juanmafe.newsletter.adapters.jpa;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.juanmafe.newsletter.adapters.jpa.dao.NewsletterRepository;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterSubscriptionEntity;
import com.juanmafe.newsletter.adapters.jpa.mappers.ToNewsletterSubscriptionMapper;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.ports.out.NewsletterPersistence;

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
		return newsletterRepository.findAll().stream().map(ToNewsletterSubscriptionMapper::toNewsletterSubscription);
	}

	@Override
	public String save(NewsletterSubscription newsletterSubscription) {
		return newsletterSubscription != null ? newsletterRepository.save(new NewsletterSubscriptionEntity(newsletterSubscription)).getId().toString() : "-1";
	}

	@Override
	public void delete(String id) {
		newsletterRepository.deleteById(Long.parseLong(id));
	}

}