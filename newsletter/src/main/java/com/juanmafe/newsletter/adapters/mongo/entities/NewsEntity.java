package com.juanmafe.newsletter.adapters.mongo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * News Entity.
 * @author juanmafe.
 */
@Document(collection = "news")
@ExcludeFromJacocoGeneratedReport
public class NewsEntity {

	/** {@link Long} id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	/** {@link String} title */
	private String title;

	/** {@link String} description */
	private String description;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

}