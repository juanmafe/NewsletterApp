package com.juanmafe.newsletter.adapters.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterTechnologies;

/**
 * Newsletter Subscription Dto.
 * @author juanmafe.
 */
@ExcludeFromJacocoGeneratedReport
public class NewsletterSubscriptionDto implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 8312984321018060549L;

	/** {@link String} name */
	private String name;

	/** {@link String} surname */
	private String surname;

	/** {@link LocalDate} birthday */
	private LocalDate birthday;

	/** {@link String} frequency */
	private String frequency;

	/** {@link String} {@link List} technologies */
	private List<String> technologies;

	/**
	 * Default Constructor.
	 */
	public NewsletterSubscriptionDto() {}

	/**
	 * Constructor based on {@link NewsletterSubscription}.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 */
	public NewsletterSubscriptionDto(NewsletterSubscription newsletterSubscription) {
		this.name = newsletterSubscription.getName();
		this.surname = newsletterSubscription.getSurname();
		this.birthday = newsletterSubscription.getBirthday();
		this.frequency = newsletterSubscription.getFrequency().getName();
		this.technologies = newsletterSubscription.getTechnologies().stream().map(NewsletterTechnologies::getName).collect(Collectors.toList());
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the technologies
	 */
	public List<String> getTechnologies() {
		return technologies;
	}

	/**
	 * @param technologies the technologies to set
	 */
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

}