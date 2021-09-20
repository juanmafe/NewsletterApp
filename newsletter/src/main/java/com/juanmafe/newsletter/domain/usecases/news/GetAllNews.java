package com.juanmafe.newsletter.domain.usecases.news;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.domain.models.news.News;
import com.juanmafe.newsletter.ports.out.NewsPersistence;

/**
 * Get All News.
 * @author juanmafe.
 */
@Service
public class GetAllNews {

	/** {@link NewsPersistence} newsPersistence */
	@Autowired
	private NewsPersistence newsPersistence;

	/**
	 * Gets all news.
	 * @return {@link News} {@link Stream}.
	 */
	public Stream<News> execute() {
		return newsPersistence.getAllNews();
	}

}