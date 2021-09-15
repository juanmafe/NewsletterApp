package com.juanmafe.newsletter.ports.in;

/**
 * Delete Newsletter Service.
 * @author juanmafe.
 */
public interface DeleteNewsletterService {

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	void execute(String id);

}