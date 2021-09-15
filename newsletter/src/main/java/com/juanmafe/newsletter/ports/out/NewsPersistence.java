package com.juanmafe.newsletter.ports.out;

import java.util.stream.Stream;
import com.juanmafe.newsletter.domain.models.news.News;

/**
 * News Persistence Layer.
 * @author juanmafe.
 */
public interface NewsPersistence {

	/**
	 * Gets all news.
	 * @return {@link News} {@link Stream}.
	 */
	Stream<News> getAllNews();

}