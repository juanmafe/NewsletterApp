package com.juanmafe.newsletter.adapters.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterSubscriptionEntity;

/**
 * Newsletter JPA Repository by Spring Data.
 * @author juanmafe.
 */
public interface NewsletterRepository extends JpaRepository<NewsletterSubscriptionEntity, Long> {}