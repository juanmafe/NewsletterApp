package com.juanmafe.newsletter.domain.services;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.news.News;
import com.juanmafe.newsletter.domain.persistence.NewsPersistence;

/**
 * News Service.
 * @author juanmafe.
 */
@Service
public class NewsService {

	/** {@link NewsPersistence} newsPersistence */
	@Autowired
	private NewsPersistence newsPersistence;

	/**
	 * Gets all news.
	 * @return {@link News} {@link Stream}.
	 */
	public Stream<News> getAllNews() {
		return newsPersistence.getAllNews();
	}

}