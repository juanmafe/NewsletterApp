package com.juanmafe.newsletter.adapters.mongo;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.juanmafe.newsletter.adapters.mongo.dao.NewsRepository;
import com.juanmafe.newsletter.adapters.mongo.entities.NewsEntity;
import com.juanmafe.newsletter.domain.models.news.News;
import com.juanmafe.newsletter.domain.persistence.NewsPersistence;

/**
 * Newsletter Mongo Persistence Layer.
 * @author juanmafe.
 */
@Repository
public class NewsMongo implements NewsPersistence {

	/** {@link NewsRepository} newsRepository */
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public Stream<News> getAllNews() {
		return newsRepository.findAll().stream().map(NewsEntity::toNews);
	}

}