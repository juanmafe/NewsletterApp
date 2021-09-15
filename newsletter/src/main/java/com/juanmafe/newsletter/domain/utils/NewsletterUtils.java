package com.juanmafe.newsletter.domain.utils;

/**
 * Newsletter utilities.
 * @author juanmafe.
 */
public final class NewsletterUtils {

	/**
	 * Private Constructor
	 */
	private NewsletterUtils() {}

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