package com.juanmafe.newsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * Newsletter Application.
 * @author juanmafe.
 */
@SpringBootApplication()
@ExcludeFromJacocoGeneratedReport
public class NewsletterApplication {

	/**
	 * Main.
	 * @param args String[].
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewsletterApplication.class, args);
	}

}