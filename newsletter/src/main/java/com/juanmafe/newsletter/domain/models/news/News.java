package com.juanmafe.newsletter.domain.models.news;

import java.util.Objects;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.AbstractModel;

/**
 * News.
 * @author juanmafe.
 */
@ExcludeFromJacocoGeneratedReport
public class News extends AbstractModel {

	/** {@link String} title */
	private String title;

	/** {@link String} description */
	private String description;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description, title);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof News)) {
			return false;
		}
		News other = (News) obj;
		return Objects.equals(description, other.description) && Objects.equals(title, other.title);
	}

}