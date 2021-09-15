package com.juanmafe.newsletter.adapters.rest.news;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.juanmafe.newsletter.domain.models.news.News;
import com.juanmafe.newsletter.domain.usecases.GetAllNews;
import com.juanmafe.newsletter.ports.in.GetAllNewsService;

/**
 * News Get All Rest Controller.
 * @author juanmafe.
 */
@RestController
@RequestMapping("/news")
public class NewsGetAllRest {

	/** {@link GetAllNews} getAllNewsService */
	@Autowired
	private GetAllNewsService getAllNewsService;

	/**
	 * Gets all news.
	 * @return {@link News} {@link Stream}
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Stream<News> getAllNews() {
		return getAllNewsService.execute();
	}

}