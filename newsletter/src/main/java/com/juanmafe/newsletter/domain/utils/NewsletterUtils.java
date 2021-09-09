package com.juanmafe.newsletter.domain.utils;

import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * Newsletter Utils.
 * @author juanmafe.
 */
public final class NewsletterUtils {

	/**
	 * Private Constructor
	 */
	private NewsletterUtils() {}

	/**
	 * Checks newsletter empty fields.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return boolean.
	 */
	public static boolean checkNewsletterEmptyFields(NewsletterSubscription newsletterSubscription) {
		return newsletterSubscription != null
			&& newsletterSubscription.getName() != null
			&& newsletterSubscription.getSurname() != null
			&& newsletterSubscription.getFrequency() != null
			&& !newsletterSubscription.getTechnologies().isEmpty();
	}

	/**
	 * Checks if a string is a number.
	 * @param string String.
	 * @return boolean.
	 */
	public static boolean isNumeric(String string) {
		if(string == null) return false;
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}