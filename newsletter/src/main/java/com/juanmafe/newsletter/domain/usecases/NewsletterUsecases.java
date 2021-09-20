package com.juanmafe.newsletter.domain.usecases;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.usecases.newsletter.CreateNewsletter;
import com.juanmafe.newsletter.domain.usecases.newsletter.DeleteNewsletter;
import com.juanmafe.newsletter.domain.usecases.newsletter.GetAllNewsletter;
import com.juanmafe.newsletter.ports.in.NewsletterService;

/**
 * Newsletter Service.
 * @author juanmafe.
 */
@Service
@ExcludeFromJacocoGeneratedReport
public class NewsletterUsecases implements NewsletterService {

	/** {@link GetAllNewsletter} getAllNewsletterService */
	@Autowired
	private GetAllNewsletter getAllNewsletterService;

	/** {@link CreateNewsletter} createNewsletterService */
	@Autowired
	private CreateNewsletter createNewsletterService;

	/** {@link DeleteNewsletter} deleteNewsletterService */
	@Autowired
	private DeleteNewsletter deleteNewsletterService;

	@Override
	public Stream<NewsletterSubscription> getAll() {
		return getAllNewsletterService.execute();
	}

	@Override
	public String create(NewsletterSubscription newsletterSubscription) {
		return createNewsletterService.execute(newsletterSubscription);
	}

	@Override
	public void deleteById(String id) {
		deleteNewsletterService.execute(id);
	}

}