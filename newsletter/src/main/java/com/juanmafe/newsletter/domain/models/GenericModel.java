package com.juanmafe.newsletter.domain.models;

import java.util.Objects;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * Generic Model.
 * @author juanmafe.
 */
@ExcludeFromJacocoGeneratedReport
public abstract class GenericModel extends AbstractModel {

	/** {@link String} name */
	private String name;

	/** {@link String} description */
	private String description;

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

	@Override
	public int hashCode() {
		final var prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
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
		if (!(obj instanceof GenericModel)) {
			return false;
		}
		GenericModel other = (GenericModel) obj;
		return Objects.equals(name, other.name);
	}

}