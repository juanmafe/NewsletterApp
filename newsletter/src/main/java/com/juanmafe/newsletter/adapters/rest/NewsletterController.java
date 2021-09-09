package com.juanmafe.newsletter.adapters.rest;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.juanmafe.newsletter.adapters.dto.NewsletterSubscriptionDto;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.services.NewsletterService;

/**
 * Newsletter Rest Controller.
 * @author juanmafe.
 */
@RestController
@RequestMapping("/newsletter")
public class NewsletterController {

	/** {@link NewsletterService} newsletterService */
	@Autowired
	private NewsletterService newsletterService;

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscriptionDto} {@link Stream}.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Stream<NewsletterSubscriptionDto> getAllNewsletters() {
		return newsletterService.getAllNewsletters().map(NewsletterSubscriptionDto::new);
	}

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link String}.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String createNewsletter(@RequestBody NewsletterSubscription newsletterSubscription) {
		return newsletterService.create(newsletterSubscription);
	}

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteNewsletter(@PathVariable("id") String id) {
		newsletterService.delete(id);
	}

}