package com.juanmafe.newsletter.adapters.jpa.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterTechnologiesEntity;
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
	 * Gets a {@link NewsletterTechnologies} from {@link NewsletterTechnologiesEntity} {@link List}.
	 * @param newsletterTechnologiesEntityList {@link NewsletterTechnologiesEntity} {@link List}.
	 * @return {@link NewsletterTechnologies} Object.
	 */
	public static List<NewsletterTechnologies> toNewsletterTechnologiesFromEntity(List<NewsletterTechnologiesEntity> newsletterTechnologiesEntityList) {
		return newsletterTechnologiesEntityList.stream().map(ToNewsletterTechnologiesMapper::toNewsletterTechnologies).collect(Collectors.toList());
	}

	/**
	 * Turns {@link NewsletterTechnologiesEntity} into {@link NewsletterTechnologies};
	 * @return {@link NewsletterTechnologies} Object.
	 */
	public static NewsletterTechnologies toNewsletterTechnologies(NewsletterTechnologiesEntity newsletterTechnologiesEntity) {
		var newsletterTechnologies = new NewsletterTechnologies();
		BeanUtils.copyProperties(newsletterTechnologiesEntity, newsletterTechnologies);
		return newsletterTechnologies;
	}

}