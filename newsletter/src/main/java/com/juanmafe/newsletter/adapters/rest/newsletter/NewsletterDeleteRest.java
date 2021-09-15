package com.juanmafe.newsletter.adapters.rest.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.juanmafe.newsletter.domain.services.newsletter.DeleteNewsletterService;

/**
 * Newsletter Delete Rest Controller.
 * @author juanmafe.
 */
@RestController
@RequestMapping("/newsletter")
public class NewsletterDeleteRest {

	/** {@link DeleteNewsletterService} deleteNewsletterService */
	@Autowired
	private DeleteNewsletterService deleteNewsletterService;

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteNewsletter(@PathVariable("id") String id) {
		deleteNewsletterService.execute(id);
	}

}