package com.juanmafe.newsletter.adapters.rest.newsletter;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.juanmafe.newsletter.ports.dto.NewsletterProducedDto;
import com.juanmafe.newsletter.ports.in.GetAllNewsletterService;

/**
 * Newsletter Get All Rest Controller.
 * @author juanmafe.
 */
@RestController
@RequestMapping("/newsletter")
public class NewsletterGetAllRest {

	/** {@link GetAllNewsletterService} getAllNewsletterService */
	@Autowired
	private GetAllNewsletterService getAllNewsletterService;

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterProducedDto} {@link Stream}.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Stream<NewsletterProducedDto> getAllNewsletters() {
		return getAllNewsletterService.execute().map(NewsletterProducedDto::new);
	}

}