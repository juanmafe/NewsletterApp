package com.juanmafe.newsletter.adapters.jpa.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.newsletter.NewsletterSubscription;

/**
 * Newsletter Subscription Entity.
 * @author juanmafe.
 */
@Entity
@Table(name="NEWS_SUBS")
@ExcludeFromJacocoGeneratedReport
public class NewsletterSubscriptionEntity {

	/** {@link Long} id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** {@link String} name */
	@Column(name="NAME", length=200, nullable=false)
	private String name;

	/** {@link String} surname */
	@Column(name="SURNAME", length=200, nullable=false)
	private String surname;

	/** {@link LocalDate} birthday */
	@Column(name="BIRTHDAY", length=200, nullable=true)
	private LocalDate birthday;

	/** {@link NewsletterFrequencyEntity} frequency */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NEWS_SUBS_FREQ", nullable=false)
	private NewsletterFrequencyEntity frequency;

	/** {@link NewsletterTechnologiesEntity} {@link List} technologies */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "NEWS_SUBS_TAGS",
		joinColumns = @JoinColumn(name = "ID_NEWS_SUBS", nullable = false),
		inverseJoinColumns = @JoinColumn(name="ID_NEWS_SUBS_TECH", nullable = false))
	private List<NewsletterTechnologiesEntity> technologies;

	/**
	 * Default Constructor.
	 */
	public NewsletterSubscriptionEntity() {}

	/**
	 * Constructor based on {@link NewsletterSubscription} Object.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 */
	public NewsletterSubscriptionEntity(NewsletterSubscription newsletterSubscription) {
		this.name = newsletterSubscription.getName();
		this.surname = newsletterSubscription.getSurname();
		this.birthday = newsletterSubscription.getBirthday();
		this.frequency = new NewsletterFrequencyEntity(newsletterSubscription.getFrequency());
		this.technologies = newsletterSubscription.getTechnologies().stream().map(NewsletterTechnologiesEntity::new).collect(Collectors.toList());
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
	public NewsletterFrequencyEntity getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(NewsletterFrequencyEntity frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the technologies
	 */
	public List<NewsletterTechnologiesEntity> getTechnologies() {
		return technologies!= null ? new ArrayList<>(technologies) : new ArrayList<>();
	}

	/**
	 * @param technologies the technologies to set
	 */
	public void setTechnologies(List<NewsletterTechnologiesEntity> technologies) {
		this.technologies = technologies != null ? new ArrayList<>(technologies) : new ArrayList<>();
	}

	/**
	 * Turns {@link NewsletterSubscriptionEntity} into {@link NewsletterSubscription};
	 * @return {@link NewsletterSubscription} Object.
	 */
	public NewsletterSubscription toNewsletterSubscription() {
		var newsletterSubscription = new NewsletterSubscription();
		newsletterSubscription.setId(this.getId() != null ? this.getId().toString() : null);
		newsletterSubscription.setName(this.getName());
		newsletterSubscription.setSurname(this.getSurname());
		newsletterSubscription.setBirthday(this.getBirthday());
		newsletterSubscription.setFrequency(this.getFrequency().toNewsletterFrequency());
		newsletterSubscription.setTechnologies(this.getTechnologies().stream().map(NewsletterTechnologiesEntity::toNewsletterTechnologies).collect(Collectors.toList()));
		return newsletterSubscription;
	}

}