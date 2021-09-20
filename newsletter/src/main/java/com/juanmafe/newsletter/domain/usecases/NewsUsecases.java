package com.juanmafe.newsletter.domain.usecases;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanmafe.newsletter.annotations.ExcludeFromJacocoGeneratedReport;
import com.juanmafe.newsletter.domain.models.news.News;
import com.juanmafe.newsletter.domain.usecases.news.GetAllNews;
import com.juanmafe.newsletter.ports.in.NewsService;

/**
 * News Service.
 * @author juanmafe.
 */
@Service
@ExcludeFromJacocoGeneratedReport
public class NewsUsecases implements NewsService {

	/** {@link GetAllNews} getAllNewsService */
	@Autowired
	private GetAllNews getAllNewsService;

	@Override
	public Stream<News> getAll() {
		return getAllNewsService.execute();
	}

}