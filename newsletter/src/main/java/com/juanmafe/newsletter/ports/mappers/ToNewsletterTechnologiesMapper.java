package com.juanmafe.newsletter.ports.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import com.juanmafe.newsletter.adapters.jpa.entities.NewsletterTechnologiesEntity;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterTechnologies;

/**
 * To NewsletterTechnologies Mapper.
 * @author juanmafe.
 */
public interface ToNewsletterTechnologiesMapper {

	/**
	 * Gets a {@link NewsletterTechnologies} from ID {@link List}.
	 * @param ids String {@link List}.
	 * @return {@link NewsletterTechnologies} Object.
	 */
	default List<NewsletterTechnologies> toNewsletterTechnologiesFromIDs(List<String> ids) {
		return ids.stream().map(this::toNewsletterTechnologies).collect(Collectors.toList());
	}

	/**
	 * Gets a {@link NewsletterTechnologies} from ID.
	 * @param id String.
	 * @return {@link NewsletterTechnologies} Object.
	 */
	default NewsletterTechnologies toNewsletterTechnologies(String id) {
		var newsletterTechnologies = new NewsletterTechnologies();
		newsletterTechnologies.setId(id);
		return newsletterTechnologies;
	}

	/**
	 * Gets a {@link NewsletterTechnologies} from {@link NewsletterTechnologiesEntity} {@link List}.
	 * @param newsletterTechnologiesEntityList {@link NewsletterTechnologiesEntity} {@link List}.
	 * @return {@link NewsletterTechnologies} Object.
	 */
	default List<NewsletterTechnologies> toNewsletterTechnologiesFromEntity(List<NewsletterTechnologiesEntity> newsletterTechnologiesEntityList) {
		return newsletterTechnologiesEntityList.stream().map(this::toNewsletterTechnologies).collect(Collectors.toList());
	}

	/**
	 * Turns {@link NewsletterTechnologiesEntity} into {@link NewsletterTechnologies};
	 * @return {@link NewsletterTechnologies} Object.
	 */
	default NewsletterTechnologies toNewsletterTechnologies(NewsletterTechnologiesEntity newsletterTechnologiesEntity) {
		var newsletterTechnologies = new NewsletterTechnologies();
		BeanUtils.copyProperties(newsletterTechnologiesEntity, newsletterTechnologies);
		return newsletterTechnologies;
	}

}