package com.juanmafe.newsletter.adapters.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterTechnologies;

/**
 * Newsletter Technologies Entity.
 * @author juanmafe.
 */
@Entity
@Table(name="NEWS_SUBS_TECH")
@ExcludeFromJacocoGeneratedReport
public class NewsletterTechnologiesEntity {

	/** {@link Long} id */
	@Id
	private Long id;

	/** {@link String} name */
	@Column(name="NAME", length=200, nullable=false)
	private String name;

	/** {@link String} description */
	@Column(name="DESCRIPTION", length=200, nullable=false)
	private String description;

	/** {@link NewsletterSubscriptionEntity} {@link List} newsletter */
	@ManyToMany(mappedBy = "technologies")
	private List<NewsletterSubscriptionEntity> newsletter;

	/**
	 * Default Constructor.
	 */
	public NewsletterTechnologiesEntity() {}

	/**
	 * Constructor based on {@link NewsletterTechnologies} Object.
	 * @param newsletterTechnologies {@link NewsletterTechnologies} Object.
	 */
	public NewsletterTechnologiesEntity(NewsletterTechnologies newsletterTechnologies) {
		this.id = newsletterTechnologies.getId() != null ? Long.valueOf(newsletterTechnologies.getId()) : null;
		this.name = newsletterTechnologies.getName();
		this.description = newsletterTechnologies.getDescription();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the newsletter
	 */
	public List<NewsletterSubscriptionEntity> getNewsletter() {
		return new ArrayList<>(newsletter);
	}

	/**
	 * @param newsletter the newsletter to set
	 */
	public void setNewsletter(List<NewsletterSubscriptionEntity> newsletter) {
		this.newsletter = newsletter != null ? new ArrayList<>(newsletter) : new ArrayList<>();
	}

}