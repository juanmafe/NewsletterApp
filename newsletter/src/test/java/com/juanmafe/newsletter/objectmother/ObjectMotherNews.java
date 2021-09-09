package com.juanmafe.newsletter.objectmother;

import java.util.Arrays;
import java.util.stream.Stream;
import com.juanmafe.newsletter.domain.models.news.News;

/**
 * Object Mother News.
 * @author juanmafe
 */
public class ObjectMotherNews {

	public static Stream<News>getNewsStream() {
		return Arrays.asList(getNews()).stream();
	}

	public static News getNews() {
		var news = new News();
		news.setTitle("Linux");
		news.setDescription("Lanzamiento Linux");
		return news;
	}

}