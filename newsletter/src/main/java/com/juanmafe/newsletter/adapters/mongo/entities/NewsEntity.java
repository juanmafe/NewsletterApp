package com.juanmafe.newsletter.adapters.mongo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.news.News;

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
	private String _id;

	/** {@link String} title */
	private String title;

	/** {@link String} description */
	private String description;

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
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

	/**
	 * Turns {@link NewsEntity} into {@link News};
	 * @return {@link News} Object.
	 */
	public News toNews() {
		var news = new News();
		news.setId(this.get_id());
		news.setTitle(this.getTitle());
		news.setDescription(this.getDescription());
		return news;
	}

}