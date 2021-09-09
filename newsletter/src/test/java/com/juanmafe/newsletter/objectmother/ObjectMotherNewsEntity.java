package com.juanmafe.newsletter.objectmother;

import java.util.Arrays;
import java.util.List;
import com.juanmafe.newsletter.adapters.mongo.entities.NewsEntity;

/**
 * Object Mother News Entity.
 * @author juanmafe
 */
public class ObjectMotherNewsEntity {

	public static List<NewsEntity>getNewsEntityList() {
		return Arrays.asList(getNewsEntity());
	}

	public static NewsEntity getNewsEntity() {
		var newsEntity = new NewsEntity();
		newsEntity.setTitle("Linux");
		newsEntity.setDescription("Lanzamiento Linux");
		return newsEntity;
	}

}