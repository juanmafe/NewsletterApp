package com.juanmafe.newsletter.adapters.rest.newsletter;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.juanmafe.newsletter.ports.dto.NewsletterConsumedDto;
import com.juanmafe.newsletter.ports.in.CreateNewsletterService;
import com.juanmafe.newsletter.ports.mappers.ToNewsletterSubscriptionMapper;

/**
 * Newsletter Create Rest Controller.
 * @author juanmafe.
 */
@RestController
@RequestMapping("/newsletter")
public class NewsletterCreateRest implements ToNewsletterSubscriptionMapper {

	/** {@link CreateNewsletterService} createNewsletterService */
	@Autowired
	private CreateNewsletterService createNewsletterService;

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterConsumedDto} Object.
	 * @return {@link String}.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String createNewsletter(@Valid @RequestBody NewsletterConsumedDto newsletterConsumedDto) {
		return createNewsletterService.execute(toNewsletterSubscription(newsletterConsumedDto));
	}

}