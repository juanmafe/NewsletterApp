package com.juanmafe.newsletter.adapters.rest.mappers;

import java.util.List;
import java.util.stream.Collectors;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterTechnologies;

/**
 * To NewsletterTechnologies Mapper.
 * @author juanmafe.
 */
public final class ToNewsletterTechnologiesMapper {

	/**
	 * Private Constructor.
	 */
	private ToNewsletterTechnologiesMapper() {}

	/**
	 * Gets a {@link NewsletterTechnologies} from ID {@link List}.
	 * @param ids String {@link List}.
	 * @return {@link NewsletterTechnologies} Object.
	 */
	public static List<NewsletterTechnologies> toNewsletterTechnologiesFromIDs(List<String> ids) {
		return ids.stream().map(ToNewsletterTechnologiesMapper::toNewsletterTechnologies).collect(Collectors.toList());
	}

	/**
	 * Gets a {@link NewsletterTechnologies} from ID.
	 * @param id String.
	 * @return {@link NewsletterTechnologies} Object.
	 */
	public static NewsletterTechnologies toNewsletterTechnologies(String id) {
		var newsletterTechnologies = new NewsletterTechnologies();
		newsletterTechnologies.setId(id);
		return newsletterTechnologies;
	}

}