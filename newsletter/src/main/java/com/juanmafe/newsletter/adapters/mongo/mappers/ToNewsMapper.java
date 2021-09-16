package com.juanmafe.newsletter.adapters.mongo.mappers;

import org.springframework.beans.BeanUtils;
import com.juanmafe.newsletter.adapters.mongo.entities.NewsEntity;
import com.juanmafe.newsletter.domain.models.news.News;

/**
 * To News Mapper.
 * @author juanmafe.
 */
public final class ToNewsMapper {

	/**
	 * Private Constructor.
	 */
	private ToNewsMapper() {}

	/**
	 * Turns {@link NewsEntity} into {@link News};
	 * @return {@link News} Object.
	 */
	public static News toNews(NewsEntity newsEntity) {
		var news = new News();
		BeanUtils.copyProperties(newsEntity, news);
		return news;
	}

}