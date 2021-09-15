package com.juanmafe.newsletter.ports.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * Newsletter Consumed DTO.
 * @author juanmafe.
 */
@ExcludeFromJacocoGeneratedReport
public class NewsletterConsumedDto {

	/** {@link String} name */
	@NotEmpty(message = "Please provide a name.")
	private String name;

	/** {@link String} surname */
	@NotEmpty(message = "Please provide a surname.")
	private String surname;

	/** {@link LocalDate} birthday */
	private LocalDate birthday;

	/** {@link String} frequency */
	@NotEmpty(message = "Please provide a frequency.")
	private String frequency;

	/** {@link String} {@link List} technologies */
	@NotEmpty(message = "Please provide a technology.")
	private List<String> technologies;

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