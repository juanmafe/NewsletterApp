package com.juanmafe.newsletter.ports.in;

import java.util.stream.Stream;
import com.juanmafe.newsletter.domain.models.news.News;

/**
 * Get all News Service.
 * @author juanmafe.
 *
 */
public interface GetAllNewsService {

	/**
	 * Gets all news.
	 * @return {@link News} {@link Stream}.
	 */
	Stream<News> execute();

}